package day04_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02_WindowHandle extends TestBase {
    // 1- https://www.amazon.com sayfasina gidelim
// 2- url'in 'amazon' icerdigini test edelim
// 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
// 4- title'in 'Best Buy' icerdigini test edelim
// 5- ilk sayfaya(amazon) donup sayfada java aratalım
// 6- arama sonuclarının 'Java' icerdigini test edelim
// 7- ikinci sayfaya(bestbuy) donelim
// 8- logonun gorundugunu test edelim


    @Test
    public void test01() {

        // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        String amazonHandle = driver.getWindowHandle();

        // 2- url'in 'amazon' icerdigini test edelim
        String amazonUrl = driver.getCurrentUrl();
        Assert.assertTrue(amazonUrl.contains("amazon"));

        // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String bestBuyHandle = driver.getWindowHandle();

        // 4- title'in 'Best Buy' icerdigini test edelim
        String bestBuyTitle = driver.getTitle();
        Assert.assertTrue(bestBuyTitle.contains("Best Buy"));

        // 5- ilk sayfaya(amazon) donup sayfada java aratalım
        driver.switchTo().window(amazonHandle);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);

        // 6- arama sonuclarının 'Java' icerdigini test edelim
        WebElement sonuc = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        Assert.assertTrue(sonuc.getText().contains("Java"));

        // 7- ikinci sayfaya(bestbuy) donelim
        driver.switchTo().window(bestBuyHandle);

        // 8- logonun gorundugunu test edelim
        WebElement logo = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());


    }
}
