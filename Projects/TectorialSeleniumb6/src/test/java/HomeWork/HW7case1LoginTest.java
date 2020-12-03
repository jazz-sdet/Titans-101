package HomeWork;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageHW.HW7C1Validation;
import pageHW.HW7Case1Page;

public class HW7case1LoginTest  {

    public HW7Case1Page loginFunc;
    public HW7C1Validation validFunctionalities;
    WebDriver driver;
    SoftAssert softAssert=new SoftAssert();

    @BeforeClass
    public void setsUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        loginFunc = new HW7Case1Page(driver);
    }

    @Test
    public void case1(){
        driver.get("http://demo.guru99.com/V4/");
        loginFunc.loginPage("mngr294976", "jybemam");
        loginFunc.loginButton.click();
    }

    @Test
    public void case2(){
        driver.findElement(By.xpath("//div[@id='closeBtn']")).click();
        softAssert.assertEquals(validFunctionalities.managerFunc.getText(), "Manager");
        softAssert.assertEquals(validFunctionalities.newCustomerFunc.getText(),"New Customer");
        softAssert.assertEquals(validFunctionalities.editCustomerFunc.getText(), "Edit Customer");
        softAssert.assertEquals(validFunctionalities.delCustomerFunc.getText(),"Delete Customer");
        softAssert.assertEquals(validFunctionalities.newAccountFunc.getText(),"New Account");
        softAssert.assertEquals(validFunctionalities.editAccountFunc.getText(), "Edit Account");
        softAssert.assertEquals(validFunctionalities.delAccountFunc.getText(), "Delete Account");
        softAssert.assertEquals(validFunctionalities.depositFunc.getText(), "Deposit");
        softAssert.assertEquals(validFunctionalities.withdrawalFunc.getText(), "Withdrawal");
        softAssert.assertEquals(validFunctionalities.fundTransferFunc.getText(),"Fund Transfer");
        //softAssert.assertEquals(validFunctionalities.);

    }

}
