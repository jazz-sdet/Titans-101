package HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class HW4_3_4 {
    WebDriver driver;
    @BeforeClass
    public void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
        @Test
    public void testCasePart1() throws InterruptedException {
        driver.get("https://www.cars.com/");
        WebElement certifiedCars =driver.findElement(By.xpath("//select[@name='stockType']"));
        certifiedCars.click();
        Select select=new Select(certifiedCars);
        select.selectByIndex(3);
        Thread.sleep(1000);
        certifiedCars.click();
        WebElement allCarMake=driver.findElement(By.name("makeId"));
        allCarMake.click();
        Thread.sleep(1000);
            Select selectMake=new Select(allCarMake);
            selectMake.selectByVisibleText("Toyota");
            Thread.sleep(1000);
            allCarMake.click();
            WebElement model=driver.findElement(By.name("modelId"));
            allCarMake.click();
            Thread.sleep(1000);
            Select selectModel=new Select(model);
            selectModel.selectByVisibleText("Corolla");
            Thread.sleep(1000);
            model.click();
            WebElement maxPrice=driver.findElement(By.name("priceMax"));
            maxPrice.click();
            Select selectMaxPrice=new Select(maxPrice);
            selectMaxPrice.selectByValue("30000");
            Thread.sleep(1000);
            maxPrice.click();
            WebElement radius=driver.findElement(By.name("radius"));
            radius.click();
            Select selectRadius=new Select(radius);
            selectRadius.selectByValue("40");
            Thread.sleep(1000);
            radius.click();
            WebElement zipCode=driver.findElement(By.name("zip"));
            zipCode.clear();
            zipCode.sendKeys("60618");
            driver.findElement(By.xpath("//input[@type='submit']")).click();
            driver.get("https://www.cars.com/for-sale/searchresults.action/?cpoId=28444&mdId=20861&mkId=20088&prMx=30000&rd=40&searchSource=QUICK_FORM&stkTypId=28881&zc=60018");
            Assert.assertTrue(driver.getTitle().contains("Certified Used"));
            driver.findElement(By.xpath("//h1[contains(.,'Certified Used Toyota Corolla for Sale')]")).isDisplayed();
            //==================Part2===========================
            boolean selected=driver.findElement(By.xpath("//div[@name='rd']/select/option[@value='40']")).isSelected();
            System.out.println(selected);
            WebElement newUsed=driver.findElement(By.id("stkTypId-28444"));
            System.out.println(newUsed.isSelected());
            System.out.println(driver.findElement(By.id("mkId-20088")).isSelected());
            System.out.println(driver.findElement(By.id("mdId-20861")).isSelected());


        }

    }

