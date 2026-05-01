package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.DriverFactory;
import org.testng.Assert;

public class LoginSteps {

    LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    @Given("the user is on the login page")
    public void navigateToLogin() {
        DriverFactory.getDriver().get("https://www.saucedemo.com/");
    }

    @When("the user logs in with username {string} and password {string}")
    public void performLogin(String user, String pass) {
        loginPage.login(user, pass);
    }

    @Then("the outcome should be {string}")
    public void verifyOutcome(String expectedOutcome)
    {
        if(expectedOutcome.equals("success"))
        {
            String url = DriverFactory.getDriver().getCurrentUrl();
            Assert.assertTrue(url.contains("inventory.html"), "Login was successful!");
        }
        else
        {
            String actualError = loginPage.getErrorMessage();
            String url = DriverFactory.getDriver().getCurrentUrl();
            Assert.assertTrue(actualError.contains(expectedOutcome),
                    "Error message mismatch! Expected: " + expectedOutcome + " but got: " + actualError);
        }
    }
}
