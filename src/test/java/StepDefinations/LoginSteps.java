package StepDefinations;

import Pages.CatalogPage;
import Pages.LogInPage;
import Pages.MenuPage;
import Utils.CommonMethods;
import io.cucumber.java.en.*;

import static StepDefinations.Base.soft;

public class LoginSteps {
    private Base base;
    MenuPage menuPage = new MenuPage(Base.driver);
    CatalogPage catalogPage = new CatalogPage(Base.driver);
    LogInPage loginPage = new LogInPage(Base.driver);

    @When("user clicks on Menu button")
    public void user_clicks_on_menu_button() throws InterruptedException {
        Thread.sleep(1000);
        catalogPage.clickOnMenuButton();
    }

    @When("user clicks on Log In button")
    public void user_clicks_on_log_in_button() throws InterruptedException {
        Thread.sleep(1500);
        menuPage.clickOnLogInTab();
    }

    @When("user enters username and password")
    public void user_enters_username_and_password() {
        loginPage.enterUserNameField(Base.props.getProperty("username"));
        loginPage.enterPasswordField(Base.props.getProperty("password"));
    }

    @When("user clicks on Login button")
    public void user_clicks_on_login_button() throws InterruptedException {
        loginPage.clickOnLoginButton();
        System.out.println("here");
    }

    @When("user clicks on Log Out button")
    public void user_clicks_on_log_out_button() throws InterruptedException {
        menuPage.clickOnLogOutTab();
    }

    @When("user clicks on Logout popup")
    public void user_clicks_on_logout_popup() {
        menuPage.clickOnLogOutPopup();
        loginPage.clickOnLogOutSuccessfulPopup();
    }

    @Then("User is on login page")
    public void userIsOnLoginPage() throws InterruptedException {
        loginPage.userIsOnLoginPage();
        catalogPage.userOnCatalogPage();

    }
}
