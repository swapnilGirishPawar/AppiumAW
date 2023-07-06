package StepDefinations;

import Pages.CartPage;
import Pages.CatalogPage;
import io.cucumber.java.en.*;

public class NavigationSteps {
    CatalogPage catalogPage = new CatalogPage(Base.driver);
    CartPage cartPage = new CartPage();

    @Given("User is on Cataloge page")
    public void user_is_on_cataloge_page() {
        catalogPage.userOnCatalogPage();
    }

    @When("user clicks on Cart button")
    public void user_clicks_on_cart_button() throws InterruptedException {
        catalogPage.clickOnCartButton();
    }

    @Then("user lands on cart page")
    public void user_lands_on_cart_page() {
        cartPage.cartPageIsEmpty();
        System.out.println("Done");
    }
}
