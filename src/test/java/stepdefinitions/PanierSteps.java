package stepdefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import static org.junit.Assert.assertEquals;

public class PanierSteps {
    WebDriver driver;

    @Given("l'utilisateur est sur la page d'accueil")
    public void userOnHomePage() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // Requis pour GitHub Actions
        driver = new ChromeDriver(options);
        driver.get("http://localhost:8080"); // URL de votre app
    }

    @When("il clique sur le bouton {string} du premier produit")
    public void clickAddButton(String buttonName) {
        driver.findElement(By.id("add-to-cart-btn")).click();
    }

    @Then("le compteur du panier doit afficher {string}")
    public void verifyCartCount(String expectedCount) {
        String actualCount = driver.findElement(By.id("cart-count")).getText();
        assertEquals(expectedCount, actualCount);
        driver.quit();
    }
}