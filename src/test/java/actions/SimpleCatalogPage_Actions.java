package actions;

import elements.SimpleCatalogPage_Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import executionConfig.CustomWebDriverManager;
import utils.Hooks;

public class SimpleCatalogPage_Actions {

    private WebDriver driver;
    private WebDriverWait wait;
    SimpleCatalogPage_Elements simpleCatalogPageElements;
    Common_Actions common_actions;


    public SimpleCatalogPage_Actions(Hooks hooks) {
        CustomWebDriverManager customWebDriverManager = CustomWebDriverManager.getInstance();
        this.wait = customWebDriverManager.getDriverWait();
        this.driver = customWebDriverManager.getDriver();

        simpleCatalogPageElements = new SimpleCatalogPage_Elements(driver);
    }

    public void clickOnItem(String item) {
        WebElement itemElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[text()='" + item + "']")));
        itemElement.click();
    }

    public void clickOnAddToCart(String item) {
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add to cart " + item + "']")));
        addToCartButton.click();
    }

//    public void clickOnWhiteSandal() throws InterruptedException {
//        common_actions.clickOnElementByXpathJS("//h3[text()='White sandals']");
//    }
}
