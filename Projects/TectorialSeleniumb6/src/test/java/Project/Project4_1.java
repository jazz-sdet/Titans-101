package Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Project4_1 {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.audiusa.com/");
        driver.findElement(By.xpath("//button[@id='onetrust-pc-btn-handler']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(text(),'Confirm My Choices')]")).click();
        driver.findElement(By.xpath("//span[.='SUVs & Wagons']")).click();
        driver.findElement(By.xpath("//*[@id=\"nm-id-content\"]/div/div[2]/audi-model-band/div[3]/ul[2]/li[1]/div/ul/li[2]/div/a/picture/img")).click();
        WebElement nameYearValidation=driver.findElement(By.xpath("//h1[.='\t2021 Audi Q5']"));
        String actual=nameYearValidation.getText();
        String expected="2021 Audi Q5";
        Assert.assertEquals(actual,expected);
        driver.findElement(By.xpath("//*[@id=\"nm-id-stage\"]/div/div[2]/div/div/div/a[2]")).click();
        List <WebElement> list=driver.findElements(By.xpath("//div[@class='nm-module-trimline-engine-wrapper']"));
    }
}
