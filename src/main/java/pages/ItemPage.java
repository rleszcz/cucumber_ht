package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends BasePage {
    @FindBy(xpath = "//a[@role=\"button\" and contains(text(), \"Add to cart\")]")
    private static WebElement ADD_TO_CART_BUTTON;

    @FindBy(xpath = "//*[contains(text(), \"Go to cart\")]")
    private static WebElement GO_TO_CART_BUTTON;

    @FindBy(xpath = "//span[@id=\"fshippingCost\"]")
    private static WebElement SHIPPING_COST_ELEMENT;

    @FindBy(xpath = "//input[@class=\"qtyInput\"]")
    private static WebElement QUANTITY_FIELD;

    @FindBy(xpath = "//div[@id=\"w1-16-_errMsg\"]")
    public WebElement QUANTITY_ERROR_MESSAGE;

    public ItemPage(WebDriver driver){
        super(driver);
    }

    @Step("Add to cart")
    public ItemPage addToCart() {
        clickOnElement(waitToBeClickable(ADD_TO_CART_BUTTON, driver));
        return this;
    }

    @Step("Go to cart")
    public ItemPage goToCart() {
        clickOnElement(waitToBeClickable(GO_TO_CART_BUTTON, driver));
        return this;
    }

    @Step("Enter quantity")
    public ItemPage enterQuantity(String quantity) {
        clickOnElement(QUANTITY_FIELD);
        pressKey(Keys.BACK_SPACE);
        enterTextIntoField(QUANTITY_FIELD, quantity);
        return this;
    }
}
