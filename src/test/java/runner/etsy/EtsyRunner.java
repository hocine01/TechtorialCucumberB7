package runner.etsy;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue ={ "steps/etsy","steps/hook"},
        dryRun = false,
        tags= "@outline"
)
public class EtsyRunner {
}
