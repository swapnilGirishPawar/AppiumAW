package Pages;

import StepDefinations.Base;
import org.openqa.selenium.By;

public class CartPage extends Base {



    private final By cartPageText = By.xpath(props.getProperty("emptyCartPageText"));

public void userOnCartPage(){
    if(driver.findElement(cartPageText).isDisplayed()){
        System.out.println("user is on cart page");
    }
}

public void cartPageIsEmpty(){
    if(driver.findElement(cartPageText).isDisplayed()){
        System.out.println("cart page is empty");
    }
    else System.out.println("there is something on page");
}

}
