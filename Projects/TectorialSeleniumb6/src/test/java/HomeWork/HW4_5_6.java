package HomeWork;
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
public class HW4_5_6 {
    WebDriver driver;
    @BeforeClass
    public void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.cars.com/");
        Select dropDownCertCar=new Select(driver.findElement(By.xpath("//select[@name='stockType']")));
        dropDownCertCar.selectByIndex(3);
        Select dropBoxMakes=new Select(driver.findElement(By.xpath("//select[@name='makeId']")));
        dropBoxMakes.selectByVisibleText("Lexus");
        Select dropModel=new Select(driver.findElement(By.xpath("//select[@name='modelId']")));
        dropModel.selectByValue("21027");
        Select dropMaxPrice=new Select(driver.findElement(By.xpath("//select[@name='priceMax']")));
        dropMaxPrice.selectByVisibleText("$50,000");
        WebElement zipCode=driver.findElement(By.name("zip"));
        zipCode.clear();
        zipCode.sendKeys("60616");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(1000);
        List <WebElement> listOfCars=driver.findElements(By.tagName("h2"));
        int actual=listOfCars.size();
        System.out.println(actual);
        int expected=20;
        Assert.assertTrue(actual<=expected);
        //==========Part2================
        List<WebElement> nameOfCar=driver.findElements(By.xpath("//h2[@class='listing-row__title']"));
        for (WebElement cars: nameOfCar){

            Assert.assertTrue(cars.getText().contains("Lexus ES 350"));
        }
        List <WebElement> distance=driver.findElements(By.xpath("//div[@class='listing-row__distance ']"));
        for(WebElement dist: distance) {
            int index = dist.getText().trim().indexOf(" ");
            String miles = dist.getText().trim().substring(0, index);
            Double doubleValues = Double.valueOf(miles);
            Assert.assertTrue(doubleValues <= 50);
        }
           Select select=new Select(driver.findElement(By.xpath("//select[@class='select-sort-options']")));
           select.selectByVisibleText("Mileage: Highest");
           List <WebElement> priceListing=driver.findElements(By.xpath("//span[@class='listing-row__price ']"));

           for(WebElement price: priceListing){
               String n=price.getText().trim().replace("$", "");
               String pr=n.replace(",", ".");
               Double convPrice=Double.valueOf(pr);
               Assert.assertTrue(convPrice<=50);

           }
        }
        }






