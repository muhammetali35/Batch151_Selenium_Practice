package day04_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C01_DropDownMenu extends TestBase {
    // https://www.amazon.com/ sayfasina gidin
    // dropdown'dan "Books" secenegini secin
    // arama cubuguna "Java" aratın
    // arama sonuclarinin Java icerdigini test edin

    @Test
    public void test01() {

        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");


        // dropdown'dan "Books" secenegini secin

        // dropdown 3 adımda handle edilir

        // 1- dropdown locate edilmeli
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        // 2- select objesi olusturulur
        Select select = new Select(ddm);

        // 3- optionlardan bir tanesi secilir
        //select.selectByVisibleText("Books");
        //select.selectByIndex(5);
        select.selectByValue("search-alias=stripbooks-intl-ship");

        // arama cubuguna "Java" aratın
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Java"+ Keys.ENTER);

        // arama sonuclarinin Java icerdigini test edin
        WebElement sonuc = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        Assert.assertTrue(sonuc.getText().contains("Java"));






    }
}
