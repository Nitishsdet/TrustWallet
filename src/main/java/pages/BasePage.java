package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverUtils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage {

    protected AppiumDriver driver;

    public BasePage() {
        this.driver = DriverUtils.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickElement(WebElement e) {
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(250)).ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class).ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.visibilityOf(e));
        wait.until(ExpectedConditions.elementToBeClickable(e));
        e.click();
    }

    public String getText(WebElement e) {
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(250)).ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class).ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.visibilityOf(e));
        return e.getText();
    }
}
