package letgo_test_packages.homepage_categories.testClasses;


import letgo_test_packages.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
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
}
