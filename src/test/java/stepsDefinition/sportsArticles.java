package stepsDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class sportsArticles {


    WebDriver driver;

    String URL = "https://www.bbc.co.uk/sport/football/scores-fixtures";

    String sportPage = "//*[@id=\"orb-header\"]/div/nav[2]/ul/li[3]/a/span";

    String Headings = "//a[@class=\"ssrcss-1vyfvn-LogoLink e9p57e4\"]";

    String lastHeading = "//h2[@class=\"ssrcss-z4ecog-StyledHeading efc3qse1\"]";


    @Given("user is on the website.")
    public void user_is_on_the_website() {


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


    }

    @When("user clicks on the Sport option.")
    public void user_clicks_on_the_sport_option() {

        driver.findElement(By.xpath(sportPage)).click();

        String PageHeader = driver.findElement(By.xpath(Headings)).getText();
        String LastHeader = driver.findElement(By.xpath(lastHeading)).getText();

        System.out.println("The first header is : " + PageHeader);
        System.out.println("The last header is : " + LastHeader);

    }


    @Then("user should see all articles that are related to sports.")
    public void user_should_see_all_articles_that_are_related_to_sports () {

            String ExpectedPageHeader = "BBC Sport - Scores, Fixtures, News - Live Sport";
            String ActualPageHeader =  driver.getTitle();

            if (ActualPageHeader.equals(ExpectedPageHeader)){
                System.out.println("User  can see articles related to sport");
            }else{
                System.out.println("User is on the wrong page");
            }


            driver.close();

        }

    }


