package Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Pr3Test3 {
    @Test
    public void testThree() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        WebElement women=driver.findElement(By.xpath("//a[@title='Women']"));
        women.click();
        Thread.sleep(1000);
        WebElement dresses=driver.findElement(By.xpath("//div[@class='subcategory-image']/a[@title='Dresses']"));
        Actions actions=new Actions(driver);
        //actions.moveToElement(dresses).click().perform();
        dresses.click();
        Thread.sleep(1000);
        WebElement summerDresses=driver.findElement(By.xpath("//div[@id='subcategories']/ul/li/div[@class='subcategory-image']/a[@title='Summer Dresses']"));
        summerDresses.click();
        Thread.sleep(1000);
        WebElement chiffonDress=driver.findElement(By.xpath("//div[@class='product-image-container']/a/img[@title='Printed Chiffon Dress']"));
        actions.moveToElement(chiffonDress).clickAndHold().doubleClick().perform();
//        moreButton.click();
//        Thread.sleep(1000);
//        WebElement addToCart=driver.findElement(By.xpath("//button[@name='Submit']"));
//        //addToCart.click();
//        actions.moveToElement(addToCart).build().perform();
//

//"//a[@title='Dresses']"  "//span[@class='grower CLOSE']"
    }
}
