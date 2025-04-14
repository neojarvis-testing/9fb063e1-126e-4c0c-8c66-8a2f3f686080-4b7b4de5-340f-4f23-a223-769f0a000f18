package stepdefinitions;

import java.util.List;
import org.openqa.selenium.By;
import com.aventstack.extentreports.Status;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePageActions;
import pages.SignInPageActions;
import uistore.SignInPageLocators;
import utils.HelperUtility;
import utils.LogHelper;
import utils.ReportGenerator;
import utils.Root;
import utils.ScreenCapture;

public class VerifyLanguageChangeStep {

    public HomePageActions homePageActions=new HomePageActions(Root.driver);
    public SignInPageActions signInPageActions=new SignInPageActions(Root.driver);
    public HelperUtility helper=new HelperUtility(Root.driver);
    

@When("the user hovers over the Sign In \\/ Join button")
public void the_user_hovers_over_the_sign_in_join_button() {
    homePageActions.hoverOverSignInIcon();
}
@When("the user clicks on the Join Free button")
public void the_user_clicks_on_the_join_free_button() {
    homePageActions.clickOnJoinFreeButton();
}
@Then("the {string} should be displayed")
public void the_should_be_displayed(String string) {
    signInPageActions.vefifyRegisteredPage(string);
}


@When("the user clicks on the Sign in now Link")
public void the_user_clicks_on_the_sign_in_now_link() {
    signInPageActions.clickOnSignInNowLink();
}

@Then("the user should land on {string} page")
public void the_user_should_land_on_page(String string) {
    signInPageActions.verifySignInpage(string);
}

@Then("user hovers over the language dropdown")
public void user_hovers_over_the_language_dropdown() {
    signInPageActions.hoverOverLanguageChange();
}

@Then("the user updates the language selection and verifies the text changes:")
public void the_user_updates_the_language_selection_and_verifies_the_text_changes(io.cucumber.datatable.DataTable dataTable) {
    
    List<String> text=dataTable.asList();
    for(int i=0;i<text.size();i++){
    helper.mouseHover(SignInPageLocators.signInPageLanguageDropdown);
    helper.performClick(By.xpath("(//a[contains(text(),'"+text.get(i)+"')])[1]"));
    helper.verifyAcutalAndExpected(helper.retrieveText(SignInPageLocators.signInPageLanguageDropdown),text.get(i));
    LogHelper.info("Language change to "+text.get(i));
    Hooks.extentTest.log(Status.INFO,"Language change to "+text.get(i));
    ReportGenerator.addScreenshotToReport("Language change to "+text.get(i),Hooks.extentTest,"Language change to "+text.get(i));
    ScreenCapture.takePageScreenShot(text.get(i));
    
    }

  
}
}