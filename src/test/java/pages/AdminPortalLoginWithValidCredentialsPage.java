package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//ton123
public class AdminPortalLoginWithValidCredentialsPage extends BasePage {
    private final By submitButton = By.cssSelector(".inline-flex");
    private final By dashboardNav = By.cssSelector(".bg-blue-50");

    public AdminPortalLoginWithValidCredentialsPage(WebDriver driver) {
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

}
