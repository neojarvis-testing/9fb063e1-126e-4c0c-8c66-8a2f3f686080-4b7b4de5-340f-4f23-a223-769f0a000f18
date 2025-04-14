package stepdefinitions;

import java.util.List;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePageActions;
import pages.SearchResultPageActions;
import utils.Root;

public class SearchWiresAndFurnituresStepdefiniton {
    ExtentTest test = Hooks.extentTest;
    HomePageActions homePage = new HomePageActions(Root.driver);
    SearchResultPageActions searchResultPage = new SearchResultPageActions(Root.driver);


    @Then("user lands on home page")
    public void user_lands_on_home_page() {
        homePage.verifyMadeInChinaLogo(test);
    }

    @When("search for Wires")
    public void user_click_searchbar_and_enter_wires_in_searchbar_and_press_enter(io.cucumber.datatable.DataTable dataTable) {
        List<String> productList = dataTable.asList();
        homePage.searchProductInSearchBar(productList.get(0), test);
    }

    @Then("user is taken to {string} page")
    public void user_is_taken_to_page(String string) {
        searchResultPage.verifyWiresResultPage(string, test);
    }

    @When("user click on first product link in search results")
    public void user_click_on_first_product_link_in_search_results() {
        searchResultPage.clickFirstWiresProduct(test);
    }

    @Then("user is taken to {string} product page")
    public void user_is_taken_to_product_page(String string) {
        searchResultPage.verifyWiresProductPage(string, test);
    }

    @When("user returns back to parent window")
    public void user_returns_back_to_parent_window() {
        searchResultPage.returnToParentWindow(test);
    }

    @When("search for Furniture")
    public void search_for_furniture(io.cucumber.datatable.DataTable dataTable) {
        List<String> productList = dataTable.asList();
        homePage.searchProductInSearchBar(productList.get(0), test);        
    }

    @When("user click on {string} link")
    public void user_click_on_link(String string) {
        searchResultPage.clickMoreLink(string, test);
    }

    @When("navigate to second page of the results")
    public void navigate_to_second_page_of_the_results() {
        searchResultPage.clickPaginationPage2Link(test);
    }

    @Then("user is taken to second page of the results")
    public void user_is_taken_to_second_page_of_the_results() {
        searchResultPage.verifyFurnitureSecondPage("Furniture", test);
    }

    @When("user click on site logo")
    public void user_click_on_site_logo() {
        searchResultPage.clickSiteLogo(test);
    }

}