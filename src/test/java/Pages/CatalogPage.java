package Pages;

import StepDefinations.Base;
import Utils.CommonMethods;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class CatalogPage extends Base {
    private final By sortButton = By.xpath(props.getProperty("sortButton"));
    private final By pageTitle = By.xpath(props.getProperty("pageTitle"));
    private final By cartButton = By.xpath(props.getProperty("cartButton"));
    private final By menuButton = By.xpath(props.getProperty("menuButton"));

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

    public CatalogPage(IOSDriver driver){
        Base.driver = driver;
    }
}
