package actions;

import elements.SimpleHomePage_Elements;
import org.openqa.selenium.WebDriver;
import utils.Hooks;

public class SimpleHomePage_Actions {

    SimpleHomePage_Elements simpleHomePage_elements;

    public SimpleHomePage_Actions(Hooks hooks) {
        WebDriver driver = hooks.getDriver();
        simpleHomePage_elements = new SimpleHomePage_Elements(driver);
    }

    public void clickOnCatalogLogo() {
        simpleHomePage_elements.catalogButton.click();
    }
}