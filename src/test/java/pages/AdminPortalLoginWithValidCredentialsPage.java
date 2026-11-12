package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//ton
public class AdminPortalLoginWithValidCredentialsPage extends BasePage {
    private final By emailInput = By.cssSelector("input[type='email']");
    private final By passwordInput = By.cssSelector("input[type='password']");
    private final By submitButton = By.xpath("//button[text()='Login']");    private final By dashboardNav = By.cssSelector("nav.dashboard-sidebar");

    public AdminPortalLoginWithValidCredentialsPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email.trim());
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
        System.out.println("Submit clicked - Dev B");
    }

    public boolean isDashboardDisplayed() {
        return !driver.findElements(dashboardNav).isEmpty()
                && driver.findElement(dashboardNav).isDisplayed();
    }
}