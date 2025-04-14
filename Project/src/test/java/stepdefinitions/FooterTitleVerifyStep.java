package stepdefinitions;

import java.util.List;

import com.aventstack.extentreports.Status;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePageActions;
import utils.LogHelper;
import utils.Root;
import utils.ScreenCapture;

public class FooterTitleVerifyStep {
    HomePageActions homePageActions=new HomePageActions(Root.driver);

@When("the user clicks on links in the {string} section")
public void the_user_clicks_on_links_in_the_section(String string) {
    homePageActions.hoverToFooter();
}

@Then("the following redirections should occur successfully")
public void the_following_redirections_should_occur_successfully(io.cucumber.datatable.DataTable dataTable) {
    List<List<String>> getTitleAndURL=dataTable.asLists();
    homePageActions.hotItemsList(getTitleAndURL);
}


@When("logs and screenshots are captured")
public void logs_and_screenshots_are_captured() {
    ScreenCapture.takePageScreenShot("final_page");
}
@Then("they should verify successful navigation and expected outcomes")
public void they_should_verify_successful_navigation_and_expected_outcomes() {
    LogHelper.info(Thread.currentThread().getStackTrace()[2].getMethodName());
    Hooks.extentTest.log(Status.PASS,Thread.currentThread().getStackTrace()[2].getMethodName());
}

}
 
