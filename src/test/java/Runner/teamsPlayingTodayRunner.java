package Runner;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/Record_of_all_teams_playing_today.feature",
        glue = "stepsDefinition",
        dryRun = false,
        monochrome = true,
        plugin = {"pretty","html:test-output"}
)

public class teamsPlayingTodayRunner {
}
