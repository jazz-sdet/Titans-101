package HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;

public class HW3TestCase2Parts {
        WebDriver driver;
        @BeforeClass
        public void setup() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        @Test
        public void testOne() {
            driver.get("https://www.saucedemo.com/");
            WebElement userName = driver.findElement(By.id("user-name"));
            userName.sendKeys("standard_user");
            WebElement passWord = driver.findElement(By.id("password"));
            passWord.sendKeys("secret_sauce");
            WebElement loginBtn = driver.findElement(By.id("login-button"));
            loginBtn.click();
            WebElement lowToHigh = driver.findElement(By.xpath("//select//option[@value='hilo']"));
            lowToHigh.click();
            List<WebElement> addToCardButtons = driver.findElements(By.xpath("//button[.='ADD TO CART']"));
            addToCardButtons.get(0).click();
            addToCardButtons.get(1).click();
        }
        @Test
        public void testTwo() throws InterruptedException {
            driver.get("https://www.saucedemo.com/cart.html");

            driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]")).click();

            driver.findElement(By.xpath("//a[@class='btn_action checkout_button']")).click();

            WebElement firstName=driver.findElement(By.id("first-name"));
            firstName.sendKeys("Sam");
            WebElement lastName=driver.findElement(By.id("last-name"));
            lastName.sendKeys("Smith");
            WebElement zipCode=driver.findElement(By.id("postal-code"));
            zipCode.sendKeys("60613");
            driver.findElement(By.xpath("//input[@class='btn_primary cart_button']")).click();

            WebElement totalPrice=driver.findElement(By.xpath("//div[@class='summary_total_label']"));

            String expectedOutput="Total: $86.38";
            Assert.assertEquals(totalPrice.getText(), expectedOutput);
            String currentUrl=driver.getCurrentUrl();
            Assert.assertTrue(currentUrl.contains("checkout"));
            driver.findElement(By.xpath("//a[@class='btn_action cart_button']")).click();
            driver.get("https://www.saucedemo.com/checkout-complete.html");
            Thread.sleep(1000);
            WebElement thankYou=driver.findElement(By.xpath("//h2[@class='complete-header']"));
            String actual=thankYou.getText();
            String expected="THANK YOU FOR YOUR ORDER";
            Assert.assertEquals(actual, expected);





        }

    }
