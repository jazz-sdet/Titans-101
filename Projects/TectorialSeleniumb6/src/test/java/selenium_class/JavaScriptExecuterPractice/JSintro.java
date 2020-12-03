package selenium_class.JavaScriptExecuterPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class JSintro {
    WebDriver driver;
    SoftAssert softAssert;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        softAssert=new SoftAssert();
    }

    @Test
    public void validationJSExecutor(){

        driver.get("https://www.techtorialacademy.com/");
        System.out.println(driver.getTitle());

        JavascriptExecutor js= (JavascriptExecutor) driver;
        String title=js.executeScript("return document.title").toString();
        System.out.println(title);

        WebElement browseCourse=driver.findElement(By.linkText("Browse Course"));

        js.executeScript("arguments[0].click()", browseCourse);

        System.out.println(js.executeScript("return document.title").toString());

        js.executeScript("alert(\"Techtorial Academy JavaScript executor\")");
        Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        WebElement getStartButton=driver.findElement(By.xpath("//h4[.='Online Course']/following-sibling::div//a"));

        js.executeScript("arguments[0].scrollIntoView(true);",getStartButton); //scroll down till find the element

        WebElement programsHeader=driver.findElement(By.tagName("h1"));

        js.executeScript("arguments[0].scrollIntoView(true);",programsHeader); //scroll back to the beginning of the page
    }

    @Test
    public void scrollUntilTheEndOfThePage() throws InterruptedException {
        driver.get("https://www.techtorialacademy.com/");

        JavascriptExecutor js=(JavascriptExecutor)driver;

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); //finds the height of the page

        //driver.navigate().refresh(); -to refresh the page
        //driver.navigate().back(); - to make the page go back
        //driver.navigate().forward(); -page forward
        Thread.sleep(2000);
        js.executeScript("history.go(0)"); //-it also refreshes the page

        WebElement onlineCourse=driver.findElement(By.xpath("//a[.='Online Course']"));
        Point buttonCord=onlineCourse.getLocation();
        int xCORD=buttonCord.getX();
        int YCORD=buttonCord.getY();

        js.executeScript("window.scrollTo("+xCORD+", "+YCORD+")");

        js.executeScript("arguments[0].setAttribute('style','background-color:red')", onlineCourse);


    }
}
