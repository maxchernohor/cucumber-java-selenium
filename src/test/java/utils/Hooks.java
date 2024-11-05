package utils;

import executionConfig.CustomWebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    private WebDriver driver;

    @Before(order = 0)
    public void setUp() {
        driver = CustomWebDriverManager.getDriver();
        System.out.println("Global Before Hook Executed");
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (driver != null) {
            try {
                // Capture screenshot if the scenario fails
                if (scenario.isFailed() && driver instanceof TakesScreenshot) {
                    final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                    scenario.attach(screenshot, "image/png", scenario.getName());
                }
            } finally {
                // Quit the driver to close the browser
                driver.quit();
                CustomWebDriverManager.resetInstance();
                System.out.println("Global After Hook Executed, browser closed.");
            }
        }
    }

    public WebDriver getDriver() {
        return CustomWebDriverManager.getDriver();
    }
}