package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePageActions;
import pages.ProductsPageActions;
import utils.HelperUtility;
import utils.ReportGenerator;
import utils.Root;
import utils.ScreenCapture;

public class InquiryFormStep {

    HomePageActions homePageActions = new HomePageActions(Root.driver);
    ProductsPageActions productActions = new ProductsPageActions(Root.driver);
    HelperUtility helper = new HelperUtility(Root.driver);

    @When("the user identifies the search bar element")
    public void the_user_identifies_the_search_bar_element() {
        homePageActions.searchBarClick();
    }

    @When("the user enters {string} into the search bar")
    public void the_user_enters_into_the_search_bar(String string) {
        homePageActions.searchProductInSearchBar(string);
    }

    @When("the user clicks the search button or presses Enter")
    public void the_user_clicks_the_search_button_or_presses_enter() {
        homePageActions.productSearchEnter();

    }

    @When("the user clicks on the first product company")
    public void the_user_clicks_on_the_first_product_company() {
        productActions.clickFirstProductCompany();
    }

    @Then("the user validates the product detail page title matches the product name")
    public void the_user_validates_the_product_detail_page_title_matches_the_product_name() {
        productActions.verifyProductDetailPageTitle();
    }

    @Then("the user identifies the Inquiry or Contact Now button")
    public void the_user_identifies_the_inquiry_or_contact_now_button() {
        productActions.contactSupplierVerify();
    }

    @When("the user clicks the Inquiry or Contact Now button")
    public void the_user_clicks_the_inquiry_or_contact_now_button() {
        productActions.clickContactSupplier();
    }

    @Then("the user validates the send inquiry form is displayed")
    public void the_user_validates_the_send_inquiry_form_is_displayed() {
        productActions.verifySendInquiryFormDisplayed();
    }

    @When("the user enters {string} into the content box")
    public void the_user_enters_into_the_content_box(String string) {
        productActions.sendDataToTextArea(string);
    }

    @When("the user inputs a dummy email id {string} into the email address field")
    public void the_user_inputs_a_dummy_email_id_into_the_email_address_field(String string) {
        productActions.enterEmail(string);
    }

    @When("the user clicks the Send Inquiry or Submit button")
    public void the_user_clicks_the_send_inquiry_or_submit_button() {
        productActions.clickSendInquiry();
    }

    @Then("the user enters the {string} in the name field")
    public void the_user_enters_the_in_the_name_field(String string) {
        productActions.sendNameField(string);
    }

    @Then("the user enters the {string} in the company name field")
    public void the_user_enters_the_in_the_company_name_field(String string) {
        productActions.sendCompanyField(string);
    }

    @Then("the user enters the {string} in the phone number field and submits the form")
    public void the_user_enters_the_in_the_phone_number_field_and_submits_the_form(String string) {
        productActions.sendMobileField(string);
    }

    @Then("the user verifies a successful inquiry submission message is displayed")
    public void the_user_verifies_a_successful_inquiry_submission_message_is_displayed() {
        productActions.enterSendInquiryNow();
        productActions.verifySuccessfulMessage();
    }

    @Then("the user takes a screenshot for verification")
    public void the_user_takes_a_screenshot_for_verification() {
        ScreenCapture.takePageScreenShot("FinalPage");
    }

    @Then("attaches the screenshot to the report for reporting purposes")
    public void attaches_the_screenshot_to_the_report_for_reporting_purposes() {
        ReportGenerator.addScreenshotToReport("Final_Page", Hooks.extentTest, "Description");
    }

}