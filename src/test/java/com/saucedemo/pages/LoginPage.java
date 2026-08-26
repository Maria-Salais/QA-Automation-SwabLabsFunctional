package com.saucedemo.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;


public class LoginPage {



    public WebDriver driver;
    public Properties OR;

    public By usernameLocator;
    public By passwordLocator;
    public By loginButtonLocator;
    public By textoLoginLocator;

    public LoginPage(WebDriver driver, Properties props) {
        this.driver = driver;
        this.OR = props;

        usernameLocator = By.id(OR.getProperty("usernameInputID"));
        passwordLocator = By.id(OR.getProperty("passwordInputID"));
        loginButtonLocator = By.className(OR.getProperty("loginBtnClassName"));
    }

    public void llenarEmail(String email) {
        driver.findElement(usernameLocator).sendKeys(email);
    }

    public void llenarPassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void clickBotonLogin() {
        driver.findElement(loginButtonLocator).click();
    }

    public void login(String nombreUsuario, String password) {
        this.llenarEmail(nombreUsuario);
        this.llenarPassword(password);
        this.clickBotonLogin();
    }
}
