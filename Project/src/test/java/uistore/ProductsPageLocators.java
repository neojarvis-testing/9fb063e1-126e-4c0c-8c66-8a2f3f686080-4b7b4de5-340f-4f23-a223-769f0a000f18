package uistore;

import org.openqa.selenium.By;

public class ProductsPageLocators {

    public static By electronicsProductPageText = By.cssSelector("em[class='product_word']");

    public static By productPageSupplierListMenu = By.xpath("//a[contains(text(),'Supplier List')]");
    public static By productPageProductListMenu = By.xpath("//a[contains(text(),'Product List')]");
    public static By consumerElectronicsCatagory = By.xpath("//a[contains(@href,'Consumer-Electronics-Catalog')]");
    public static By selectedCatagoryFilter = By.xpath("(//span[@class='refine-selected'])[1]");
    public static By iso9000 = By.cssSelector(
            "a[href='//www.made-in-china.com/company-search/Electronics/C1--CD_Consumer-Electronics-Catalog--MC_9/1.html']");
    public static By selectedIso9000 = By.xpath("(//span[@class='refine-selected'])[2]");
    public static By diamondMember = By.cssSelector(
            "a[href='//www.made-in-china.com/company-search/Electronics/C1--CD_Consumer-Electronics-Catalog--MC_9--CL_DM/1.html']");
     public static By checkedDiamondMember=By.xpath("(//input[@type='checkbox'])[4]");
            public static By firstProduct = By.xpath("(//h2[@class='company-name'])[1]");
    public static By diamondTextLocator = By.cssSelector("span[class='shop-sign__text']");
    public static By productpageClickFirstCompanyAfterSearch = By.xpath("(//h2[@class='product-name'])[1]");
    public static By productpageContactSupplierButton = By.xpath("(//a[@class='btns button-link-contact'])[1]");
    public static By productpageVerifyProductName = By
            .cssSelector("h1[class='sr-proMainInfo-baseInfoH1 J-baseInfo-name']");
    public static By productpageVerifyFormIsdisplayed = By.cssSelector("form[id='J-sendInquiry-new']");
    public static By productpageTextArea = By.id("content");
    public static By productpageEmailBox = By.cssSelector("input[id='senderMail']");
    public static By productpageSendInquiry = By.xpath("(//input[@class='btn btn-main btn-big'])[1]");
    public static By productpageVerifySuccessfulMessage = By.xpath("//div[@class='ft-result__title J-msg-h1']");
    public static By productpageSendName = By.id("senderName");
    public static By productpageSendCompanyName = By.id("comName");
    public static By productpageSendMobile = By.id("senderMobile");
    public static By productpageSendInquiryNow = By.xpath("(//input[@class='btn btn-main btn-big'])[1]");
    public static By ProductsPageLEDStripLight = By.xpath("//a[text()='Led Strip Light']");
    public static By ProductsPageLcontact = By.xpath("(//a[@class='btn btn-main'])[2]");
    public static By ProductsPageColourtemp = By.xpath("//span[contains(text(),'Color Temperature')]");
    public static By ProductsPagewarmligth = By.xpath("//a[contains(text(),'Warm White')]");
    public static By ProductsPageLedlight = By.cssSelector("a[href='//www.made-in-china.com/products-search/hot-china-products/Led_Light_Tube.html']");
    public static By ledLightPageTitle = By.cssSelector("em[class='product_word']");
    public static By ledtubeLightPageTitle = By.cssSelector("h1[class='product_word']");

}
