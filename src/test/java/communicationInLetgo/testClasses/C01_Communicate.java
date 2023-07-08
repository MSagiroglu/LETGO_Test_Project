package communicationInLetgo.testClasses;

import letgo_test_packages.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C01_Communicate extends TestBase {


    @Test
    public void test01() {

        //letgo sayfasına git
        driver.get("https://www.letgo.com");
        //giris butonuna tklayınız.
        WebElement cerez = driver.findElement(By.xpath("//*[@class='onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon']"));
        cerez.click();
        driver.findElement(By.xpath("//span[contains(text(),'Giriş')]")).click();
        bekle(3);

        //mail.:simitleyla@gmail.com
        //sifre:zonguldak.67
        // chat kutusunun gorunur oldugunu dogrula
        //chat kutusuna tıkla
        //"Henuz Mesaj Yok" yazısını dogrula
        //---- mesaj varsa---
        //Gelen kutusunun erisilebilir oldugunu dogrula
        //gelen kutusundaki mesajların gonderi tarihinin gorunur oldugunu dogrula


    }
}