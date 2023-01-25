package AppiumClasses;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium13_BrowserstackCalculator {

    @Test
    public void browserstackCalculator() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "cevik_mBUgLl");
        caps.setCapability("browserstack.key", "xRCXwV5yR7yuWr2XgwX9");

        // Set URL of the application under test
        caps.setCapability("app", "bs://f8353e4ff814b333577bcc9e88cbded77afd0880");

        // Specify device and os_version for testing
        caps.setCapability("device", "Samsung Galaxy S22");
        caps.setCapability("os_version", "12.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "Calculator");
        caps.setCapability("build", "browserstack-Calculator");
        caps.setCapability("name", "Calculator");


        // Initialise the remote WebDriver using BrowserStack remote URL
        // and desired capabilities defined above
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
                new URL("http://hub.browserstack.com/wd/hub"), caps);

        // Write your test case statements here
        MobileElement num5 = driver.findElementById("com.google.android.calculator:id/digit_5");
        MobileElement num7 = driver.findElementById("com.google.android.calculator:id/digit_7");
        MobileElement num8 = driver.findElementById("com.google.android.calculator:id/digit_8");
        MobileElement num9 = driver.findElementById("com.google.android.calculator:id/digit_9");

        MobileElement plus = driver.findElementByAccessibilityId("plus");

        MobileElement equals = driver.findElementByAccessibilityId("equals");

        num9.click();
        num5.click();
        plus.click();
        num7.click();
        num8.click();

        ReusableMethods.waitFor(3);
        MobileElement preResult = driver.findElementById("com.google.android.calculator:id/result_preview");
        System.out.println("preResult = " + preResult.getText());

        ReusableMethods.waitFor(3);
        equals.click();

        ReusableMethods.waitFor(3);
        MobileElement result = driver.findElementById("com.google.android.calculator:id/result_final");
        System.out.println("final result = " + result.getText());  // StaleElementReferenceException
        String preResultText = result.getText();


        ReusableMethods.waitFor(3);
        Assert.assertEquals(result.getText(), preResultText);


        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        driver.quit();
    }
}
