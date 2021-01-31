package selenium_class.SelectIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Task {

    @Test
    public void testA() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");
        WebElement text=driver.findElement(By.xpath("//input[@name='q']"));
        text.sendKeys("Selenium");
        WebElement search=driver.findElement(By.xpath("//form[@id='tsf']"));

        Thread.sleep(1000);
        search.click();

        List<WebElement> titles=driver.findElements(By.xpath("//h3//span"));

//        for(WebElement title: titles){
//            System.out.println(title.getText());


        for(WebElement title:titles){
            if(!title.getText().equals("")) {
                Assert.assertTrue(title.getText().toLowerCase().contains("selenium"));
            }
        }



    }
}
