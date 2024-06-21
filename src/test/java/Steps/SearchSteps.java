package Steps;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import HooksBase.BaseClass;
import Pages.Elements;

public class SearchSteps {
     public WebDriver driver=BaseClass.driver;
     Elements elements = new Elements(driver);
    public WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(120));

    @Given("User is on the search page")
    public void user_is_on_the_search_page() throws InterruptedException {
        System.out.println("Inside StepDef");
        driver.get("https://www.google.com/");
        // wait.until(ExpectedConditions.visibilityOf(elements.verifySearch));
         Thread.sleep(150000);
        System.out.println(driver.getTitle());
        // elements.verifyPopup.sendKeys("0123456789");
        // elements.verifyAndClose();
    }
}
