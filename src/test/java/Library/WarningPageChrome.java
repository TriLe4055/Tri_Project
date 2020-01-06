package Library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class WarningPageChrome {

    private static WebDriver driver = null;

    By DetailsButton_click = By.id("details-button");
    By ProceedLink_click = By.id("proceed-link");

    public WarningPageChrome (WebDriver driver) {
        this.driver = driver;
    }

    public void Proceed () {
        driver.findElement(DetailsButton_click).click();
        driver.findElement(ProceedLink_click).click();
    }

}
