package com.saucedemo.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;



public class ExtentReportManager {



    public ExtentReports createReport(String reportPath, String browser, String baseURL) {
        String currentDate = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
        String fileName = String.format("%sE 2ETestReport_%s.html", reportPath, currentDate);

        ExtentReports extentReport = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(fileName);

        spark.config().setTimeStampFormat("dd MMM yyyy HH:mm:ss z");
        spark.config().setTheme(Theme.DARK);

        extentReport.attachReporter(spark);
        extentReport.setSystemInfo("Platform", System.getProperty("os.name"));
        extentReport.setSystemInfo("Version", System.getProperty("os.version"));
        extentReport.setSystemInfo("Browser", browser);
        extentReport.setSystemInfo("Context URL", baseURL);

        return extentReport;
    }
}
