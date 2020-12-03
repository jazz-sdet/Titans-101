package HomeWork;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class HW2_4 {

    @Test
    public void testA(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement userName=driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement clickLogin=driver.findElement(By.id("login-button"));
        clickLogin.click();
        List<WebElement> prodNames=driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        ArrayList <String> obtainedList=new ArrayList<>();
        for (WebElement prod: prodNames){
            obtainedList.add(prod.getText());
            }


        ArrayList <String> sortedList=new ArrayList<>();
        for(String s: obtainedList){
            sortedList.add(s);
        }
        Collections.sort(sortedList);
        Assert.assertTrue(sortedList.equals(obtainedList));




        //Set<WebElement> namesOfProd=new TreeSet<>();
//        String [] expected={"Sauce Labs Backpack", "Sauce Labs Bike Light","Sauce Labs Bolt T-Shirt","Sauce Labs Fleece Jacket","Sauce Labs Onesie",
//                "Test.allTheThings() T-Shirt (Red)"};
//        //List expd=new ArrayList<>();
//        //expd.add(expected);
//        for(WebElement names:prodNames) {
//            for(String exp: expected){
//                //System.out.println(names.getText().compareTo(exp)
//            }
//            System.out.println(names.equals(expected));

           // System.out.println(names.getText().equals(expected));
            //System.out.println(names.getText());
//            if(names.getText().equals(expected)){
//                System.out.println("Name of the products are unique");
//            }else{
//                System.out.println("Product names are not unique");
//            }





    }

    public static class HW3_1 {
        @Test
        public void test() {
            WebDriverManager.chromedriver().setup();
            WebDriver drive = new ChromeDriver();

            drive.get("https://www.saucedemo.com/");
            WebElement userName = drive.findElement(By.id("user-name"));
            userName.sendKeys("standard_user");
            WebElement passWord = drive.findElement(By.id("password"));
            passWord.sendKeys("secret_sauce");
            WebElement loginBtn = drive.findElement(By.id("login-button"));
            loginBtn.click();
            WebElement actual=drive.findElement(By.xpath("//div[@id='inventory_filter_container']/select/option[@value='za']"));
            String expected="Name (Z to A)";
            //System.out.println(actual.getText().equals(expected));
            Assert.assertEquals(actual.getText(), expected);


        }
    }
}
