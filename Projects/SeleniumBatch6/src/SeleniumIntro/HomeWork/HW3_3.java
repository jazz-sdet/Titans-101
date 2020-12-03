package SeleniumIntro.HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class HW3_3 {
    public static void main(String[] args) {
        System.setProperty("webdriver chrome.driver", "chromedriver");
        WebDriver drive = new ChromeDriver();
        drive.get("https://www.saucedemo.com/");
        WebElement userName = drive.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        WebElement passWord = drive.findElement(By.id("password"));
        passWord.sendKeys("secret_sauce");
        WebElement loginBtn = drive.findElement(By.id("login-button"));
        loginBtn.click();
        WebElement lowToHigh = drive.findElement(By.xpath("//select//option[@value='lohi']"));
        lowToHigh.click();
        List<WebElement> priceTag = drive.findElements(By.xpath("//div[@class='inventory_item_price']"));
        WebElement addToCartButton=drive.findElement(By.xpath("//button[.='ADD TO CART']"));

        List<String> arrPr=new ArrayList<>();
        List <Double> numbers=new ArrayList<>();

        for(WebElement p: priceTag){
           arrPr.add(p.getText().replace("$",""));

        }
        System.out.println(arrPr);
        List <String> aaaa=new ArrayList<>(arrPr);
        System.out.println(aaaa.equals(arrPr));


        WebElement min=drive.findElement(By.xpath("//button[@class='btn_primary btn_inventory']"));






//        for(String db: arrPr){
//            numbers.add(Double.parseDouble(db));
//        }
//        System.out.println(numbers);
       // Double firstMin=numbers.get(0).;
        //Double secondMin=numbers.get(1);









    }
}
