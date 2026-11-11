package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchOwnerListWithDebounceAndPersistFilterParametersPage extends BasePage {

    private final By vehicleOwnersNavLink = By.xpath("//*[text()='Vehicle Owners']");
    private final By searchInput = By.cssSelector(".pl-9");

    public SearchOwnerListWithDebounceAndPersistFilterParametersPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToVehicleOwners() {
        if (!driver.getCurrentUrl().contains("/admin/owners")) {
            driver.findElement(vehicleOwnersNavLink).click();
        }
    }

    public void enterSearchTerm(String term) {
        driver.findElement(searchInput).clear();
        driver.findElement(searchInput).sendKeys(term);
    }

    public String getSearchInputValue() {
        return driver.findElement(searchInput).getAttribute("value");
    }

    public boolean isSearchInputVisible() {
        return isElementVisible(searchInput);
    }
}
