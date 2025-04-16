package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.Status;

import stepdefinitions.Hooks;
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
    public void iterateItemsClickAndVerify(List<List<String>> listOfString,String elementName) {
        switch (elementName) {
            case "Product Directory":
                for (int i = 1; i <= 9; i++) {
                    WebElement element = Root.driver.findElement(By.xpath("(//a[@class='item-anchor'])[" + i + "]"));
                    element.click();
                    helper.switchToWindow(2);
                    helper.verifyAcutalAndExpected(listOfString.get(i - 1).get(1), Root.driver.getCurrentUrl());
                    Hooks.extentTest.log(Status.PASS, Root.driver.getCurrentUrl()+" verified");
                    Root.driver.close();
                    helper.switchToWindow(1);
                }
                break;
            default:
                break;
        }
        
    }

}
 
