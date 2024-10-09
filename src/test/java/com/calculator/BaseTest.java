package com.calculator;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    AndroidDriver driver;


    @BeforeClass
    public void setupAppium(){
        try {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability("udid", "288c9cf5");
        capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("appPackage", "com.oneplus.calculator");
        capabilities.setCapability("appActivity", ".Calculator");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");



            driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);

        }

    }


    @AfterTest
    public void tearDown(){
        driver.quit();

    }

    public void takeScreenshot() {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String currentDir = System.getProperty("user.dir") + "/build/screenshots/";
            FileUtils.copyFile(scrFile, new File(currentDir + System.currentTimeMillis() + ".jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
