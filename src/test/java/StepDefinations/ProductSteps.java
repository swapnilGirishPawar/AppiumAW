package StepDefinations;

import Pages.CartPage;
import Pages.CatalogPage;
import Pages.ProductPage;
import Utils.CommonMethods;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;

public class ProductSteps {
    Base base = new Base();
    CatalogPage catalogPage = new CatalogPage(Base.driver);
    ProductPage productPage = new ProductPage(Base.driver);
    CartPage cartPage = new CartPage(Base.driver);
    @When("User navigates to the product")
    public void user_navigates_to_the_product() throws InterruptedException {
        // swipe till the product
        catalogPage.navigateTillProduct();
    }

    @When("user clicks on the product")
    public void user_clicks_on_the_product() throws InterruptedException {
        CatalogPage.clickOnProduct((Base.props.getProperty("productNumber6")));
    }

    @When("user add {int} quantity of product")
    public void user_add_quantity_of_product(int int1) throws InterruptedException {
        productPage.clicksOnCounterAddButton();
    }

    @When("user clicks on add to cart button")
    public void user_clicks_on_add_to_cart_button() throws InterruptedException {
        productPage.clickOnAddToCartButton();
    }

    @Then("Product with {int} quantity visible in cart page.")
    public void product_with_quantity_visible_in_cart_page(int int1) throws Throwable {
        catalogPage.clickOnCartButton();
        cartPage.quantityVisibleInCart(int1);
        catalogPage.clickOnCatalogButton();
    }

    @When("User navigates to cart page")
    public void user_navigates_to_cart_page() throws InterruptedException {
        catalogPage.clickOnCartButton();
    }

    @When("user clicks on the remove items button")
    public void user_clicks_on_the_remove_items_button() {
        productPage.clicksOnCounterMinusButton();
    }

    @Then("cart page become empty.")
    public void cart_page_become_empty() {
        cartPage.userOnEmptyCartPage();
    }
}
