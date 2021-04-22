package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    private static final String HOME_PAGE_URL = "https://www.ebay.com/";

    @FindBy(xpath = "//input[@type=\"text\"]")
    private static WebElement SEARCH_FIELD;

    @FindBy(xpath = "//a[@role=\"button\" and @class=\"thrd\"]")
    private static WebElement SITE_SELECTION_TAB;

    @FindBy(xpath = "//p[contains(text(), \"Poland\")]")
    private static WebElement POLAND_BUTTON;

    @FindBy(xpath = "//p[contains(text(), \"Russia\")]")
    private static WebElement RUSSIA_BUTTON;

    @FindBy(xpath = "//a[@title=\"My eBay\"]")
    private static WebElement MY_EBAY_SECTION_BUTTON;

    @FindBy(xpath = "//a[@href=\"https://cart.ebay.com\"]")
    private static WebElement CART_BUTTON;

    @FindBy(xpath = "//a[@title=\"Advanced Search\"]")
    private static WebElement ADVANCED_SEARCH_BUTTON;

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

    @Step("Navigate to advanced search page")
    public HomePage navigateToAdvancedSearch() {
        clickOnElement(waitToBeClickable(ADVANCED_SEARCH_BUTTON, driver));
        return this;
    }
}
