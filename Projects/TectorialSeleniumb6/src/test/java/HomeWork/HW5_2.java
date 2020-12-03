package HomeWork;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
public class HW5_2 {

    WebDriver driver;

    @BeforeClass
    public void driverCH() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    public void homeWork2() throws InterruptedException {

        SoftAssert softAssertion = new SoftAssert();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        WebElement blueCircle = driver.findElement(By.id("draggable"));
        WebElement blue = driver.findElement(By.xpath("//div[@class='test1']"));
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.clickAndHold(blueCircle).moveToElement(blue).perform();
        blue = driver.findElement(By.xpath("//div[@class='test1']"));
        Assert.assertTrue(blue.getText().equals("Now you can drop it."));

        WebElement orange = driver.findElement(By.xpath("//div[@class='test2']"));
        Assert.assertTrue(orange.getText().equals("(Drop here)"));
    }
}
