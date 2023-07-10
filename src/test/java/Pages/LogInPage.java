package Pages;

import StepDefinations.Base;
import Utils.CommonMethods;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class LogInPage extends Base {
    private final By LogInUsernameField = By.xpath(props.getProperty("LoginUsernameField"));
    private final By LogInPasswordField = By.xpath(props.getProperty("LoginPasswordField"));
    private final By LogInLogInButton = By.xpath(props.getProperty("LoginLogInButton"));
    private final By LoginLogoutSuccessfulPopup = By.xpath(props.getProperty("LoginLogoutSuccessfulPopup"));

    public void clickOnLoginButton() throws InterruptedException {
        CommonMethods.clickOnElement(LogInLogInButton);
        CommonMethods.addLogToReport("Clicked on Log In Button");
    }
    public void enterUserNameField(String username){
        CommonMethods.enterText(username, LogInUsernameField);
        CommonMethods.addLogToReport("Entered Username:- "+username);

    }
    public void enterPasswordField(String password){
        CommonMethods.enterText(password, LogInPasswordField);
        CommonMethods.addLogToReport("Entered Password:- "+password);

    }
    public void clickOnLogOutSuccessfulPopup() {
        CommonMethods.clickOnElement(LoginLogoutSuccessfulPopup);
        CommonMethods.addLogToReport("Clicked on Logout success popup");
    }
    public void userIsOnLoginPage() {
        if(driver.findElement(LogInUsernameField).isDisplayed()){
            CommonMethods.addLogToReport("User is on Log In Page");
        }
    }

    public LogInPage(IOSDriver driver){
        Base.driver = driver;
    }

}
