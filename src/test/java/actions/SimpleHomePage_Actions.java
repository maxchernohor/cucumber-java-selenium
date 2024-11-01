package actions;

import elements.SimpleHomePage_Elements;
import org.openqa.selenium.WebDriver;
import utils.Hooks;

public class SimpleHomePage_Actions {

    private WebDriver driver;
    SimpleHomePage_Elements simpleHomePage_elements;

    public SimpleHomePage_Actions(Hooks hooks) {
        this.driver = hooks.getDriver();
        simpleHomePage_elements = new SimpleHomePage_Elements(driver);
    }

    public void clickOnCatalogLogo() {
        simpleHomePage_elements.catalogButton.click();
    }

//    public void enterSearchString(String string) {
//        ebayadvancedsearch_elements.searchString.sendKeys(string);
//    }

//    public void enterExcludeString(String string) {
//        ebayadvancedsearch_elements.excludeString.sendKeys(string);
//    }
//
//    public void enterMinPrice(String string) {
//        ebayadvancedsearch_elements.minPrice.sendKeys(string);
//    }
//
//    public void enterMaxPrice(String string) {
//        ebayadvancedsearch_elements.maxPrice.sendKeys(string);
//    }
//
//    public void clickOnSearchBtn() {
//        ebayadvancedsearch_elements.srchBtn.click();
//    }

}
