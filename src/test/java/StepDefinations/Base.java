package StepDefinations;


import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterSuite;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Base {
    public static InputStream file;
    public static IOSDriver driver;
    public static AppiumDriverLocalService service;
    protected static Properties props = new Properties();

    public static void fileLoader(String filePath) throws IOException {
        file = Files.newInputStream(Paths.get(filePath));
        props.load(file);
    }
    public static void configPropertiesReader() throws IOException {
        fileLoader("src/test/resources/Properties/config.properties");
        fileLoader("src/test/resources/Properties/CatalogPageLocators.properties");
        fileLoader("src/test/resources/Properties/CartPageLocators.properties");
        fileLoader("src/test/resources/Properties/MenuPageLocators.properties");
        fileLoader("src/test/resources/Properties/LogInPageLocators.properties");
    }

    public static Boolean checkIfServerIsRunning(int port)
    {
        boolean isServerRunning=false;
        ServerSocket serversocket;
        try{
            serversocket = new ServerSocket(port);
            serversocket.close();
        }
        catch(IOException e)
        {
            isServerRunning = true;
        }

        return isServerRunning;
    }

    public static AppiumDriverLocalService startServer(){
        Boolean flag = checkIfServerIsRunning(4723);
        if(!flag){
            service = AppiumDriverLocalService.buildDefaultService();
            service.start();
        }
        return service;
    }
//    public static void StartEmulator() throws IOException, InterruptedException {
//        Runtime.getRuntime().exec(System.getProperty("user.dir")+"/Library/Developer/CoreSimulator/Devices/3566F5C1-A152-409F-BEA1-147905D384D0");
//        Thread.sleep(15000);
//    }


    @Before
    public void launchApplication() throws IOException, InterruptedException {
        service = startServer();
        configPropertiesReader();
        String automationName = props.getProperty("automationName");
        String platformName = props.getProperty("platformName");
        String deviceName = props.getProperty("deviceName");
        String deviceType = props.getProperty("deviceType");
        String appPath = props.getProperty("appPath");
        String appiumUrl = props.getProperty("appiumUrl");

        if(deviceType.equalsIgnoreCase("Simulator") && platformName.equalsIgnoreCase("iOS")){
//            StartEmulator();
            XCUITestOptions options =new XCUITestOptions();
            options.setDeviceName(deviceName);
            options.setPlatformName(platformName);
            options.setApp(System.getProperty("user.dir")+appPath);
            options.setAutomationName(automationName);
            driver = new IOSDriver(new URL(appiumUrl), options);
            System.out.println("iOS app launched in Simulator");Thread.sleep(2000);

        } else if (deviceType.equalsIgnoreCase("real Device") && platformName.equalsIgnoreCase("iOS")) {
            // capabilities for launching the real device :-
            XCUITestOptions options =new XCUITestOptions();
            options.setDeviceName(deviceName);
            options.setPlatformName(platformName);
            options.setApp(System.getProperty("user.dir")+appPath);
            options.setAutomationName(automationName);
            driver = new IOSDriver(new URL(appiumUrl), options);
            System.out.println("iOS app launched in real device");Thread.sleep(2000);
        }
    }

//    @BeforeStep // this will execute before step definition
//    public void beforeStep(){
//        System.out.println("this is @BeforeStep");
//    }

    @AfterStep
    public void takeScreenshot(Scenario scenario) {
        final byte []  screenshot =((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "img/png", "image");
    }

    @After // execute after each scenario
    public void afterMethod() {
        driver.terminateApp("com.saucelabs.mydemoapp.rn");
        System.out.println("App terminated successfully");
    }

    @AfterSuite
    public void afterSuite(){
        service.stop();
        System.out.println("service stopped");
    }

}
