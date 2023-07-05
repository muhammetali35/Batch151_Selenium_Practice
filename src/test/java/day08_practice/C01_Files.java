package day08_practice;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_Files {



    @Test
    public void test01() throws InterruptedException {
        // masaustunde bir text dosyası olusturunuz
        // masaustunde text dosyasının olup olmadıgını test ediniz

        // dinamik hale getirelim

        String farkliKisim= System.getProperty("user.home");
        System.out.println("farkliKisim = " + farkliKisim);

        String ortakKisim= "C:\\Users\\FADİME YILMAZ\\Desktop\\boş.txt";
        System.out.println("ortakKisim = " + ortakKisim);

        String dosyaYolu = farkliKisim + ortakKisim;
        System.out.println("Dosya yolu "+dosyaYolu);

        Thread.sleep(5000);

       // Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));




    }
}
