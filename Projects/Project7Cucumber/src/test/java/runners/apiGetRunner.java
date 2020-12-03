package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = "stepDefs",
        tags = "@starwarVehicle",
        dryRun = false,
        plugin = {"pretty", "junit:target/ProjectAPI.xml", "json:src/test/resources/ProjectApi.json"}
)

public class apiGetRunner {

}
