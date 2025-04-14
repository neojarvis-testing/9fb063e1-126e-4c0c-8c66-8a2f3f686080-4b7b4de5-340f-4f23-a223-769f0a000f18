package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.Status;

import stepdefinitions.Hooks;
import uistore.ProductsPageLocators;
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
        waitFor=new WaitFor(driver);
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
    }

    /**
     * Description: click on supplier's list menu
     * Author: Sushil Lodhi
     */
    public void clickSupplierListMenu() {
        driver.findElement(ProductsPageLocators.productPageSupplierListMenu).click();
    }

    /**
     * Description: locate catagories filter
     * Author: Sushil Lodhi
     */
    public void identifyCategoryFilter() {
       LogHelper.info(Thread.currentThread().getStackTrace()[2].getMethodName());
    }

    /**
     * Description: select consumer electronics
     * Author: Sushil Lodhi
     */
    public void selectConsumerElectronics() {
        helper.performClick(ProductsPageLocators.consumerElectronicsCatagory);
        driver.navigate().refresh();
    }

    public void identifyISO9000Filter() {

    }

    /**
     * Description: select ISO9000 in filter
     * Author: Sushil Lodhi
     */
    public void selectISO9000() {
        helper.performClick(ProductsPageLocators.iso9000);
        driver.navigate().refresh();
    }

    /**
     * Description: select diamond member checkbox
     * Author: Sushil Lodhi
     */
    public void selectDiamondMemberCheckBox() {
        helper.performClick(ProductsPageLocators.diamondMember);
    }

    /**
     * Description: clicks on first product
     * Author: Sushil Lodhi
     */
    public void clickFirstProduct() {
        helper.performClick(ProductsPageLocators.firstProduct);
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
        } catch (Exception e) {
            e.printStackTrace();
            LogHelper.error("Error Caught");
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
            LogHelper.info("Assertion done");
        } catch (Exception e) {
            e.printStackTrace();
            LogHelper.error("Error Caught");
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
        } catch (Exception e) {
            e.printStackTrace();
        } catch (AssertionError e) {
            e.printStackTrace();
            LogHelper.error("Error Caught");
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
        } catch (Exception e) {
            e.printStackTrace();
            LogHelper.error("Error Caught");
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
        } catch (Exception e) {
            e.printStackTrace();
            LogHelper.error("Error Caught");
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
        } catch (Exception e) {
            e.printStackTrace();
            LogHelper.error("Error Caught");
        }
    }

    /**
     * Description: Enter company name in inquiry form
     * Author: Bharani
     * @param company
     */
    public void sendCompanyField(String company) {
        helper.performClick(ProductsPageLocators.productpageSendCompanyName);
        helper.enterText(ProductsPageLocators.productpageSendCompanyName, company);
    }

    /**
     * Description: send data to mobile number in inquiry form
     * Author: Bharani
     */
    public void sendMobileField(String mobile) {
        helper.performClick(ProductsPageLocators.productpageSendMobile);
        helper.enterText(ProductsPageLocators.productpageSendMobile, mobile);
        LogHelper.info("Filled the Form");
    }

    /**
     * Description: send data to name in inquiry form
     * Author: Bharani
     */
    public void sendNameField(String name) {
        try {
            helper.performClick(ProductsPageLocators.productpageSendName);
            helper.enterText(ProductsPageLocators.productpageSendName, name);

        } catch (Exception e) {
            e.printStackTrace();
            LogHelper.error("Error Caught");
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
            ReportGenerator.addScreenshotToReport("Verification_Page", Hooks.extentTest, "Final Page Of the Action");
        } catch (Exception e) {
            e.printStackTrace();
            LogHelper.error("Error Caught");
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

    /**
     * Description: click on the contact now
     * Author: Radhika
     */

    public void contactnow() {
        helper.performClick(ProductsPageLocators.ProductsPageLcontact);
        LogHelper.info("clicked over" + helper.retrieveText(ProductsPageLocators.ProductsPageLcontact));
        Hooks.extentTest.log(Status.INFO,
                "clicked over" + helper.retrieveText(ProductsPageLocators.ProductsPageLcontact));
    }

    /**
     * Description: click on the ledlight tube filter
     * Author: Radhika 
     */

    public void ledlighttubefilter() {
        ScreenCapture.takePageScreenShot(driver.getTitle());
        LogHelper.info("clicked over filter" + helper.retrieveText(ProductsPageLocators.ProductsPageColourtemp));
    }
 

}