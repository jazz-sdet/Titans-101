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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class HW4_1_2 {
    WebDriver driver;
    @BeforeClass
    public void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void case1() {
        driver.get("http://uitestpractice.com/Students/Select#");
        WebElement india = driver.findElement(By.xpath("//select[@id='countriesSingle']/option[@value='india']"));
        String expected = "India";
        Assert.assertEquals(india.getText(), expected);
        List<WebElement> dropDown = driver.findElements(By.xpath("//select[@id='countriesSingle']/option"));
        System.out.println(dropDown.size());
        int actual = dropDown.size();
        int exp = 4;
        Assert.assertEquals(actual, exp);
        String expectedNames[] = {"India", "United states of America", "China", "England"};
        List<String> actualNames = new ArrayList<>();
        List<String> expd = new ArrayList<>();
        expd.addAll(Arrays.asList(expectedNames));
        for (WebElement opt : dropDown) {
            actualNames.add(opt.getText());
        }
        Assert.assertEquals(actualNames, expd);
        System.out.println(dropDown.get(2).getText());
        WebElement usa=driver.findElement(By.xpath("//select[@id='countriesSingle']/option[text()='United states of America']"));
        System.out.println(usa.getText());
    }
    @Test
    public void caseTwo() throws InterruptedException {
        driver.get("http://uitestpractice.com/Students/Select#");
        List<WebElement> countries = driver.findElements(By.xpath("//select[@id='countriesSingle']/option"));

        String expectedCountries[] = {"India", "United states of America", "China", "England"};

        List<String> actualNames = new ArrayList<>();
        List<String> expectedC = new ArrayList<>();
        expectedC.addAll(Arrays.asList(expectedCountries));

        for (WebElement opt : countries) {
            actualNames.add(opt.getText());
        }
        Assert.assertEquals(actualNames, expectedC);
        WebElement china=driver.findElement(By.xpath("//*[@id=\"countriesMultiple\"]/option[3]"));
       WebElement england=driver.findElement(By.xpath("//*[@id=\"countriesMultiple\"]/option[4]"));
       Actions actions=new Actions(driver);
       actions.moveToElement(china)
               .clickAndHold()
               .keyDown(Keys.SHIFT)
               .release(england)
               .perform();
        Boolean display=driver.findElement(By.xpath("//div[@id='result']")).isDisplayed();
        System.out.println(display);
        Select multipleSelect = new Select(driver.findElement(By.xpath("//select[@id='countriesMultiple']")));
        multipleSelect.deselectAll();
        Thread.sleep(3000);
        multipleSelect.selectByIndex(0);
        multipleSelect.selectByVisibleText("United states of America");
        multipleSelect.selectByIndex(2);
        multipleSelect.selectByIndex(3);
        System.out.println(display);
        multipleSelect.deselectByIndex(2);
        multipleSelect.deselectByValue("england");











    }


}
