package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPortalLoginWithValidCredentialsPage extends BasePage {

    private final By emailInput = By.name("email");
    private final By passwordInput = By.name("password");
    private final By loginButton = By.cssSelector(".inline-flex");
    private final By dashboardElement = By.cssSelector(".bg-blue-50");

    public AdminPortalLoginWithValidCredentialsPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isDashboardVisible() {
        return isElementVisible(dashboardElement);
    }
}
