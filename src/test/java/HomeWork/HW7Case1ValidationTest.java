package HomeWork;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageHW.HW7C1Validation;

public class HW7Case1ValidationTest {

    WebDriver driver;
    public HW7C1Validation validFunctionalities;
    SoftAssert softAssert;

    @BeforeClass
    public void SetUP(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        validFunctionalities=new HW7C1Validation(driver);
        softAssert=new SoftAssert();
    }

    @Test
    public void validCase1(){
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
