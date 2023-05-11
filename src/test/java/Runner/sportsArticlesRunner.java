package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/Read_all_articles_related_to_sport.feature",
        glue = "stepsDefinition",
        dryRun = false,
        monochrome = true,
        plugin = {"pretty","html:test-output"}
)

public class sportsArticlesRunner {
}
