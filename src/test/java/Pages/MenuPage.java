package Pages;

import StepDefinations.Base;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class MenuPage extends Base {
    private final By MenuLogInButton = By.xpath(props.getProperty("MenuLogInButton"));
    private final By MenuLogOutButton = By.xpath(props.getProperty("MenuLogOutButton"));
    private final By MenuResetButton = By.xpath(props.getProperty("MenuResetAppStateButton"));
    private final By MenuCloseButton = By.xpath(props.getProperty("MenuCrossButton"));
    private final By MenuAboutButton = By.xpath(props.getProperty("MenuAboutButton"));
    private final  By MenuLogoutPopUp = By.xpath(props.getProperty("MenuLogoutPopUp"));


    public void clickOnLogInTab() throws InterruptedException {
        CommonMethods.waitForTextVisibility(MenuLogInButton);
        CommonMethods.clickOnElement(MenuLogInButton);
    }
    public void clickOnLogOutTab() throws InterruptedException {
        CommonMethods.waitForTextVisibility(MenuLogOutButton);
        CommonMethods.clickOnElement(MenuLogOutButton);
    }
    public void clickOnAboutTab() throws InterruptedException {
        CommonMethods.clickOnElement(MenuAboutButton);
    }
    public void clickOnResetTab() throws InterruptedException {
        CommonMethods.clickOnElement(MenuResetButton);
    }
    public void clickOnCloseTab() throws InterruptedException {
        CommonMethods.clickOnElement(MenuCloseButton);
    }

    public void clickOnLogOutPopup(){
        CommonMethods.clickOnElement(MenuLogoutPopUp);
    }
    public MenuPage(IOSDriver driver){
        Base.driver = driver;
    }

}
