package StepDefinations;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;
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
    public static InputStream file;
    public static IOSDriver driver;

    Properties props = new Properties();
    public void propertiesReader() throws IOException {
        file = Files.newInputStream(Paths.get("src/test/resources/Properties/config.properties"));
        props.load(file);
    }


    @Before
    public void launchApplication() throws IOException, InterruptedException {
        System.out.println("app");
        propertiesReader();
        String automationName = props.getProperty("automationName");
        String platformName = props.getProperty("platformName");
        String deviceName = props.getProperty("deviceName");
        String deviceType = props.getProperty("deviceType");
        String appPath = props.getProperty("appPath");
        String appiumUrl = props.getProperty("appiumUrl");

        if(deviceType.equalsIgnoreCase("Simulator") && platformName.equalsIgnoreCase("iOS")){

            XCUITestOptions options =new XCUITestOptions();
            options.setDeviceName(deviceName);
            options.setPlatformName(platformName);
            options.setApp(System.getProperty("user.dir")+appPath);
            options.setAutomationName(automationName);
            driver = new IOSDriver(new URL(appiumUrl), options);
            System.out.println("iOS app launched");Thread.sleep(2000);

        } else if (deviceType.equalsIgnoreCase("real Device") && platformName.equalsIgnoreCase("iOS")) {
            // capabilities for launching the real device :-
            XCUITestOptions options =new XCUITestOptions();
            options.setDeviceName(deviceName);
            options.setPlatformName(platformName);
            options.setApp(System.getProperty("user.dir")+appPath);
            options.setAutomationName(automationName);
            driver = new IOSDriver(new URL(appiumUrl), options);
            System.out.println("iOS app launched");Thread.sleep(2000);

        }

        System.out.println("app launched");
    }

    @BeforeStep // this will execute before step definition
    public void beforeStep(){
        System.out.println("this is @BeforeStep");
    }

    @AfterStep
    public void takeScreenshot(Scenario scenario) {
        System.out.println("this is @AfterStep");
//        final byte []  screenshot =((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//        scenario.attach(screenshot, "img/png", "image");
    }
    @After // execute after each scenario
    public void afterTest() {
        System.out.println("this is @After");
//        driver.close();
//        driver.quit();
    }
}
