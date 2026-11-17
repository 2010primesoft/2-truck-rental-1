package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormRejectsInvalidEmailFormatPage extends BasePage {
    private final By emailField = By.name("email");
    private final By passwordField = By.name("password");
    private final By signInButton = By.cssSelector(".inline-flex");

    public LoginFormRejectsInvalidEmailFormatPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSignIn() {
        driver.findElement(signInButton).click();
    }

    public boolean isSignInButtonVisible() {
        return isElementVisible(signInButton);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
