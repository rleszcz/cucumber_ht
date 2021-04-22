package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CaptchaPage extends BasePage {

    @FindBy(xpath = "//form[@id=\"captcha_form\"]")
    public WebElement CAPTCHA_MESSAGE;

    public CaptchaPage(WebDriver driver) {
        super(driver);
    }
}