package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePageActions;
import pages.ProductsPageActions;
import uistore.ProductsPageLocators;
import utils.HelperUtility;
import utils.LogHelper;
import utils.Root;
import utils.ScreenCapture;

public class StepFilterVerify {
    HomePageActions homePageActions = new HomePageActions(Root.driver);
    ProductsPageActions productsPageActions = new ProductsPageActions(Root.driver);
    HelperUtility helper = new HelperUtility(Root.driver);

    @Then("the {string} logo is displayed on the homepage")
    public void the_logo_is_displayed_on_the_homepage(String string) {
        homePageActions.verifyMadeInChinaLogo();

    }

    @When("I identify the search bar element")
    public void i_identify_the_search_bar_element() {
        homePageActions.identifySearchBarAndClick();
    }

    @When("I enter {string} into the search bar")
    public void i_enter_into_the_search_bar(String string) {
        homePageActions.enterTextIntoSearchBar(string);
    }

    @When("I click the search button or press Enter")
    public void i_click_the_search_button_or_press_enter() {
        homePageActions.clickSearchButton();
    }

    @Then("the search results page title should contain the keyword {string}")
    public void the_search_results_page_title_should_contain_the_keyword(String string) {
        productsPageActions.verifyElectronicsPageTitle(string);
    }

    @When("I wait for the search results to load")
    public void i_wait_for_the_search_results_to_load() {
        LogHelper.info(Thread.currentThread().getStackTrace()[2].getMethodName());
    }

    @When("I click on the {string} module")
    public void i_click_on_the_module(String string) {
        productsPageActions.clickSupplierListMenu();
        LogHelper.info(Thread.currentThread().getStackTrace()[2].getMethodName());
    }

    @When("I identify a filter option {string}")
    public void i_identify_a_filter_option(String string) {
        productsPageActions.identifyCategoryFilter();
    }

    @When("I select the filter value {string}")
    public void i_select_the_filter_value(String string) {
        productsPageActions.selectConsumerElectronics();
    }

    @Then("only products from the {string} category should be displayed")
    public void only_products_from_the_category_should_be_displayed(String string) {
        productsPageActions.verifyFilterSelected(ProductsPageLocators.consumerElectronicsCatagory, string);
    }

    @When("I identify the {string} section")
    public void i_identify_the_section(String string) {
        productsPageActions.identifyISO9000Filter();
    }

    @When("I select {string}")
    public void i_select(String string) {
        productsPageActions.selectISO9000();
    }

    @Then("the {string} filter should be displayed under the {string} section")
    public void the_filter_should_be_displayed_under_the_section(String string, String string2) {
        productsPageActions.verifyFilterSelected(ProductsPageLocators.selectedIso9000, string);

    }

    @When("I select the {string} checkbox")
    public void i_select_the_checkbox(String string) {
        productsPageActions.selectDiamondMemberCheckBox();
    }

    @Then("the results should display only {string} listings")
    public void the_results_should_display_only_listings(String string) {
        productsPageActions.verifyFilterSelected(ProductsPageLocators.selectedIso9000, string);
    }

    @When("I click on the first displayed company result")
    public void i_click_on_the_first_displayed_company_result() {
        productsPageActions.clickFirstProduct();
    }

    @Then("I should be redirected to the company's page")
    public void i_should_be_redirected_to_the_company_s_page() {
        productsPageActions.switchToCompanyPage();
    }

    @Then("the page should contain the keyword {string}")
    public void the_page_should_contain_the_keyword(String string) {
        helper.verifyAcutalAndExpected(helper.retrieveText(ProductsPageLocators.diamondTextLocator), string);
    }

    @Then("I capture a screenshot of the page")
    public void i_capture_a_screenshot_of_the_page() {
        ScreenCapture.takePageScreenShot("diamond_member_product");
    }

}
