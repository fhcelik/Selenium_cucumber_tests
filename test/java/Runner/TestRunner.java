package Runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
//	html:target/cucumber-html-report	
		features="features",
		glue="com.selenTest.WebPages",
		plugin= {"pretty","json:target/json/output.json","html:target/cucumber-html-report"}
		)
public class TestRunner {

}
