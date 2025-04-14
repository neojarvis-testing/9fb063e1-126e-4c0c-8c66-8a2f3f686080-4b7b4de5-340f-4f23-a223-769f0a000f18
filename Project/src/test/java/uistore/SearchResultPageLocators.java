package uistore;

import org.openqa.selenium.By;

public class SearchResultPageLocators {

        public static By searchResultPageWiresText = By.className("product_word");

        public static By searchResultPageWiresPagination = By.className("pager");

        public static By searchResultPageWiresFirstProduct = By.cssSelector(
                        "a[title='Factory UL83 Electric Power Electrical Cable Thhn Wire 14/12/10AWG Power Aluminum Copper UL Certification Cable']");

        public static By searchResultPageWiresProductDetailsText = By
                        .xpath("//span[contains(text(), 'Product Details')]");

        public static By searchResultPageFurnitureText = By.className("product_word");

        public static By searchResultPageFurnitureMoreLink = By
                        .xpath("//a[@class='more-less']//span[contains(text(), 'More')]");

        public static By searchResultPageFurnitureLinks = By.xpath("//div[@class='J-tags']//a");

        public static By searchResultPageFurniturePaginationPage2Link = By.linkText("2");

        public static By searchResultPageFurnituresText = By.className("product_word");

        public static By searchResultPageSiteLogo = By.cssSelector("a[href='//www.made-in-china.com']");

}
 