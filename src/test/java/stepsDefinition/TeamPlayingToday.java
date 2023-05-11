package stepsDefinition;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class TeamPlayingToday {


    WebDriver driver;

    String URL = "https://www.bbc.co.uk/sport/football/scores-fixtures";

    String FootballFixtures = "//article[@class=\"sp-c-fixture\" ]";

    @Given("User is on the Football page.")
    public void user_is_on_the_football_page() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    @Then("user should see all football matches that are playing today.")
    public void user_should_see_all_football_matches_that_are_playing_today() {

        List<WebElement> TeamPlaying = new ArrayList<>(driver.findElements(By.xpath(FootballFixtures)));

        for (WebElement webElement : TeamPlaying) {
            String values = webElement.getText();
            if (!values.equals("null")) {
                System.out.println("These are matches that are playing:\n " + values);
            } else {
                System.out.println("There are no matches");
            }

        }

//    if (TeamPlaying.isEmpty())
//        {
//            System.out.println("No teams are playing today");
//        }else{
//            System.out.println(TeamPlaying.size());
//            System.out.println("The following teams are playing today: " + TeamPlaying);
//        }

        driver.close();


    }
}
