package actions;

import executionConfig.BrowserConfig;
import executionConfig.CustomWebDriverManager;
import org.openqa.selenium.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Hooks;

import java.time.Duration;

public class Common_Actions {
    private final WebDriver driver;
    private final int defaultSleepBeforeAction = 0;

    // Retrieve the application username and password from the environment variables
    private final String appUSERNAME = System.getenv("USERNAME_APP");
    private final String appPASSWORD = System.getenv("PASSWORD_APP");

    public Common_Actions(Hooks hooks) {
        this.driver = hooks.getDriver();
    }

    public void goToUrl(String url) {
        driver.get(url);
    }

    public String getCurrentPageUrl() {
        return driver.getCurrentUrl();
    }

    public String getCurrentPageTitle() {
        return driver.getTitle();
    }

    public void openLoginByEnv() throws Exception {
        WebDriver driver = CustomWebDriverManager.getDriver();
        String environment = System.getProperty("environment", "dev"); // Default to "dev" if not set

        if ("dev".equalsIgnoreCase(environment)) {
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
            String url = BrowserConfig.getEnvironmentUrl("dev");
            driver.get(url);
        } else if ("tst".equalsIgnoreCase(environment)) {
            String url = BrowserConfig.getEnvironmentUrl("tst");
            driver.get(url);
        }
    }
    public void login() throws Exception {
        System.out.println("Logging in to app via keycloak");

        WebDriver driver = CustomWebDriverManager.getDriver();
        WebDriverWait driverWait = CustomWebDriverManager.getDriverWait();

        WebElement element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        element.sendKeys(appUSERNAME);
        element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
        element.sendKeys(appPASSWORD);
        element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.name("login")));
        element.click();

        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[contains(text(), 'Logout')]")));

        System.out.println("Logged in successfully");
    }

    public void clickOnButton(String buttonName) throws InterruptedException {
        sleep(defaultSleepBeforeAction);

        WebDriverWait driverWait = CustomWebDriverManager.getDriverWait();

        WebElement element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(), '" + buttonName + "')]")));
        element.click();

        System.out.println("Clicked on button with name: " + buttonName);
    }

    public void clickOnElementByText(String text) throws InterruptedException {
        sleep(defaultSleepBeforeAction);

        WebDriverWait driverWait = CustomWebDriverManager.getDriverWait();

        WebElement element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), '" + text + "')]")));
        element.click();

        System.out.println("Clicked on element with text: " + text);
    }


    public void clickOnElementByXpathJS(String xpath) throws InterruptedException {
        // Click Next
        sleep(defaultSleepBeforeAction);

        WebDriverWait driverWait = CustomWebDriverManager.getDriverWait();
        WebDriver driver = CustomWebDriverManager.getDriver();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        js.executeScript("arguments[0].click();", element);

        System.out.println("Clicked on element with xpath: " + xpath);

    }


    public void clickOnTagByText(String tag, String containsText) throws InterruptedException {
        sleep(defaultSleepBeforeAction);

        WebDriverWait driverWait = CustomWebDriverManager.getDriverWait();

        WebElement element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//" + tag + "[contains(text(), '" + containsText + "')]")));
        element.click();

        System.out.println("Clicked on tag: " + tag + " which contains text: " + containsText);

    }

    public void clickOnElementByXpath(String xpath) throws InterruptedException {
        sleep(defaultSleepBeforeAction);

        WebDriverWait driverWait = CustomWebDriverManager.getDriverWait();

        WebElement element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        element.click();
        System.out.println("Clicked on element by xpath: " + xpath);

    }

    public void clickOnElementById(String id) throws InterruptedException {
        sleep(defaultSleepBeforeAction);

        WebDriverWait driverWait = CustomWebDriverManager.getDriverWait();

        WebElement element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
        element.click();

        System.out.println("Clicked on element by id: " + id);
    }

    public void clickOnElementByName(String name) throws InterruptedException {
        sleep(defaultSleepBeforeAction);


        WebDriverWait driverWait = CustomWebDriverManager.getDriverWait();

        WebElement element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.name(name)));
        element.click();

        System.out.println("Clicked on element by name: " + name);
    }

    public void clickOnTagByClass(String tag, String className) throws InterruptedException {
        sleep(defaultSleepBeforeAction);

        WebDriverWait driverWait = CustomWebDriverManager.getDriverWait();

        WebElement element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//" + tag + "[@class='" + className + "']")));

        element.click();

        System.out.println("Clicked on tag: " + tag + " which contains classname: " + className);
    }

    public void selectCheckboxByInputNameAttributeContainsValue(String name, String checkboxValue) throws InterruptedException {
        sleep(defaultSleepBeforeAction);

        WebDriverWait driverWait = CustomWebDriverManager.getDriverWait();
        WebDriver driver = CustomWebDriverManager.getDriver();
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        WebElement element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@name, '" + name + "')]/following-sibling::span[contains(text(), '" + checkboxValue + "')]")));
        jse.executeScript("arguments[0].scrollIntoView();", element);
        jse.executeScript("arguments[0].click();", element);

        System.out.println("Selected checkbox with input name: " + name + " which contains value: " + checkboxValue);
    }

    public void textShouldExist(String text) throws InterruptedException {
        sleep(defaultSleepBeforeAction);

        WebDriver driver = CustomWebDriverManager.getDriver();
        Boolean result = true;

        System.out.println("Validating that text: " + text + " exists");

        try {
            new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//*[contains(text(), '" + text + "')]")));
        } catch (Exception e) {
            result = false;
        }
        Assert.assertTrue("Text '" + text + "' does not exist on a page.", result);
    }

    public void textShouldNotExist(String text) throws InterruptedException {
        sleep(defaultSleepBeforeAction);

        WebDriver driver = CustomWebDriverManager.getDriver();
        Boolean result = true;

        System.out.println("Validating that text: " + text + " is not exists");

        try {
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//*[contains(text(), '" + text + "')]")));
        } catch (Exception e) {
            result = false;
        }
        Assert.assertFalse("Unexpected text '" + text + "' exists on a page.", result);
    }

    public void elementShouldExist(String tag, String text) {
        WebDriver driver = CustomWebDriverManager.getDriver();

        System.out.println("Validating that element with tag: " + tag + "and text : " + text + " exists");

        Boolean result = true;
        try {
            new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//" + tag + "[contains(text(), '" + text + "')]")));
        } catch (Exception e) {
            result = false;
        }
        Assert.assertTrue(tag + "element with text '" + text + "' does not exist on a page.", result);
    }

    public WebElement getElementByXpath(String xpath) {
        WebDriverWait driverWait = CustomWebDriverManager.getDriverWait();

        System.out.println("Searching for element with xpath: " + xpath);

        WebElement element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return element;
    }

    public WebElement getElementByTagAndText(String tag, String text) {
        WebDriverWait driverWait = CustomWebDriverManager.getDriverWait();

        System.out.println("Searching for element with tag: " + tag + " and text: " + text);

        WebElement element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//" + tag + "[contains(text(), '" + text + "')]")));
        return element;
    }

    public void inputTextByXpath(String xpath, String inputText) throws InterruptedException {
        sleep(defaultSleepBeforeAction);

        System.out.println("Input text: " + inputText + " by xpath: " + xpath);

        WebDriverWait driverWait = CustomWebDriverManager.getDriverWait();

        WebElement element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        element.sendKeys(inputText);
    }

    public void inputTextById(String id, String inputText) throws InterruptedException {
        sleep(defaultSleepBeforeAction);

        System.out.println("Input text: " + inputText + " by id: " + id);

        WebDriverWait driverWait = CustomWebDriverManager.getDriverWait();

        WebElement element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
        element.sendKeys(inputText);
    }


    public void inputTextByTagAttributeContainsValue(String tag, String attribute, String containsValue, String inputText) throws InterruptedException {
        sleep(defaultSleepBeforeAction);

        System.out.println("Input text: " + inputText + " by tag: " + tag + " attribute: " + attribute + " contains value: " + containsValue);

        WebDriverWait driverWait = CustomWebDriverManager.getDriverWait();

        WebElement element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//" + tag + "[contains( @" + attribute + ", '" + containsValue + "')]")));
        element.sendKeys(inputText);
    }

    public void inputTextByTextAreaIdContainsValue(String idContainsValue, String inputText) throws InterruptedException {
        sleep(defaultSleepBeforeAction);

        System.out.println("Input text: " + inputText + " by id contains value: " + idContainsValue);

        WebDriverWait driverWait = CustomWebDriverManager.getDriverWait();

        WebElement element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea[contains( @id, '" + idContainsValue + "')]")));
        element.sendKeys(inputText);
    }


    public void sleep(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    public void scrollToBottom() throws InterruptedException {
        WebDriver driver = CustomWebDriverManager.getDriver();

        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        // Scroll down till the bottom of the page
        js1.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        Thread.sleep(1000);

        System.out.println("Scrolled to bottom");
    }
}
