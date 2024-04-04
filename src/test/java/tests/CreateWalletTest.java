package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SamplePage;
import utils.DriverUtils;


public class CreateWalletTest extends BaseTest {

    String text;
    @Test(description = "Create New Wallet CTA is displayed for a new user")
    public void createWalletOptionVisible() {
        text = page.getCreateWalletText();
        Assert.assertEquals(text, "Create new wallet", "Text did not match");
    }

    @Test(description = "Wallet can be created by skipping backup")
    public void createWalletWithSkipBackup() {
        page.skipBackup();
    }

    @Test(description = "Verify success bottom sheet is shown just after wallet is created")
    public void walletCreatedSuccessfully() {
        text = page.verifySuccessScreen();
        Assert.assertEquals(text, "Welcome aboard", "Success screen failed to load");

    }
}