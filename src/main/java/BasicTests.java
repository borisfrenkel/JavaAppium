import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BasicTests {
    AndroidDriver<AndroidElement> driver;

    @Before
    public void Before() throws MalformedURLException {
        File appDir = new File("src\\main\\resources");
        File app = new File(appDir, "ApiDemos-debug.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel Boris");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        //ui automator => Android apps
        //uiautomator2
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Test
    public void basicTest1() {
        driver.findElementById("android:id/text1").click();
        driver.findElementById("android:id/text1").click();

        Assert.assertTrue(driver.findElementByClassName("android.view.View").isDisplayed());
    }

    @Test
    public void basicTest2() {
        driver.findElementById("android:id/text1").click();
        driver.findElementsById("android:id/text1").get(1).click();

        Assert.assertTrue(driver.findElementsByClassName("android.widget.TextView").get(1).getText().contains("1. Enable QueryBack (Settings -> Accessibility -> QueryBack)."));
        Assert.assertTrue(driver.findElementsByClassName("android.widget.TextView").get(1).getText().contains("2. Enable Explore-by-Touch (Settings -> Accessibility -> Explore by Touch). "));
        Assert.assertTrue(driver.findElementsByClassName("android.widget.TextView").get(1).getText().contains("3. Touch explore the list."));
    }
}
