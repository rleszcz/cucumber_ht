package tests;

import drivers.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.*;
import java.time.Duration;

public class DefinitionSteps {

    protected WebDriver driver;
    protected DriverManager driverManager = null;
    protected HomePage homePage = null;
    protected SearchResultsPage searchResultsPage = null;
    protected ItemPage itemPage = null;
    protected AdvancedSearchPage advancedSearchPage = null;

    @Before
    public void prepare() {
        driverManager = new DriverManager();
        driver = driverManager.getDriver("Edge");
        homePage = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        itemPage = new ItemPage(driver);
        advancedSearchPage = new AdvancedSearchPage(driver);
    }

    @After
    public void cleanUp() {
        driver.quit();
    }

    WebElement waitPresent(String xPath, long seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
    }

    WebElement waitClickable(String xPath, long seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
    }

    static final String POLISH_LOGO_BUTTON_XPATH = "//header[@id=\"gh\"]//a[@href=\"https://www.ebay.pl\"]";

    @Given("User opens home page.")
    public void userOpensHomePage() {
        homePage.open();
    }

    @When("User selects Poland out of collapsible list.")
    public void userSelectsPolandOutOfCollapsibleList() {
        homePage.navigateToPolishVersion();
    }

    @Then("User is redirected to Polish site.")
    public void userIsRedirectedToPolishSite() {
        waitPresent(POLISH_LOGO_BUTTON_XPATH, 5);
        Assert.assertTrue(driver.findElement(By.xpath(POLISH_LOGO_BUTTON_XPATH)).isDisplayed());
    }

    @When("User hovers the mouse cursor over My eBay menu button.")
    public void userHoversTheMouseCursorOverMyEBayMenuButton() {
        homePage.openMyEbaySection();
    }

    static final String MY_EBAY_SECTION_ITEM_SUMMARY_XPATH = "//div[@class=\"gh-menu\"]//a[contains(text(), \"Summary\")]";
    static final String MY_EBAY_SECTION_ITEM_RECENTLY_VIEWED_XPATH = "//div[@class=\"gh-menu\"]//a[contains(text(), \"Recently Viewed\")]";
    static final String MY_EBAY_SECTION_ITEM_BIDS_OFFERS_XPATH = "//div[@class=\"gh-menu\"]//a[contains(text(), \"Bids/Offers\")]";
    static final String MY_EBAY_SECTION_ITEM_WATCHLIST_XPATH = "//div[@class=\"gh-menu\"]//a[contains(text(), \"Watchlist\")]";
    static final String MY_EBAY_SECTION_ITEM_PURCHASE_HISTORY_XPATH = "//div[@class=\"gh-menu\"]//a[contains(text(), \"Purchase History\")]";
    static final String MY_EBAY_SECTION_ITEM_BUY_AGAIN_XPATH = "//div[@class=\"gh-menu\"]//a[contains(text(), \"Buy Again\")]";
    static final String MY_EBAY_SECTION_ITEM_SELLING_XPATH = "//div[@class=\"gh-menu\"]//a[contains(text(), \"Selling\")]";
    static final String MY_EBAY_SECTION_ITEM_SAVED_SEARCHES_XPATH = "//div[@class=\"gh-menu\"]//a[contains(text(), \"Saved Searches\")]";
    static final String MY_EBAY_SECTION_ITEM_SAVED_SELLERS_XPATH = "//div[@class=\"gh-menu\"]//a[contains(text(), \"Saved Sellers\")]";
    static final String MY_EBAY_SECTION_ITEM_MESSAGES_XPATH = "//div[@class=\"gh-menu\"]//a[contains(text(), \"Messages\")]";

