package day08_practice;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_ extends TestBase {

    @Test
    public void test01() throws IOException {

        // https://www.teknosa.com/ adresine gidin
        driver.get("https://www.teknosa.com/");

        try {
            driver.findElement(By.xpath("//div[@id='ins-editable-button-1580496494']")).click();
        } catch (Exception e) {
            System.out.println("cookies cıkmadı");
        }

        // arama cubuguna oppo yazip enter'a basınız
        WebElement aramaKutusu = driver.findElement(By.id("search-input"));
        aramaKutusu.sendKeys("oppo",Keys.ENTER);


        // sonuc yazısını yazdiriniz
        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@class='plp-panel-block1']"));
        System.out.println("Sonuc Yazisi: "+sonucYazisi.getText());

        // ilk urunun fotografını cekin

        WebElement ilkUrun = driver.findElement(By.xpath("(//div[@class='prd-inner'])[1]"));
        File kayit = new File("target/ekranGoruntusu/urun1.Jpeg");

        File geciciDosya = ilkUrun.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciDosya,kayit);




    }
}
