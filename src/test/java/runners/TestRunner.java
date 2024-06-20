package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/", // Path to your feature files
        glue = {"Steps","Pages","HooksBase"},
        plugin = {"pretty"}// Package where your step definitions are located
)
public class TestRunner {
    // This class will not have any code because Cucumber will run the feature files based on the options provided
}
