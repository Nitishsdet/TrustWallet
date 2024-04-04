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


    }

    @AfterClass
    public void tearDown() {
        DriverUtils.quitDriver();

    }

    @BeforeMethod
    public void testSetup (){
        page = new SamplePage(driver);
    }

}
