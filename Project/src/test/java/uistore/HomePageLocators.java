package uistore;

import org.openqa.selenium.By;

public class HomePageLocators {

        // *********************** Buttons ******************************
        public static By homePageSearchButton = By.id("J-nail-search-submit");
        public static By homepagePopUpcloseButton = By
                        .cssSelector("span[class='campaign-pop-close J-campaign-pop-close']");
        public static By homepageNavbarJoinFreeButton = By.xpath("(//a[@class='nail-btn'])[1]");
        public static By homepagejoinfree = By.xpath("(//a[@class='nail-btn'])[1]");

        // *********************** Links ******************************
        public static By homePageLogoLink = By.cssSelector("a[href='//www.made-in-china.com']");
        public static By homepageNavbarSignInIcon = By.xpath("//div[@class='login-link']");
        public static By homePageSideBarCategoryManufacturingLink = By
                        .xpath("(//span[text()='Manufacturing & Processing Machinery'])[3]");
        public static By homePageSideBarCategoryConsumerLink = By.xpath("(//span[text()='Consumer Electronics'])[3]");
        public static By homePageSideBarCategoryIndustrialLink = By
                        .xpath("(//span[text()='Industrial Equipment & Components'])[3]");
        public static By homePageSideBarCategoryElectrialLink = By
                        .xpath("(//span[text()='Electrical & Electronics'])[3]");
        public static By homePageSideBarCategoryConstructionLink = By
                        .xpath("(//span[text()='Construction & Decoration'])[3]");
        public static By homePageSideBarCategoryLightIndustryLink = By
                        .xpath("(//span[text()='Light Industry & Daily Use'])[3]");
        public static By homePageSideBarCategoryAutoMotorcycleLink = By
                        .xpath("(//span[text()='Auto, Motorcycle Parts & Accessories'])[3]");
        public static By homePageSideBarCategoryApparelAccessoriesLink = By
                        .xpath("(//span[text()='Apparel & Accessories'])[3]");
        public static By homePageSideBarCategoryLightsLightingLink = By
                        .xpath("(//span[text()='Lights & Lighting'])[3]");
        public static By homePageSideBarCategorySportingGoodsLink = By
                        .xpath("(//span[text()='Sporting Goods & Recreation'])[3]");
        public static By menuBarBuyerLink = By.xpath("//a[@href='https://www.made-in-china.com/help/faq/']");
        public static By menuBarNewUserGuideLink = By.linkText("New User Guide");
        public static By menuBarAuditedSuppliersLink = By.linkText("Audited Suppliers' Reports");
        public static By menuBarMeetSuppliersLink = By.linkText("Meet Suppliers");
        public static By homepageSignIn = By.xpath("//div[@class='login-link']");

        // *********************** Menu *****************************************/
        public static By homePageBuyerDropdownMenu = By
                        .cssSelector("a[href='https://www.made-in-china.com/help/faq/']");
        public static By homePageLogo = By.className("nail-logo-wrap");
        public static By homePageBuyerproductDirectory = By.xpath("//a[text()='Product Directory']");
        public static By homePageMadeInChinaLogo = By.className("nail-logo-wrap");
        public static By homePageledtube = By
                        .cssSelector("a[href='//www.made-in-china.com/Lights-Lighting-Catalog/LED-Tube.html']");

        // ********************** Input Field ************************************/
        public static By registerPageEmailinput = By.xpath("//input[@class='ft-input']");
        public static By homePageSearchBar = By.name("word");

        public static By homePageLightligthing = By.xpath("(//span[contains(text(),'Lights & Lighting')])[3]");
        public static By homepagePopup = By.xpath("//span[@class='campaign-pop-close J-campaign-pop-close']");

        public static By registerPageEmail = By.cssSelector("div[class='ft-input-wrap']");

        public static By registerPageAgree = By.xpath("//span[contains(text(),'I agree to the ')]");
        public static By homepageBuyer = By.xpath("(//a[contains(text(),'Buyer')])[1]");
        public static By homepageNewUserGuide = By.xpath("//a[contains(text(),'New User Guide')]");
        public static By homepageReturnBack = By.xpath("(//a[@href='//www.made-in-china.com/'])[1]");
        public static By homepageAuditedSuppliersReports = By.xpath("(//a[@href='//www.made-in-china.com/'])[1]");
        public static By homepageMeetSuppliers = By.xpath("//a[contains(text(),'Meet Suppliers')]");
        public static By homePageSideBarCategoryLabel=By.xpath("//h3[@class='cate-title medium-size-bold']");
        public static By categoryPageSideBarCategoryLabel=By.xpath("//h1[@class='cate-title']");
}
 