package pages;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import stepdefinitions.Hooks;
import uistore.HomePageLocators;
import uistore.ProductsPageLocators;
import utils.HelperUtility;
import utils.LogHelper;
import utils.ReportGenerator;
import utils.Root;
import utils.ScreenCapture;
import utils.WaitFor;

public class HomePageActions {

    public HelperUtility helper;
    public WebDriver driver;

    public HomePageActions(WebDriver driver) {
        this.driver = driver;
        this.helper = new HelperUtility(driver);
    }

    /**
     * Description: closes the popup appears on screen
     * Author: Sushil Lodhi
     */
    public void closePopup() {
        helper.performClick(HomePageLocators.homepagePopUpcloseButton);
        LogHelper.info(Root.prop.getProperty("closePopupLog"));
    }

    /**
     * Description: verifies made in china logo
     * Author: Sushil Lodhi
     */
    public void verifyMadeInChinaLogo() {
        Assert.assertTrue(helper.isWebElementElementDisplayed(HomePageLocators.homePageLogo));
        LogHelper.info("click" + helper.retrieveDomAttribute(HomePageLocators.homePageLogoLink, "href"));
    }

    /**
     * Description: Enters some value in search bar
     * Author: Sushil Lodhi
     * 
     * @param productName
     */
    public void enterTextIntoSearchBar(String productName) {
        helper.enterText(HomePageLocators.homePageSearchBar, productName);
        LogHelper.info("enter value" + productName);
    }


    /**
     * Description: Hover over Buyer's Button
     * Author: Sushil Lodhi
     */
    public void homePageHoverOverBuyer() {
        helper.mouseHover(HomePageLocators.homePageBuyerDropdownMenu);

    }

    /**
     * Description: User clicks on some element
     * Author:Sushil Lodhi
     * @param clickOnElement
     */
    public void userClickOn(String clickOnElement){
        switch (clickOnElement) {
            case "search button":
                 helper.performClick(HomePageLocators.homePageSearchButton);
                LogHelper.info(helper.getCurrentMethodName() + " on " + HomePageLocators.homePageSearchButton);
                LogHelper.info(Thread.currentThread().getStackTrace().toString());
                break;
            case "Supplier List module":
                    driver.findElement(ProductsPageLocators.productPageSupplierListMenu).click();
                    break;
            case "First displayed company result":
                    helper.performClick(ProductsPageLocators.firstProduct);
                    break;
            case "Product Directory":
                    helper.performClick(HomePageLocators.homePageBuyerproductDirectory);
                    helper.switchToWindow(1);
                    break;
            default:
                break;
        }
        
    }

    public void identifyElement(String string){
        switch (string) {
            case "search bar element":
            helper.performClick(HomePageLocators.homePageSearchBar);
            LogHelper.info(helper.retrieveDomAttribute(HomePageLocators.homePageSearchBar, "placeholder"));    
            break;
            case "Management Certification section":
            LogHelper.info(Thread.currentThread().getStackTrace()[2].getMethodName());
            break;
            case "Member & Type section":
                LogHelper.info(string);
                break;
            default:
                break;
        }
    }



    /**
     * Description: Hovers over the Sign In icon and logs its text for tracking
     */
    public void hoverOverSignInIcon() {
        try {
            helper.mouseHover(HomePageLocators.homepageNavbarSignInIcon);
            LogHelper.info("Hover  on " + helper.retrieveText(HomePageLocators.homepageNavbarSignInIcon) + " Icon");
            Hooks.extentTest.log(Status.INFO,
                    "Hover on " + helper.retrieveText(HomePageLocators.homepageNavbarSignInIcon) + " Icon");
        } catch (Exception e) {
            LogHelper.info(e.getMessage());
        }
    }

    /**
     * Description: Clicks the "Join Free" button and switches to the newly opened
     * window
     */
    public void clickOnJoinFreeButton() {
        helper.performClick(HomePageLocators.homepageNavbarJoinFreeButton);
        helper.switchToNewWindow();
    }

    /**
     * Description: Click on product directory button present inside buyer dropmenu
     * Author: Sushil Lodhi
     */
    public void clickOnProductDirectory() {
        helper.performClick(HomePageLocators.homePageBuyerproductDirectory);
        helper.switchToWindow(1);
    }

    /**
     * Description: Clicks on search bar
     * Author: Bharani
     */
    public void searchBarClick() {
        helper.performClick(HomePageLocators.homePageSearchBar);
        LogHelper.info("Clicked on HomePageSearchBar");
    }

