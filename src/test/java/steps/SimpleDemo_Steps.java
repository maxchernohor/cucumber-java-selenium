package steps;

import actions.Common_Actions;
import actions.SimpleGenericProductPage_Actions;
import actions.SimpleHomePage_Actions;
import actions.SimpleCatalogPage_Actions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ConfigReader;
import utils.Hooks;

import static org.junit.Assert.fail;

public class SimpleDemo_Steps {
    private Common_Actions common_actions;
    private SimpleHomePage_Actions simpleHomePage_actions;
    private SimpleCatalogPage_Actions simpleCatalogPage_actions;
    private SimpleGenericProductPage_Actions simpleGenericProductPage_actions;
    private ConfigReader configReader;
    private String baseUrl;

    public SimpleDemo_Steps(Hooks hooks, SimpleHomePage_Actions simpleHomePage_actions, SimpleCatalogPage_Actions simpleCatalogPage_actions, SimpleGenericProductPage_Actions simpleGenericProductPage_actions) {
        this.common_actions = new Common_Actions(hooks);
        this.simpleHomePage_actions = simpleHomePage_actions;
        this.simpleCatalogPage_actions = simpleCatalogPage_actions;
        this.simpleGenericProductPage_actions = simpleGenericProductPage_actions;
        this.configReader = new ConfigReader();
        this.baseUrl = configReader.getProperty("simple.baseUrl");
    }

    @Given("I am on the Simple Demo Home Page")
    public void i_am_on_Simple_Main_Page() throws InterruptedException {
        common_actions.goToUrl(baseUrl);
        common_actions.textShouldExist("Just a demo site");
    }

    @When("I click on Catalog Button")
    public void i_click_on_Catalog_Button() {
        simpleHomePage_actions.clickOnCatalogLogo();
    }

    @Then("I navigated to Catalog Page")
    public void i_navigated_to_Catalog_Page() {
        String catalogPath = configReader.getProperty("simple.catalog.path");
        String expectedUrlPart = baseUrl + catalogPath;
        String actualUrl = common_actions.getCurrentPageUrl();

        if (!actualUrl.contains(expectedUrlPart)) {
            fail("Page did not navigate to the expected catalog page. Expected URL part: " + expectedUrlPart + ", but got: " + actualUrl);
        }
    }

    @Given("I scroll to the bottom")
    public void i_scroll_to_bottom() throws InterruptedException {
        common_actions.scrollToBottom();
    }

    @When("I click on white sandals")
    public void i_click_on_white_sandals() throws InterruptedException {
//        simpleCatalogPage_actions.clickOnWhiteSandal();
        common_actions.clickOnElementByXpathJS("//h3[text()='White sandals']");
    }

    @When("I click on {string}")
    public void i_click_on_item(String item) {
        simpleCatalogPage_actions.clickOnItem(item);
    }

    @When("I click on add to cart {string}")
    public void i_click_on_add_to_cart_item(String item) {
        simpleCatalogPage_actions.clickOnAddToCart(item);
    }


    @Then("I navigated to white sandals page")
    public void i_navigated_to__white_sandals_page() {
        String whiteSandalsPath = configReader.getProperty("simple.whitesandals.path");
        String expectedUrlPart = baseUrl + whiteSandalsPath;
        String actualUrl = common_actions.getCurrentPageUrl();

        if (!actualUrl.contains(expectedUrlPart)) {
            fail("Page did not navigate to the expected catalog page. Expected URL part: " + expectedUrlPart + ", but got: " + actualUrl);
        }
    }

    @When("I click on add to cart sandals")
    public void i_click_on_add_to_cart() throws InterruptedException {
        simpleGenericProductPage_actions.addToCart();
    }

    @Then("the cart count should increase by one")
    public void the_cart_count_should_increase_by_one() {
        simpleGenericProductPage_actions.validateCartCountIncreased();
    }
}