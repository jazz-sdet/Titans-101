package runnerClass;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/",
        glue = "java/stepDefs",
        tags = "@login",
        dryRun = false
        //plugin = {"pretty", "junit:target/mrs.xml", "json:target/mrs.json"}
)


public class rename {
}
