package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
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
