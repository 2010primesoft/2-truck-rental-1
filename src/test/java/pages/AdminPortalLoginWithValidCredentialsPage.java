package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPortalLoginWithValidCredentialsPage extends BasePage {

    private final By emailInput = By.name("email");
    private final By passwordInput = By.name("password");
    private final By signInButton = By.cssSelector(".inline-flex");
    private final By dashboardTab = By.cssSelector(".bg-blue-50");

    public AdminPortalLoginWithValidCredentialsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginPageLoaded() {
        return isElementVisible(signInButton);
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(signInButton).click();
    }

    public boolean isDashboardDisplayed() {
        return isElementVisible(dashboardTab);
    }
}
