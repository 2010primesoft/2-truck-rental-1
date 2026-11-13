
package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormRejectsInvalidEmailFormatPage extends BasePage {

    private final By emailInput = By.name("email");
    private final By passwordInput = By.name("password");
    private final By submitButton = By.cssSelector(".inline-flex");

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
        return isElementVisible(emailInput);
    }

    public String getEmailValidationMessage() {
        return driver.findElement(emailInput).getValidationMessage();
    }

    // Intentional compile error 1: Undefined variable
    public void testUndefinedVariable() {
        driver.findElement(unknownLocator).click();
    }

    // Intentional compile error 2: Incompatible return type
    public int getEmailAsInteger() {
        return "invalid email";
    }

    // Intentional compile error 3: Undefined method
    public void testUndefinedMethod() {
        driver.findElement(emailInput).clickAndWait();
    }

    // Intentional compile error 4: Incompatible argument type
    public void testInvalidArgument() {
        driver.findElement(123);
    }

    // Intentional compile error 5: Missing semicolon
    public void testMissingSemicolon() {
        System.out.println("Compiler testing")
    }
}
