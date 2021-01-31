package Project;

import com.sun.org.apache.xerces.internal.xs.StringList;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.border.EmptyBorder;
import java.util.*;

public class Pr3Test2 {
    @Test
    public void testTwo(){
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");

        List<WebElement> itemPrices = driver.findElements(By.xpath("//div[@class='right-block']//span[@class='price product-price']"));
        List<Double>convPrice=new ArrayList<>();

        double dbl;
        for(WebElement prices: itemPrices){
            if(prices.getText().length()>1){
                dbl=Double.parseDouble(prices.getText().substring(1));
                convPrice.add(dbl);
            }
        }
        Collections.sort(convPrice);
        double expensiveItem=0;
        int orderNum=0;
        for(int i=0; i<convPrice.size();i++){
            expensiveItem=convPrice.get(convPrice.size()-1);
            orderNum=(int)expensiveItem;
        }
        System.out.println(expensiveItem);



        List<WebElement> productNm = driver.findElements(By.xpath("//h5[@itemprop='name']/a"));
        String item=null;
        List <String> prodNames=new ArrayList<>();
        for(WebElement names: productNm){
            prodNames.add(names.getText());

        }
        item=prodNames.get(2);
        System.out.println(item);
        Actions actions=new Actions(driver);
        WebElement dress=driver.findElement(By.xpath("//div[@class='product-image-container']"));
       /// WebElement price=driver.findElement(By.xpath("//span[@itemprop='price']"));

       WebElement quickView=driver.findElement(By.xpath("//a[@class='quick-view']"));
       quickView.click();





//        for(WebElement dr: dress){
//            dr.click();
//        }

       // Actions actions=new Actions(driver);








        }


    }

