package SeleniumIntro.HomeWork;

import com.sun.org.apache.xerces.internal.xs.StringList;
import com.sun.tools.javac.util.ArrayUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HW3_1 {
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


        double prices;
        double newOne;
        String billSign;
        List<String> withoutSign = new ArrayList<>();
        Object [] arrPrice;
        List<String> n = new ArrayList<>();

        for (WebElement pr : priceTag) {

            System.out.println(pr.getText().replace("$", ""));
            withoutSign.add(pr.getText());

            arrPrice=withoutSign.toArray();
            //System.out.println(arrPrice);
            for(Object s: arrPrice){
                //prices=double.parseDouble(s);
            }




        }



    }













}
