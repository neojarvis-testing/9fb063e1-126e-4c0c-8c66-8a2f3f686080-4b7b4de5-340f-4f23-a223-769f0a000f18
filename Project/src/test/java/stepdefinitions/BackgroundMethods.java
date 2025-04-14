package stepdefinitions;

import io.cucumber.java.en.Given;
import pages.HomePageActions;
import utils.LogHelper;
import utils.Root;

public class BackgroundMethods {
    HomePageActions homePageActions = new HomePageActions(Root.driver);

    @Given("the browser is launched and navigates to {string}")
    public void the_browser_is_launched_and_navigates_to(String string) {
        LogHelper.info(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Given("the popup closed")
    public void the_popup_closed() {
        homePageActions.closePopup();
        LogHelper.info(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

}
