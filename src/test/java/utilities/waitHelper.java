package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class waitHelper {
    public WebDriver driver;

    public waitHelper(WebDriver driver){
        this.driver =driver;

    }
    public void wait (WebElement element, Duration timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver,timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));

    }




}
