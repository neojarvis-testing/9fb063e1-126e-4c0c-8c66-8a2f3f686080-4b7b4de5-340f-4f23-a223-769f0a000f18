package pages;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.SearchResultPageLocators;
import utils.HelperUtility;
import utils.LogHelper;
import utils.ReportGenerator;
import utils.Root;
import utils.ScreenCapture;

public class SearchResultPageActions {
    WebDriver driver;
    HelperUtility helper;
    public SearchResultPageActions(WebDriver driver){
        this.driver = Root.driver;
        this.helper = new HelperUtility(Root.driver);
    }

    /**
     * Author - Suhansh Bangre
     * Description - verifies wires search result page contains text "Wires"
     @param ExtentTest test
     @param String string
     */
    public void verifyWiresResultPage(String string, ExtentTest test) {
        String actualText = helper.retrieveText(SearchResultPageLocators.searchResultPageWiresText);
        helper.verifyAcutalAndExpected(string, actualText);

        LogHelper.info("result page contains "+actualText);
        test.log(Status.INFO, "result page contains "+actualText);
        ReportGenerator.addScreenshotToReport("WiresSearchResultPage", test, "Wires Search Result Page Screen");
        ScreenCapture.takePageScreenShot("WiresSearchResultPage");
    }

    
    /**
     * Author - Suhansh Bangre
     * Description - click on first wire product in search result page
     @param ExtentTest test
     */
    public void clickFirstWiresProduct(ExtentTest test) {
        String productName = helper.retrieveText(SearchResultPageLocators.searchResultPageWiresFirstProduct);
        helper.performClick(SearchResultPageLocators.searchResultPageWiresFirstProduct);
        test.log(Status.INFO, "click on "+productName);
        LogHelper.info("click on "+productName);

    }
    
    /**
     * Author - Suhansh Bangre
     * Description - verifies wires product page contains text "Product Details"
     @param ExtentTest test
     */
    public void verifyWiresProductPage(String string, ExtentTest test) {
        String actualText = helper.retrieveText(SearchResultPageLocators.searchResultPageWiresProductDetailsText);
        helper.verifyAcutalAndExpected(string, actualText);

        test.log(Status.INFO, "page contains text "+actualText);
        ReportGenerator.addScreenshotToReport("WiresFirstProductPage", test, "Wires First Product Page Screen");
        ScreenCapture.takePageScreenShot("WiresFirstProductPage");

        LogHelper.info("page contains text "+actualText);
    }
    
    /**
     * Author - Suhansh Bangre
     * Description - takes user to parent window
     @param ExtentTest test
     */
    public void returnToParentWindow(ExtentTest test) {
        helper.switchToParentWindow();
        String pageTitle = Root.driver.getTitle();
        test.log(Status.INFO, "switched to window "+pageTitle);
        LogHelper.info("switched to window "+pageTitle);
    }
    
    /**
     * Author - Suhansh Bangre
     * Description - click on more link in search result page
     @param ExtentTest test
     */
    public void clickMoreLink(String string, ExtentTest test) {
        String moreText = helper.retrieveText(SearchResultPageLocators.searchResultPageFurnitureMoreLink);
        helper.performClick(SearchResultPageLocators.searchResultPageFurnitureMoreLink);
        test.log(Status.INFO, "click on "+moreText);
        LogHelper.info("click on "+moreText);
    }
    
    /**
     * Author - Suhansh Bangre
     * Description - click on pagination page 2 link
     @param ExtentTest test
     */
    public void clickPaginationPage2Link(ExtentTest test) {
        String paginationPage2LinkText = helper.retrieveText(SearchResultPageLocators.searchResultPageFurniturePaginationPage2Link);
        helper.performClick(SearchResultPageLocators.searchResultPageFurniturePaginationPage2Link);
        test.log(Status.INFO, "click on "+paginationPage2LinkText);
        LogHelper.info("click on "+paginationPage2LinkText);
    }
    
    /**
     * Author - Suhansh Bangre
     * Description - verifies second page of search result page
     @param ExtentTest test
     */
    public void verifyFurnitureSecondPage(String expectedText, ExtentTest test) {
        String actualText = helper.retrieveText(SearchResultPageLocators.searchResultPageFurnitureText);
        helper.verifyAcutalAndExpected(expectedText, actualText);

        test.log(Status.INFO, actualText+" is present on page");
        ReportGenerator.addScreenshotToReport("FurnitureSecondPage", test, "Furniture Second Page Screen");
        ScreenCapture.takePageScreenShot("FurnitureSecondPage");

        LogHelper.info(actualText+" is present on page");
    }
    
    /**
     * Author - Suhansh Bangre
     * Description - click on site logo in search result page
     @param ExtentTest test
     */
    public void clickSiteLogo(ExtentTest test) {
        helper.performClick(SearchResultPageLocators.searchResultPageSiteLogo);
        test.log(Status.INFO, "click on site logo");
        ReportGenerator.addScreenshotToReport("HomePage", test, "Home Page Screen");
        ScreenCapture.takePageScreenShot("HomePage");

        LogHelper.info("click on site logo");
    }


}