package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleHomePage {

    private WebDriver driver;
    private WebDriverWait wait; // Declare WebDriverWait

    // Constructor to initialize the WebDriver and WebDriverWait
    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60)); // Initialize wait
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120)); // Increase page load timeout
    }

    // Locator for the search box
    private By searchBox = By.name("q");

    // Open the Google homepage
    public void open() {
        driver.get("https://www.google.com");
    }

    // Wait for the search input field to be visible and then enter a search query
    public void enterSearchQuery(String query) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(searchBox));
            element.sendKeys(query);
        } catch (Exception e) {
            System.err.println("Failed to enter search query: " + e.getMessage());
        }
    }

    // Wait for the search input field to be visible and get the current text
    public String getSearchInputText() {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
            return element.getAttribute("value");
        } catch (Exception e) {
            System.err.println("Failed to retrieve search input text: " + e.getMessage());
            return ""; // Return empty string on failure
        }
    }
}
