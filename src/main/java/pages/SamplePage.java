package pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.DriverUtils;

import java.time.Duration;


public class SamplePage extends BasePage {

    @FindBy(xpath = "//android.widget.TextView[@text='Get Started']")
    public WebElement GetStartedCTA;
    @FindBy(xpath = "(//android.view.View)[2]")
    public WebElement CreateWalletCTA;
    @FindBy(xpath = "//android.widget.TextView[@text='Create new wallet']")
    public WebElement CreateWalletText;
    @FindBy(xpath = "//android.view.View[@class='android.view.View'][2]")
    public WebElement SkipBackup;
    @FindBy(xpath = "//android.widget.TextView[@index='0' and @text='1']")
    public WebElement Press1key;
    @FindBy(xpath = "//android.widget.TextView[@text='Welcome aboard']")
    public WebElement SuccessBottomSheet;
    @FindBy(xpath = "//android.widget.TextView[@text='Start using Trust Wallet']")
    public WebElement SuccessBottomSheetCTA;

    public SamplePage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String getCreateWalletText() {
        clickElement(GetStartedCTA);
        return getText(CreateWalletText);
    }

    public void skipBackup() {
        clickElement(CreateWalletCTA);
        clickElement(SkipBackup);
        int count = 0;
        while (count < 12) {
            Press1key.click();
            count++;
        }

    }

    public String verifySuccessScreen() {
        return getText(SuccessBottomSheet);


    }


}
