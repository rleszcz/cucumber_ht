package context;

import drivers.PageManager;
import org.openqa.selenium.WebDriver;

public class CucumberStepContext {
    private static CucumberStepContext instance;
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    PageManager pageManager;

    private CucumberStepContext() {
    }

    public static CucumberStepContext getInstance() {
        if (instance == null)
            instance = new CucumberStepContext();
        return instance;
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public void setDriver(WebDriver driver) {
        CucumberStepContext.driver.set(driver);
    }

    public PageManager getPageManager() {
        return pageManager;
    }

    public void setPageManager(PageManager pageManager) {
        this.pageManager = pageManager;
    }
}
