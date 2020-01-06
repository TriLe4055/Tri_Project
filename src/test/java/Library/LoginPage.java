package Library;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private static WebDriver driver = null;

    By Textbox_Companyname = By.xpath("//input[@id='companyName']");
    By Textbox_Username = By.xpath("//input[@id='userName']");
    By Textbox_Password = By.xpath("//input[@id='password']");
    By Button_Login = By.xpath("//input[@id='submit']");

    public LoginPage (WebDriver driver) {
        this.driver = driver;
    }

    public void Login (String company, String Username, String password) {
        driver.findElement(Textbox_Companyname).sendKeys(company);
        driver.findElement(Textbox_Username).sendKeys(Username);
        driver.findElement(Textbox_Password).sendKeys(password);
        driver.findElement(Button_Login).click();
    }

}
