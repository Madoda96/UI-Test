package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;




@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/log_in_negative_scenarios.feature",
        glue = "stepsDefinition",
        dryRun = false,
        monochrome = true,
        plugin = {"pretty","html:test-output"}
)


public class loginNegativeRunner {
}
