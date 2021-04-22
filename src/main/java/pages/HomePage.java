package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    private static final String HOME_PAGE_URL = "https://www.ebay.com/";

    @FindBy(xpath = "//input[@type=\"text\"]")
    private WebElement SEARCH_FIELD;

    @FindBy(xpath = "//a[@role=\"button\" and @class=\"thrd\"]")
    private WebElement SITE_SELECTION_TAB;

    @FindBy(xpath = "//p[contains(text(), \"Poland\")]")
    private WebElement POLAND_BUTTON;

    @FindBy(xpath = "//p[contains(text(), \"Russia\")]")
    private WebElement RUSSIA_BUTTON;

    @FindBy(xpath = "//a[@title=\"My eBay\"]")
    private WebElement MY_EBAY_SECTION_BUTTON;

    @FindBy(xpath = "//a[@href=\"https://cart.ebay.com\"]")
    private WebElement CART_BUTTON;

    @FindBy(xpath = "//div[@id=\"mainContent\"]")
    public WebElement MAIN_SECTION;

    @FindBy(xpath = "//header[@id=\"gh\"]//a[@href=\"https://www.ebay.pl\"]")
    public WebElement POLISH_LOGO_BUTTON;

    @FindBy(xpath = "//div[@class=\"gh-menu\"]//a[contains(text(), \"Summary\")]")
    public WebElement MY_EBAY_SECTION_SUMMARY_ITEM;

    @FindBy(xpath = "//div[@class=\"gh-menu\"]//a[contains(text(), \"Recently Viewed\")]")
    public WebElement MY_EBAY_SECTION_RECENTLY_VIEWED_ITEM;

    @FindBy(xpath = "//div[@class=\"gh-menu\"]//a[contains(text(), \"Bids/Offers\")]")
    public WebElement MY_EBAY_SECTION_BIDS_OFFERS_ITEM;

    @FindBy(xpath = "//div[@class=\"gh-menu\"]//a[contains(text(), \"Watchlist\")]")
    public WebElement MY_EBAY_SECTION_WATCHLIST_ITEM;

    @FindBy(xpath = "//div[@class=\"gh-menu\"]//a[contains(text(), \"Purchase History\")]")
    public WebElement MY_EBAY_SECTION_PURCHASE_HISTORY_ITEM;

    @FindBy(xpath = "//div[@class=\"gh-menu\"]//a[contains(text(), \"Buy Again\")]")
    public WebElement MY_EBAY_SECTION_BUY_AGAIN_ITEM;

    @FindBy(xpath = "//div[@class=\"gh-menu\"]//a[contains(text(), \"Selling\")]")
    public WebElement MY_EBAY_SECTION_SELLING_ITEM;

    @FindBy(xpath = "//div[@class=\"gh-menu\"]//a[contains(text(), \"Saved Searches\")]")
    public WebElement MY_EBAY_SECTION_SAVED_SEARCHES_ITEM;

    @FindBy(xpath = "//div[@class=\"gh-menu\"]//a[contains(text(), \"Saved Sellers\")]")
    public WebElement MY_EBAY_SECTION_SAVED_SELLERS_ITEM;

    @FindBy(xpath = "//div[@class=\"gh-menu\"]//a[contains(text(), \"Messages\")]")
    public WebElement MY_EBAY_SECTION_MESSAGES_ITEM;

    public HomePage(WebDriver driver){
        super(driver);
    }

    @Step("Open home page")
    public HomePage open() {
        openWebPage(HOME_PAGE_URL);
        return this;
    }

    @Step("Search for...")
    public HomePage searchFor(String searchPhrase) {
        enterTextIntoField(SEARCH_FIELD, searchPhrase);
        pressKey(Keys.ENTER);
        return this;
    }

    @Step("Navigate to Polish version")
    public HomePage navigateToPolishVersion() {
        scrollTo(driver, SITE_SELECTION_TAB);
        clickOnElement(waitToBeClickable(SITE_SELECTION_TAB, driver));
        clickOnElement(waitToBeClickable(POLAND_BUTTON, driver));
        return this;
    }

    @Step("Navigate to Russian version")
    public HomePage navigateToRussianVersion() {
        scrollTo(driver, SITE_SELECTION_TAB);
        clickOnElement(waitToBeClickable(SITE_SELECTION_TAB, driver));
        clickOnElement(waitToBeClickable(RUSSIA_BUTTON, driver));
        return this;
    }

    @Step("Open My eBay section")
    public HomePage openMyEbaySection() {
        mouseOverElement(MY_EBAY_SECTION_BUTTON);
        return this;
    }

    @Step("Go to cart")
    public HomePage goToCart() {
        clickOnElement(waitToBeClickable(CART_BUTTON, driver));
        return this;
    }

    @Step("Navigate to login page")
    public HomePage navigateToLoginPage() {
        clickOnElement(waitToBeClickable(MY_EBAY_SECTION_BUTTON, driver));
        return this;
    }

}
