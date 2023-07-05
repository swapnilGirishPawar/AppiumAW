package Pages;

import StepDefinations.Base;
import org.openqa.selenium.By;

public class CartPage extends Base {

    private final By cartPageText = By.xpath("//XCUIElementTypeStaticText[@name='No Items']");

public void userOnCartPage(){
    if(driver.findElement(cartPageText).isDisplayed()){
        System.out.println("user is on cart page");
    }
}

}
