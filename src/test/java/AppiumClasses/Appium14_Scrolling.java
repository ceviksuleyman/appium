package AppiumClasses;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.BaseClass;
import utilities.ReusableMethods;

import java.net.MalformedURLException;

public class Appium14_Scrolling extends BaseClass {

    @Test
    public void testScrolling() throws MalformedURLException {

        AndroidDriver driver = getAndroidDriver();
        System.out.println("App Installed...");
        // api demos butonuna tikla
        driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();
        ReusableMethods.waitFor(3);
        // preference butonuna tikladik
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        // preference dependencies butonuna bastik
        ReusableMethods.waitFor(3);
        // uiScrollable
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Switches\"))");

        WebElement switches = driver
                .findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").text(\"Switches\")");
        switches.click();

        /*Dimension dimension = driver.manage().window().getSize();
        int start_x = (int) (dimension.width * 0.5);
        int start_y = (int) (dimension.height * 0.8);
        int end_x = (int) (dimension.width * 0.5);
        int end_y = (int) (dimension.height * 0.2);

        TouchAction touchAction = new TouchAction(driver);

        for (int i = 0; i < 3; i++) {
            ReusableMethods.waitFor(3);
            touchAction.press(PointOption.point(start_x, start_y)).moveTo(PointOption.point(end_x, end_y)).release().perform();
        }*/
    }
}
