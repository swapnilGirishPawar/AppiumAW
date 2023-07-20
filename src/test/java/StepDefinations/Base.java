package StepDefinations;


import Utils.Stopwatch;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.cucumber.java.*;
import net.datafaker.providers.entertainment.SouthPark;
import org.openqa.selenium.OutputType;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import static Utils.Stopwatch.printElapsedTime;
import static Utils.Stopwatch.stopAndResetStopwatch;

public class Base {
    public static InputStream file;
    public static IOSDriver driver;
    public static AppiumDriverLocalService service;
    protected static Properties props = new Properties();
    protected static SoftAssert soft = new SoftAssert();
    static Stopwatch stopwatch = new Stopwatch();

    public static void fileLoader(String filePath) throws IOException {
        file = Files.newInputStream(Paths.get(filePath));
        props.load(file);
    }
    public static void configPropertiesReader() throws IOException {
        fileLoader("src/test/resources/Properties/Config.properties");
        fileLoader("src/test/resources/Properties/CatalogPageLocators.properties");
        fileLoader("src/test/resources/Properties/CartPageLocators.properties");
        fileLoader("src/test/resources/Properties/MenuPageLocators.properties");
        fileLoader("src/test/resources/Properties/LogInPageLocators.properties");
        fileLoader("src/test/resources/Properties/ProductPageLocators.properties");
    }
    public static Boolean checkIfServerIsRunning(int port) {
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

//            AppiumServiceBuilder builder = new AppiumServiceBuilder();
//            builder
//                    .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
//                    .usingDriverExecutable(new File("/usr/local/bin/node"))
//                    .usingPort(4723)
//                    .withLogFile(new File("test-output/AppiumLogs/"+"AppiumLog.txt"));
//            service =  AppiumDriverLocalService.buildService(builder);
//            service.start();
        }
        return service;
    }
    public static void launchApplication() throws IOException {
            service = startServer();
            configPropertiesReader();
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

            } else if (deviceType.equalsIgnoreCase("real Device") && platformName.equalsIgnoreCase("iOS")) {
                // capabilities for launching the real device :-
                XCUITestOptions options =new XCUITestOptions();
                options.setDeviceName(deviceName);
                options.setPlatformName(platformName);
                options.setApp(System.getProperty("user.dir")+appPath);
                options.setAutomationName(automationName);
                driver = new IOSDriver(new URL(appiumUrl), options);
            }
    }
//    @AfterStep
//    public static void takeScreenshot(Scenario scenario) {
//        final byte []  screenshot =((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//        scenario.attach(screenshot, "img/png", "image");
//    }

    @AfterStep
    public void screenShot(Scenario scenario){
        byte[] screenshotBytes = driver.getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshotBytes, "image/png", "screenshot");
    }
    @After // execute after each scenario
    public static void afterScenario(Scenario scenario) {
        byte[] screenshotBytes = driver.getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshotBytes, "image/png", "screenshot");
//        soft.assertAll();

    }
    @BeforeAll
    public static void beforeAl() throws IOException {
        stopwatch.start();
        launchApplication();
    }
    @AfterAll
    public static void afterAll(){
        service.stop();
        stopAndResetStopwatch(stopwatch);
    }


}
