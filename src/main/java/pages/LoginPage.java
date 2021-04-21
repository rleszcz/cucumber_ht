package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private static final String LOGIN_PAGE_URL = "https://signin.ebay.com";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open login page directly")
    public LoginPage openLoginPageDirectly() {
        openWebPage(LOGIN_PAGE_URL);
        return this;
    }

}