    /**
     * Description: Enter Text in search bar
     * Author: Bharani
     * 
     * @param productName
     */
    public void searchProductInSearchBar(String productName) {
        try {
            helper.enterText(HomePageLocators.homePageSearchBar, productName);
            LogHelper.info("Entered Value inside the SearchBar");
        } catch (Exception e) {
            e.printStackTrace();
            LogHelper.error("Error Caught");
        }
    }

    /**
     * Description: performs search enter actions
     * Author: Bharani
     */
    public void productSearchEnter() {
        helper.performClick(HomePageLocators.homePageSearchButton);
        LogHelper.info("Click Action done on SearchBar");
    }

    /**
     * Desription: Verifies the category label
     * Author: Krushna
     * 
     * @param string
     */
    public void verifyCategoryLabel(String string) {
        helper.verifyAcutalAndExpected(string, helper.retrieveText(HomePageLocators.homePageSideBarCategoryLabel));
    }

    public void hoverOverSignIn() {
        helper.mouseHover(HomePageLocators.homepageSignIn);
        Hooks.extentTest.log(Status.INFO, Thread.currentThread().getStackTrace()[1].getMethodName());
        LogHelper.info("Hovering on signin");  
    }
    /* Author:Raja
      * Description:Hovers the mouse over the "Join Free" button on the homepage.
      */

    public void hoverOverJoinFree() {
        helper.mouseHover(HomePageLocators.homepagejoinfree);
        Hooks.extentTest.log(Status.INFO, Thread.currentThread().getStackTrace()[1].getMethodName());
        LogHelper.info("Hovering on joinfree");
    }
    /* Author:Raja
      * Description:Clicks the "Join Free" button on the homepage.
      */

    public void clickJoinFree() {
        helper.performClick(HomePageLocators.homepagejoinfree);
        Hooks.extentTest.log(Status.INFO, Thread.currentThread().getStackTrace()[1].getMethodName());
        LogHelper.info("Clicked on joinfree");   
    }
    /* Author:Raja
      * Description:Switches the WebDriver context to a new window or tab.
      */

    public void switchToNewWindow() {
        helper.switchToNewWindow();
        Hooks.extentTest.log(Status.INFO, Thread.currentThread().getStackTrace()[1].getMethodName());
        
    }
    /* Author:Raja
      * Description:Hovers the mouse over the email input box on the registration page.
      */

    public void hoverOverEmailInput() {
        helper.mouseHover(HomePageLocators.registerPageEmailinput);
        LogHelper.info("Hovering on Email input box");
        Hooks.extentTest.log(Status.INFO, "Hovering on Email input box");  
    }
    /* Author:Raja
      * Description:Clicks the email input box on the registration page.
      */

    public void clickEmailInput() {
        WaitFor.waitForElemetToBeClickable(HomePageLocators.registerPageEmailinput);
        helper.performClick(HomePageLocators.registerPageEmailinput);
        LogHelper.info("Clicked on Email input box ");
        Hooks.extentTest.log(Status.WARNING, "Clicked on Email input box"); 
    }
    /* Author:Raja
      * Description:Enters an email address into the email input box on the registration page.
      */

    public void enterEmail(String emailValue) {
        Hooks.extentTest.log(Status.INFO, "Read data from Excel");
        helper.enterText(HomePageLocators.registerPageEmailinput,emailValue); 
    }
    /* Author:Raja
      * Description:Clicks the "Agree" button on the registration page.
      */

    public void clickEmail() {
        helper.performClick(HomePageLocators.registerPageAgree);
        LogHelper.info("Clicked on Agree ");
        Hooks.extentTest.log(Status.INFO, "Clicked on Agree");
        Hooks.extentTest.log(Status.INFO, "Captcha Required");
        
    }
    /* Author:Raja
      * Description:Takes a screenshot of the current page and adds it to the report.
      */

    public void screenshot() {
        ReportGenerator.addScreenshotToReport("signinpage", Hooks.extentTest, "captcha required");
        
    }
    /* Author:Raja
      * Description:Hovers the mouse over the "Buyer" section on the homepage.
      */

    public void hoverOverBuyer() {
        helper.mouseHover(HomePageLocators.homepageBuyer);
        LogHelper.info("Hovering on Buyer");
        Hooks.extentTest.log(Status.INFO, "Hovering on Buyer");
    }
    /* Author:Raja
      * Description:Clicks the "New User Guide" link on the homepage and switches to the new tab.
      */

    public void clickNewUserGuide() {
        helper.performClick(HomePageLocators.homepageNewUserGuide);
        LogHelper.info("Clicked on Newuserguide");
        Hooks.extentTest.log(Status.INFO, "Clicked on Newuserguide"); 
        helper.switchToNewWindow();
        LogHelper.info("Switched to new Tab");
        Hooks.extentTest.log(Status.INFO, "Switched to new Tab");
    }
    /* Author:Raja
      * Description:Switches the WebDriver context to a new window or tab.
      */

