package Utils;

import StepDefinations.Base;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.HashMap;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class CommonMethods extends Base {

    // CommonMethods :
//    1 clickOnElement(By element)
//    2. enterText(String text, By element)
//    3. swipeByCount(int count)
//    4. swipeUtilElementVisible(String attribute, String typeOfAttribute)
//    5. swipeUtilTextVisible(String text)
//    6. waitForTextVisibility(By element)
//    7. addLogToReport(String log)
//    8. killAndLaunchApp()
//    9. isElementDisplayed(By element)
//    10. clearField(By element)

    public static void addLogToReport(String log) {
        ExtentCucumberAdapter.addTestStepLog(log);
    }
    public static  void clickOnElement(By element){
        driver.findElement(element).click();
    }

    public static void enterText(String text, By element){
        driver.findElement(element).sendKeys(text);
    }

    // Swipe Methods
    public static void swipeByCount(){

    }
    public static void swipeUtilElementVisible( String attribute, String typeOfAttribute){
        HashMap<String, Object> scrollObject = new HashMap<>();
        scrollObject.put("direction", "down");
        scrollObject.put(typeOfAttribute, attribute);
        driver.executeScript("mobile:scroll", scrollObject);
        driver.findElement(By.id(attribute));
    }
    public static void swipeUtilTextVisible(String text){

    }


    public void longPressOnElement(By Element){
        TouchAction action = new TouchAction(driver);
        action.longPress(longPressOptions().withElement(element(driver.findElement(Element))).withDuration(Duration.ofSeconds(5)))
                .release().perform();
//        action.tap(TapOptions.tapOptions().withElement(ElementOption.element(driver.findElement(Element)))).perform();
    }

    // Visibility methods
    public static void waitForTextVisibility(By element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }



    public void killAndLaunchApp(){
        driver.terminateApp(props.getProperty("bundleId"));
    }

    // Assertions:-
    public By isElementDisplayed(By element) throws Throwable {

        Assert.assertTrue(driver.findElement(element).isDisplayed());
        return element;
    }

    public void clearField(By element){
            driver.findElement(element).clear();
    }


}