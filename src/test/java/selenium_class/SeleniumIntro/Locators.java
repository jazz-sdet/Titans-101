package selenium_class.SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver=new ChromeDriver();

        driver.get("file:///Users/zhazgulkalimalieva/Desktop/HTML/Techtorial.html");

        WebElement addressOne=driver.findElement(By.name("address1"));
        addressOne.sendKeys("620 W Addison St");

        WebElement addressTwo=driver.findElement(By.name("address2"));
        addressTwo.sendKeys("Apt #104");

        WebElement cityInput=driver.findElement(By.name("city"));
        cityInput.sendKeys("Lakeview");

        WebElement stateInput=driver.findElement(By.name("state"));
        stateInput.sendKeys("Illinois");

        WebElement zipCodeInput=driver.findElement(By.name("postalCode"));
        zipCodeInput.sendKeys("60613");

        WebElement country=driver.findElement(By.name("country"));
        country.sendKeys("Argentina");

        WebElement header=driver.findElement(By.tagName("h1"));
        //header.sendKeys("test");
        System.out.println(header.getText());

        WebElement bTag=driver.findElement(By.tagName("b"));
        //FindElement returns single web element. If we have more than one matching Locator value in html
        //findElement returns only first matching element
        System.out.println(bTag.getText());

        WebElement seleniumButton=driver.findElement(By.linkText("Selenium"));
        //i have only one matching a tag on the html which Selenium has, thats why it is unique element
        seleniumButton.click();
        driver.navigate().back();

        WebElement  testNG=driver.findElement(By.linkText("TestNG"));
        testNG.click();
        driver.navigate().back();

        WebElement apiButton=driver.findElement(By.partialLinkText("Rest"));
        apiButton.click();
        driver.navigate().back();
//////////////////////////////////////////////////////////////
        addressOne=driver.findElement(By.name("address1"));
        addressTwo=driver.findElement(By.name("address2"));
        cityInput=driver.findElement(By.name("city"));
        stateInput=driver.findElement(By.name("state"));
        addressOne.clear();
        addressTwo.clear();
        cityInput.clear();
        stateInput.clear();
        zipCodeInput.clear();

        WebElement cucumber=driver.findElement(By.linkText("Cucumber"));
        //submitButton.submit();

        WebElement submitButton=driver.findElement(By.id("submitbutton"));
        submitButton.click();







    }
}
