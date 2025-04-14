package uistore;

import org.openqa.selenium.By;

public class SignInPageLocators {

     public static By registerPageSignInNowLink=By.partialLinkText("Sign in now");
    public static By signInPageLanguageDropdown = By.xpath("//div[@class='language-switch pc-show']");
    public static By signInPageEspanolLink = By.xpath("(//a[contains(text(),'Español')])[1]");
    public static By signInPageFranceLink = By.xpath("(//a[contains(text(),'Français')])[1]");
    public static By signInPageGermanLink = By.xpath("(//a[contains(text(),'Deutsch')])[1]");
    public static By signInPageRussianLink = By.xpath("(//a[contains(text(),'Русский язык')])[1]");
    public static By signInPageJapaneseLink = By.xpath("(//a[contains(text(),'日本語')])[1]");
    public static By signInPageEnglishLink = By.xpath("(//a[contains(text(),'English')])[1]");

}
