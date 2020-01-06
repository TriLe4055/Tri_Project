package Scripts;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Library.AmazonHomePage;
import static org.apache.commons.lang3.StringUtils.containsIgnoreCase;

public class Amazon {
    private static WebDriver driver = null;

    @BeforeTest
    public void SetupTest(){
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/ChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public static void Amazon_Search() {
        //Navigate to Amazon web
        driver.get("https://www.amazon.com/");
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='nav-sprite nav-logo-base']")).isDisplayed());

        //Search product
        AmazonHomePage SearchProduct = new AmazonHomePage (driver);
        String searchText = "headphone";
        String departmentText = "All Departments";
        SearchProduct.SearchProduct(driver, departmentText,searchText);

        //Verify search
        List<WebElement> list = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));

        boolean check = true;
        for(WebElement element : list) {
            String str = element.getText();
            if (!containsIgnoreCase(str,searchText)) {
                check = false;
                System.out.println(element.getText());
                System.out.println("Verify failed");
                break;
            }
        }
        Assert.assertTrue(check);
    }

    @AfterTest
    public void TearDownTest() {
        driver.close();
        System.out.println("Test completed");
    }
}
