package selenium_class.TestNGAnnotations;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParallelExecution {

    //WebDriver driver;

    @BeforeMethod
    public void setuppp(){
        //driver=Driver.getDriver("chrome");
        WebDriverManager.chromedriver().setup();
        //driver=new ChromeDriver();
    }

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        System.out.println("Executing test 1");
        driver.get("https://www.amazon.com/");
        Thread.sleep(1000);
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon.com"));
    }

    @Test
    public void test2() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        System.out.println("Executing test 2");
        driver.get("https://www.google.com/?gws_rd=ssl");
        Thread.sleep(1000);
        Assert.assertTrue(driver.getCurrentUrl().contains("google.com"));
    }


}
