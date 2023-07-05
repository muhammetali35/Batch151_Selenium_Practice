package day06_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.Set;

public class C03_ActionMoveToElement extends TestBase {

    // https://amazon.com adresine gidiniz
    // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
    // Change country/region butonuna basiniz
    // United States dropdown'undan 'Turkey (Türkiye)' seciniz
    // Go to website butonuna tiklayiniz
    // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz

    @Test
    public void test01() throws InterruptedException {
        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");
        String ilkSayfaHandle = driver.getWindowHandle();
        System.out.println("ilkSayfaHandle = " + ilkSayfaHandle);
        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim

        Actions actions = new Actions(driver);

        WebElement dilMenu= driver.findElement(By.xpath("//div[text()='EN']"));

        actions.moveToElement(dilMenu).perform();

        Thread.sleep(2000);

        // Change country/region butonuna basiniz
        driver.findElement(By.xpath("(//div[@class='icp-mkt-change-lnk'])[1]")).click();


        // United States dropdown'undan 'Turkey (Türkiye)' seciniz
        WebElement ddm = driver.findElement(By.id("icp-dropdown"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Turkey (Türkiye)");

        Thread.sleep(2000);

        // Go to website butonuna tiklayiniz

        driver.findElement(By.xpath("//h3")).click();
        /*
        dropdown opsiyon listesi ' Go to website' butonuna basmamıza engel olduğu için
        herhangi bir yere clik yapıp dropdown opsiyon listesinin toparlanmasını sağladık.
         */


        driver.findElement(By.xpath("//input[@class='a-button-input']")).click();
        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());

        // acilan yeni sayfanin Title'inin Elektronik icerdigini test ediniz

        Set<String> pencereler = driver.getWindowHandles();
        String ikinciSayfaHandle="";

        for(String w : pencereler){
            if(!w.equals(ilkSayfaHandle)){

                ikinciSayfaHandle = w;

            }

        }


        System.out.println("ikinciSayfaHandle = " + ikinciSayfaHandle);

        driver.switchTo().window(ikinciSayfaHandle);

        Thread.sleep(2000);

        Assert.assertTrue(driver.getTitle().contains("Elektronik"));




    }
}

