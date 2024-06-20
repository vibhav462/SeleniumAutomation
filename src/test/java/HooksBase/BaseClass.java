package HooksBase;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

public class BaseClass {
    public static WebDriver driver;
    public static Scenario scenarionew=null;

    @Before
    public static void SetUp(Scenario scenario){
        DOMConfigurator.configure("log4j2.xml");
        scenarionew=scenario;
        driver=startBrowser();
        System.out.println("In Before Class");
    }

    public static WebDriver startBrowser(){
        driver =edgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        return driver;
    }

    public static WebDriver edgeDriver(){
        WebDriverManager.edgedriver().setup();
        EdgeOptions options=new EdgeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--headless");
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        return driver;
    }

    @After
    public static void tearBrowser(){
        if(driver!=null){
            driver.manage().window().fullscreen();
            driver.close();
            driver.quit();
            driver=null;
        }
        System.out.println("In After Class");
    }
}
