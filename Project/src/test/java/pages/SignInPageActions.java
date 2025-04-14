package pages;
import org.openqa.selenium.WebDriver;
import uistore.SignInPageLocators;
import utils.HelperUtility;
import utils.LogHelper;
import utils.ScreenCapture;

public class SignInPageActions {

    public WebDriver driver;
    public HelperUtility helper;
    

    public SignInPageActions(WebDriver driver){
        this.driver=driver;
        this.helper=new HelperUtility(driver);
    }

    /**
     * Description: Hovers over the language dropdown on the sign-in page and captures a screenshot
     */
    public  void clickOnLanguage(){
        try{
        helper.mouseHover(SignInPageLocators.signInPageLanguageDropdown);
        ScreenCapture.takePageScreenShot(driver.getTitle());
        }catch(Exception e){
            LogHelper.info(e.getMessage());
        }
        
    }

    /**
     * Description: Verifies that the current page title matches the expected registered page title
     */
    public void vefifyRegisteredPage(String string){
        helper.verifyAcutalAndExpected(string, driver.getTitle());

    }
    /**
     * Description: Clicks the "Sign In Now" link on the registration page
     */
    public void clickOnSignInNowLink(){
        try{
            helper.performClick(SignInPageLocators.registerPageSignInNowLink);
        }catch(Exception e){
            LogHelper.info(e.getMessage());
        }
        
}

/**
     * Description: Confirms that the sign-in page title matches the expected value
     */
    public void verifySignInpage(String string) {
        helper.verifyAcutalAndExpected(string, driver.getTitle());
    }

    /**
     * Description: Takes a screenshot of the page when interacting with the language change option
     */
    public void hoverOverLanguageChange() {
        ScreenCapture.takePageScreenShot(driver.getTitle());
    }
}