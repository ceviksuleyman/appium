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

public class Appium09 {

    @Test
    public void test() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\cevik\\IdeaProjects\\mobileTesting\\src\\Apps\\apiDemos.apk");
        //capabilities.setCapability("appPackage", "com.touchboarder.android.api.demos");
        //capabilities.setCapability("appActivity", "com.touchboarder.androidapidemos.MainActivity");
        capabilities.setCapability("noReset", true);
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        threadSleep(2);
        //AndroidDriver driver = getAndroidDriver();

        System.out.println("App intstalled...");
        //api demos butonuna tikla
        driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();
        threadSleep(2);

        //preference butonuna tikladik
        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();

        //preference dependencies butonuna bastik
        threadSleep(2);
        driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();


        //check box check et
        threadSleep(2);
        driver.findElementById("android:id/checkbox").click();

        //wifi setting tikladik
        threadSleep(2);
        driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").click();


        //text penceresi acildigini gorduk
        threadSleep(2);
        Assert.assertTrue(driver.findElementById("android:id/alertTitle").isDisplayed());

        //text yazdiralim
        driver.findElementById("android:id/edit").sendKeys("TextAppium");


        //ok butonuna bas
        driver.findElementById("android:id/button1").click();

        System.out.println("mission completed....");

        threadSleep(2);


        //session kapat
        driver.closeApp();
    }
}
