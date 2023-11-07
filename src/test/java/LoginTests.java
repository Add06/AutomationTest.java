import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTests extends BaseTests {

    String standardUser = "standard_user";

    @Test
    void shouldLoginAsStandardUser() {

        //Login as standard user
        login(standardUser, "secret_sauce");

        //5. Verify that the user is logged in
        By inventoryContainer = By.id("inventory_container");
        WebElement element = browser.findElement(inventoryContainer);

        //option 1
        assertTrue(element.isDisplayed());

        //option 2
//        assertTrue(browser.findElement(inventoryContainer).isDisplayed());
    }

    @Test
    void shouldLoginAsLockedOutUser() {
        //Login
        login("locked_out_user","secret_sauce");

        //5. Verify that the user is locked
        By containerErrorMessage = By.xpath("//h3");
        WebElement element = browser.findElement(containerErrorMessage);

        String expectedErrorMessage = "Epic sadface: Sorry, this user has been locked out.";
        String actualErrorMessage = element.getText();

        //option 2
        assertEquals(expectedErrorMessage, actualErrorMessage);
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
}
