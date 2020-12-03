package SeleniumProject2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.*;

public class Case5 {
    public static void main(String[] args){

        System.setProperty("webdriver chrome.driver", "chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("https://blazedemo.com/purchase.php");

       /* WebElement name=driver.findElement(By.xpath("//input[@id=('inputName')]"));
        name.sendKeys("David");
        WebElement address=driver.findElement(By.xpath("//input[@name=('address')]"));
        address.sendKeys("2000 E Devon Ave");

        WebElement city=driver.findElement(By.id("city"));
        city.sendKeys("Chicago");

        WebElement state=driver.findElement(By.id("state"));
        state.sendKeys("Illinois");

        WebElement zipCode=driver.findElement(By.id("zipCode"));
        zipCode.sendKeys("60606");

        WebElement ccNumber = driver.findElement(By.id("creditCardNumber"));
        ccNumber.sendKeys("4566998734522988");

        WebElement creditCardMonth=driver.findElement(By.id("creditCardMonth"));
        creditCardMonth.clear();
        creditCardMonth.sendKeys("09");

        WebElement creditCardYear=driver.findElement(By.id("creditCardYear"));
        creditCardYear.clear();
        creditCardYear.sendKeys("2024");

        WebElement nameOnCard=driver.findElement(By.id("nameOnCard"));
        nameOnCard.sendKeys("David Trump");



        WebElement rememberMeButton=driver.findElement(By.id("rememberMe"));
        rememberMeButton.submit();



        String URL=driver.getCurrentUrl();
        System.out.println(URL.equals("http://blazedemo.com/confirmation.php"));*/























        WebElement inputName = driver.findElement(By.id("inputName"));
        inputName.sendKeys("David");
        WebElement address = driver.findElement(By.id("address"));
        address.sendKeys("2000 E devon Ave");
        WebElement city = driver.findElement(By.id("city"));
        city.sendKeys("Chicago");
        WebElement  state = driver.findElement(By.id("state"));
        state.sendKeys("Illinois");
        WebElement zipCode =driver.findElement(By.id("zipCode"));
        zipCode.sendKeys("60606");
        WebElement ccNumber = driver.findElement(By.id("creditCardNumber"));
        ccNumber.sendKeys("4566998734522988");
        WebElement ccMonth = driver.findElement(By.id("creditCardMonth"));
        ccMonth.sendKeys("09");
        WebElement ccYear = driver.findElement(By.id("creditCardYear"));
        ccYear.sendKeys("2024");
        WebElement nameOnCard = driver.findElement(By.id("nameOnCard"));
        nameOnCard.sendKeys("David Trump");
        WebElement rememberMe =driver.findElement(By.id("rememberMe"));
        rememberMe.click();
        WebElement purchaseFlight = driver.findElement(By.xpath("//input[contains(@value, 'Purc')]"));
        purchaseFlight.click();
        System.out.println(driver.getCurrentUrl());
        System.out.println("Is the current URL \"http://blazedemo.com/confirmation.php\" ? "
                + driver.getCurrentUrl().equals("https://blazedemo.com/confirmation.php") );
        System.out.println("Is the title BlazeDemo Confirmation ? " + driver.getTitle().equals("BlazeDemo Confirmation"));
        WebElement isDisplayed = driver.findElement(By.xpath("//h1"));
        System.out.println(isDisplayed.getText().equals("Thank you for your purchase today!"));


    }
}
