package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OwnerListPage extends BasePage {

    private static final By VEHICLE_OWNERS_NAV = By.xpath("//*[text()='Vehicle Owners']");

    public OwnerListPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToVehicleOwners() {
        if (isElementVisible(VEHICLE_OWNERS_NAV)) {
            driver.findElement(VEHICLE_OWNERS_NAV).click();
        }
    }

    public boolean isOnOwnerListPage() {
        return driver.getCurrentUrl().contains("owner") || driver.getCurrentUrl().contains("admin") || isElementVisible(VEHICLE_OWNERS_NAV);
    }
}
