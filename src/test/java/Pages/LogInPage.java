package Pages;

import StepDefinations.Base;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class LogInPage extends Base {
    private final By LogInUsernameField = By.xpath(props.getProperty("LoginUsernameField"));
    private final By LogInPasswordField = By.xpath(props.getProperty("LoginPasswordField"));
    private final By LogInLogInButton = By.xpath(props.getProperty("LoginLogInButton"));
    private final By LoginLogoutSuccessfulPopup = By.xpath(props.getProperty("LoginLogoutSuccessfulPopup"));

    public void clickOnLoginButton() throws InterruptedException {
        CommonMethods.clickOnElement(LogInLogInButton);
    }
    public void enterUserNameField(String username){
        CommonMethods.enterText(username, LogInUsernameField);
    }
    public void enterPasswordField(String username){
        CommonMethods.enterText(username, LogInPasswordField);
    }
    public void clickOnLogOutSuccessfulPopup() {
        CommonMethods.clickOnElement(LoginLogoutSuccessfulPopup);
    }

    public LogInPage(IOSDriver driver){
        Base.driver = driver;
    }

    public void userIsOnLoginPage() {
        if(driver.findElement(LogInUsernameField).isDisplayed()){
            System.out.println("user is on login page");
        }
    }
}
