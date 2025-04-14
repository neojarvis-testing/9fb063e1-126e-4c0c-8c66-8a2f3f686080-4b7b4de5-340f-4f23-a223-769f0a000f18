package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import utils.HelperUtility;
import utils.Root;

public class CategoriesPageActions {

    public HelperUtility helper;
    public WebDriver driver;

    public CategoriesPageActions(WebDriver driver) {
        this.driver = driver;
        this.helper = new HelperUtility(driver);
    }

    /**
     * Description: It iterates items of category page and verify the url
     * Author: Sushil Lodhi
     * @param test
     */
    public void iterateItemsClickAndVerify(ExtentTest test, List<List<String>> listOfString) {
        for (int i = 1; i <= 9; i++) {
            WebElement element = Root.driver.findElement(By.xpath("(//a[@class='item-anchor'])[" + i + "]"));
            element.click();
            helper.switchToWindow(2);
            helper.verifyAcutalAndExpected(listOfString.get(i - 1).get(1), Root.driver.getCurrentUrl());
            Root.driver.close();
            helper.switchToWindow(1);
        }
    }

}
