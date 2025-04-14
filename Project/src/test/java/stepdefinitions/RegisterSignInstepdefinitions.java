package stepdefinitions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePageActions;
import utils.Root;

public class RegisterSignInstepdefinitions {
    HomePageActions homePageActions = new HomePageActions(Root.driver);


    @When("the user hovers over the Sign In button")
    public void the_user_hovers_over_the_sign_in_button() {
        homePageActions.hoverOverSignIn();   
    }

    @When("the user hovers over the Join Free button")
    public void the_user_hovers_over_the_join_free_button() {
        homePageActions.hoverOverJoinFree();
        
    }

    @When("user clicks on the Join Free button")
public void user_clicks_on_the_join_free_button() {
        homePageActions.clickJoinFree();
}

    @When("the user switches to the registration window")
    public void the_user_switches_to_the_registration_window() {
        homePageActions.switchToNewWindow();
        
    }

    @When("the user hovers over the email input field")
    public void the_user_hovers_over_the_email_input_field() {
        homePageActions.hoverOverEmailInput();
        
    }

    @When("the user clicks on the email input field")
    public void the_user_clicks_on_the_email_input_field() {
        homePageActions.clickEmailInput();
        
    }

    @When("the user enters the email {string}")
    public void the_user_enters_the_email(String string) {
        homePageActions.enterEmail(string);
        
    }

    @When("the user clicks on the Agree button")
    public void the_user_clicks_on_the_agree_button() {
        homePageActions.clickEmail();
        
    }

    @Then("the user captures a screenshot")
    public void the_user_captures_a_screenshot() {
        homePageActions.screenshot();
        
    }

}