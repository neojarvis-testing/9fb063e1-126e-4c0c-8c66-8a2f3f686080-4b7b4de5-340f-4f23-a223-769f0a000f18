package stepdefinitions;

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

    @When("the user clicks the {string} filter")
    public void the_user_clicks_the_filter(String string) {
        productsPageActions.ledstripLight();

    }

    @When("the user clicks the {string} or {string} button")
    public void the_user_clicks_the_or_button(String string, String string2) {

        productsPageActions.contactnow();

    }

    @When("fills the inquiry form with {string} in Content and {string} in Email Address")
    public void fills_the_inquiry_form_with_in_content_and_in_email_address(String string, String string2) {

        sendInqueryActions.contentBoxandemail(string, string2);

    }

    @When("clicks the {string} button")
    public void clicks_the_button(String string) {

        sendInqueryActions.sendInquery();

    }

    @When("the user navigates back to the homepage using the site logo")
    public void the_user_navigates_back_to_the_homepage_using_the_site_logo() {
        sendInqueryActions.homepagelogo();
    }

    @When("the user hovers over {string} under the Categories section")
    public void the_user_hovers_over_under_the_categories_section(String string) {

        homePageActions.LightsLighting();

    }

    @When("hovers over {string} under the {string} section")
    public void hovers_over_under_the_section(String string, String string2) {

        homePageActions.Ledtube();

    }

    @Then("the keyword {string} should be present on the product list page")
    public void the_keyword_should_be_present_on_the_product_list_page(String string) {
         LogHelper.info(string);
    }

    @When("the user clicks the {string}")
    public void the_user_clicks_the(String string) {
        productsPageActions.ledlighttubefilter();

    }

}