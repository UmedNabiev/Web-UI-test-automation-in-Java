package org.example.Lesson6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.example.Lesson6.LoginPage;
import java.time.Duration;
import java.time.Instant;

public class PageObjectLoginTest extends AbstractTest {

    @Test
    void loginInPageObjTest() throws InterruptedException {
        driver.get("https://www.livejournal.com/");
        new LoginPage(driver)
                .clickloginField()
                .fillInputLogin("Umed19")
                .fillInputPassword("U906906m")
                .clickLoginButton();
           }

}
