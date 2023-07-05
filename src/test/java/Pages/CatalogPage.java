package Pages;

import StepDefinations.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import javax.swing.text.Element;

public class CatalogPage extends Base {
    private final By sortButton = By.xpath("//XCUIElementTypeOther[@name='sort button']");
    private final By pageTitle = By.xpath("//XCUIElementTypeStaticText[@name='Products']");
    private final By cartButton = By.xpath("//XCUIElementTypeButton[@name='tab bar option cart']");
    private final By menuButton = By.xpath("//XCUIElementTypeButton[@name='tab bar option menu']");

    public void clickOnSortButton(){
        driver.findElement(sortButton).sendKeys(Keys.ENTER);
    }
    public void clickOnCartButton(){
        driver.findElement(cartButton).sendKeys(Keys.ENTER);
    }
    public void clickOnMenuButton(){
        driver.findElement(menuButton).sendKeys(Keys.ENTER);
    }
    public void userOnCatalogPage(){
    if(driver.findElement(pageTitle).isDisplayed()){
        System.out.println("user is on catalog page");
    }
    }
}
