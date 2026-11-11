/**
 * Generated automation config — TestHooks.java.
 *
 * Login happens ONCE per test run (@BeforeAll), not per scenario, using
 * the same structural field-detection approach this project's own
 * authenticate() already proved against the real app: find the one
 * visible input[type="password"], walk up to its enclosing form, find
 * the email/text field and submit button inside that same form, fill,
 * submit, wait for the URL to leave the login page.
 *
 * Credentials are read from environment variables at run time — never
 * written into this file. Set AUTOMATION_LOGIN_EMAIL and
 * AUTOMATION_LOGIN_PASSWORD before running `mvn test`.
 */
package hooks;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

import base.DriverFactory;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestHooks {

    public static WebDriver driver;
    private static final String BASE_URL = "https://truckrent.g-axis.in/";
    private static final Duration LOGIN_TIMEOUT = Duration.ofSeconds(15);

    private static WebElement[] findLoginForm() {
        List<WebElement> passwordInputs = driver.findElements(By.cssSelector("input[type='password']"))
                .stream().filter(WebElement::isDisplayed).toList();
        if (passwordInputs.isEmpty()) {
            throw new RuntimeException("No visible password field found on the login page.");
        }
        WebElement passwordField = passwordInputs.get(0);

        WebElement form = passwordField.findElement(By.xpath("ancestor::form[1]"));

        WebElement usernameField = null;
        for (String selector : new String[] {"input[type='email']", "input[type='text']"}) {
            List<WebElement> candidates = form.findElements(By.cssSelector(selector));
            if (!candidates.isEmpty()) {
                usernameField = candidates.get(0);
                break;
            }
        }
        if (usernameField == null) {
            throw new RuntimeException("No username/email field found in the login form.");
        }

        List<WebElement> submitButtons = form.findElements(By.cssSelector("button[type='submit']"));
        if (submitButtons.isEmpty()) {
            submitButtons = form.findElements(By.tagName("button"));
        }
        if (submitButtons.isEmpty()) {
            throw new RuntimeException("No submit button found in the login form.");
        }

        return new WebElement[] {usernameField, passwordField, submitButtons.get(0)};
    }

    private static void login() {
        String email = System.getenv("AUTOMATION_LOGIN_EMAIL");
        String password = System.getenv("AUTOMATION_LOGIN_PASSWORD");
        if (email == null || password == null) {
            throw new RuntimeException(
                "AUTOMATION_LOGIN_EMAIL and AUTOMATION_LOGIN_PASSWORD must both be set "
                + "in the environment before running this suite.");
        }

        driver.get(BASE_URL);
        String loginPageUrl = driver.getCurrentUrl();

        WebElement[] fields = findLoginForm();
        fields[0].sendKeys(email);
        fields[1].sendKeys(password);
        fields[2].click();

        Instant deadline = Instant.now().plus(LOGIN_TIMEOUT);
        while (Instant.now().isBefore(deadline)) {
            if (!driver.getCurrentUrl().equals(loginPageUrl)) {
                return;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }

        throw new RuntimeException(
            "Login did not succeed within " + LOGIN_TIMEOUT.getSeconds()
            + "s -- still on " + driver.getCurrentUrl() + ".");
    }

    @BeforeAll
    public static void beforeAll() {
        driver = DriverFactory.createDriver();
        login();
    }

    @AfterAll
    public static void afterAll() {
        if (driver != null) {
            driver.quit();
        }
    }
}
