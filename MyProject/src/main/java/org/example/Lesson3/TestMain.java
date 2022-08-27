package org.example.Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;;

public class TestMain {
    public static void autotest() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://google.com");

// Test# 1. Login to livejournal.com
        driver.get("https://www.livejournal.com/");
        driver.findElement(By.cssSelector(".s-header-item__link--login")).click();
        driver.findElement(By.cssSelector(".b-loginform-checkbox__control")).click();
        driver.findElement(By.id("user")).sendKeys("Umed19");
        driver.findElement(By.id("lj_loginwidget_password")).sendKeys("U906906m");
        driver.findElement(By.xpath("//button[@name='action:login']")).click();

// Test# 2. Add post
//        driver.findElement(By.xpath("//*[@id=\"js\"]/body/div[2]/header/div[1]/nav[2]/ul/li[4]/a")).click();
//        driver.findElement(By.xpath("//div[@id='content']/div/div/div[2]/textarea")).click();
//        driver.findElement(By.xpath("//textarea")).sendKeys("Test_blog");
//        driver.findElement(By.cssSelector(".public-DraftStyleDefault-block")).sendKeys("All dogs go to Heaven");
//        driver.findElement(By.xpath("//div[2]/button/span")).click();
//        driver.findElement(By.xpath("//button[contains(.,'Опубликовать')]")).click();

// Test# 3. Add comment to someone's post
//        driver.findElement(By.xpath("//*[@id=\"js\"]/body/div[2]/div[3]/div[1]/section[1]/div/div/div[1]/div[1]/div/div/article/a")).click();
//        driver.findElement(By.cssSelector(".aentry-post__socials:nth-child(2) .\\_3p:nth-child(2) .\\_w6 path")).click();
//        driver.findElement(By.xpath("//*[@id=\"body\"]")).sendKeys("What a crap!");
//        driver.findElement(By.id("comment_submit")).click();

// Test# 4. Edit own post
        driver.findElement(By.xpath("//*[@id=\"js\"]/body/div[2]/header/div[1]/nav[2]/ul/li[2]/a/span")).click();
        driver.findElement(By.xpath("//*[@id=\"entry-umed19-318\"]/header/h3/a")).click();
        driver.findElement(By.cssSelector(".svgicon--more")).click();
        driver.findElement(By.xpath("//span[contains(.,'Редактировать запись')]")).click();
        driver.findElement(By.cssSelector(".notranslate")).sendKeys(". Looks like it works");
        driver.findElement(By.cssSelector(".\\_129 > .\\_123")).click();
        driver.findElement(By.xpath("//span[contains(.,'Опубликовать')]")).click();

//Завершаем работу с ресурсом
       //driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        autotest();

    }
}