    public void switchto() {
        helper.switchToNewWindow();
        LogHelper.info("Switched to new Tab");
        Hooks.extentTest.log(Status.INFO, "Switched to new Tab");  
    }
    /* Author:Raja
      * Description:Verifies that the current URL contains a specific string.
      */


    public void verifyUrl(String string) {
        String userUrl=Root.driver.getCurrentUrl();
        LogHelper.info("Getting url from current window");
        Hooks.extentTest.log(Status.INFO, "Getting url from current window");
        if(userUrl.contains(string)){
            Assert.assertTrue(true);
        }
        LogHelper.info("Verified the url");
        Hooks.extentTest.log(Status.INFO, "Verified the url");
    }
    /* Author:Raja
      * Description:Clicks the "Return Back" button or homepagelogo to navigate back to the homepage.
      */

    public void returnBack() {
        helper.performClick(HomePageLocators.homepageReturnBack);
        LogHelper.info("Returning back to homepage");
        Hooks.extentTest.log(Status.INFO, "Returning back to homepage");  
    }
    /* Author:Raja
      * Description:Clicks the "Audited Suppliers Reports" link on the homepage.
      */

    public void clickAuditedSuppliers() {
        helper.performClick(HomePageLocators.homepageAuditedSuppliersReports);
        LogHelper.info("Clicked on AuditedSupplierReports");
        Hooks.extentTest.log(Status.INFO, "Clicked on AuditedSupplierReports");  
    }
    /* Author:Raja
      * Description:Clicks the "Meet Suppliers" link on the homepage.
      */
    public void clickMeetSuppliers() {
        helper.performClick(HomePageLocators.homepageMeetSuppliers);
        LogHelper.info("Clicked on MeetPageSuppliers");
        Hooks.extentTest.log(Status.INFO, "Clicked on MeetPageSuppliers");  
    }

    /**
    * Description: scrolling down to the footer
    * Author: Radhika
    */

   public void hoverToFooter() {
      helper.scrollOnPage(6000);
      Hooks.extentTest.log(Status.INFO, Thread.currentThread().getStackTrace()[1].getMethodName());
   }

   /**
    * Description: click items and verify
    * Author: Radhika
    */

   public void hotItemsList(List<List<String>> listItems) {
      try {

         List<WebElement> elem = Root.driver.findElements(By.xpath("//div[@class='hot-item']/a"));
         for (int i = 1; i <= 12; i++) {
            elem.get(i - 1).click();
            helper.switchToWindow(1);
            ScreenCapture.takePageScreenShot(driver.getTitle());
            ReportGenerator.addScreenshotToReport(driver.getTitle(), Hooks.extentTest,
                  "screenshot of each link");
            String actualURL = Root.driver.getCurrentUrl();
            String expectedURL = listItems.get(i - 1).get(1);
            helper.verifyAcutalAndExpected(expectedURL, actualURL);
            String actualTitle = Root.driver.getTitle();
            String expectedTitle = listItems.get(i - 1).get(0);
            helper.verifyAcutalAndExpected(expectedTitle, actualTitle);
            Hooks.extentTest.log(Status.INFO,expectedTitle+ " is same as "+ actualTitle);
            Root.driver.close();
            helper.switchToWindow(0);
         }
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }}

 /**
     * Author - Suhansh Bangre
     * Description - verifies home page logo is present on home page 
     @param ExtentTest test
     */
    public void verifyMadeInChinaLogo(ExtentTest test){
        Assert.assertTrue(helper.isWebElementElementDisplayed(HomePageLocators.homePageLogo));
        LogHelper.info("click"+helper.retrieveDomAttribute(HomePageLocators.homePageLogoLink, "href"));
        Hooks.extentTest.log(Status.INFO, "click"+helper.retrieveDomAttribute(HomePageLocators.homePageLogoLink, "href"));
    }

    
    /**
     * Author - Suhansh Bangre
     * Description - verifies home page logo is present on home page 
     @param ExtentTest test
     @param String productName
     */
    public void searchProductInSearchBar(String productName, ExtentTest test) {
        try {
            helper.performClick(HomePageLocators.homePageSearchBar);
            Root.driver.findElement(HomePageLocators.homePageSearchBar).clear();
            helper.enterText(HomePageLocators.homePageSearchBar, productName);
            helper.performEnter(HomePageLocators.homePageSearchBar);
             
            LogHelper.info("click on search bar");
            LogHelper.info(productName + " entered in search bar");
            LogHelper.info("searched " + productName);
            test.log(Status.INFO, "click on search bar");
            test.log(Status.INFO, productName + " entered in search bar");
            test.log(Status.INFO, "searched " + productName);
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    }
