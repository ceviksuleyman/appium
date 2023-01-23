package AppiumClasses;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static utilities.ReusableMethods.threadSleep;

public class Appium10 {

    @Test
    public void test() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\cevik\\IdeaProjects\\mobileTesting\\src\\Apps\\apiDemos.apk");
        capabilities.setCapability("noReset", true);

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        threadSleep(3);
        System.out.println("App intstalled...");


        //api demos butonuna tikla
        driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();
        threadSleep(3);

        //preference butonuna tikladik
        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();

        //preference dependencies butonuna bastik
        threadSleep(3);
        driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();

        // checkbox control click
        String isChecked = driver
                .findElementByAndroidUIAutomator("UiSelector().resourceId(\"android:id/checkbox\").checkable(true)")
                .getAttribute("checked");

        System.out.println(isChecked + " < =========== > ");
        if (isChecked.equals("false")) {

            driver.findElementById("android:id/checkbox").click();
            System.out.println("if < =========== >");
        }

        // wifi setting tikladik
        threadSleep(3);
        driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").click();

        // text penceresi acildigini gorduk
        threadSleep(3);
        Assert.assertTrue(driver.findElementById("android:id/alertTitle").isDisplayed());
        threadSleep(1);

        // text yazdiralim
        driver.findElementById("android:id/edit").sendKeys("TextAppium");
        threadSleep(1);

        // ok butonuna bas
        driver.findElementById("android:id/button1").click();
        threadSleep(1);

        System.out.println("mission completed....");
        threadSleep(2);

        // session kapat
        driver.closeApp();
    }
}
