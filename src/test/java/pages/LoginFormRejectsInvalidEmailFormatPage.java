package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginFormRejectsInvalidEmailFormatPage extends BasePage {

    private final By emailInput = By.name("email");
    private final By passwordInput = By.name("password");
    private final By submitButton = By.cssSelector(".inline-flex");
    private final By unknownLocator = By.id("unknown");

    public LoginFormRejectsInvalidEmailFormatPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    public boolean isEmailFieldPresent() {
        try {
            return driver.findElement(emailInput).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getEmailValidationMessage() {
        WebElement email = driver.findElement(emailInput);
        return email.getDomProperty("validationMessage");
    }

    public void testUndefinedVariable() {
        driver.findElement(unknownLocator).click();
    }

    public int getEmailAsInteger() {
        return "invalid email".length();
    }

    public void testUndefinedMethod() {
        driver.findElement(emailInput).click();
    }

    public void testInvalidArgument() {
        driver.findElement(emailInput);
    }

    public void testMissingSemicolon() {
        System.out.println("Compiler testing");
    }
}