package tests;

import context.CucumberStepContext;
import drivers.PageManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class DefinitionSteps {

    static final String EXPECTED_CAPTCHA_MESSAGE = "Please verify yourself to continue";
    static final String EXPECTED_QUANTITY_ERROR_MESSAGE = "Please enter quantity of 1 or more";
    static final String RECENTLY_VIEWED_ITEMS_SECTION = "Your Recently Viewed Items";
    WebDriver driver = CucumberStepContext.getInstance().getDriver();
    PageManager pageManager = CucumberStepContext.getInstance().getPageManager();

    protected WebElement myWait(WebElement element, WebDriver driver) {
        WebElement visibleElement = null;
        try {
            visibleElement = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            System.out.println("Element was not loaded!");
        }
        return visibleElement;
    }

    @Given("User opens home page.")
    public void userOpensHomePage() {
        pageManager.homePage().open();
    }

    @When("User navigates to login page.")
    public void userNavigatesToLoginPage() {
        pageManager.homePage().navigateToLoginPage();
    }

    @Then("Captcha message is displayed.")
    public void checkIfCaptchaMessageIsDisplayed() {
        myWait(pageManager.captchaPage().CAPTCHA_MESSAGE, driver);
        Assert.assertTrue(pageManager.captchaPage().CAPTCHA_MESSAGE.getText().contains(EXPECTED_CAPTCHA_MESSAGE));
    }

    @When("User searches for {string}.")
    public void userSearchesForItemName(final String searchPhrase) {
        pageManager.homePage().searchFor(searchPhrase);
    }

    @And("User saves his search.")
    public void userSavesHisSearch() {
        pageManager.searchResultsPage().saveThisSearch();
    }

    @And("User picks the first result and navigates to cart.")
    public void userPicksTheFirstResultAndNavigatesToCart() {
        pageManager.searchResultsPage().clickOnTheFirstItemListed();
        pageManager.itemPage().addToCart()
                .goToCart();
    }

    @Then("Cart is not empty.")
    public void cartIsNotEmpty() {
        myWait(pageManager.cartPage().NON_EMPTY_CART, driver);
        Assert.assertTrue(pageManager.cartPage().NON_EMPTY_CART.isDisplayed());
    }

    @And("User opens any search results.")
    public void userOpensAnySearchResults() {
        pageManager.searchResultsPage().clickOnTheFirstItemListed();
    }

    @Then("Recently viewed items are displayed on the home page.")
    public void recentlyViewedItemsAreDisplayedOnTheHomePage() {
        pageManager.homePage().open();
        Assert.assertTrue(pageManager.homePage().MAIN_SECTION.getText().contains(RECENTLY_VIEWED_ITEMS_SECTION));
    }

    @When("User selects Poland out of collapsible list.")
    public void userSelectsPolandOutOfCollapsibleList() {
        pageManager.homePage().navigateToPolishVersion();
    }

    @Then("User is redirected to Polish site.")
    public void userIsRedirectedToPolishSite() {
        myWait(pageManager.homePage().POLISH_LOGO_BUTTON, driver);
        Assert.assertTrue(pageManager.homePage().POLISH_LOGO_BUTTON.isDisplayed());
    }

    @When("User hovers the mouse cursor over My eBay menu button.")
    public void userHoversTheMouseCursorOverMyEBayMenuButton() {
        pageManager.homePage().openMyEbaySection();
    }

    @Then("All required sections are visible.")
    public void allRequiredSectionsAreVisible() {
        Assert.assertTrue(pageManager.homePage().MY_EBAY_SECTION_SUMMARY_ITEM.isDisplayed());
        Assert.assertTrue(pageManager.homePage().MY_EBAY_SECTION_RECENTLY_VIEWED_ITEM.isDisplayed());
        Assert.assertTrue(pageManager.homePage().MY_EBAY_SECTION_BIDS_OFFERS_ITEM.isDisplayed());
        Assert.assertTrue(pageManager.homePage().MY_EBAY_SECTION_WATCHLIST_ITEM.isDisplayed());
        Assert.assertTrue(pageManager.homePage().MY_EBAY_SECTION_PURCHASE_HISTORY_ITEM.isDisplayed());
        Assert.assertTrue(pageManager.homePage().MY_EBAY_SECTION_BUY_AGAIN_ITEM.isDisplayed());
        Assert.assertTrue(pageManager.homePage().MY_EBAY_SECTION_SELLING_ITEM.isDisplayed());
        Assert.assertTrue(pageManager.homePage().MY_EBAY_SECTION_SAVED_SEARCHES_ITEM.isDisplayed());
        Assert.assertTrue(pageManager.homePage().MY_EBAY_SECTION_SAVED_SELLERS_ITEM.isDisplayed());
        Assert.assertTrue(pageManager.homePage().MY_EBAY_SECTION_MESSAGES_ITEM.isDisplayed());
    }

    @And("User enters a negative number of <Quantity>.")
    public void userEntersANegativeNumberOfQuantity(int quantity) {

    }

    @And("User enters a negative number of {string}.")
    public void userEntersANegativeNumberOfQuantity(String quantity) {
        pageManager.itemPage().enterQuantity(quantity);
    }

    @Then("Error message is displayed.")
    public void errorMessageIsDisplayed() {
        Assert.assertTrue(new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElement(pageManager.itemPage().QUANTITY_ERROR_MESSAGE, EXPECTED_QUANTITY_ERROR_MESSAGE)));
    }
}
