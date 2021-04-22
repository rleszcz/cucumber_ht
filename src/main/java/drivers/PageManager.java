package drivers;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageManager {

    public WebDriver driver;
    private HomePage homePage;
    private CaptchaPage captchaPage;
    private SearchResultsPage searchResultsPage;
    private ItemPage itemPage;
    private CartPage cartPage;

    public PageManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage homePage() {
        if (homePage == null)
            homePage = new HomePage(driver);
        return homePage;
    }

    public CaptchaPage captchaPage() {
        if (captchaPage == null)
            captchaPage = new CaptchaPage(driver);
        return captchaPage;
    }

    public SearchResultsPage searchResultsPage() {
        if (searchResultsPage == null)
            searchResultsPage = new SearchResultsPage(driver);
        return searchResultsPage;
    }

    public ItemPage itemPage() {
        if (itemPage == null)
            itemPage = new ItemPage(driver);
        return itemPage;
    }

    public CartPage cartPage() {
        if (cartPage == null)
            cartPage = new CartPage(driver);
        return cartPage;
    }

}
