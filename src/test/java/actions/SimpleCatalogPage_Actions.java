package actions;

import elements.SimpleCatalogPage_Elements;
import org.openqa.selenium.WebDriver;
import utils.Hooks;

public class SimpleCatalogPage_Actions {

    private WebDriver driver;
    SimpleCatalogPage_Elements simpleCatalogPageElements;

    public SimpleCatalogPage_Actions(Hooks hooks) {
        this.driver = hooks.getDriver();
        simpleCatalogPageElements = new SimpleCatalogPage_Elements(driver);
    }

    public void clickOnWhiteSandal() {
        simpleCatalogPageElements.whiteSandals.click();
    }
}
