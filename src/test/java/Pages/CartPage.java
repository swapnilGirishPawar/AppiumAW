package Pages;

import StepDefinations.Base;
import Utils.CommonMethods;
import io.appium.java_client.CommandExecutionHelper;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CartPage extends Base {
    private final By cartPageText = By.xpath(props.getProperty("emptyCartPageText"));
    private final By cartPageTitle = By.xpath(props.getProperty("cartPageTitle"));
    private final By cartPageProductRow = By.xpath(props.getProperty("cartPageProductRow"));
    private final By checkoutButton = By.xpath(props.getProperty("checkoutButton"));
    private final By productLabel = By.xpath(props.getProperty("productLabel"));
    private final By ProductPageCounterAmount = By.xpath(props.getProperty("ProductPageCounterAmount"));

public void userOnEmptyCartPage(){
    driver.findElement(cartPageText).isDisplayed();
}

public void cartPageIsEmpty(){
    driver.findElement(cartPageText).isDisplayed();
}
public void quantityVisibleInCart(int count) throws Throwable {
        CommonMethods.isElementDisplayed(ProductPageCounterAmount);
        String CountAmount = (driver.findElement(ProductPageCounterAmount)).getText();
        Assert.assertEquals(String.valueOf(count), CountAmount);
    System.out.println("required amount:- "+count+" & page Amount:- "+CountAmount);
    }

    public void clickOnCartButton() throws InterruptedException {
        CommonMethods.clickOnElement(By.xpath(props.getProperty("cartButton")));
        CommonMethods.addLogToReport("Clicked On Cart Button");
    }


public CartPage(IOSDriver driver){
    Base.driver = driver;
}


}
