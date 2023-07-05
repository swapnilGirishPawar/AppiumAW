package com.test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.cucumber.java.Before;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Base {
    public InputStream file;
    Properties props = new Properties();
    public void propertiesReader() throws IOException {
        file = Files.newInputStream(Paths.get("src/test/resources/ConfigProperties/config.properties"));
        props.load(file);
    }


    @BeforeTest
    public void launchApplication() throws IOException, InterruptedException {
        propertiesReader();
        String automationName = props.getProperty("automationName");
        String platformName = props.getProperty("platformName");
        String deviceName = props.getProperty("deviceName");
        String appPath = props.getProperty("appPath");
        System.out.println("here"+appPath);
        String appiumUrl = props.getProperty("appiumUrl");

        if(props.getProperty("platformName").equalsIgnoreCase("Android")){
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName(platformName);
            options.setAutomationName(automationName);
            options.setDeviceName(deviceName);
            options.setApp(System.getProperty("user.dir")+appPath);
            AndroidDriver driver = new AndroidDriver(new URL(appiumUrl), options);
            System.out.println("Android app launched");Thread.sleep(2000);
        }
        else if(props.getProperty("platformName").equalsIgnoreCase("iOS")){
            XCUITestOptions options =new XCUITestOptions();
            options.setDeviceName(deviceName);
            options.setApp(System.getProperty("user.dir")+appPath);
            IOSDriver driver = new IOSDriver(new URL(appiumUrl), options);
            System.out.println("iOS app launched");Thread.sleep(2000);
        }
    }

    @Test
    public void test1(){
        System.out.println("App launched");
    }

    @Test
    public void test2() throws InterruptedException {
        System.out.println("App launched");
        Thread.sleep(2000);
    }
}
