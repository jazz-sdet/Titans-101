package cucumber_class.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/",
        glue = "cucumber_class/StepDefs",
        tags = "@etsy",
        dryRun = false,
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class etsyRunner {
}
