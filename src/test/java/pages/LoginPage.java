package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {



    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginBtn = By.id("login-button");
    private By errorContainer = By.cssSelector("h3[data-test='error']");

    public  LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String user, String password) {
        writeText(usernameField, user);
        writeText(passwordField, password);
        click(loginBtn);
    }

    public String getErrorMessage()
    {
        return readText(errorContainer);
    }
}
