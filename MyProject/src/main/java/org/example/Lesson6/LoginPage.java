package org.example.Lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasicPage {
    @FindBy(xpath = "//*[@id=\"js\"]/body/div[2]/header/div[1]/nav[2]/ul/li[2]/a")
    public WebElement loginField;

    @FindBy(xpath = "//input[@id='user']")
    public WebElement inputLogin;

    @FindBy(xpath = "//input[@id='lj_loginwidget_password']")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[@class='b-loginform-btn b-loginform-btn--login b-loginform-btn--auth b-loginform-btn--center']")
    public WebElement loginButton;

    public LoginPage fillInputLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    public LoginPage fillInputPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    public MainPage clickLoginButton() {
        loginButton.click();
        return new MainPage(driver);
    }

    public void login(String login, String password) {
        loginField.click();
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        loginButton.click();
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickloginField() {
        loginField.click();
        return this;
    }
}
