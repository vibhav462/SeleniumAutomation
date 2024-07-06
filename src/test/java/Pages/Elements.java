package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Elements {
    private WebDriver driver;

    @FindBy(xpath = "//*[@data-test-attrib='cleartrip-logo']")
    public WebElement verifySearch;

    @FindBy(xpath = "//*[@placeholder='Enter mobile number']")
    public WebElement verifyPopup;

    @FindBy(xpath = "//*[contains(text(),'Change number')]")
    public WebElement chngNumber;

    @FindBy(xpath = "//*[@class=' c-pointer c-neutral-900']")
    public WebElement crossMark;

    @FindBy(xpath="//*[contains(text(),'Log in / Sign up')]")
    public WebElement logINBtn;

    @FindBy(xpath="//h1")
    public WebElement headingText;

    @FindBy(xpath="//h2")
    public WebElement heading2Text;

    @FindBy(xpath="//*[contains(text(),'Round trip')]")
    public WebElement roundTrip;

    @FindBy(xpath="(//*[@class='flex flex-middle'])[3]")
    public WebElement oneWayDropDown;

    @FindBy(xpath = "(//*[@class='flex flex-middle'])[4]")
    public WebElement adultEconomy;

    @FindBy(xpath="(//a[@class=' fs-4 pl-2 fw-300  td-none flex flex-middle'])[2]")
    public WebElement busTab;

    @FindBy(xpath="//p[contains(text(),'Search buses')]")
    public WebElement busesHdLine;

    @FindBy(xpath = "//p[contains(text(),'Enjoy hassle free bookings with Cleartrip')]")
    public WebElement busesBlwHdLine;

    @FindBy(xpath="//*[@id='departure']")
    public WebElement depPlace;

    @FindBy(xpath = "//*[@id='arrival']")
    public WebElement arrPlace;

    @FindBy(xpath="//*[@class='c-pointer']")
    public WebElement switchBtn;

    @FindBy(xpath = "//button[contains(text(),'Search Buses')]")
    public WebElement searchBusBtn;

    @FindBy(xpath = "//*[@class='sc-gEvEer kdZUgb']")
    public WebElement SuggestionList;

    @FindBy(xpath="//*[contains(text(),'Cheapest')]")
    public WebElement cheapestBus;

    @FindBy(xpath="//*[contains(text(),'Seabird Tourists')]/../../../div[2]/div[2]/div[2]/button/div")
    public WebElement seabirdSeatSelect;

    public void clickUsingJavascript(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    @FindBy(xpath="//canvas")
    public WebElement canvas;

    @FindBy(xpath = "//input[@id='Pick-up point']")
    public WebElement pickUpPoint;

//    @FindBy(xpath="//p[contains(text(),'Majestic')]")
//    public WebElement suggestPuClick;

    public void suggestPuClick(String place){
        driver.findElement(By.xpath("//p[contains(text(),'"+place+"')]")).click();
    }

    @FindBy(xpath = "//input[@id='Drop-off point']")
    public WebElement dropOffPoint;

//    @FindBy(xpath="//p[contains(text(),'Mapsa')]")
//    public WebElement suggestDoClick;

    public void suggestDoClick(String place){
        driver.findElement(By.xpath("//p[contains(text(),'"+place+"')]"));
    }
    @FindBy(xpath = "//*[contains(text(),'Continue')]")
    public WebElement continueBtn;

    @FindBy(xpath = "//p[contains(text(),'Male')]")
    public WebElement MaleClick;

    @FindBy(xpath = "//*[@id='firstName_0']")
    public WebElement firstName;

    @FindBy(xpath = "//*[@id='lastNmae_0']")
    public WebElement lastName;

    @FindBy(xpath = "//*[@id='age_0']")
    public WebElement age;

    @FindBy(xpath = "//*[@id='mobile']")
    public WebElement mob;

    @FindBy(xpath = "//*[@id='email']")
    public WebElement emailId;



    public void selectSeats(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "var canvas = arguments[0]; " +
                "var boundingRect = canvas.getBoundingClientRect(); " +
                "var clientX = boundingRect.left + 70; " + // Example x coordinate (adjust as needed)
                "var clientY = boundingRect.top + 539; " + // Example y coordinate (adjust as needed)
                "var clickEvent = new MouseEvent('click', { " +
                "    'view': window, " +
                "    'bubbles': true, " +
                "    'cancelable': true, " +
                "    'clientX': clientX, " +
                "    'clientY': clientY " +
                "}); " +
                "canvas.dispatchEvent(clickEvent); ";
        js.executeScript(script, canvas);
        System.out.println("Hello");
    }

    public void scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public Elements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyAndClose() {
        String abc = chngNumber.getText();
        Assert.assertEquals(abc, "Change number");
        crossMark.click();
    }
}
