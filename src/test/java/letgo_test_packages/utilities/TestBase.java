package tecproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class TestBase {
    protected static WebDriver driver;
    /*
     TestBase class'indan obje olusturmanin onune gecmek icin bu class'i abstract yapabiliriz
     TestBase testBase new = TestBase(); yani bu sekilde obje olusturmanin onune gecmis oluruz
     Bu class'a extends yaptigimiz test class'larindan ulabiliriz
 */

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    //@After
    //public void tearDown() throws Exception {
    //    driver.quit();
    // }

    //HARD WAIT(bekleme metodu)
    public void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Selenium Wait/ExplicitWait

    //visibilityOf(element) metodu ile wait
    public void visibleElement(WebElement element, int saniye) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(saniye));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    //visibilityOfElementLocated(locator) metodu ile wait

    public void visibleElement(By locator, int saniye) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(saniye));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //AlertWait methodu
    public void alertWait(int saniye){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(saniye));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    //FluentWait visible methodu
    public void visibleFluentWait(WebElement element,int saniye,int milisaniye){
        new FluentWait<>(driver).withTimeout(Duration.ofSeconds(saniye)).
                pollingEvery(Duration.ofMillis(milisaniye)).
                until(ExpectedConditions.visibilityOf(element));
    }

    //Accept Alert Method
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    //Dismiss Alert Method
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    //Get Text  Alert Method
    public String getTextAlert() {
        return driver.switchTo().alert().getText();
    }

    //senKeys() Alert Method
    public void senKeysAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    //Dropdown VisibleText
    public void selectVisibleText(WebElement ddm, String text) {
        Select select = new Select(ddm);
        select.selectByVisibleText(text);
    }

    //Dropdown index
    public void selectByindex(WebElement ddm, int idx) {
        Select select = new Select(ddm);
        select.selectByIndex(idx);
    }

    //Dropdown value
    public void selectByValue(WebElement ddm, String text) {
        Select select = new Select(ddm);
        select.selectByValue(text);
    }

    //SwitchTo Window-1
    public void switchToWindow1(int index) {
        List<String> pencereler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(index));
    }

    //SwitchTo Window-2
    public void switchToWindow2(int index) {
        driver.switchTo().window(driver.getWindowHandles().toArray()[index].toString());
    }


}
