package AppiumClasses;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium12_BrowserstackIOS {

    @Test
    public void browserstackIOS() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "cevik_mBUgLl");
        caps.setCapability("browserstack.key", "xRCXwV5yR7yuWr2XgwX9");

        // Set URL of the application under test
        caps.setCapability("app", "bs://444bd0308813ae0dc236f8cd461c02d3afa7901d");

        // Specify device and os_version for testing
        caps.setCapability("device", "iPhone 12 Pro Max");
        caps.setCapability("os_version", "16");


        // Set other BrowserStack capabilities
        caps.setCapability("project", "Appium Project");
        caps.setCapability("build", "browserstack-2");
        caps.setCapability("name", "sample_test_IOS");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        IOSDriver<IOSElement> driver = new IOSDriver<IOSElement>(
                new URL("http://hub-cloud.browserstack.com/wd/hub"), caps);

        // Test case for the BrowserStack sample iOS app.
        // If you have uploaded your app, update the test case here.
        IOSElement textButton = (IOSElement) new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Text Button")));
        textButton.click();


        IOSElement textInput = (IOSElement) new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Text Input")));
        textInput.sendKeys("hello@browserstack.com");


        ReusableMethods.waitFor(6);
        IOSElement textOutput = (IOSElement) new WebDriverWait(driver, 35)
                .until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Text Input"))); // Text Output fail
        if (textOutput != null && textOutput.getText().equals("hello@browserstack.com")) {
            assert (true);
        } else {
            assert (false);
        }
        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        driver.quit();
    }
}
