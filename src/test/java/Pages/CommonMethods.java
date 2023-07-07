package Pages;

import StepDefinations.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;

public class CommonMethods extends Base {
    public static  void clickOnElement(By element){
        driver.findElement(element).click();
    }

    public static void enterText(String text, By element){
        driver.findElement(element).sendKeys(text);
    }

    // Swipe Methods
    public static void swipeByPercentage(){

    }
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

    // Visibility methods
    public static void waitForTextVisibility(By element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}