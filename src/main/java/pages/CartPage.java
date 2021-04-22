package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(xpath = "//div[@class=\"cart-bucket-lineitem\"]")
    public WebElement NON_EMPTY_CART;

    public CartPage(WebDriver driver) {
        super(driver);
    }
}
