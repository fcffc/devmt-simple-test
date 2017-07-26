package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/CadastrarMembro.feature", glue = { "stepDefinitions" }, plugin = {
		"html:target/devmtSimpleTestHtmlReport" })

public class TestRunner {

}
