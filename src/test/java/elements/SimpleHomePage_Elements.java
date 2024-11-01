package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CustomWebDriverManager;
import utils.Hooks;

public class SimpleHomePage_Elements {

    private WebDriver driver;

    @FindBy(xpath = "//a[text()='Home']")
    public WebElement homeButton;

    @FindBy(xpath = "//a[text()='Catalog']")
    public WebElement catalogButton;


    public SimpleHomePage_Elements(WebDriver driver) {
        this.driver = CustomWebDriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

}
