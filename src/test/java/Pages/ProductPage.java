package Pages;

import StepDefinations.Base;
import Utils.CommonMethods;
import io.appium.java_client.CommandExecutionHelper;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class ProductPage extends Base {
    private final By productPageTitle = By.xpath("productPageTitle");
    private final By counterPlusButton = By.xpath("counterPlusButton");
    private final By counterMinusButton = By.xpath("counterMinusButton");
    private final By counterAmount = By.xpath("counterAmount");
    private final By addToCartButton = By.xpath("addToCartButton");

    public void clicksOnCounterAddButton(int count){
        String counter = driver.findElement(counterAmount).getText();
        for (int i = 0; i <=count; i++) {
            System.out.println("Counting ");
            CommonMethods.addLogToReport("Loop Count:- "+i+" Counter:- "+counter);
            CommonMethods.clickOnElement(counterPlusButton);
        }
    }

    public void clicksOnCounterAddButton(){
        CommonMethods.clickOnElement(counterPlusButton);
    }
    public void clicksOnCounterMinusButton(int count){
        for (int i = 1; i <=count; i++) {
            CommonMethods.clickOnElement(counterMinusButton);
        }
    }

    public void clickOnAddToCartButton(){
        CommonMethods.clickOnElement(addToCartButton);
    }


    public ProductPage(IOSDriver driver){
        Base.driver = driver;
    }
}
