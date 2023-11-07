import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ShoppingCartTests extends BaseTests {

    String standardUser = "standard_user";

    @Test
    void shouldCheckoutWithSingleProduct() {
        login(standardUser, "secret_sauce");

        //1. Add desired product to cart
        String desiredProduct = "Sauce Labs Onesie45";
        addSingleProduct(desiredProduct);

        //TODO Homework
        // 2. Check product visual indicator

        //3. read desired product title
        //4. read desired product price
        //5.Navigate to the cart

        //Checks
        //1. product title
        //2. product qty
        //3. product price

        // Go to Checkout page

        //... completed checkout
    }

    public void login(String username, String password) {
        //2. Enter username - id user-name
        By usernameInput = By.id("user-name");
        browser.findElement(usernameInput).sendKeys(username);

        //3. Enter password - id password
        By passwordInput = By.id("password");
        browser.findElement(passwordInput).sendKeys(password);

        //4. Click Login - id login-button
        By loginButton = By.id("login-button");
        browser.findElement(loginButton).click();
    }

    public void addSingleProduct(String desiredProduct) {
        List<WebElement> productsTitles = browser.findElements(By.xpath("//div[@class='inventory_item_name']"));
        boolean isProductFound = false;

        for (int index = 0; index < productsTitles.size(); index++) {
            // check if the current product equals desiredProduct
            if (productsTitles.get(index).getText().equals(desiredProduct)) {
                isProductFound = true;

                // if yes, then add it to cart
                By addToCartButton = By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']");
                productsTitles.get(index).findElements(addToCartButton).get(index).click();
                break;
            }
        }

        if (!isProductFound) {
            throw new RuntimeException("Unable to find product with title " + desiredProduct);
        }
    }
}
