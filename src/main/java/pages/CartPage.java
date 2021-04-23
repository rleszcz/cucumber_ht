package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(xpath = "//div[@class=\"cart-bucket-lineitem\"]")
    public WebElement NON_EMPTY_CART;

    @FindBy(xpath = "//div[@class=\"empty-cart\"]")
    public WebElement EMPTY_CART;

    @FindBy(xpath = "//button[@data-test-id=\"cart-remove-item\"]")
    public WebElement REMOVE_BUTTON;

    public CartPage(WebDriver driver) {
        super(driver);
    }
    public CartPage removeFromCart(){
        clickOnElement(waitToBeClickable(REMOVE_BUTTON, driver));
        return this;
    }
}
