package Scripts;

import Library.Homepage;
import Library.LoginPage;
import Library.WarningPageChrome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class NavigateTest {
    private static WebDriver driver = null;

    @BeforeTest
    public void setUpTest () {

        //Setup Chrome driver
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/Drivers/ChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public static void Test () {

        //create object forLogin page and Homepage
        WarningPageChrome Warningpage = new WarningPageChrome(driver);
        LoginPage Loginpage = new LoginPage(driver);
        Homepage Homepage = new Homepage(driver);

        //go to EU1 PS
        driver.get("https://eu1professionalservices.spheracloud.internal.spherasolutions.com/logon.aspx?");
        driver.manage().window().maximize();
        Warningpage.Proceed();

        //Input login information.
        Loginpage.Login("Veolia ANZ", "Dave Cousins", "Sphera!23$");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Homepage.Click_closehint();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(driver.findElement(By.xpath("//a[@id='hopscotch_logo']//img[@class='brand-image']")).isDisplayed());

        //Navigate to Reporting
        Homepage.Navigation_Homepage("Reporting");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Homepage.Navigation_Homepage("Audits");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Homepage.Navigation_Homepage("Config");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         Homepage.Logout();
    }
    @AfterTest
    public void TearDownTest() {

        driver.close();
        driver.quit();
        System.out.println("Test completed");
    }
}
