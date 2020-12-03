package selenium_class.TestNGIntro;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
public class TestAnnotation {
    @Test
    public void testA() throws InterruptedException{
        //it will download the chromeDriver for your automation.
        //All dependencies will be downloaded in .m2 file ~/.m2
        //it is for ~/.cache/selenium driver storage
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("https://www.facebook.com/");

        WebElement createNew=driver.findElement(By.id("u_0_2"));
        createNew.click();

        Thread.sleep(2000);

        WebElement firstName=driver.findElement(By.name("firstname"));
        firstName.sendKeys("David");

        WebElement lastname=driver.findElement(By.name("lastname"));
        lastname.sendKeys("Hunt");

        WebElement phoneNum=driver.findElement(By.name("reg_email__"));
        phoneNum.sendKeys("8728054738");

        WebElement password=driver.findElement(By.id("password_step_input"));
        password.sendKeys("928786jaz");

        WebElement month=driver.findElement(By.id("month"));
        Select selectMonth=new Select(month);

        selectMonth.selectByVisibleText("May");
        Thread.sleep(1000);

        selectMonth.selectByValue("2");
        Thread.sleep(1000);

        selectMonth.selectByIndex(9);


    }


}
