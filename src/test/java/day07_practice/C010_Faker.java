package day07_practice;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.nio.file.WatchEvent;

public class C010_Faker extends TestBase {
    @Test
    public void test01() {


        // 'https://www.facebook.com' sayfasina gidiniz
        driver.get("https://www.facebook.com");

        // yeni hesap olustur butonuna basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();


        // isim kutusunu locate ediniz
        WebElement isimKutusu =  driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[1]"));




        // geriye kalan alanlari TAB ile dolasarak faker bilgilerle formu doldurun

        Faker faker = new Faker();

        Actions actions = new Actions(driver);

        String email= faker.internet().emailAddress();//Hocanın sayfasında iki
                                                    // mail istiyordu bu yüzden aynı maili yapsın diye dışarda bir değişkene assing yaptık

        actions.click(isimKutusu).
                sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("15").
                sendKeys(Keys.TAB).
                sendKeys("Mart").
                sendKeys(Keys.TAB).
                sendKeys("2000").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_RIGHT).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).
                perform();


/*
mause ile yaptirdigimiz isi actions objesi ile yaptirdik. TAB ile form icinde ilerledik.
sendKeys ve Keys.TAB'larla devam ederken email address kismini da yazdiktan sonra kodumuzu calistirdik
ve kodun calismasi sonucunda gelinen son asamada ayni emaili' tekrar girmemiz yonunde bir istek ile karsilastik
Bunun uzerine actions ve devamindaki kodlarimizin uzerine ciktik ve orada faker.internet()emailAddress())
kismini tekrar yazip bir email ismini verdigimiz bir String'e assign ettik. actions.click(isimKutusu) seklinde
baslayip devam eden kodumuz icinde uzun uzun sendKeys(faker.internet().emailAddress()) yazmak yerine yukarida
bunu email ismi ile tanimladigimiz icin sendKeys() parantezi icine sadece String olan email ismini yazdik. Su
sekilde yazdik:  sendKeys(email).
                  sendKeys(Keys.TAB).
Bizden kodu calistirinca tekrar ayni emaili girmemiz istendiginden cunku ilk girdigimiz emailin
dogrulanmasi gerekir. Bu nedenle devaminda yine sunu yazdik:
 sendKeys(email).
 sendKeys(Keys.TAB).
 Kaydol formunda Cinsiyet kisminda Kadin, Erkek ve Ozel isimli butonlar var ve biz Erkek butonunu sectik.
 Burada bir daha TAB yaparsak cinsiyetler arasi gezinmiyor. Artik Kadin butonunu secmek istersek
 Keys.ARROW_RIGHT yazarak yani sag ok tusuna basarak diger cinsiyet secenegine gidebiliriz. Aksi halde bir daha
 TAB'a bassaydik cinsiyet secenekleri icinde kalamazdik. Sonraki webelement'lere TAB ile gecebiliriz.

 Sectigimiz Erkek butonundan itibaren bes kez Keys.TAB yazinca bizi kaydol butonu uzerine goturecegini manual olarak yapip gorduk.
 Bu nedenle bes kez Keys.TAB yazdik ve kaydol butonuna tiklanmasi icin Keys.ENTER eklemesi yaptik. Son
 kisima geldigimiz icin perform() eklemesi ile kodumuzu tamamladik ve calistirdik.
 */




    }


}