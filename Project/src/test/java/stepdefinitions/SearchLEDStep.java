package stepdefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePageActions;
import pages.ProductsPageActions;
import pages.SendInqueryActions;
import utils.LogHelper;
import utils.Root;

public class SearchLEDStep {
    HomePageActions homePageActions = new HomePageActions(Root.driver);
    ProductsPageActions productsPageActions = new ProductsPageActions(Root.driver);
    SendInqueryActions sendInqueryActions = new SendInqueryActions(Root.driver);

    @When("the user searches for {string} in the search bar")
    public void the_user_searches_for_in_the_search_bar(String string) {
        homePageActions.searchProductInSearchBar(string);
        homePageActions.productSearchEnter();
    }

    @Then("the search results for {string} should be displayed")
    public void the_search_results_for_should_be_displayed(String string) {
        productsPageActions.verifyLEDPage(string);
    }

    @When("the user fills inquiry form with {string} and {string}")
    public void the_user_fills_inquiry_form_with_and(String string, String string2) {

        sendInqueryActions.contentBoxandemail(string, string2);

    }

    @Then("the user validate {string} present on {string} page")
    public void the_user_validate_present_on_page(String string, String string2) {
        LogHelper.info(string);
    }

    @When("the user navigates back to {string}")
    public void the_user_navigates_back_to(String string) {
        Assert.assertEquals(Root.driver.getCurrentUrl(), string);
    }

    @When("the user clicks the {string}")
    public void the_user_clicks_the(String string) {
        productsPageActions.clickLEDElement(string);

    }

    @When("the user hovers over {string} under {string} section")
    public void the_user_hovers_over_under_section(String string, String string2) {
        productsPageActions.hoverOverSections(string);
    }

}