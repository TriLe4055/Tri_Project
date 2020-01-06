package Library;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IncidentPage {

    private static WebDriver driver = null;
    private static WebElement element = null;

    By Button_AddIncident = By.xpath("//body/nav[@id='main-nav']/div[@class='container-fluid']/div[@id='bs-example-navbar-collapse-1']/ul[@id='modulePages']/li[3]/a[1]");

    public IncidentPage (WebDriver driver) {
        this.driver = driver;
    }

    public void Click_AddIncident () {
        driver.findElement(Button_AddIncident).click();
    }

    public static WebElement Button_AddIncident (WebDriver driver) {
        element = driver.findElement(By.xpath("//body/nav[@id='main-nav']/div[@class='container-fluid']/div[@id='bs-example-navbar-collapse-1']/ul[@id='modulePages']/li[3]/a[1]"));
        return element;
    }
}
