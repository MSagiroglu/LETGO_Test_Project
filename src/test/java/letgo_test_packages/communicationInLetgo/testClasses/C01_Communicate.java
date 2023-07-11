package letgo_test_packages.communicationInLetgo.testClasses;

import letgo_test_packages.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class C01_Communicate extends TestBase {


    @Test
    public void test01() {
        extentReport("Chrome","LetGo Communication","src/test/java/letgo_test_packages/communicationInLetgo/reports");
        extentTest=extentReports.createTest("Letgo Communication Report","Communication Raporu");

        //letgo sayfasına git
        driver.get("https://www.letgo.com");
        extentTest.info("Anasayfaya gidildi.");
         String ilkSayfaHandle= driver.getWindowHandle();
        extentTest.info("window handle edildi");
        //giris butonuna tklayınız.
        WebElement cerez = driver.findElement(By.xpath("//*[@class='onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon']"));
        cerez.click();
        extentTest.info("Cerez kapatıldı");
        driver.findElement(By.xpath("//span[contains(text(),'Giriş')]")).click();
        bekle(3);
        extentTest.info("Login icn giris tusuna basıldı");


   WebElement mailIleDevamEt = driver.findElement(By.xpath("//button[@data-aut-id='emailLogin']"));
mailIleDevamEt.click();

        extentTest.info("mail ile devam et butonuna basıldı");
WebElement aydınlatmaMetni =driver.findElement(By.xpath("//span[text()='Aydınlatma metnimizi okuyunuz']"));
aydınlatmaMetni.click();
        extentTest.info("'Aydınlatma metnimizi okuyunuz' yazısına tıklandı");

//yeni pencere acıldı ve handle edildi
        Set<String> pencereler =driver.getWindowHandles();
        for (String w:pencereler) {
            System.out.println(w);
            if (!w.equals(ilkSayfaHandle)){//eger birici sayfaya esit degise
                driver.switchTo().window(w);//yeni pencereye gecis yap
            }

        }
        extentTest.info("yeni pencere acıldı ve handle edildi");
        Actions action =new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
extentTest.info("sayfanın sonuna gidildi");
WebElement aydınlatmaMetniEvet = driver.findElement(By.xpath("//button[@class='button article-vote article-vote-up']"));
aydınlatmaMetniEvet.click();
        extentTest.info("'Aydınlatma metninde Evet e tıklandi");

WebElement mail = driver.findElement(By.xpath("//input[@id='user_email']"));
mail.sendKeys("leylasimitcicayli@gmail.com");
WebElement passWord = driver.findElement(By.xpath("//input[@id='user_password']"));
passWord.sendKeys("Zonguldak6781.",Keys.ENTER);
extentTest.info("login yapıldı");



//ROBOT UYGULAMASINI HANDLE EDEMEDİM

        /*action.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();

        WebElement aydınlatmaMetniEvet2 = driver.findElement(By.xpath("//button[@class='button article-vote article-vote-up']"));
        aydınlatmaMetniEvet2.click();*/


        // chat kutusunun gorunur oldugunu dogrula
        //chat kutusuna tıkla
        //"Henuz Mesaj Yok" yazısını dogrula
        //---- mesaj varsa---
        //Gelen kutusunun erisilebilir oldugunu dogrula
        //gelen kutusundaki mesajların gonderi tarihinin gorunur oldugunu dogrula


    }
}