package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private static final By EMAIL_INPUT = By.name("email");
    private static final By PASSWORD_INPUT = By.name("password");
    private static final By SIGN_IN_BUTTON = By.cssSelector(".inline-flex");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://truckrent.g-axis.in/admin/login");
    }

    public void enterEmail(String email) {
        driver.findElement(EMAIL_INPUT).clear();
        driver.findElement(EMAIL_INPUT).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(PASSWORD_INPUT).clear();
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    public void clickSignIn() {
        driver.findElement(SIGN_IN_BUTTON).click();
    }

    public boolean isOnLoginPage() {
        return driver.getCurrentUrl().contains("login") || isElementVisible(SIGN_IN_BUTTON);
    }

    public boolean isPasswordInputPresent() {
        return isElementVisible(PASSWORD_INPUT);
    }
}
