package cucumber_class.StepDefs;

import Utils.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
//import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class TechtorialStepDefs {

    WebDriver driver = Driver.getDriver("chrome");

    @When("user navigates to Techtorial academy home page")
    public void user_navigates_to_techtorial(){
        System.out.println("User naviagates to techtorial.com");
        driver.get("https://techtorialacademy.com");


    }

    @And("user uses {string} as username and {string} as password")
    public void user_uses_as_username_and_as_password(String string, String string2) {
        System.out.println("User tries to log in");
        WebElement studentLogin = driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//a[@data-toggle='modal']"));
        studentLogin.click();
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .pollingEvery(Duration.ofSeconds(2))//frequency of attempts
                .withTimeout(Duration.ofSeconds(10))// max 10 seconds
                .ignoring(ElementNotInteractableException.class);// ignore this exception until

        WebElement emailField = fluentWait.until(myDriver -> {
            WebElement emailFieldInt = myDriver.findElement(By.name("signup[signup_email]"));//until it locates this element
            emailFieldInt.sendKeys("admin");//sends the key
            return emailFieldInt;
        });
        WebElement passwordField = driver.findElement(By.name("signup[signup_password]"));
        passwordField.sendKeys("admin123");

        WebElement loginStn=driver.findElement(By.cssSelector("#LoginSubmit"));
        loginStn.click();
    }
    @Then("user is logged in")
    public void user_logged_in(){
        System.out.println("User was not able to login");
        WebElement error = driver.findElement(By.xpath("//*[@class='toast toast-error']"));

        Assert.assertTrue(error.isDisplayed());
        Assert.assertEquals(error.getText(), "Error");

    }
}

















