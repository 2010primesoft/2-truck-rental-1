/**
 * Generated automation config — DriverFactory.java.
 *
 * Driver creation only — kept separate from TestHooks (login/lifecycle)
 * so a change to one is never mistaken for the other.
 */
package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    public static WebDriver createDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");
        WebDriver driver = new ChromeDriver(options);
        // How long to keep looking for an element that is not there yet.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // HOW LONG TO WAIT FOR A PAGE, which Selenium does not limit by
        // default. Without this, driver.get() against an address that
        // accepts no connection waits until Selenium's own 180-second
        // command timeout fires — a real run on 2026-11-16 spent 213
        // seconds that way and tested nothing, reporting only
        // "java.util.concurrent.TimeoutException". Thirty seconds is far
        // longer than a healthy page needs and far shorter than giving up
        // on the whole run.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        // The same for a script that never returns.
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        return driver;
    }
}
