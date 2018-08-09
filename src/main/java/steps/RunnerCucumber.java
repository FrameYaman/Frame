package steps;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
	(
		features = "src/main/resources/features/exemplo.feature",
		plugin = {"pretty" , "html:target/report-html" }
	)
public class RunnerCucumber {

}
