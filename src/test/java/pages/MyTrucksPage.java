package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;

public class MyTrucksPage extends BasePage {

    public MyTrucksPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTrucksRouteVisited() {
        return driver.getCurrentUrl().contains("truck") || driver.getCurrentUrl().contains("client") || driver.getTitle().toLowerCase().contains("truck");
    }
}