    @Then("All required sections are visible.")
    public void allRequiredSectionsAreVisible() {
        Assert.assertTrue(driver.findElement(By.xpath(MY_EBAY_SECTION_ITEM_SUMMARY_XPATH)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(MY_EBAY_SECTION_ITEM_RECENTLY_VIEWED_XPATH)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(MY_EBAY_SECTION_ITEM_BIDS_OFFERS_XPATH)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(MY_EBAY_SECTION_ITEM_WATCHLIST_XPATH)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(MY_EBAY_SECTION_ITEM_PURCHASE_HISTORY_XPATH)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(MY_EBAY_SECTION_ITEM_BUY_AGAIN_XPATH)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(MY_EBAY_SECTION_ITEM_SELLING_XPATH)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(MY_EBAY_SECTION_ITEM_SAVED_SEARCHES_XPATH)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(MY_EBAY_SECTION_ITEM_SAVED_SELLERS_XPATH)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(MY_EBAY_SECTION_ITEM_MESSAGES_XPATH)).isDisplayed());
    }

    @When("User navigates to login page.")
    public void userNavigatesToLoginPage() {
        homePage.navigateToLoginPage();
    }

    static final String CAPTCHA_FORM_XPATH = "//form[@id=\"captcha_form\"]";
    static final String EXPECTED_CAPTCHA_MESSAGE = "Please verify yourself to continue";

    @Then("Captcha message is displayed.")
    public void checkIfCaptchaMessageIsDisplayed() {
        waitPresent(CAPTCHA_FORM_XPATH, 5);
        Assert.assertTrue(driver.findElement(By.xpath(CAPTCHA_FORM_XPATH)).getText().contains(EXPECTED_CAPTCHA_MESSAGE));
    }

    @When("User navigates to cart.")
    public void userNavigatesToCart() {
        homePage.goToCart();
    }

    static final String EMPTY_CART_XPATH = "//div[@class=\"empty-cart\"]";

    @Then("Cart is empty.")
    public void cartIsEmpty() {
        Assert.assertTrue(driver.findElement(By.xpath(EMPTY_CART_XPATH)).isDisplayed());
    }

    @When("User searches for {string}.")
    public void userSearchesForItemName(final String searchPhrase) {
        homePage.searchFor(searchPhrase);
    }

    @And("User picks the first result and navigates to cart.")
    public void userPicksTheFirstResultAndNavigatesToCart() {
        searchResultsPage.clickOnTheFirstItemListed();
        itemPage.addToCart()
                .goToCart();
    }

    static final String NON_EMPTY_CART_XPATH = "//div[@class=\"cart-bucket-lineitem\"]";

    @Then("Cart is not empty.")
    public void cartIsNotEmpty() {
        waitPresent(NON_EMPTY_CART_XPATH, 5);
        Assert.assertTrue(driver.findElement(By.xpath(NON_EMPTY_CART_XPATH)).isDisplayed());
    }

    @And("User opens any search results.")
    public void userOpensAnySearchResults() {
        searchResultsPage.clickOnTheFirstItemListed();
    }

    static final String MAIN_SECTION_XPATH = "//div[@id=\"mainContent\"]";
    static final String RECENTLY_VIEWED_ITEMS_SECTION = "Your Recently Viewed Items";

    @Then("Recently viewed items are displayed on the home page.")
    public void recentlyViewedItemsAreDisplayedOnTheHomePage() {
        homePage.open();
        Assert.assertTrue(driver.findElement(By.xpath(MAIN_SECTION_XPATH)).getText().contains(RECENTLY_VIEWED_ITEMS_SECTION));
    }

    @And("User saves his search.")
    public void userSavesHisSearch() {
        searchResultsPage.saveThisSearch();
    }

    @When("User navigates to advanced search.")
    public void userNavigatesToAdvancedSearch() {
        homePage.navigateToAdvancedSearch();
    }

    @And("User searches for {string} with free shipping.")
    public void userSearchesForItemNameWithFreeShipping(String itemName) {
        advancedSearchPage.searchWithFreeShipping(itemName);
    }

    static final String THE_FIRST_RESULT_XPATH = "//div[@id=\"ResultSetItems\"]//li[@r=\"1\"]";
    static final String FREE_SHIPPING_PHRASE = "Free shipping";

    @Then("For the first result the shipping cost is free.")
    public void forTheFirstResultTheShippingCostIsFree() {
        waitPresent(THE_FIRST_RESULT_XPATH, 5);
        Assert.assertTrue(driver.findElement(By.xpath(THE_FIRST_RESULT_XPATH)).getText().contains(FREE_SHIPPING_PHRASE));
    }
}
