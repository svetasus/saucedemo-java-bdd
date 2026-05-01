package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;


public class CheckoutPage extends BasePage {

    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By zipCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By errorContainer = By.cssSelector("h3[data-test='error']");

    public CheckoutPage(WebDriver driver)
    {
        super(driver);
    }

    public void fillShippingInfo(String firstName, String lastName, String zip)
    {
        writeText(firstNameField, firstName);
        writeText(lastNameField, lastName);
        writeText(zipCodeField, zip);
        click(continueButton);
    }

    public String getErrorMessage() {
        return readText(errorContainer);
    }
}
