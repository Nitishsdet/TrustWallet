package tests;

import io.appium.java_client.AppiumDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.SamplePage;
import utils.DriverUtils;

public class BaseTest {

    AppiumDriver driver;
    SamplePage page;
    @BeforeClass
    public void setUp() {

        DriverUtils.initializeDriver();
        driver=DriverUtils.getDriver();
        page = new SamplePage(driver);


    }

    @AfterClass
    public void tearDown() {
        DriverUtils.quitDriver();

    }


}
