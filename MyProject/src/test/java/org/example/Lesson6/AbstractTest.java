package org.example.Lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.OptionsWithArguments;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractTest {

    static WebDriver driver;;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void init(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

//    @BeforeEach
//    void initDriver() {
//        driver = new ChromeDriver();
//        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    }

    @AfterAll
    static void close() {
        driver.quit();
    }

   }
