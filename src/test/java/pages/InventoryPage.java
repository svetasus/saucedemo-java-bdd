package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class InventoryPage extends BasePage {


    private By sortDropdown = By.className("product_sort_container");
    private By itemPrices = By.className("inventory_item_price");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public void sortItemByText(String sortOption)
    {
        String priceBefore = readText(itemPrices);


        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(sortDropdown));
        Select select = new Select(dropdown);
        select.selectByVisibleText(sortOption);

        wait.until(ExpectedConditions.not(
                ExpectedConditions.textToBePresentInElementLocated(itemPrices, priceBefore)
        ));
    }

    public String getFirstItemPrice()
    {
        return readText(itemPrices);

    }

}
