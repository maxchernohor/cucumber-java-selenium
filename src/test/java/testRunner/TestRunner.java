package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        // Specifies the path to the feature files
        features = {"src/test/resources/features"},

        // Specifies the package containing the step definitions
        glue = {"steps", "utils"},

        // Specifies the format of the output reports and their location
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"
        },

        // If true, checks that every step in the feature files has a corresponding step definition without actually running the tests
        dryRun = false,

        // If true, makes the console output more readable by removing unnecessary characters
        monochrome = true,

        // Specifies which tagged scenarios to run
        tags = "@P1 or @P2"
)
public class TestRunner extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = false)
        public Object[][] scenarios() {
                return super.scenarios();
        }
}