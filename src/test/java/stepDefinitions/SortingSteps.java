package stepDefinitions;

import io.cucumber.java.en.*;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.LoginPage;
import pages.InventoryPage;
import utils.DriverFactory;

import java.time.Duration;


public class SortingSteps {


    LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    InventoryPage inventoryPage = new InventoryPage(DriverFactory.getDriver());

    @Given("the user is logged into SauceDemo")
    public void userIsLoggedIn()
    {
        DriverFactory.getDriver().get("https://www.saucedemo.com/");

        loginPage.login("standard_user", "secret_sauce");
    }


    @When("the user selects {string} from the sort dropdown menu")
    public void userChoosesSort(String dropdown_option)
    {
        inventoryPage.sortItemByText(dropdown_option);
    }

    @Then("the first item displayed should cost {string}")
    public void checkFirstItemCost(String req_cost)
    {
        Assert.assertEquals(inventoryPage.getFirstItemPrice(), req_cost,"The price of the first item did not match!");
    }


}
