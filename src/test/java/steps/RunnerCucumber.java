package steps;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
	(
		features = "src/main/resources/features/exemplo.feature",
		glue = "",
		tags = {},
		plugin = {"pretty", "html:target/screenshot"},
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		strict = false
	)

public class RunnerCucumber {

}
