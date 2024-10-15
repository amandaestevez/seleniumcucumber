package stepsDefinition;

import hooks.Hooks; // Import Hooks from the hooks package
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.GoogleHomePage;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleHomePageStepsDef {

    private WebDriver driver = Hooks.getDriver();
    private GoogleHomePage googleHomePage;

    @Given("I am on the Google search homepage")
    public void i_am_on_the_google_search_homepage() {
        googleHomePage = new GoogleHomePage(driver);
        googleHomePage.open();
    }

    @When("I enter {string} in the search input field")
    public void i_enter_in_the_search_input_field(String query) {
        googleHomePage.enterSearchQuery(query);
    }

    @Then("the search input field should contain {string}")
    public void the_search_input_field_should_contain(String expectedText) {
        String actualText = googleHomePage.getSearchInputText();
        assertEquals(expectedText, actualText, "The search input does not match the expected text.");
    }
}
