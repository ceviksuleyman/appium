package AppiumClasses;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import static utilities.ReusableMethods.threadSleep;

public class Appium06WebAppChrome {


    @Test
    public void test() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60000");
        //capabilities.setCapability("noReset", true);
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        threadSleep(3);


        /**
         * chrome://inspect/#devices
         */


        driver.get("https://www.amazon.com");
        threadSleep(15);

        System.out.println(driver.getContext() + " app acildiginda tur");

        Set<String> contextNames = driver.getContextHandles();
        for (String w : contextNames) {

            System.out.println(w);
            if (w.contains("WEBVIEW_chrome")) {
                threadSleep(3);
                driver.context(w);
            }
        }
        System.out.println(driver.getContext() + " app degisimden sonra tur");
        threadSleep(3);


        MobileElement homeScreenLogo = driver.findElementByAccessibilityId("Amazon");
        Assert.assertTrue(homeScreenLogo.isDisplayed());
        threadSleep(3);

        driver.findElementByXPath("//android.view.View[@content-desc=\"Sign in ›\"]/android.widget.TextView").click();


        threadSleep(3);
        driver.closeApp();
    }
}

