package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//to test the changes 

public class AdminDashboardPage extends BasePage {

    private final By dashboardHeading = By.cssSelector(".bg-blue-50");

    public AdminDashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDashboardVisible() {
        return isElementVisible(dashboardHeading);
    }
}
