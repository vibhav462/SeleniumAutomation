package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

import org.openqa.selenium.WebElement;
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
        driver.get("https://www.cleartrip.com/");
        System.out.println(driver.getTitle());
        wait.until(ExpectedConditions.visibilityOf(elements.verifySearch));
        elements.verifyPopup.sendKeys("0127777789");
        elements.verifyAndClose();
    }

    @And("I navigate to Bus tab and verify details")
    public void iNavigateToBusTabAndVerifyDetails() {
        elements.busTab.click();
        Assert.assertEquals(elements.busesHdLine.getText(),"Search buses");
        Assert.assertEquals(elements.busesBlwHdLine.getText(),"Enjoy hassle free bookings with Cleartrip");
    }

    @And("I enter {string} to {string} as destinations")
    public void iEnterToAsDestinations(String dep, String arr) {
        elements.depPlace.sendKeys(dep);
        elements.arrPlace.sendKeys(arr);
        elements.searchBusBtn.click();
    }

    @And("I enter {string} to {string} as destinations pass")
    public void iEnterToAsDestinationsPass(String dep, String arr) throws InterruptedException {
        elements.depPlace.sendKeys(dep);
        WebElement suggestionDepList = wait.until(ExpectedConditions.visibilityOf(elements.SuggestionList));
        Thread.sleep(5000);
        WebElement desiredDepSuggestion = suggestionDepList.findElement(By.xpath("//*[contains(text(),'"+dep+"')]"));
        desiredDepSuggestion.click();
        elements.arrPlace.sendKeys(arr);
        WebElement suggestionArrList = wait.until(ExpectedConditions.visibilityOf(elements.SuggestionList));
        Thread.sleep(5000);
        WebElement desiredArrSuggestion = suggestionArrList.findElement(By.xpath("//*[contains(text(),'"+arr+"')]"));
        desiredArrSuggestion.click();
        try{elements.searchBusBtn.click();}catch (Exception e){e.printStackTrace();}
        elements.cheapestBus.click();
        System.out.println();
        try {
            Thread.sleep(5000);
            elements.scrollToElement(elements.seabirdSeatSelect);
            elements.seabirdSeatSelect.click();
        }catch(Exception e){elements.clickUsingJavascript(elements.seabirdSeatSelect);}
        elements.selectSeats();}

    @And("I enter {string} {string} as first and last name")
    public void iEnterAsFirstAndLastName(String firstName, String lastName) {
        elements.MaleClick.click();
        elements.firstName.sendKeys(firstName);
        elements.lastName.sendKeys(lastName);
        elements.age.sendKeys("27");
        elements.mob.sendKeys("7030479980");
        elements.emailId.sendKeys("abc@efg.com");
    }

    @And("I select {string} {string} as pick up and drop off points")
    public void iSelectAsPickUpAndDropOffPoints(String pick, String drop) {
        elements.pickUpPoint.sendKeys(pick);
        elements.suggestPuClick(pick);
        elements.dropOffPoint.sendKeys(drop);
        elements.suggestDoClick(drop);
        elements.continueBtn.click();
    }
}
