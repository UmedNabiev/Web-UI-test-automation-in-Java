package org.example.Lesson5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class ErrorTest extends AbstractTest {

    @Test
    void test() throws InterruptedException {
        WebDriver driver = getDriver();
        driver.get("https://www.livejournal.com/");
        driver.findElement(By.xpath("//*[@id=\"js\"]/body/div[2]/header/div[1]/nav[2]/ul/li[1]/div/form/button/span")).click();
        
        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        Thread.sleep(10000);

        WebElement webElement = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/nav[2]/ul/li[1]/div/form/div/div/input"));
            }
        });

        webElement.click();
        webElement.sendKeys("pizza");
        webElement.submit();
    }
}
