package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminDashboardPage extends BasePage {
//lol
    private final By dashboardHeading = By.cssSelector(".bg-blue-50");
///lol
    public AdminDashboardPage(WebDriver driver) {
        super(driver);
    }
//testing for no conf
    public boolean isDashboardDisplayed() {
        return isElementVisible(dashboardHeading);
    }
}//completed
