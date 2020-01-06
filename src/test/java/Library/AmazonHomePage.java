package Library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class AmazonHomePage {
    private static WebDriver driver = null;

    By Dropdown_search = By.xpath("//select[@id='searchDropdownBox']");
    By Textbox_search = By.xpath("//input[@id='twotabsearchtextbox']");
    By Button_submitSearch = By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']");

    public AmazonHomePage (WebDriver driver) {
        this.driver = driver;
    }

    public void SearchProduct (WebDriver driver, String Department, String SearchText) {
        // Choose desired department
        Select department = new Select(driver.findElement(Dropdown_search));
        department.selectByVisibleText(Department);

        //Input desired product.
        driver.findElement(Textbox_search).clear();
        driver.findElement(Textbox_search).sendKeys(SearchText);

        //Submit search
        driver.findElement(Button_submitSearch).click();
    }
}
