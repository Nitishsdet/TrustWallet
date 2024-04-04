package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverUtils {

    private static AppiumDriver driver;

    public static void initializeDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appPackage", "com.wallet.crypto.trustapp");
        capabilities.setCapability("appActivity", "com.wallet.crypto.trustapp.ui.app.AppActivity");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "onePlus");
        capabilities.setCapability("automationName", "UiAutomator2");

        try {
            driver = new AppiumDriver(new URL("http://127.0.0.1:4725/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Appium server URL is invalid", e);
        }
    }

    public static AppiumDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Driver not initialized. Please call initializeDriver first.");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
