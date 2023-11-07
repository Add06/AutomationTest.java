import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BaseTests {

    WebDriver browser;
    String appURL = "https://www.saucedemo.com/";

    @BeforeEach
    void beforeEachTest() {
        // Setup chromedriver binary file
        WebDriverManager.edgedriver().setup();

        //0. Open Chrome browser
        browser = new EdgeDriver();

        //1. Access URL app - https://www.saucedemo.com/
        browser.get(appURL);
    }

    @AfterEach
    void afterEachTest() {
        browser.close();
    }
}