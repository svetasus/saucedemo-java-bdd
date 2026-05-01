package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.CheckoutPage;
import utils.DriverFactory;

import java.time.Duration;


public class CheckoutSteps {

    CheckoutPage checkoutPage = new CheckoutPage(DriverFactory.getDriver());

    @Given("the user navigates directly to the checkout page")
    public void navigateToCheckout() {

        DriverFactory.getDriver().get("https://www.saucedemo.com/checkout-step-one.html");
    }

    @When("the user enters first name {string}, last name {string}, and zip {string}")
    public void enterShippingData(String firstName, String lastName, String zip)
    {
        checkoutPage.fillShippingInfo(firstName,lastName,zip);
    }

    @Then("the user should be taken to the Checkout Overview page")
    public void verifySuccessfulSubmission() {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("checkout-step-two.html"));

        String currentUrl = DriverFactory.getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("checkout-step-two.html"), "Did not navigate to overview page!");
    }

    @Then("the checkout error should be {string}")
    public void verifyCheckoutError(String expectedError) {
        String actualError = checkoutPage.getErrorMessage();
        Assert.assertEquals(actualError, expectedError, "Checkout validation error mismatch!");
    }
}
