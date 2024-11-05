package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import executionConfig.CustomWebDriverManager;

public class SimpleCatalogPage_Elements {

    private WebDriver driver;

    @FindBy(xpath = "//h3[text()='White sandals']")
    public WebElement whiteSandals;

    @FindBy(xpath = "//h3[text()='Grey jacket']")
    public WebElement greyJacker;

    @FindBy(xpath = "//h3[text()='Noir jacket']")
    public WebElement noirJacket;

    public SimpleCatalogPage_Elements(WebDriver driver) {
        this.driver = CustomWebDriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

}
