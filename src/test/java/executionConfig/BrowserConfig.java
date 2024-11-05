package executionConfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;

public class BrowserConfig {

    private static final Properties properties = new Properties();
    private static final String PROPERTIES_FILE = "src/test/java/executionConfig/browser-config.properties"; // Path relative to project root
    private static final int DEFAULT_TIMEOUT_IN_SECONDS = 30;
    private static final String DEFAULT_BROWSER_NAME = "chrome"; // Set a default browser name
    private static final String DEFAULT_HEADLESS = "true";

    static {
        try (FileInputStream input = new FileInputStream(Paths.get(PROPERTIES_FILE).toFile())) {
            properties.load(input);
        } catch (IOException ex) {
            System.err.println("Error loading properties file: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private static String getProperty(String propertyName, String defaultValue) {
        // First, try to get the value from system properties
        String propertyValue = System.getProperty(propertyName);
        // If system property is not set, fallback to properties file
        if (propertyValue == null || propertyValue.isEmpty()) {
            propertyValue = properties.getProperty(propertyName, defaultValue);
        }
        return propertyValue;
    }

    public static String getBrowserName() {
        return getProperty("browser.name", DEFAULT_BROWSER_NAME);
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(getProperty("browser.headless", DEFAULT_HEADLESS));
    }

    public static Duration getTimeout() {
        String timeoutStr = getProperty("webdriver.timeout", String.valueOf(DEFAULT_TIMEOUT_IN_SECONDS));
        try {
            return Duration.ofSeconds(Integer.parseInt(timeoutStr));
        } catch (NumberFormatException e) {
            System.err.println("Invalid timeout value provided, falling back to default: " + DEFAULT_TIMEOUT_IN_SECONDS);
            // If the timeout is not a valid number, fall back to default timeout
            return Duration.ofSeconds(DEFAULT_TIMEOUT_IN_SECONDS);
        }
    }

    public static String getEnvironmentUrl(String environment) {
        // Retrieve environment-specific URL
        return properties.getProperty("environment." + environment);
    }
}