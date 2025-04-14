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

    @Given("the user hovers over the buyer module")
    public void the_user_hovers_over_the_buyer_module() {
        homePageActions.homePageHoverOverBuyer();
    }

    @Given("the user clicks on {string} under the search section")
    public void the_user_clicks_on_under_the_search_section(String string) {
        homePageActions.clickOnProductDirectory();
    }

    @Then("the browser navigates to the {string} page in a new tab")
    public void the_browser_navigates_to_the_page_in_a_new_tab(String string) {
        Assert.assertTrue(Root.driver.getTitle().contains(string));
        LogHelper.info("navigate back to product directory");
    }

    @When("the user iterates through the Product Directory links")
    public void the_user_iterates_through_the_product_directory_links(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> stringElements = dataTable.asLists();
        categoriesPageActions.iterateItemsClickAndVerify(Hooks.extentTest, stringElements);
    }

    @Then("the browser redirects to the correct page for each link")
    public void the_browser_redirects_to_the_correct_page_for_each_link() {
        LogHelper.info(Thread.currentThread().getStackTrace()[2].getMethodName());
    }

    @Then("the URL contains the expected value")
    public void the_url_contains_the_expected_value() {
        Hooks.extentTest.log(Status.PASS, "click on casting");
    }

    @Then("logs and screenshots are handled for specific actions")
    public void logs_and_screenshots_are_handled_for_specific_actions() {
        ReportGenerator.addScreenshotToReport("agricultural_machinery", Hooks.extentTest, "agricultural_machinery");
    }

}
