package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "(//ul[@class=\"srp-results srp-list clearfix\"]/li)[1]//h3")
    private static WebElement THE_FIRST_ITEM_LISTED;

    @FindBy(xpath = "//button[@class=\"faux-link follow-ebay__trigger\"]")
    private static WebElement SAVE_THIS_SEARCH_BUTTON;

    public SearchResultsPage(WebDriver driver){
        super(driver);
    }

    @Step("Click on the first item that was listed")
    public SearchResultsPage clickOnTheFirstItemListed() {
        clickOnElement(waitToBeClickable(THE_FIRST_ITEM_LISTED, driver));
        return this;
    }

    @Step("Save this search")
    public SearchResultsPage saveThisSearch() {
        clickOnElement(waitToBeClickable(SAVE_THIS_SEARCH_BUTTON, driver));
        return this;
    }

}
