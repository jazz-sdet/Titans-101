package selenium_class.SelectIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectPractice {

    @Test
    public void test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("https://www.facebook.com/");

        WebElement createNew=driver.findElement(By.id("u_0_2"));
        createNew.click();

        Thread.sleep(2000);
        WebElement firstName=driver.findElement(By.name("firstname"));
        firstName.sendKeys("David");

        WebElement lastname=driver.findElement(By.name("lastname"));
        lastname.sendKeys("Hunt");

        WebElement phoneNum=driver.findElement(By.name("reg_email__"));
        phoneNum.sendKeys("8728054738");

        WebElement password=driver.findElement(By.id("password_step_input"));
        password.sendKeys("928786jaz");

        WebElement month=driver.findElement(By.id("month"));
        Select mn=new Select(month);
        mn.selectByIndex(6);

        WebElement day=driver.findElement(By.id("day"));
        Select bdDay=new Select(day);
        bdDay.selectByValue("26");

        WebElement year=driver.findElement(By.id("year"));
        Select bdYear=new Select(year);
        bdYear.selectByVisibleText("1998");

        Thread.sleep(1000);
        year.sendKeys("2010");
    }

    @Test
    public void test2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("https://www.facebook.com/");

        WebElement createNew=driver.findElement(By.id("u_0_2"));
        createNew.click();
        Thread.sleep(2000);

        WebElement month=driver.findElement(By.id("month"));
        Select selectMonth=new Select(month);
      //getFirstSelectedOption() returns the webelement of first selected option

        WebElement selectOption=selectMonth.getFirstSelectedOption();
        String actual=selectOption.getText().toLowerCase();
        //LocalDate.now().getMonth().toString().substring(0,3)
        System.out.println(LocalDate.now().getMonth().toString());

        String expected=(LocalDate.now().getMonth().toString().substring(0,3).toLowerCase()); //comes from Business req current month

        Assert.assertEquals(actual, expected);
    }
    @Test
    public void test3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.navigate().to("https://www.facebook.com/");
        WebElement createNew=driver.findElement(By.id("u_0_2"));
        createNew.click();
        Thread.sleep(2000);
        WebElement month=driver.findElement(By.id("month"));
        Select selectMonth=new Select(month);
        //getOptions() returns all the opoions under option method

        List<WebElement>options=selectMonth.getOptions();
        List<String> actualOptions=new ArrayList<>();
        for(WebElement option: options){
            actualOptions.add(option.getText());
        }
        String [] expOptions={"Month", "Jan", "Feb", "Mar", "Apr","May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        List<String> expectedOptions= Arrays.asList(expOptions);

        Assert.assertEquals(expectedOptions, actualOptions);


    }
}
