package stepdefinitions;

import java.util.List;
import org.junit.Assert;
import com.aventstack.extentreports.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CategoriesPageActions;
import pages.HomePageActions;
import pages.ProductsPageActions;
import utils.HelperUtility;
import utils.LogHelper;
import utils.ReportGenerator;
import utils.Root;

public class StepProductDirectory {

    HomePageActions homePageActions = new HomePageActions(Root.driver);
    ProductsPageActions productsPageActions = new ProductsPageActions(Root.driver);
    CategoriesPageActions categoriesPageActions = new CategoriesPageActions(Root.driver);
    HelperUtility helper = new HelperUtility(Root.driver);

    @When("the user hovers over {string} menu")
        public void the_user_hovers_over_menu(String string) {
        productsPageActions.hoverOverSections(string);
    }

    @Given("the user click on {string} button")
        public void the_user_click_on_button(String string) {
            homePageActions.userClickOn(string);
    }


    @Then("the browser navigates to the {string} page in a new tab")
    public void the_browser_navigates_to_the_page_in_a_new_tab(String string) {
        Assert.assertTrue(Root.driver.getTitle().contains(string));
        LogHelper.info("navigate back to product directory");
    }

    @Then("the user iterates and verifies through {string} links")
    public void the_user_iterates_and_verifies_through_links(String string, io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> stringElements = dataTable.asLists();
        categoriesPageActions.iterateItemsClickAndVerify(stringElements,string);
        LogHelper.info(Thread.currentThread().getStackTrace()[2].getMethodName());
        Hooks.extentTest.log(Status.PASS, "click on casting");
    }

    @Then("logs and screenshots are handled for specific actions")
    public void logs_and_screenshots_are_handled_for_specific_actions() {
        ReportGenerator.addScreenshotToReport("agricultural_machinery", Hooks.extentTest, "agricultural_machinery");
    }

}
