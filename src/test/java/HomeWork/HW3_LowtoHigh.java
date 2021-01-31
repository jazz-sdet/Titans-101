package HomeWork;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class HW3_LowtoHigh {
    @Test
    public void lowTohigh() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        WebElement passWord = driver.findElement(By.id("password"));
        passWord.sendKeys("secret_sauce");
        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.click();
        WebElement lowToHigh = driver.findElement(By.xpath("//select//option[@value='lohi']"));
        lowToHigh.click();
        List<WebElement> namesOfProducts = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<WebElement> priceTag = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        List<Double> convertedPrice = new ArrayList<>();
        double dbl;

        for (WebElement prices : priceTag) {
            String withoutDollarSPrice = prices.getText().replace("$", "");
            dbl=Double.parseDouble(withoutDollarSPrice);
            convertedPrice.add(dbl);
        }
        List<Double>twoCheapestItems=new ArrayList<>();
        twoCheapestItems.add(convertedPrice.get(0));
        twoCheapestItems.add(convertedPrice.get(1));
        System.out.println("Two cheapest product prices: "+  twoCheapestItems);

        List <String> itemNames=new ArrayList<>();
        for(WebElement names: namesOfProducts) {
            itemNames.add(names.getText());
        }
        List <String> twoItemNames=new ArrayList<>();
        twoItemNames.add(itemNames.get(0));
        twoItemNames.add(itemNames.get(1));
        System.out.println("Two cheapest product names: "+twoItemNames);

        List<WebElement> addToCardButtons=driver.findElements(By.xpath("//button[.='ADD TO CART']"));
        addToCardButtons.get(0).click();
        addToCardButtons.get(1).click();

        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]")).click();
       List <WebElement> insideCartItems=driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
       List <String> actualOutput=new ArrayList<>();
       for(WebElement in: insideCartItems){
           actualOutput.add(in.getText());
       }
        Assert.assertEquals(actualOutput, twoItemNames);

    }
}




