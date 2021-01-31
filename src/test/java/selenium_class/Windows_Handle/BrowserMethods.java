//package selenium_class.Windows_Handle;
//
//import Utils.BrowserUtils;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//public class BrowserMethods {
//    @Test
//    public void validateSwitchUrl(){
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver=new ChromeDriver();
//        driver.get("http://www.popuptest.com/popuptest1.html");
//        System.out.println(driver.getCurrentUrl());
//
//        BrowserUtils.switchByURL(driver, "http://www.popuptest.com/popup3.html");
//        System.out.println(driver.getCurrentUrl());
//        Assert.assertEquals(driver.getCurrentUrl(), "http://www.popuptest.com/popup3.html");

