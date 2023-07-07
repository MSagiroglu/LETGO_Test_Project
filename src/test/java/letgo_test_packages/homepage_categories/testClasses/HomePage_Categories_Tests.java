package letgo_test_packages.homepage_categories.testClasses;


import letgo_test_packages.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class HomePage_Categories_Tests extends TestBase {
    @Test
    public void test01_logo_Test() {
        extentReport("Chrome","LetGo Home Page Testi","src/test/java/letgo_test_packages/homepage_categories/reports");
        extentTest=extentReports.createTest("Letgo Home Page Report","Home Page Raporu");

        //	www.letgo.com sayfasına git
        driver.get("https://www.letgo.com");
        extentTest.info("Anasayfaya gidildi.");

        //  Çıkan çerezi kapatma
        WebElement cerez = driver.findElement(By.xpath("//*[@class='onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon']"));
        cerez.click();
        extentTest.info("Çerez kapatıldı.");

        //  Letgo logosunun görünür olup olmadığını doğrulayınız.
        WebElement letGoimg = driver.findElement(By.xpath("(//img)[1]"));
        assert letGoimg.isDisplayed();
        webElementResmi(letGoimg,"src/test/java/letgo_test_packages/homepage_categories/img/webElement");
        extentTest.info("Letgo logosunun görünür olduğu doğrulandı.");
        extentTest.pass("Sayfa Kapatıldı.");
        extentReports.flush();
    }



    @Test
    public void test02_locationTest() { //--> Konum hatası alındı, devam edilecek.
        extentReport("Chrome","LetGo Home Page Testi","src/test/java/letgo_test_packages/homepage_categories/reports");
        extentTest=extentReports.createTest("Letgo Home Page Report","Home Page Raporu");

        //	www.letgo.com sayfasına git
        driver.get("https://www.letgo.com");
        extentTest.info("Anasayfaya gidildi.");

        //  Çıkan çerezi kapatma
        WebElement cerez = driver.findElement(By.xpath("//*[@class='onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon']"));
        cerez.click();
        extentTest.info("Çerez kapatıldı.");
        //3.	Konum kısmına tıklandığında “Mevut Konum” Tıklandığında konum izinleri kapalıysa
        // “Konumuna erişemiyoruz” yazısının çıktığını doğrulayın.

    }

    @Test
    public void test03_InputLocation() {
        extentReport("Chrome","LetGo Home Page Testi","src/test/java/letgo_test_packages/homepage_categories/reports");
        extentTest=extentReports.createTest("Letgo Location Test Report","Letgo Location Testi");
        //	www.letgo.com sayfasına git
        driver.get("https://www.letgo.com");
        extentTest.info("Anasayfaya gidildi.");

        //  Çıkan çerezi kapatma
        WebElement cerez = driver.findElement(By.xpath("//*[@class='onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon']"));
        cerez.click();
        bekle(2);
        extentTest.info("Çerez kapatıldı.");

        WebElement location= driver.findElement(By.xpath("//input[@class='_1dasd']"));
        location.clear();
        extentTest.info("Location kısmı silindi.");
        bekle(2);
        location.sendKeys("Turgutlu", Keys.ENTER);
        extentTest.info("Location kısmına Turgutlu girildi ve enter'a basıldı");

        WebElement result= driver.findElement(By.xpath("//div[@class='_1lcFr']//span[1]"));

        String expectedResult= "Turgutlu, Manisa";
        String actualResult= result.getText();
        assert expectedResult.equals(actualResult);
        extentTest.info("Location'a Turgutlu yazdıtan sonra Turgutlu, Manisa'nın çıktığı doğrulandı.");
        tumSayfaResmi("src/test/java/letgo_test_packages/homepage_categories/img/tum_sayfa");
        extentTest.pass("Sayfa Kapatıldı.");
        extentReports.flush();
    }
}
