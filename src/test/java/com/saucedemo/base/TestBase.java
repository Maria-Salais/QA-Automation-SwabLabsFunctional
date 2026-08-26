package com.saucedemo.base;
import com.aventstack.extentreports.ExtentReports;
import com.saucedemo.utils.ExtentReportManager;
import com.saucedemo.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.Properties;

public class TestBase {
    public WebDriver driver;
    public Properties config = new Properties();
    public Properties OR = new Properties();
    public Properties inputData = new Properties();
    public Utils utils = new Utils();
    public ExtentReportManager reportManager = new ExtentReportManager();
    public ExtentReports report;

    @BeforeClass
    public void setUp() throws Exception {

        try {
            config.load(TestBase.class.getClassLoader().getResourceAsStream("properties/config.properties"));
            OR.load(TestBase.class.getClassLoader().getResourceAsStream("properties/OR.properties"));
            inputData.load(TestBase.class.getClassLoader().getResourceAsStream("properties/input-values.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String browser = config.getProperty("browserType");

        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", config.getProperty("chromeDriverPath"));
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.firefox.driver", config.getProperty("geckoDriverPath"));
            driver = new FirefoxDriver();
        } else if (browser.equals("safari")) {
            System.setProperty("webdriver.safari.driver", config.getProperty("safariDriverPath"));
            driver = new SafariDriver();
        } else if (browser.equals("edge")) {
            System.setProperty("webdriver.edge.driver", config.getProperty("edgeDriverPath"));
            driver = new EdgeDriver();
        } else {
            throw new Exception("Browser incorrecto");
        }

        report = reportManager.createReport(config.getProperty("testReportPath"), config.getProperty("browserType"),
                config.getProperty("loginBaseURL"));
    }

    @AfterClass
    public void postconditions() {
        driver.quit();
        report.flush();

    }
}
