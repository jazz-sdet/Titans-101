package selenium_class.Frames;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IframePractice {

    WebDriver driver;
    // @BeforeClass annotation will run before Test and BeforeMethod annotation inside the class

    @BeforeClass
    public void initializeDriver(){
        //System.setProperty("webdriver.chrome.driver", "locationOfDriver");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

        driver.manage().window().maximize(); //there is also full i gotta look at


    }
    @Test
    public void test1(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement header=driver.findElement(By.tagName("h3"));
        System.out.println(header.getText());

        driver.switchTo().frame(0);

        WebElement content=driver.findElement(By.tagName("p"));
        System.out.println(content.getText());

        //defaultContent() method switch back to your main html.
        driver.switchTo().defaultContent();
        //header=driver.findElement(By.tagName("h3")); it is very safe way, better to reinitialize
        System.out.println(header.getText());

    }
    @Test
    public void test2(){

        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        WebElement secondMiddle = driver.findElement(By.xpath("//frame[@name='frame-middle']"));
        driver.switchTo().frame(secondMiddle);
        WebElement middleText = driver.findElement(By.id("content"));
        System.out.println(middleText.getText());
        //when we use the nested frames, we can use the parentFrame() method to switch to parent frame.
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        System.out.println(driver.findElement(By.tagName("body")).getText());







}
}
