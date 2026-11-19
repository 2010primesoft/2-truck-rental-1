package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminDashboardPage extends BasePage {
    private static final By DASHBOARD_INDICATOR = By.cssSelector(".bg-blue-50");

    public AdminDashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDashboardVisible() {
        return isElementVisible(DASHBOARD_INDICATOR);
    }
}
