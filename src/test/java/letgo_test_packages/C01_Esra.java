package letgo_test_packages;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C01_Esra extends TestBase {


    @Test
    public void test01() {
        /*
        1-Otoplus logo gorunurlugunun test edilmesi
        2-Mevcut konumu gosterilmesi
        3-Marka’ya gore urunlerin filtrelemesi
        4-Site yoneticileri ile iletisim kurma linki

         */

         //https://www.letgo.com/ sayfasina gidelim
        driver.get("https://www.letgo.com/ ");

        //acilan sayfa en altta gittigi icin en ustte geldik
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP,Keys.UP).perform();
        bekle(3);

        //araba al butinuna tiklayalim
        driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
        bekle(3);

        //yeni sekmede acilan sayfaya gectik
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        bekle(3);

        //  1-Otoplus logo gorunurlulgunu test edelim
        WebElement otoplusLogo = driver.findElement(By.xpath("(//img)[1]"));
        Assert.assertTrue(otoplusLogo.isDisplayed());
        bekle(3);

        // Konum secme menusunden Turkiye seciniz


        //hayalimdeki arabna buttonuna "mercedes"yaziniz
       WebElement aramaKutusu = driver.findElement(By.xpath("(//input)[2]"));
       aramaKutusu.click();
       aramaKutusu.sendKeys("mercedes",Keys.ENTER);
       bekle(3);

        //Site yoneticileri ile iletisim kurma linkine tikla
        WebElement iletisimButonu = driver.findElement(By.xpath("//*[@class='D6d69']"));
        iletisimButonu.click();

    }

    @Test
    public void test02() {

        /*
        img/text resmi (arabali buyuk resim ) gorunurlulugunu test ediniz
         */

        //https://www.letgo.com/ sayfasina gidelim
        driver.get("https://www.letgo.com/ ");

        //acilan sayfa en altta gittigi icin en ustte geldik
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP,Keys.UP).perform();
        bekle(3);

        //araba al butinuna tiklayalim
        driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
        bekle(3);

        //yeni sekmede acilan sayfaya gectik
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        bekle(3);

        //img/text resmi (arabali buyuk resim ) gorunurlulugunu test ediniz

       WebElement arabaResmi= driver.findElement(By.xpath("(//img)[2]"));
       Assert.assertTrue(arabaResmi.isDisplayed());


    }

    @Test
    public void test03() {

        //hayalindeki araba sadece bir tik uzaginda yazisinin gorunurlulugunu test ediniz
        WebElement hayalindekiArabaYazisi= driver.findElement(By.xpath("(//h2)[1]"));
        Assert.assertTrue(hayalindekiArabaYazisi.isDisplayed());

 ///yorum

    }
}
