package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTech {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("file:///Users/zhazgulkalimalieva/Desktop/HTML/Techtorial.html");

        WebElement header=driver.findElement(By.id("techtorial1"));
        //get text, click element, is displayed, is selected, send key
        //getText()--returns text returns String
        System.out.println(header.getText());

        //SendKeys() method will send the given String to the input box
        WebElement firstNameInput=driver.findElement(By.id("frstName"));
        firstNameInput.sendKeys("Sam");

        WebElement lastNameInput=driver.findElement(By.id("lastName"));
        lastNameInput.sendKeys("Smith");

        WebElement phoneNumInput=driver.findElement(By.id("phoneNum"));
        phoneNumInput.sendKeys("8728064747");

        WebElement userNameInput=driver.findElement(By.id("userName"));
        userNameInput.sendKeys("jnfe@gmail.com");

        //address1

    }
}
