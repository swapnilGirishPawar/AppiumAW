package Utils;

import StepDefinations.Base;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.appium.java_client.TouchAction;
import jdk.internal.vm.compiler.word.Pointer;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
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


//    public static void addLogToReport(String log) {
//        ExtentCucumberAdapter.addTestStepLog(log);
//    }
    public static  void clickOnElement(By eleme){
        if(driver.findElement(eleme).isDisplayed()) {
            WebElement element = driver.findElement(eleme);
            Point location = element.getLocation();
            Dimension size = element.getSize();
            Point center =  getCenterOfElement(location, size);
            PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
            Sequence sequence = new Sequence(finger1, 1)
                    .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), center))
                    .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(new Pause(finger1, Duration.ofMillis(200)))
                    .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Collections.singletonList(sequence));
        }
        else {
            System.out.println(eleme+"-> is not present");
        }

    }
    public static void sendKeysEnter(By element) throws InterruptedException {
        if(driver.findElement(element).isDisplayed()) {
            Thread.sleep(1500);
            driver.findElement(element).sendKeys(Keys.ENTER);
        }
        else {
            System.out.println(element+"-> is not present");
        }

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
    public static By isElementDisplayed(By element) throws Throwable {

        Assert.assertTrue(driver.findElement(element).isDisplayed());
        return element;
    }

    public void clearField(By element){
            driver.findElement(element).clear();
    }

// soft asserts
    protected static SoftAssert sa = new SoftAssert();
    public static void addLogToReport(String messageToBeAddInReport) {
        try {
            ExtentCucumberAdapter.addTestStepLog(messageToBeAddInReport);
        } catch (Exception e ){
            e.printStackTrace();
        }
    }
    public static void isSoftElementDisplayed(By actualElement, By expectedElement){
        sa.assertEquals(actualElement, expectedElement);
        addLogToReport("Actual element :- "+actualElement);
        addLogToReport("Expected element :- "+expectedElement);
    }
    // overload -
    public static void isSoftElementDisplayed(String actualElementLocator, String expectedElementLocator){
        WebElement actualElement = driver.findElement(By.xpath(actualElementLocator));
        WebElement expectedElement = driver.findElement(By.xpath(expectedElementLocator));
        sa.assertEquals(actualElement, expectedElement);
        sa.assertAll();
        addLogToReport("Actual element :- "+actualElement);
        addLogToReport("Expected element :- "+expectedElement);
    }

    public static void softElementTrue(By element){
        sa.assertTrue(driver.findElement(element).isDisplayed());
        addLogToReport("Element to be True :- "+element);
    }
    // overload -
    public static void softElementTrue(String locator){
        WebElement element = driver.findElement(By.xpath(locator));
        sa.assertTrue(element.isDisplayed());
        addLogToReport("locator to be True :- "+locator);
    }

    public static void softElementFalse(By element){
        sa.assertFalse(driver.findElement(element).isDisplayed());
        addLogToReport("Element to be False :- "+element);
    }
    // overload -
    public static void softElementFalse(String locator){
        WebElement element = driver.findElement(By.xpath(locator));
        sa.assertFalse(element.isDisplayed());
        addLogToReport("locator to be False :- "+locator);
    }

    // Gestures, tap on element(using appium java client)
    // added lines in the clickOnElement function.
    public static Point getCenterOfElement(Point location, Dimension size){
        return new Point(location.getX() + size.getWidth() / 2,
                         location.getY() + size.getHeight() / 2);
    }

    // Double tap On element
    public void doubleTapOnElement(By ele){
        WebElement element = driver.findElement(ele);
        Point location = element.getLocation();
        Dimension size = element.getSize();
        Point center =  getCenterOfElement(location, size);
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), center))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(100)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(100)))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(100)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(sequence));
    }

    // Long press on element -
    public void longPressOnElement(By eleme, int seconds){
        WebElement element = driver.findElement(eleme);
        Point location = element.getLocation();
        Dimension size = element.getSize();
        Point center =  getCenterOfElement(location, size);
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), center))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofSeconds(seconds)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(sequence));
    }
    // Zoom gestures
    public void zoomOnTheElement(By ele){
        WebElement element = driver.findElement(ele);

        Point center = getCenterOfElement(element.getLocation(), element.getSize());
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");
        Sequence sequence1 = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), center))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), center.getX()+100, center.getY()-100))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        Sequence sequence2 = new Sequence(finger2, 1)
                .addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), center))
                .addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger2, Duration.ofMillis(200)))
                .addAction(finger2.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), center.getX()-100, center.getY()+100))
                .addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(sequence1, sequence2));
    }

    // Swiping / scrolling gesture using appium java client -
        // this function will only do scroll action. doesn't find for particular element.
    public void scrollOnScreen(){
        Dimension size =  driver.manage().window().getSize();
        int startX = size.getWidth() / 2;
        int startY = size.getHeight() / 2;
        int endX = startX;
        int endY = (int) (size.getHeight() * 0.25);
        PointerInput finger1 =  new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(sequence));
    }

    public void scrollUntilElement(By Ele){
        WebElement element = driver.findElement(Ele);
        if(!element.isDisplayed()) {
            Dimension size = driver.manage().window().getSize();
            int startX = size.getWidth() / 2;
            int startY = size.getHeight() / 2;
            int endX = startX;
            int endY = (int) (size.getHeight() * 0.25);
            PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
            Sequence sequence = new Sequence(finger1, 1)
                    .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                    .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(new Pause(finger1, Duration.ofMillis(200)))
                    .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
                    .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Collections.singletonList(sequence));
        }
        else {
            System.out.println(element + " element is displayed on the screen, ready to perform action on it");
        }
    }

    // Drag and drop action - appium java client
    public void dragAndDrop(By ele1, By ele2){
        WebElement element1 = driver.findElement(ele1);
        WebElement element2 = driver.findElement(ele2);
        Point center1 = getCenterOfElement(element1.getLocation(), element1.getSize());
        Point center2 = getCenterOfElement(element2.getLocation(), element2.getSize());

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), center1))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(500)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), center2))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(sequence));

    }
}