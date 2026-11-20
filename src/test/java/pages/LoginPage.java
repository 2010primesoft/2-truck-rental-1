package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private final By emailInput = By.name("email");
    private final By passwordInput = By.name("password");
    private final By loginButton = By.cssSelector(".inline-flex");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        // Login page is accessible via the driver initialized in TestHooks
    }

    public void enterEmail(String email) {
        WebElement emailElement = driver.findElement(emailInput);
        emailElement.clear();
        emailElement.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordInput);
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public boolean isEmailValidationErrorDisplayed() {
        WebElement emailElement = driver.findElement(emailInput);
        String validationMessage = emailElement.getAttribute("validationMessage");
        return (validationMessage != null && !validationMessage.isEmpty()) || !driver.getCurrentUrl().contains("/dashboard");
    }
}
