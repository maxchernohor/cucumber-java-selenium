package utils;

import executionConfig.CustomWebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = CustomWebDriverManager.getDriver();
        System.out.println("Global Before Hook Executed");
    }

    @After
    public void tearDown(Scenario scenario) {
        if (driver != null) {
            try {
                // Capture screenshot if the test fails
                if (scenario.isFailed() && driver instanceof TakesScreenshot) {
                    final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                    // Attach screenshot to the test result (implementation depends on your reporting tool)
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    driver.quit();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                CustomWebDriverManager.resetInstance();
                System.out.println("Global After Hook Executed, browser closed.");
            }
        }
    }

    public WebDriver getDriver() {
        return CustomWebDriverManager.getDriver();
    }
}