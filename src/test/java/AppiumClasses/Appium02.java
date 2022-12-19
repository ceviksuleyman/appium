package AppiumClasses;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium02 {

    @Test
    public void test01() throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        /*
        adb shell
        dumpsys window | grep -E "mCurrentFocus"
         */

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\cevik\\IdeaProjects\\mobileTesting\\src\\Apps\\gestureTool.apk");
        capabilities.setCapability("appPackage", "com.davemac327.gesture.tool");
        capabilities.setCapability("appActivity", "com.davemac327.gesture.tool.GestureBuilderActivity");
        capabilities.setCapability("noReset", true);  // Eger applikasyona izinleri atlayip ana sayfada acilmasini istemiyorsaniz asagidaki komutu kullanabilirsiniz


        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        if (driver.isDeviceLocked()) driver.unlockDevice(); // ekran kilitliyse ekrani ac

        System.out.println("app yuklendi");
        Thread.sleep(2000);
        MobileElement homeScreenTitle = driver.findElementById("android:id/title");
        Assert.assertTrue(homeScreenTitle.isDisplayed());
        System.out.println("anasayfa acildi");

        Thread.sleep(2000);
        MobileElement testButton = driver.findElementById("com.davemac327.gesture.tool:id/testButton");
        testButton.click();
        System.out.println("test button calisti");

        Thread.sleep(2000);
        MobileElement testAGestureTitle = driver.findElementById("android:id/title");
        Assert.assertTrue(testAGestureTitle.isDisplayed());
        System.out.println("Test Screen Acildi");

        driver.closeApp();
    }
}
