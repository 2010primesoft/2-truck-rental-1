/**
 * Generated automation config — BasePage.java.
 *
 * Every generated page object extends this — shared helpers only, never
 * a scenario-specific locator or action. isElementVisible() is used for
 * every unverified success/outcome assertion (see unverified_assertions).
 */
package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected final WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected boolean isElementVisible(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
