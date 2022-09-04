package org.example.Lesson5;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.*;

public class LiveJournalTest {

    static WebDriver driver;

    @BeforeAll
    static void init(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

   @Test
    void myLogintest() throws InterruptedException {
        // Test# 1. Login to livejournal.com
        driver.get("https://www.livejournal.com/");
        WebElement webElement = driver.findElement(By.cssSelector(".s-header-item__link--login"));
        webElement.click();
        sleep(1000);
        WebElement webElement2 = driver.findElement(By.xpath("//*[@id=\"user\"]"));
        webElement2.click();
        webElement2.sendKeys("Umed19");
        WebElement webElement3 = driver.findElement(By.id("lj_loginwidget_password"));
        webElement3.click();
        webElement3.sendKeys("U906906m");
        WebElement webElement4 = driver.findElement(By.xpath("//button[@name='action:login']"));
        webElement4.click();
    }

    @BeforeEach
    void getPage() throws InterruptedException {
        driver.get("https://www.livejournal.com/");
        myLogintest();
    }

    @Test
    void AddPosttest() throws InterruptedException {
        // Test# 2. Add post
        Actions addpostElement = new Actions(driver);
        addpostElement.click(driver.findElement(By.xpath("//*[@id=\"js\"]/body/div[2]/header/div[1]/nav[2]/ul/li[4]/a")));
        addpostElement.build().perform();
        WebElement writeHeadingElement = driver.findElement(By.xpath("//div[@id='content']/div/div/div[2]/textarea"));
        writeHeadingElement.sendKeys("Test blog for lesson 5");
        WebElement writeBodyElement = driver.findElement(By.cssSelector(".public-DraftStyleDefault-block"));
        writeBodyElement.sendKeys("It's getting harder");

        driver.findElement(By.xpath("//div[2]/button/span")).click();
        Actions publishElement = new Actions(driver);
        publishElement.click(driver.findElement(By.xpath("/html/body/div[11]/footer/div/div/div[2]/div[2]/div/footer/div/button/span")));
        publishElement.build().perform();

        String URL = driver.getCurrentUrl();
        Assertions.assertEquals(URL, "https://www.livejournal.com/post");
        Thread.sleep(5000);
    }

    @Test
    void AddCommenttest() throws InterruptedException {
        // Test# 3. Add comment to someone's post
        Actions findpostElement = new Actions(driver);
        findpostElement.click(driver.findElement(By.xpath("//*[@id=\"js\"]/body/div[2]/div[3]/div[1]/section[1]/div/div/div[1]/div[1]/div/div/article/a")));
        findpostElement.build().perform();
        WebElement addcmntElement = driver.findElement(By.cssSelector(".aentry-post__socials:nth-child(2) .\\_3p:nth-child(2) .\\_w6 path"));
        addcmntElement.click();
        WebElement writecmntElement = driver.findElement(By.xpath("//*[@id=\"body\"]"));
        writecmntElement.sendKeys("Trying to add comment");

        Thread.sleep(5000);

        var publcmntElement = driver.findElement(By.xpath("//*[@id=\"comment_submit\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(publcmntElement);
        actions.click();
        actions.perform();

        Assertions.assertDoesNotThrow( ()-> driver.navigate().to("https://www.livejournal.com/"),
                "Page is not found");
    }

    @Test
    void EditPosttest() throws InterruptedException {
        // Test# 4. Edit own post
        WebElement postlistElement = driver.findElement(By.xpath("//*[@id=\"js\"]/body/div[2]/header/div[1]/nav[2]/ul/li[2]/a/span"));
        postlistElement.click();
        WebElement postElement = driver.findElement(By.xpath("//*[@id=\"entry-umed19-938\"]/header/h3/a"));
        postElement.click();

        WebElement menuElement = driver.findElement(By.cssSelector(".svgicon--more"));
        menuElement.click();
        sleep(1000);
        Actions editbtnElement = new Actions(driver);
        editbtnElement.click(driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/article[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/span[1]")));
        editbtnElement.build().perform();

        var editpostElement = driver.findElement(By.cssSelector(".aentry-post__block--unstyled > div"));
        editpostElement.click();
        Actions actionDelete = new Actions(driver);
        Action keydown = actionDelete.keyDown(Keys.CONTROL).sendKeys("a").build();
        keydown.perform();
        actionDelete.sendKeys(Keys.DELETE);
        actionDelete.perform();
        Thread.sleep(5000);

//Etot kod ne srabativaet, no bez nego ne rabotaet OSNOVNOI
        WebElement updpostElement = driver.findElement(By.cssSelector(".public-DraftStyleDefault-block.public-DraftStyleDefault-ltr"));
        updpostElement.click();
        updpostElement.sendKeys("Autumn again came down");
//Eto OSNOVNOI kod dlya dobavleniya zapisi v blog
        WebElement updpostElement2 = driver.findElement(By.cssSelector(".public-DraftStyleDefault-block.public-DraftStyleDefault-ltr"));
        updpostElement2.click();
        updpostElement2.sendKeys("Autumn again came down2");

        driver.findElement(By.xpath("/html/body/div[10]/footer/div/div/div[2]/div[2]/button/span")).click();
        Thread.sleep(5000);
        Actions publishElement2 = new Actions(driver);
        publishElement2.click(driver.findElement(By.xpath("/html[1]/body[1]/div[10]/footer[1]/div[1]/div[1]/div[2]/div[2]/div[1]/footer[1]/div[1]/button[1]/span[1]")));
        publishElement2.build().perform();
      }

         @Test
       void Helptest() throws InterruptedException {
       // Test# 5. Help apply
             WebElement menuElement = driver.findElement(By.cssSelector(".s-header-item--user.s-header-item--has-sub.s-header-item--personal.s-drop-master"));
             Thread.sleep(5000);
             Actions actionProviderMove = new Actions(driver);
             // Performs mouse move action onto the element
             actionProviderMove.moveToElement(menuElement).build().perform();
             Thread.sleep(5000);
             WebElement help = driver.findElement(By.cssSelector(".s-header-sub-list-item--support > a"));
             Actions helpclk = new Actions(driver);
             helpclk.moveToElement(help);
             Thread.sleep(5000);
             helpclk.click().build().perform();

             WebElement askElement = driver.findElement(By.xpath("//*[@id=\"js\"]/body/div[2]/div[3]/div[1]/div/div[2]/div/div[1]/h3/a"));
             askElement.click();

             WebElement urlElement = driver.findElement(By.xpath("//*[@id=\"url\"]"));
             urlElement.click();
             urlElement.sendKeys("https://www.livejournal.com/shop/");
             WebElement headElement = driver.findElement(By.xpath("//*[@id=\"subject\"]"));
             headElement.click();
             headElement.sendKeys("Can't register payment");
             WebElement messgElement = driver.findElement(By.xpath("//*[@id=\"message\"]"));
             messgElement.click();
             messgElement.sendKeys("Can't register my card, give it for free");
             sleep(1000);

             Actions sendbtnElement = new Actions(driver);
             sendbtnElement.click(driver.findElement(By.xpath("//*[@id=\"support_submit\"]")));
             sendbtnElement.build().perform();
         }

    @AfterAll
    static void close(){
        driver.quit();
    }

}
