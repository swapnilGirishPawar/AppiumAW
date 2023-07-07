package Pages;

import StepDefinations.Base;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import javax.swing.text.Element;

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
    }
    public void clickOnMenuButton() throws InterruptedException {
        CommonMethods.clickOnElement(menuButton);
    }
    public void userOnCatalogPage(){
        if(driver.findElement(pageTitle).isDisplayed()){
            System.out.println("user is on catalog page");
        }
    }

    public CatalogPage(IOSDriver driver){
        Base.driver = driver;
    }
}
