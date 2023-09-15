import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BestBuyStepDefs {
    private WebDriver driver;

    @Given("I open the BestBuy website")
    public void i_open_the_BestBuy_website() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.bestbuy.com/");
    }

    @When("I search for {string}")
    public void i_search_for(String searchTerm) {
        WebElement searchBox = driver.findElement(By.id("gh-search-input"));
        searchBox.sendKeys(searchTerm);
        searchBox.submit();
    }

    @Then("I should see search results for {string}")
    public void i_should_see_search_results_for(String expectedText) {
        WebElement searchResultElement = driver.findElement(By.xpath("//div[@class='heading-5 v-fw-regular']"));
        String actualText = searchResultElement.getText();
        assert actualText.contains(expectedText) : "Search results do not contain the expected text.";
        driver.quit();
    }

    @And("I add the first iPhone 13 to the cart")
    public void i_add_the_first_iphone_13_to_the_cart() {
        // Locate and click on the first search result (iPhone 13)
        WebElement firstSearchResult = driver.findElement(By.xpath("//h4[contains(text(),'iPhone 13')]"));
        firstSearchResult.click();

        // Locate and click on the "Add to Cart" button
        WebElement addToCartButton = driver.findElement(By.xpath("//button[contains(text(),'Add to Cart')]"));
        addToCartButton.click();
    }

    @When("I click on the cart")
    public void i_click_on_the_cart() {
        // Locate and click on the cart icon or link
        WebElement cartIcon = driver.findElement(By.xpath("//a[@class='go-to-cart-button']"));
        cartIcon.click();
    }

    @And("I verify the order summary in the cart")
    public void i_verify_the_order_summary_in_the_cart() {
        // Assuming the order summary is displayed in a specific element, locate it
        WebElement orderSummaryElement = driver.findElement(By.xpath("//div[@class='order-summary']"));

        // Extract the text of the order summary
        String orderSummaryText = orderSummaryElement.getText();

        // Perform assertions to verify the order summary content as needed
        Assert.assertTrue(orderSummaryText.contains("Product: iPhone 13"));
        Assert.assertTrue(orderSummaryText.contains("Total Price:")); // Add other verifications as necessary
    }

    @And("I click on the 2nd item in the search results")
    public void i_click_on_the_2nd_item_in_the_search_results() {
        // Locate and click on the 2nd item (index 1 in the list)
        List<WebElement> searchResults = driver.findElements(By.xpath("//h4[contains(text(),'iPhone 13')]"));
        if (searchResults.size() >= 2) {
            searchResults.get(1).click();
        } else {
            throw new AssertionError("Not enough search results to click on the 2nd item.");
        }
    }

    @And("I click on the 3rd item in the search results")
    public void i_click_on_the_3rd_item_in_the_search_results() {
        // Locate and click on the 3rd item (index 2 in the list)
        List<WebElement> searchResults = driver.findElements(By.xpath("//h4[contains(text(),'iPhone 13')]"));
        if (searchResults.size() >= 3) {
            searchResults.get(2).click();
        } else {
            throw new AssertionError("Not enough search results to click on the 3rd item.");
        }
    }

}
