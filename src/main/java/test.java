//package appium.mobileframework;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.net.ServerSocket;
//import java.net.URL;
//import java.util.Properties;
//
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.AndroidElement;
//import io.appium.java_client.remote.AndroidMobileCapabilityType;
//import io.appium.java_client.remote.AutomationName;
//import io.appium.java_client.remote.MobileCapabilityType;
//import io.appium.java_client.service.local.AppiumDriverLocalService;
//import io.appium.java_client.service.local.AppiumServiceBuilder;
//import io.appium.java_client.remote.MobileBrowserType;
//
//public class capabilities {
//
//    public static String appPackage, appActivity, deviceName, platformName;
//
//    public AppiumDriverLocalService service;
//
//    public AppiumDriverLocalService startServer()
//    {
//
//        Boolean flag = checkIfServerIsRunning(4723);
//        if (!flag)
//        {
//            service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
//                    .usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
//                    .withAppiumJS(new File("C:\\Users\\user\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//                    .withIPAddress("120.0.0.1").usingPort(4723));
//            service.start();
//        }
//        return service;
//    }
//
//
//    public static Boolean checkIfServerIsRunning(int port) {
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
//        finally {
//            serversocket=null;
//        }
//        return isServerRunning;
//    }
//
//    public static void StartEmulator() throws IOException, InterruptedException {
//        Runtime.getRuntime().exec("C:\\Users\\user\\eclipse-workspace\\MobileFramework\\src\\main\\resources\\emulator.bat");
//        Thread.sleep(15000);
//    }
//
//
//
//    public static AndroidDriver<AndroidElement> capability() throws IOException, InterruptedException {
//
//        FileReader file = new FileReader(System.getProperty("user.dir")+"\\src\\main\\java\\global.properties");
//        Properties pro = new Properties();
//        pro.load(file);
//        appPackage = pro.getProperty("appPackage");
//        appActivity = pro.getProperty("appActivity");
//        deviceName = pro.getProperty("deviceName");
//        platformName = pro.getProperty("platformName");
//
//
//        if (deviceName.contains("pixelphone"))
//        {
//            StartEmulator();
//            Thread.sleep(15000);
//        }
//
//
//        DesiredCapabilities cap = new DesiredCapabilities();
//        cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
//        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
//        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
//        cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "C:\\Swapnil\\Selenium\\chromedriver_win32\\chromedriver.exe");
//        cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
//        cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
//        cap.setCapability(MobileCapabilityType.NO_RESET, true);
//        cap.setCapability(AndroidMobileCapabilityType.NO_SIGN,true);
//        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(cap);
//
//
//        //AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
//
//        return driver;
//    }
//
//}