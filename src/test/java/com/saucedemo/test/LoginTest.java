package com.saucedemo.test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.saucedemo.base.TestBase;


import com.saucedemo.pages.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;


public class LoginTest extends TestBase {
    String loginBaseURL;

    @Test()
    public void loginExitosoPOM() throws InterruptedException, IOException {
        loginBaseURL = config.getProperty("loginBaseURL");

        driver.get(loginBaseURL);
        driver.manage().window().maximize();

        ExtentTest test = this.report.createTest("TC-001 - Login de usuario exitoso con credenciales válidas (Page Object Model)");

        test.log(Status.INFO, "Datos del login");
        test.info(MediaEntityBuilder.createScreenCaptureFromPath(utils.captureScreen(this.driver, config.getProperty("testEvidencePath"))).build());

        LoginPage loginPage = new LoginPage(driver, OR);
        loginPage.login(inputData.getProperty("validUsernameValue"), inputData.getProperty("validPasswordValue"));

        test.log(Status.PASS, "Login Exitoso1");
        test.pass(MediaEntityBuilder.createScreenCaptureFromPath(utils.captureScreen(this.driver, config.getProperty("testEvidencePath"))).build());

        Thread.sleep(2000);
    }


}
