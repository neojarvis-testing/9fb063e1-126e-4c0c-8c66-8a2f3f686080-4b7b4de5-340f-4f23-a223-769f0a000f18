package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.Status;

import stepdefinitions.Hooks;
import uistore.HomePageLocators;
import uistore.ProductsPageLocators;
import uistore.SendInqueryPageLocators;
import utils.HelperUtility;
import utils.LogHelper;
import utils.ReportGenerator;
import utils.Root;
import utils.ScreenCapture;
import utils.WaitFor;

public class ProductsPageActions {

    public HelperUtility helper;
    public WebDriver driver;
    public WaitFor waitFor;

    public ProductsPageActions(WebDriver driver) {
        this.driver = driver;
        this.helper = new HelperUtility(driver);
        waitFor = new WaitFor(driver);
    }

    /**
     * Description: Verifies the electronics page title
     * Author: Sushil Lodhi
     * 
     * @param titleText
     */
    public void verifyElectronicsPageTitle(String titleText) {
        String electronicsText = helper.retrieveText(ProductsPageLocators.electronicsProductPageText);
        Assert.assertTrue(electronicsText.contains(titleText));
        Hooks.extentTest.log(Status.INFO, Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     * Description: locate catagories filter
     * Author: Sushil Lodhi
     */
    public void identifyCategoryFilter() {
        LogHelper.info(Thread.currentThread().getStackTrace()[2].getMethodName());
    }

    public void selectFilterOption(String filterText) {
        switch (filterText) {
            case "ISO 9000":
                helper.performClick(ProductsPageLocators.iso9000);
                Hooks.extentTest.log(Status.INFO,
                        Thread.currentThread().getStackTrace()[1].getMethodName() + " " + filterText);
                driver.navigate().refresh();
                break;
            case "Consumer Electronics":
                helper.performClick(ProductsPageLocators.consumerElectronicsCatagory);
                Hooks.extentTest.log(Status.INFO,
                        Thread.currentThread().getStackTrace()[1].getMethodName() + " " + filterText);
                driver.navigate().refresh();
                break;
            case "Diamond Member checkobx":
                helper.performClick(ProductsPageLocators.diamondMember);
                Hooks.extentTest.log(Status.INFO,
                        Thread.currentThread().getStackTrace()[1].getMethodName() + " " + filterText);
                break;
            default:
                break;
        }
    }

    /**
     * Description: checks filter is selected or not
     * Author: switched to new window or company page
     */
    public void switchToCompanyPage() {
        helper.switchToNewWindow();
    }
    /**
     * Description: checks filter is selected or not
     * Author: Sushil Lodhi
     */
    public void verifyFilterSelected(By expectedLocator, String verifierText) {
        String expectedText = helper.retrieveText(expectedLocator);
        helper.verifyAcutalAndExpected(verifierText, expectedText);
        Hooks.extentTest.log(Status.INFO, Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public void filterVerfiy(String filterText){
        switch (filterText) {
            case "Consumer Electronics":
                verifyFilterSelected(ProductsPageLocators.consumerElectronicsCatagory, filterText);
                break;
            case "ISO 9000":
                verifyFilterSelected(ProductsPageLocators.selectedIso9000, filterText);
                break;
            case "Diamond Member":
                verifyFilterSelected(ProductsPageLocators.selectedIso9000, filterText);
                break;
            default:
                break;
        }
    }

    /**
     * Description: clicks on first product company
     * Author: Bharani
     */
    public void clickFirstProductCompany() {
        try {
            helper.performClick(ProductsPageLocators.productpageClickFirstCompanyAfterSearch);
            LogHelper.info("Clicked on The First Product After Search");
            helper.switchToNewWindow();
            LogHelper.info("Window Handled From Parent To Child");
            Hooks.extentTest.log(Status.INFO, Thread.currentThread().getStackTrace()[1].getMethodName());
        } catch (Exception e) {
            LogHelper.error("Error Caught");
            Hooks.extentTest.log(Status.FAIL, Thread.currentThread().getStackTrace()[1].getMethodName());
        }
    }

    /**
     * Description: verification for page title
     * Author: Bharani
     */
    public void verifyProductDetailPageTitle() {
        try {
            String productName = Root.driver.findElement(ProductsPageLocators.productpageVerifyProductName)
                    .getText();
            LogHelper.info("Got the text from the Page for Assert");
            String pageTitle = Root.driver.getTitle();
            LogHelper.info("The PageTitle :" + pageTitle);
            Assert.assertTrue(pageTitle.contains(productName));
            Hooks.extentTest.log(Status.PASS, Thread.currentThread().getStackTrace()[1].getMethodName());
            LogHelper.info("Assertion done");
        } catch (Exception e) {
            LogHelper.error("Error Caught");
            Hooks.extentTest.log(Status.FAIL, Thread.currentThread().getStackTrace()[1].getMethodName());
        }
    }

    public void contactSupplierVerify() {
        LogHelper.info("Wait Has been initialised");
    }

    /**
     * Description: click contact now button
     * Author: Bharani
     */
    public void clickContactSupplier() {
        try {
            helper.mouseHover(ProductsPageLocators.productpageContactSupplierButton);
            LogHelper.info("Hovered on ContactSupplier Button");
            helper.performClick(ProductsPageLocators.productpageContactSupplierButton);
            LogHelper.info("Clicked on ContactSupplier Button");
            helper.switchToNewWindow();
            Hooks.extentTest.log(Status.PASS, Thread.currentThread().getStackTrace()[1].getMethodName());
            LogHelper.info("Window Switched from First Child To the Second Child");
        } catch (Exception e) {
            e.printStackTrace();
            LogHelper.error("Error Caught");
        }
    }

    /**
     * Description: check form is displayed or not
     * Author: Bharani
     */
    public void verifySendInquiryFormDisplayed() {
        try {
            WebElement form = Root.driver.findElement(ProductsPageLocators.productpageVerifyFormIsdisplayed);
            LogHelper.info("Verified the Presence of Form : Send Inquiry Form");
            Assert.assertTrue(Root.prop.getProperty("errorMessage"), form.isDisplayed());
            Hooks.extentTest.log(Status.PASS,
                    Root.prop.getProperty("errorMessage") + " is equal " + form.isDisplayed());
        } catch (Exception e) {
            Hooks.extentTest.log(Status.FAIL, e.getMessage());
        } catch (AssertionError e) {
            e.printStackTrace();
            LogHelper.error("Error Caught");
            Hooks.extentTest.log(Status.FAIL, e.getMessage());
        }
    }

    /**
     * Description: give invalid data to contact form
     * Author: Bharani
     */
    public void sendDataToTextArea(String inValidData) {
        try {
            helper.performClick(ProductsPageLocators.productpageTextArea);
            LogHelper.info("Clicked on ProductArea Content");
            helper.enterText(ProductsPageLocators.productpageTextArea, inValidData);
            LogHelper.info("Sent the Text To Content Area");
            Hooks.extentTest.log(Status.INFO, Thread.currentThread().getStackTrace()[1].getMethodName());
        } catch (Exception e) {
            LogHelper.error("Error Caught");
            Hooks.extentTest.log(Status.FAIL, Thread.currentThread().getStackTrace()[1].getMethodName());
        }
    }

    /**
     * Description: enter email in product page
     * Author: Bharani
     */
    public void enterEmail(String emailSent) {
        try {
            helper.performClick(ProductsPageLocators.productpageEmailBox);
            helper.enterText(ProductsPageLocators.productpageEmailBox, emailSent);
            LogHelper.info("Sent The Text For Email");
            Hooks.extentTest.log(Status.INFO, Thread.currentThread().getStackTrace()[1].getMethodName());
        } catch (Exception e) {
            LogHelper.error("Error Caught");
            Hooks.extentTest.log(Status.FAIL, e.getMessage());
        }
    }

    /**
     * Description: Clicks on send inquiry button
     * Author: Bharani
     */
    public void clickSendInquiry() {
        try {
            helper.performClick(ProductsPageLocators.productpageSendInquiry);
            LogHelper.info("Clicked on Send Inquiry");
            Hooks.extentTest.log(Status.INFO, Thread.currentThread().getStackTrace()[1].getMethodName());
        } catch (Exception e) {
            LogHelper.error("Error Caught");
            Hooks.extentTest.log(Status.FAIL, e.getMessage());
        }
    }

    /**
     * Description: Enter company name in inquiry form
     * Author: Bharani
     * 
     * @param company
     */
    public void sendCompanyField(String company) {
        helper.performClick(ProductsPageLocators.productpageSendCompanyName);
        helper.enterText(ProductsPageLocators.productpageSendCompanyName, company);
        Hooks.extentTest.log(Status.INFO, Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     * Description: send data to mobile number in inquiry form
     * Author: Bharani
     */
    public void sendMobileField(String mobile) {
        helper.performClick(ProductsPageLocators.productpageSendMobile);
        helper.enterText(ProductsPageLocators.productpageSendMobile, mobile);
        LogHelper.info("Filled the Form");
        Hooks.extentTest.log(Status.INFO, Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     * Description: send data to name in inquiry form
     * Author: Bharani
     */
    public void sendNameField(String name) {
        try {
            helper.performClick(ProductsPageLocators.productpageSendName);
            helper.enterText(ProductsPageLocators.productpageSendName, name);
            Hooks.extentTest.log(Status.INFO, Thread.currentThread().getStackTrace()[1].getMethodName());
        } catch (Exception e) {
            LogHelper.error("Error Caught");
            Hooks.extentTest.log(Status.FAIL, e.getMessage());
        }
    }

    /**
     * Description: Perform click on send inquiry button
     * Author: Bharani
     */
    public void enterSendInquiryNow() {
        try {
            helper.mouseHover(ProductsPageLocators.productpageSendInquiryNow);
            Hooks.extentTest.log(Status.INFO, "Hovered on Send Inquiry");
            helper.performClick(ProductsPageLocators.productpageSendInquiryNow);
            LogHelper.info("Entered SendInquiry Button");
            Hooks.extentTest.log(Status.INFO, "Entered SendInquiry Button");
            ScreenCapture.takePageScreenShot("Verification_Page");
            Hooks.extentTest.log(Status.INFO, Thread.currentThread().getStackTrace()[1].getMethodName());
            ReportGenerator.addScreenshotToReport("Verification_Page", Hooks.extentTest, "Final Page Of the Action");
        } catch (Exception e) {
            LogHelper.error("Error Caught");
            Hooks.extentTest.log(Status.FAIL, e.getMessage());
        }
    }

    /**
     * Description: verify the final message
     * Author: Bharani
     */
    public void verifySuccessfulMessage() {
        try {
            String verifyMessage = helper.retrieveText(ProductsPageLocators.productpageVerifySuccessfulMessage);
            helper.verifyAcutalAndExpected("Sent Successfully!", verifyMessage);
            LogHelper.info("Message got for Verification :" + verifyMessage);
            LogHelper.info("Verification done on SuccessfullMessage");
        } catch (Exception e) {
            e.printStackTrace();
            LogHelper.error("Error Caught");
        }
    }

    /**
     * Description: verify the ledlight text
     */
    public void verifyLEDPage(String ledTitle) {
        Assert.assertTrue(helper.retrieveText(ProductsPageLocators.ledLightPageTitle).contains(ledTitle));
    }

    /**
     * Description: verify the ledtubelight text
     * Author: Radhika
     */
    public void verifyLEDtubePage(String ledtubeTitle) {
        Assert.assertTrue(helper.retrieveText(ProductsPageLocators.ledtubeLightPageTitle).contains(ledtubeTitle));
    }

    /**
     * Description: click on the ledstriplight
     * Author: Radhika
     */
    public void ledstripLight() {
        helper.performClick(ProductsPageLocators.ProductsPageLEDStripLight);
        LogHelper.info(
                "clicked over" + helper.retrieveText(ProductsPageLocators.ProductsPageLEDStripLight));
        Hooks.extentTest.log(Status.INFO,
                "clicked over" + helper.retrieveText(ProductsPageLocators.ProductsPageLEDStripLight));
        ScreenCapture.takePageScreenShot(driver.getTitle());
    }

    public void clickLEDElement(String clickLEDElement){
        switch (clickLEDElement) {
            case "LED Strip Light filter":
                helper.performClick(ProductsPageLocators.ProductsPageLEDStripLight);
                LogHelper.info("clicked over" + helper.retrieveText(ProductsPageLocators.ProductsPageLEDStripLight));
                Hooks.extentTest.log(Status.INFO,"clicked over" + helper.retrieveText(ProductsPageLocators.ProductsPageLEDStripLight));
                ScreenCapture.takePageScreenShot(driver.getTitle());
                break;
            case "Contact Now button":
                helper.performClick(ProductsPageLocators.ProductsPageLcontact);
                LogHelper.info("clicked over" + helper.retrieveText(ProductsPageLocators.ProductsPageLcontact));
                Hooks.extentTest.log(Status.INFO,"clicked over" + helper.retrieveText(ProductsPageLocators.ProductsPageLcontact));
                break;
            case "Send Inquiry Now button":
                helper.performClick(SendInqueryPageLocators.SendInqueryPageSend);
                LogHelper.info("clicked over the button" + helper.retrieveText(SendInqueryPageLocators.SendInqueryPageSend));
                Hooks.extentTest.log(Status.INFO,"clicked over the button" + helper.retrieveText(SendInqueryPageLocators.SendInqueryPageSend));
                driver.navigate().refresh();
                helper.performClick(SendInqueryPageLocators.SendInqueryPagelogo);
                Hooks.extentTest.log(Status.INFO,clickLEDElement+" clicked");
                break;
            case "LED Light Tube filter":
                ScreenCapture.takePageScreenShot(driver.getTitle());
                LogHelper.info("clicked over filter" + helper.retrieveText(ProductsPageLocators.ProductsPageColourtemp));
                Hooks.extentTest.log(Status.INFO,"clicked over filter" + helper.retrieveText(ProductsPageLocators.ProductsPageColourtemp));
                break;
            case "homepage logo":
                helper.performClick(SendInqueryPageLocators.SendInqueryPagelogo);
                break;
            case "Product Directory":
                helper.performClick(HomePageLocators.homePageBuyerproductDirectory);
                helper.switchToWindow(1);
                break;
            default:
                break;
        }
    }

    public void hoverOverSections(String string){
        switch (string) {
            case "Lights & Lighting":
                helper.mouseHover(HomePageLocators.homePageLightligthing);
                LogHelper.info("hover over the category" + helper.retrieveText(HomePageLocators.homePageLightligthing));
                Hooks.extentTest.log(Status.INFO,
                    "hover over the category" + helper.retrieveText(HomePageLocators.homePageLightligthing));        
                break;
            case "LED Tube":
                helper.mouseHover(HomePageLocators.homePageledtube);
                helper.performClick(HomePageLocators.homePageledtube);
                Hooks.extentTest.log(Status.INFO,
                    "clicked" + helper.retrieveText(HomePageLocators.homePageledtube) + "after hovering");
                LogHelper.info("clicked" + helper.retrieveText(HomePageLocators.homePageledtube) + "after hovering");
                break;
            case "Buyer":
                helper.mouseHover(HomePageLocators.homePageBuyerDropdownMenu);
                break;
            default:
                break;
        }
    }
 

}
