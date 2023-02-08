package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\java\\cucumber", glue = "mertkanCompany.stepDefinations", monochrome = true, plugin = {
		"html:target/cucumber.html" }, tags = "@ErrorValidation")
public class TestNgTestRunner extends AbstractTestNGCucumberTests{

}
