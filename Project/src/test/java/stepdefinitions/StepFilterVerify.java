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

    @Then("the {string} logo displayed on {string}")
    public void the_logo_displayed_on(String string, String string2) {
        homePageActions.verifyMadeInChinaLogo();
    }

    @When("the user enter {string} into the search bar")
    public void the_user_enter_into_the_search_bar(String string) {
        homePageActions.enterTextIntoSearchBar(string);
    }

    @Then("the user validate search results page contains keyword {string}")
    public void the_user_validate_search_results_page_contains_keyword(String string) {
        productsPageActions.verifyElectronicsPageTitle(string);
    }

    @Then("user verify {string} filter")
    public void user_verify_filter(String string) {
        productsPageActions.filterVerfiy(string);
    }

    @When("the user select {string}")
    public void the_user_select(String string) {
        productsPageActions.selectFilterOption(string);
    }

    @Then("the results should display only {string} listings")
    public void the_results_should_display_only_listings(String string) {
    }

    @Then("the user validate redirection to {string}")
    public void the_user_validate_redirection_to(String string) {
        productsPageActions.switchToCompanyPage();
    }

    @Then("the user validate the keyword {string}")
    public void the_user_validate_the_keyword(String string) {
        helper.verifyAcutalAndExpected(helper.retrieveText(ProductsPageLocators.diamondTextLocator), string);
    }

    @Then("the user capture a screenshot of the page")
    public void the_user_capture_a_screenshot_of_the_page() {
        ScreenCapture.takePageScreenShot("diamond_member_product");
    }

    @When("the user click on {string}")
    public void the_user_click_on(String string) {
        homePageActions.userClickOn(string);
        LogHelper.info(Thread.currentThread().getStackTrace()[2].getMethodName() + " " + string);
    }

    @When("the user identify the {string}")
    public void the_user_identify_the(String string) {
        homePageActions.identifyElement(string);
    }

}
