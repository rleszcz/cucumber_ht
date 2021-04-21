package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/cucumber/", glue = "tests")
public class CucumberRunner extends AbstractTestNGCucumberTests {
}