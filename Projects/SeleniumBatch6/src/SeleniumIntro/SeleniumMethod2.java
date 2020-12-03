package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMethod2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.testdiary.com/training/selenium/selenium-test-page/");

        WebElement saveButton=driver.findElement(By.id("demo"));
        System.out.println(saveButton.isEnabled());

        WebElement javaRadio=driver.findElement(By.id("java1"));
        System.out.println(javaRadio.isEnabled());
        System.out.println("Chceck box selected");

        WebElement seleniumCheckBox=driver.findElement(By.id("seleniumbox"));
        System.out.println(seleniumCheckBox.isSelected());

        seleniumCheckBox.click();

        System.out.println(seleniumCheckBox.isSelected());

        WebElement restApiCheckBox=driver.findElement(By.id("restapibox"));
        System.out.println(restApiCheckBox.isSelected());
    }
}
