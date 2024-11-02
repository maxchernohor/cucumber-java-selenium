package actions;

import elements.SimpleGenericProductPage_Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Hooks;

import static org.junit.Assert.assertEquals;

public class SimpleGenericProductPage_Actions {

    private WebDriver driver;
    SimpleGenericProductPage_Elements simpleGenericProductPage_elements;

    public SimpleGenericProductPage_Actions(Hooks hooks) {
        this.driver = hooks.getDriver();
        simpleGenericProductPage_elements = new SimpleGenericProductPage_Elements(driver);
    }

    public void addToCart() {
        simpleGenericProductPage_elements.addToCart.click();
    }

    public void validateCartCountIncreased() {
        // Get the initial count
        WebElement cartCountElement = driver.findElement(By.id("cart-target-desktop"));
        String initialCountText = cartCountElement.getText().replaceAll("[^0-9]", "");
        int initialCount = Integer.parseInt(initialCountText);

        // Click on the "add to cart" button
        addToCart();

        // Wait for the count to update (you might need to add an explicit wait here)
        try {
            Thread.sleep(4000); // Simple wait for demonstration purposes
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Get the updated count
        String updatedCountText = cartCountElement.getText().replaceAll("[^0-9]", "");
        int updatedCount = Integer.parseInt(updatedCountText);

        // Validate that the count has increased by 1
        assertEquals("Cart count did not increase as expected", initialCount + 1, updatedCount);
    }
}
