package utils;

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
    public void tearDown(Scenario scenario) throws Exception {
        if (scenario.isFailed() && driver instanceof TakesScreenshot) {
            final byte[] shot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(shot, "image/png", scenario.getName());
        }
        if (driver != null) {
            driver.quit();
        }
        CustomWebDriverManager.resetInstance();
        Thread.sleep(1000);
        System.out.println("Global After Hook Executed");
    }

    public WebDriver getDriver() {
        return CustomWebDriverManager.getDriver();
    }
}