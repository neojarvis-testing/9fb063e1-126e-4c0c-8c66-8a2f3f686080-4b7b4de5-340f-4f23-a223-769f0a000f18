package pages;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import stepdefinitions.Hooks;
import uistore.SendInqueryPageLocators;
import utils.HelperUtility;
import utils.LogHelper;

public class SendInqueryActions {

    public WebDriver driver;
    public HelperUtility helper;
    
    public SendInqueryActions(WebDriver driver) {
        this.driver = driver;
        this.helper = new HelperUtility(driver);
    }

    /**
     * Description:entering the text in the contact and email textarea
     */
    public void contentBoxandemail(String string, String string2) {
        helper.switchToNewWindow();
        helper.performClick(SendInqueryPageLocators.SendInqueryPageText);
        helper.enterText(SendInqueryPageLocators.SendInqueryPageText, string);
        helper.performClick(SendInqueryPageLocators.SendInqueryPageEmail);
        helper.enterText(SendInqueryPageLocators.SendInqueryPageEmail, string2);
    }

    /**
     * Description: clicking on the send inquery
     */

    public void sendInquery() {
        helper.performClick(SendInqueryPageLocators.SendInqueryPageSend);
        LogHelper.info("clicked over the button" + helper.retrieveText(SendInqueryPageLocators.SendInqueryPageSend));
        Hooks.extentTest.log(Status.INFO,
                "clicked over the button" + helper.retrieveText(SendInqueryPageLocators.SendInqueryPageSend));
        driver.navigate().refresh();
        helper.performClick(SendInqueryPageLocators.SendInqueryPagelogo);

    }

    /**
     * Description: navigate back to the homepage
     */
    public void homepagelogo() {
        helper.performClick(SendInqueryPageLocators.SendInqueryPagelogo);
    }

}
