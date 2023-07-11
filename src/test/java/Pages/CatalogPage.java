package Pages;

import StepDefinations.Base;
import Utils.CommonMethods;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CatalogPage extends Base {
    private final By sortButton = By.xpath(props.getProperty("sortButton"));
    private final By pageTitle = By.xpath(props.getProperty("pageTitle"));
    private final By cartButton = By.xpath(props.getProperty("cartButton"));
    private static final By menuButton = By.xpath(props.getProperty("menuButton"));
    private static final By productNumber6 = By.xpath(props.getProperty("productNumber6"));
    private final By productNumber5 = By.xpath(props.getProperty("productNumber5"));

    public void clickOnSortButton() throws InterruptedException {
        CommonMethods.clickOnElement(sortButton);
    }
    public void clickOnCartButton() throws InterruptedException {
        CommonMethods.clickOnElement(cartButton);
        CommonMethods.addLogToReport("Clicked On Cart Button");
    }
    public void clickOnMenuButton() throws InterruptedException {
        CommonMethods.clickOnElement(menuButton);
        CommonMethods.addLogToReport("Clicked On Menu Button");
    }
    public void userOnCatalogPage(){
        if(driver.findElement(pageTitle).isDisplayed()){
            CommonMethods.addLogToReport("user is on catalog page");
        }
    }
    public void navigateTillProduct(){
        CommonMethods.swipeUtilTextVisible((driver.findElement(productNumber6)).getText());
    }

    public static void clickOnProduct(By Element){
        CommonMethods.clickOnElement(productNumber6);
    }
    public static void clickOnProduct(String Element){
        CommonMethods.clickOnElement(productNumber6);
    }

    public CatalogPage(IOSDriver driver){
        Base.driver = driver;
    }
}
