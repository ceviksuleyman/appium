package AppiumClasses;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class Appium06_WebAppChrome {


    @Test
    public void test() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60000");
        capabilities.setCapability("chromedriverExecutable", "C:\\Users\\cevik\\IdeaProjects\\mobileTesting\\src\\driver\\chromedriver.exe");

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        ReusableMethods.waitFor(3);
        //capabilities.setCapability("noReset", true);
        /*
        chrome driver versiyonunu indirme
         */
        /**
         * chrome://inspect/#devices
         */

        driver.get("https://www.automationexercise.com/");
        ReusableMethods.waitFor(3);

        System.out.println(driver.getContext() + " app acildiginda tur");

        Set<String> contextNames = driver.getContextHandles(); // all context
        for (String w : contextNames) {

            System.out.println(w);
            if (w.contains("WEBVIEW_chrome")) {

                ReusableMethods.waitFor(3);
                driver.context(w);
            }
        }
        System.out.println(driver.getContext() + " app degisimden sonra tur");


        //MobileElement logo = driver.findElementByXPath("//a[@id=\"nav-logo-sprites\"]/span[1]");
        //Assert.assertTrue(logo.isDisplayed());
        //threadSleep(3);
        //MobileElement signIn = driver.findElementByXPath("//a[@id=\"nav-logobar-greeting\"]");
        //signIn.click();
        //threadSleep(5);
        //MobileElement signInPageTitle = driver.findElementByXPath("//div[@id=\"outer-accordion-signin-signup-page\"]/h2");
        //Assert.assertTrue(signInPageTitle.isDisplayed());
        //threadSleep(3);


        driver.closeApp();
    }
}

