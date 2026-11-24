package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    private static final By DASHBOARD_LINK = By.cssSelector(".bg-blue-50");
    private static final By VEHICLE_OWNERS_LINK = By.xpath("//*[text()='Vehicle Owners']");
    private static final By LOGOUT_LINK = By.cssSelector(".text-red-500");
    private static final By USER_PROFILE_ICON = By.cssSelector(".w-8");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnDashboard() {
        return isElementVisible(DASHBOARD_LINK);
    }

    public void clickVehicleOwners() {
        driver.findElement(VEHICLE_OWNERS_LINK).click();
    }

    public void clickProfileIcon() {
        if (isElementVisible(USER_PROFILE_ICON)) {
            driver.findElement(USER_PROFILE_ICON).click();
        }
    }

    public void clickLogout() {
        driver.findElement(LOGOUT_LINK).click();
    }
}
