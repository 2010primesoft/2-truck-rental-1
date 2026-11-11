package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewPaginatedVehicleOwnersListingPage extends BasePage {

    private final By vehicleOwnersNavLink = By.xpath("//*[text()='Vehicle Owners']");
    private final By vehicleOwnersActiveHeader = By.cssSelector(".bg-blue-50");

    public ViewPaginatedVehicleOwnersListingPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToVehicleOwners() {
        driver.findElement(vehicleOwnersNavLink).click();
    }

    public boolean isVehicleOwnersHeaderVisible() {
        return isElementVisible(vehicleOwnersActiveHeader);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
