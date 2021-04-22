package tests;

import context.CucumberStepContext;
import drivers.DriverManager;
import drivers.PageManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setup() {
        CucumberStepContext.getInstance().setDriver(DriverManager.getDriver("Chrome"));
        CucumberStepContext.getInstance().setPageManager(new PageManager(CucumberStepContext.getInstance().getDriver()));
    }

    @After
    public void cleanUp() {
        CucumberStepContext.getInstance().getDriver().quit();
    }
}
