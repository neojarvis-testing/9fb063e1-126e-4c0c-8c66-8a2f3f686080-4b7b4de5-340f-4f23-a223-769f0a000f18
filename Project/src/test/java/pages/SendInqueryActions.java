package pages;

import org.openqa.selenium.WebDriver;
import uistore.SendInqueryPageLocators;
import utils.HelperUtility;

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
     * Description: navigate back to the homepage
     */
    public void homepagelogo() {
        helper.performClick(SendInqueryPageLocators.SendInqueryPagelogo);
    }

}
