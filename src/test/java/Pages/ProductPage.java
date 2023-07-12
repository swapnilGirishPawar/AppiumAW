package Pages;

import StepDefinations.Base;
import Utils.CommonMethods;
import io.appium.java_client.CommandExecutionHelper;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class ProductPage extends Base {
    private final By productPageTitle = By.xpath(props.getProperty("productPageTitle"));
    private final By counterPlusButton = By.xpath(props.getProperty("counterPlusButton"));
    private final By counterMinusButton = By.xpath(props.getProperty("counterMinusButton"));
    private final By counterAmount = By.xpath(props.getProperty("counterAmount"));
    private final By addToCartButton = By.xpath(props.getProperty("addToCartButton"));

    public void clicksOnCounterAddButton(int count){
        String counter = driver.findElement(counterAmount).getText();
        for (int i = 0; i <=count; i++) {
            System.out.println("Counting ");
            CommonMethods.addLogToReport("Loop Count:- "+i+" Counter:- "+counter);
            CommonMethods.clickOnElement(counterPlusButton);
        }
    }

    public void clicksOnCounterAddButton() throws InterruptedException {
        if(driver.findElement(counterPlusButton).isDisplayed()) {
            Thread.sleep(1500);
            CommonMethods.sendKeysEnter(counterPlusButton);
        }
        else {
            System.out.println("Element not displayed");
        }
    }
    public void clicksOnCounterMinusButton(){

        int count = Integer.parseInt(driver.findElement(counterAmount).getText());
        for (int i = 0; i < count; i++) {
            CommonMethods.clickOnElement(counterMinusButton);
        }
    }

    public void clickOnAddToCartButton() throws InterruptedException {
        if(driver.findElement(addToCartButton).isDisplayed()) {
            Thread.sleep(500);
            CommonMethods.sendKeysEnter(addToCartButton);
        }
        else {
            System.out.println("Element not displayed");
        }
    }


    public ProductPage(IOSDriver driver){
        Base.driver = driver;
    }
}
