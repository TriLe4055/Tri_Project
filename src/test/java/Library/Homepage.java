package Library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {

    private static WebDriver driver = null;

    By Button_logout = By.xpath("//a[contains(text(),'Logout')]");
    By Button_user = By.xpath("//a[@id='hopscotch_user']");
    By Button_closehint = By.xpath("//button[@class='hopscotch-bubble-close hopscotch-close']");
    By Dropdown_home = By.xpath("//a[@id='hopscotch_modules']");

    public Homepage (WebDriver driver) {
        this.driver = driver;
    }

    public void Logout() {
        driver.findElement(Button_user).click();
        driver.findElement(Button_logout).click();
    }

    public void Click_closehint () {
        driver.findElement(Button_closehint).click();
    }

    public void waitForElement(int seconds, String waitConditionLocator){
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(waitConditionLocator)));
    }

    public void Navigation_Homepage (String ModuleName) {
        driver.findElement(Dropdown_home).click();
        driver.findElement(By.xpath("//nav[@id='main-nav']//div//ul//ul//li//a[contains(text(),'" + ModuleName + "')]")).click();
    }
}