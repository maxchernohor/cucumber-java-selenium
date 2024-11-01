package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CustomWebDriverManager;

public class SimpleGenericProductPage_Elements {

    private WebDriver driver;

    @FindBy(css = ".btn.add-to-cart")
    public WebElement addToCart;

    public SimpleGenericProductPage_Elements(WebDriver driver) {
        this.driver = CustomWebDriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }
}