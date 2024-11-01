package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        // Specifies the path to the feature files
        features = {"features"},

        // Specifies the package containing the step definitions
        glue = {"steps"},

        // Specifies the format of the output reports
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"},

        // If true, checks that every step in the feature files has a corresponding step definition without actually running the tests
        dryRun = false,

        // If true, makes the console output more readable by removing unnecessary characters
        monochrome = true,

        // Specifies which tagged scenarios to run
        tags = "@P1 or @P2"
)
public class TestRunner {
}