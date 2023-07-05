package StepDefinations;

import io.cucumber.java.en.*;

public class LoginSteps {
    @Given("Browser is open")
    public void browser_is_open() {
        System.out.println("123");

    }
    @Given("User is on login page")
    public void user_is_on_login_page() {
        System.out.println("456");
    }
    @When("user enters username and password.")
    public void user_enters_username_and_password() {
        System.out.println("789");
    }
    @When("user clicks on Login button")
    public void user_clicks_on_login_button() {
        System.out.println("012");
    }
    @Then("user is navigated to the home page")
    public void user_is_navigated_to_the_home_page() {
        System.out.println("345");
    }
}
