package uistore;

import org.openqa.selenium.By;

public class CategoriesPageLocators {
    public static By manufacturingMachineTools = By.cssSelector(
            "a[href='https://www.made-in-china.com/Manufacturing-Processing-Machinery-Catalog/Machine-Tools.html?pv_id=1iofeahfk36f&faw_id=null']");
    public static By commonLocator = By.xpath("//a[@class='item-anchor']");
    public static By categoriesPageSideBarCategoryNameLabel = By.xpath("//h1[@class='cate-title']");
}
