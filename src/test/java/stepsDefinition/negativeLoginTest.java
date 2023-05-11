package stepsDefinition;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.waitHelper;

import java.time.Duration;

public class negativeLoginTest {

    WebDriver driver;

    //   String url = "https://www.bbc.co.uk/sport/football/scores-fixtures";
    String SignIn = "//a[@id=\"idcta-link\"]";
    String Username = "//input[@type=\"email\"]";
    String Password = "//input[@type=\"password\"]";
    String SignInBtn = "//button[@type=\"submit\"]";

//    String email_Password_Incorrect_msg = "//div[@id=\"form-message-general\"]";
//    String emailErrormsg = "//div[@id=\"form-message-username\"]";
//    String PasswordErrorMsg = "//*[@id=\"form-message-password\"]";


    @Given("launches chrome browser.")
    public void launches_chrome_browser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //       driver.findElement(By.xpath(SignIn)).click();
    }

    @When("user opens URL {string}")
    public void user_opens_url(String url) {
        driver.get(url);
    }

    @When("user clicks the sign in button")
    public void user_clicks_the_sign_in_button() {
        driver.findElement(By.xpath(SignIn)).click();
    }

    @When("user enters incorrect {string} and {string}")
    public void user_enters_incorrect_and(String username, String password) throws InterruptedException {
        driver.findElement(By.xpath(Username)).sendKeys(username);
        driver.findElement(By.xpath(Password)).sendKeys(password);
        driver.findElement(By.xpath(SignInBtn)).click();
        //Thread.sleep(5000);
    }

    @Then("user should see a  {string}")
    public void user_should_see_a(String errorMsg) {

        String email_Password_Incorrect_msg = "//div[@id=\"form-message-general\"]";
        String emailErrormsg = "//div[@id=\"form-message-username\"]";
        String PasswordErrorMsg = "//*[@id=\"form-message-password\"]";


        WebDriverWait WAIT = new WebDriverWait(driver, Duration.ofSeconds(10));

//        String EmailOrPasswordMsg = driver.findElement(By.xpath(email_Password_Incorrect_msg)).getText();
 //       boolean EmailPasswordVisible = driver.findElement(By.xpath(email_Password_Incorrect_msg)).isDisplayed();

//        String javascript = "document.getElementById('\"form-message-password\"')";
//        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//        WebElement element = (WebElement) jsExecutor.executeScript(javascript);
 //       String passwordErrorMessage = driver.findElement(By.xpath(PasswordErrorMsg)).getText();
//        String passwordErrorMessage = WAIT.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PasswordErrorMsg))).getText();

//        boolean passwordErrorMessageVisible = driver.findElement(By.xpath(PasswordErrorMsg)).isDisplayed();

         if ((errorMsg.equals(driver.findElement(By.xpath(email_Password_Incorrect_msg)).getText()))
             ||errorMsg.equals(driver.findElement(By.xpath(PasswordErrorMsg)).getText())){
              System.out.println(errorMsg);
         }else{

             System.out.println("Nothing happened");
         }


//             } else if (errorMsg.equals(driver.findElement(By.xpath(emailErrormsg)).getText())) {
//                 System.out.println(errorMsg);
//             }

        driver.close();
    }


}








