package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KiwiPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class Kiwi {
    AndroidDriver<AndroidElement> driver= Driver.getAndroidDriver();

    KiwiPage page=new KiwiPage();

    @Test
    public void KiwiTest() throws InterruptedException {
        // uygulamanin yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.skypicker.main"));

        //uygulamanin basariyla acildigi dogrulanir
        Assert.assertTrue(page.misafirButonu.isDisplayed());
        Thread.sleep(2000);

        // misafir olarak devam et e tiklanir
        page.misafirButonu.click();
        Thread.sleep(2000);

        // ardindan gelecek olan 3 adimda da yesil butona basilarak devam edilir
        for (int i = 0; i <3 ; i++) {
            ReusableMethods.koordinatTiklamaMethodu(550,2060,500);
        }

      // Trip type,one way olarak secilir
        page.returnButonu.click();
        Thread.sleep(2000);
        page.oneWayButonu.click();
        Thread.sleep(2000);

     // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        page.fromButonu.click();
        Thread.sleep(2000);
        page.clearButonu.click();
        Thread.sleep(2000);

      // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
        page.ulkeYazmaKutusu.click();

        if (driver.isKeyboardShown()){
            driver.getKeyboard().pressKey("Ankara");
        }else {
            page.ulkeYazmaKutusu.sendKeys("Ankara");
        }
        Thread.sleep(2000);
        page.kalkisvarisbutonu.click();
        Thread.sleep(2000);
        page.secButonu.click();

       // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
        Thread.sleep(2000);
        page.tobutonu.click();
        if (driver.isKeyboardShown()){
            driver.getKeyboard().pressKey("Frankfurt");
        }else {
            page.ulkeYazmaKutusu.sendKeys("Frankfurt");
        }
        Thread.sleep(2000);
        page.kalkisvarisbutonu.click();
        Thread.sleep(2000);
        page.secButonu.click();

        // gidis tarihi 28 Mart olarak secilir ve set date e tiklanir
        page.tarihbutonu.click();
        Thread.sleep(2000);
        ReusableMethods.koordinatTiklamaMethodu(800,1400,500);
        page.SetDatebutonu.click();
        Thread.sleep(2000);


        // search butonuna tiklanir
        page.Seachbutonu.click();
        Thread.sleep(3000);

        // en  ucuz ve aktarmasiz filtrelemeleri yapilir
        page.bestbutonu.click();
        page.enUcuzbutonu.click();
        Thread.sleep(2000);
        page.Stopbutonu.click();
        page.nonStopbutonu.click();
        Thread.sleep(2000);

        // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir
       String fiyat =page.FiyatYazisi.getText();

        driver.sendSMS("111222333","Bilet fiyati: "+fiyat );



    }





}
