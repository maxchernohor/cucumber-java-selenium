package executionConfig;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class CustomWebDriverManager {

    private static CustomWebDriverManager instance = null;

    // WebDriver and WebDriverWait objects
    private WebDriver driver;
    private WebDriverWait driverWait;

    /**
     * Private constructor to initialize WebDriver and related instances.
     */
    private CustomWebDriverManager() {
        // Initialize the WebDriver and WebDriverWait
        driver = initDriver();
        driverWait = new WebDriverWait(driver, BrowserConfig.getTimeout());
    }

    /**
     * Singleton instance retrieval.
     */
    public static CustomWebDriverManager getInstance() {
        if (instance == null) {
            instance = new CustomWebDriverManager();
        }
        return instance;
    }

    /**
     * Initializes the WebDriver based on the selected driver configuration.
     */
    private WebDriver initDriver() {
        String browserName = BrowserConfig.getBrowserName();
        boolean isHeadless = BrowserConfig.isHeadless();
        System.out.println("Browser: " + browserName + ", isHeadless: " + isHeadless);

        return switch (browserName.toLowerCase()) {
            case "chrome" -> initChromeDriver(isHeadless);
            case "firefox" -> initFirefoxDriver(isHeadless);
            case "ie" -> initInternetExplorerDriver();
            case "edge" -> initEdgeDriver(isHeadless);
            default -> throw new IllegalArgumentException("Unsupported browser: " + browserName);
        };
    }

    private WebDriver initChromeDriver(boolean headless) {
        ChromeOptions options = new ChromeOptions();
        if (headless) {
            options.addArguments("--headless");
        }
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        options.addArguments("--no-sandbox");
        options.addArguments("--start-maximized");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--verbose");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--ignore-ssl-errors=yes");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--test-type");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("safebrowsing.enabled", false);
        options.setExperimentalOption("prefs", prefs);

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        System.out.println("Chrome is initialized");
        return driver;
    }

    private WebDriver initFirefoxDriver(boolean headless) {
        FirefoxOptions options = new FirefoxOptions();
        if (headless) {
            options.addArguments("--headless");
        }

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        System.out.println("Firefox is initialized");
        return driver;
    }

    private WebDriver initInternetExplorerDriver() {
        InternetExplorerOptions options = new InternetExplorerOptions();
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver(options);
        driver.manage().window().maximize();
        System.out.println("Internet Explorer is initialized");
        return driver;
    }

    private WebDriver initEdgeDriver(boolean headless) {
        EdgeOptions options = new EdgeOptions();
        if (headless) {
            options.addArguments("--headless");
        }
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        options.addArguments("--no-sandbox");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--verbose");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--ignore-ssl-errors=yes");
        options.addArguments("--ignore-certificate-errors");

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver(options);
        driver.manage().window().maximize();

        System.out.println("Edge is initialized");
        return driver;
    }

    /**
     * Resets the singleton instance to null.
     */
    public static void resetInstance() {
        if (instance != null && instance.driver != null) {
            instance.driver.quit();
        }
        instance = null;
    }

    /**
     * Retrieves the WebDriver instance.
     *
     * @return WebDriver
     */
    public static WebDriver getDriver() {
        return getInstance().driver;
    }

    /**
     * Retrieves the WebDriverWait instance.
     *
     * @return WebDriverWait
     */
    public static WebDriverWait getDriverWait() {
        return getInstance().driverWait;
    }
}