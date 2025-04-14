package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePageActions;
import utils.Root;

public class Navigatestepdefinitions {
    HomePageActions homePageActions = new HomePageActions(Root.driver);

    @When("the user moves the cursor over the Buyer section")
    public void the_user_moves_the_cursor_over_the_buyer_section() {
        homePageActions.hoverOverBuyer();

    }

    @When("the user selects the New User Guide link")
    public void the_user_selects_the_new_user_guide_link() {
        homePageActions.clickNewUserGuide();

    }

    @When("the user changes to the new window of User Guide")
    public void the_user_changes_to_the_new_window_of_user_guide() {
      homePageActions.switchto();

    }

    @Then("the URL should contain {string}")
    public void the_url_should_contain(String string) {
        homePageActions.verifyUrl(string);
        

    }

    @Then("the user clicks on the Return Back button")
    public void the_user_clicks_on_the_return_back_button() {
        homePageActions.returnBack();
    

    }

    @When("the user hovers over the Buyer section again")
    public void the_user_hovers_over_the_buyer_section_again() {
        homePageActions.hoverOverBuyer();

    }

    @When("the user clicks on the Audited Suppliers Reports link")
    public void the_user_clicks_on_the_audited_suppliers_reports_link() {
        homePageActions.clickAuditedSuppliers();

    }

    @When("the user switches to the new window of Audited Suppliers")
    public void the_user_switches_to_the_new_window_of_audited_suppliers() {
        homePageActions.switchto();

    }

    @Then("the URL should include {string}")
    public void the_url_should_include(String string) {
        homePageActions.verifyUrl(string);

    }

    @Then("the user presses the Return Back button")
    public void the_user_presses_the_return_back_button() {
        homePageActions.returnBack();

    }

    @When("the user navigates to the Buyer section once more")
    public void the_user_navigates_to_the_buyer_section_once_more() {
        homePageActions.hoverOverBuyer();

    }

    @When("the user chooses the Meet Suppliers link")
    public void the_user_chooses_the_meet_suppliers_link() {
        homePageActions.clickMeetSuppliers();

    }

    @When("the user switches to the new window of Meet Suppliers")
    public void the_user_switches_to_the_new_window_of_meet_suppliers() {
        homePageActions.switchto();

    }

    @Then("the user clicks on the Return Back button or logo page")
    public void the_user_clicks_on_the_return_back_button_or_logo_page() {
        homePageActions.returnBack();

    }

}
