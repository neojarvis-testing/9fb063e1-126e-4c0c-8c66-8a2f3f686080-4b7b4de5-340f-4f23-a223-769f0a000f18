package stepdefinitions;

import java.time.Duration;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.Status;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePageActions;
import uistore.HomePageLocators;
import utils.HelperUtility;
import utils.LogHelper;
import utils.ReportGenerator;
import utils.Root;

public class VerifyCategoryStep {

    public static HelperUtility helper = new HelperUtility(Root.driver);
    public HomePageActions homePageActions = new HomePageActions(Root.driver);

    @When("user click on {string} in the side bar")
    public void user_click_on_in_the_side_bar(String string) {
        homePageActions.verifyCategoryLabel(string);
    }

    @Then("user navigate through categories and verify keywords:")
    public void user_navigate_through_categories_and_verify_keywords(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> category = dataTable.asLists(String.class);
        System.out.println(category.size());
        for (int i = 1; i < category.size(); i++) {
            WebElement element = Root.driver
                    .findElement(By.xpath("//li[@class='item cate-item']//span[@data-index='" + i + "']"));
            WebDriverWait wait = new WebDriverWait(Root.driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            System.out.println(category.get(i).get(0));
            WebElement pageTitle = Root.driver.findElement(HomePageLocators.categoryPageSideBarCategoryLabel);
            Assert.assertTrue(pageTitle.getText().contains(category.get(i).get(0)));
            ReportGenerator.addScreenshotToReport(pageTitle.getText(), Hooks.extentTest, pageTitle.getText());
            LogHelper.info("Clicked On " + pageTitle.getText() + " Category");
            Hooks.extentTest.log(Status.INFO, "Clicked On " + pageTitle.getText() + " Category");
            helper.performClick(HomePageLocators.homePageMadeInChinaLogo);
        }

    }

}
