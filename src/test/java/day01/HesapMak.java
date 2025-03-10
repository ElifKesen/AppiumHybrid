package day01;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class HesapMak {

    AndroidDriver<AndroidElement>driver;
    // Android driver, Android cihazlar icin uretilmis ve ona gore ozellikleri eklenmis driver
    // AppiumDriver<MobileElement> appiumDriver;
    // oncden tek bir driver vardi. o da appiumDriver di. zamanla appium kendini gelistirdi
    // android icin ayri ios icin ayri ozellikleri bulunan driverlar uretti. IOSDriver<IOSElement> iosDriver;


    // kullanici gerekli kurulumlari yapar
    @Test
    public void hesapmak() throws MalformedURLException {
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 4 H");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");//android kullandigimiz icin UiAutomator2, IOS icin XCUITest kullanilir
        caps.setCapability(MobileCapabilityType.APP,"C:\\Users\\elifk\\IdeaProjects\\Appium_Hybrid\\Apps\\Calculator_8.4 (503542421)_Apkpure (3).apk");
        //caps.setCapability(MobileCapabilityType.APP,"C:\\Users\\elifk\\IdeaProjects\\Appium_Hybrid\\Apps\\Apk Bilgisi_2.3.4_apkcombo.com.apk");

        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        // uygulamanin yuklendigini dogrular(isInstalled)
        Assert.assertTrue(driver.isAppInstalled("com.google.android.calculator"));

        // uygulamanin acildigini dogrular
        Assert.assertTrue(driver.findElementById("com.google.android.calculator:id/clr").isDisplayed());

        // 400 un 3 katininin 1200 oldugunu hesap makinasindan dogrulayalim
        driver.findElementByAccessibilityId("4").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("multiply").click();
        driver.findElementByAccessibilityId("3").click();
        String islemSonucu=driver.findElementById("com.google.android.calculator:id/result_preview").getText();

        int bekledigimSonuc=1200;

        Assert.assertEquals(Integer.parseInt(islemSonucu),bekledigimSonuc);













    }

}
