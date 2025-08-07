package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.Assert.assertTrue;

public class LoginSteps {
    WebDriver driver;

    @Given("I open the SauceDemo login page")
    public void i_open_the_login_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_credentials(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("I click the login button")
    public void i_click_login() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("I should be redirected to the inventory page")
    public void i_should_be_on_inventory_page() {
        boolean isInventory = driver.getCurrentUrl().contains("inventory");
        assertTrue(isInventory);
        driver.quit();
    }
}