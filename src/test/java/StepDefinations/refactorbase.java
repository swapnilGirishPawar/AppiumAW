//package StepDefinations;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import io.appium.java_client.ios.IOSDriver;
//import io.appium.java_client.ios.options.XCUITestOptions;
//import io.appium.java_client.service.local.AppiumDriverLocalService;
//import org.testng.annotations.*;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.ServerSocket;
//import java.net.URL;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.Properties;
//
//public class refactorbase {
//    // Variables :-
//    public static InputStream file;
//    public static IOSDriver driver;
//    public static AppiumDriverLocalService service;
//    protected static Properties props = new Properties();
//    public static ExtentReports extentReport;
//    public static ExtentSparkReporter sparkReporter;
//    public static ExtentTest extentLogger;
//
//
//    // Server Configurations:-
//    public static Boolean checkIfServerIsRunning(int port)
//    {
//        boolean isServerRunning=false;
//        ServerSocket serversocket;
//        try{
//            serversocket = new ServerSocket(port);
//            serversocket.close();
//        }
//        catch(IOException e)
//        {
//            isServerRunning = true;
//        }
//
//        return isServerRunning;
//    }
//
//    public static AppiumDriverLocalService startServer(){
//        Boolean flag = checkIfServerIsRunning(4723);
//        if(!flag){
//            service = AppiumDriverLocalService.buildDefaultService();
//            service.start();
//        }
//        return service;
//    }
//
//    // Simulator Configuration :-
//        public static void StartEmulator() throws IOException, InterruptedException {
//        Runtime.getRuntime().exec(System.getProperty("user.dir")+"/Library/Developer/CoreSimulator/Devices/3566F5C1-A152-409F-BEA1-147905D384D0");
//        Thread.sleep(15000);
//    }
//
//    // Config File reader :-
//    public static void fileLoader(String filePath) throws IOException {
//        file = Files.newInputStream(Paths.get(filePath));
//        props.load(file);
//    }
//
//    public static void configPropertiesReader() throws IOException {
//        fileLoader("src/test/resources/Properties/Config.properties");
//        fileLoader("src/test/resources/Properties/CatalogPageLocators.properties");
//        fileLoader("src/test/resources/Properties/CartPageLocators.properties");
//        fileLoader("src/test/resources/Properties/MenuPageLocators.properties");
//        fileLoader("src/test/resources/Properties/LogInPageLocators.properties");
//    }
//
//
//    @BeforeSuite
//    public void beforeSuite(){
//        service = startServer();
//    }
//    @BeforeTest
//    public void beforeTest() throws IOException {
//        configPropertiesReader();
//        String automationName = props.getProperty("automationName");
//        String platformName = props.getProperty("platformName");
//        String deviceName = props.getProperty("deviceName");
//        String deviceType = props.getProperty("deviceType");
//        String appPath = props.getProperty("appPath");
//        String appiumUrl = props.getProperty("appiumUrl");
//
//        if(deviceType.equalsIgnoreCase("Simulator") && platformName.equalsIgnoreCase("iOS")){
////            StartEmulator();
//            XCUITestOptions options =new XCUITestOptions();
//            options.setDeviceName(deviceName);
//            options.setPlatformName(platformName);
//            options.setApp(System.getProperty("user.dir")+appPath);
//            options.setAutomationName(automationName);
//            driver = new IOSDriver(new URL(appiumUrl), options);
//            System.out.println("iOS app launched in Simulator");
//
//            extentLogger = extentReport.createTest("Scenario:- ");
//            extentLogger.log(Status.INFO, "this is info");
//
//
//        } else if (deviceType.equalsIgnoreCase("real Device") && platformName.equalsIgnoreCase("iOS")) {
//            // capabilities for launching the real device :-
//            XCUITestOptions options =new XCUITestOptions();
//            options.setDeviceName(deviceName);
//            options.setPlatformName(platformName);
//            options.setApp(System.getProperty("user.dir")+appPath);
//            options.setAutomationName(automationName);
//            driver = new IOSDriver(new URL(appiumUrl), options);
//            System.out.println("iOS app launched in real device");
//        }
//    }
//    @BeforeMethod // this will execute before each test
//    public void beforeMethod(){
//        System.out.println("BM");
//    }
//
//    @Test
//    public void test1(){
//        System.out.println("Test1");
//    }
//
//    @AfterMethod
//    public void AfterMethod(){
//        System.out.println("AM");
//    }
//    @AfterTest
//    public void afterTest(){
//        driver.terminateApp("com.saucelabs.mydemoapp.rn");
//        System.out.println("App terminated successfully");
//    }
//    @AfterSuite
//    public void afterSuite(){
//        service.stop();
//    }
//}
