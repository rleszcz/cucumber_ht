package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdvancedSearchPage extends BasePage{

    @FindBy(xpath = "//input[@aria-labelledby=\"kw_lengend\"]")
    private static WebElement SEARCH_FIELD;

    @FindBy(xpath = "//input[@id=\"LH_BIN\"]")
    private static WebElement BUY_IT_NOW_CHECKBOX;

    @FindBy(xpath = "//input[@id=\"LH_FS\"]")
    private static WebElement FREE_INTERNATIONAL_SHIPPING_CHECKBOX;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private static WebElement SEARCH_BUTTON;

    public AdvancedSearchPage(WebDriver driver) {
        super(driver);
    }

    @Step("Advanced search with free shipping for a new...")
    public AdvancedSearchPage searchWithFreeShipping(String searchPhrase) {
        clickOnElement(waitToBeClickable(BUY_IT_NOW_CHECKBOX, driver));
        clickOnElement(waitToBeClickable(FREE_INTERNATIONAL_SHIPPING_CHECKBOX, driver));
        enterTextIntoField(waitToBeClickable(SEARCH_FIELD, driver), searchPhrase);
        clickOnElement(SEARCH_BUTTON);
        return this;
    }
}
