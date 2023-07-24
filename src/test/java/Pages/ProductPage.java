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

    public void clicksOnCounterAddButton(int count) {
        String counter = driver.findElement(counterAmount).getText();
        for (int i = 0; i <= count; i++) {
            CommonMethods.addLogToReport("Loop Count:- " + i + " Counter:- " + counter);
            CommonMethods.clickOnElement(counterPlusButton);
        }
    }

    public void clicksOnCounterAddButton() throws InterruptedException {
        try {
            if (driver.findElement(counterPlusButton).isDisplayed()) {
                CommonMethods.clickOnElement(counterPlusButton);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clicksOnCounterMinusButton() {
        int count = Integer.parseInt(driver.findElement(counterAmount).getText());
        try {
            if (driver.findElement(counterMinusButton).isDisplayed()) {
                for (int i = 0; i < count; i++) {
                    CommonMethods.clickOnElement(counterMinusButton);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickOnAddToCartButton() throws InterruptedException {
        try {
            if (driver.findElement(addToCartButton).isDisplayed()) {
                CommonMethods.sendKeysEnter(addToCartButton);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public ProductPage(IOSDriver driver) {
        Base.driver = driver;
    }
}
