package selenium_class.Sentrifugo.Tests;

import Utils.Driver;
import org.openqa.selenium.WebDriver;
import selenium_class.Sentrifugo.Pages.DepartmentPage;
import selenium_class.Sentrifugo.Pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DepartmentTest  {

    DepartmentPage departmentPage;
    LoginPage loginPage;
    WebDriver driver= Driver.getDriver("chrome");

    @BeforeClass
    public void setUpPage(){
        departmentPage=new DepartmentPage(driver);
        loginPage=new LoginPage(driver);

    }
    @Test(priority = 1)
    public void validateErrorMessage () throws InterruptedException {
        driver.get("http://demo.sentrifugo.com/index.php/");
        loginPage.login("EM01", "sentrifugo");
        departmentPage.departmentsButton.click();
        departmentPage.addButton.click();
        departmentPage.saveButton.click();

        Thread.sleep(1000);

        String expectedNameError="Please enter department name.";
        String actualNameError=departmentPage.errorDeptName.getText().trim();

        String expectedCodeError="Please enter department code.";
        String actualCodeError=departmentPage.errorDeptCode.getText().trim();

        Assert.assertEquals(actualNameError, expectedNameError);
        Assert.assertEquals(actualCodeError, expectedCodeError);
    }

    @Test(priority = 2)
        public void validateNewDepartment() throws InterruptedException {
        departmentPage.departmentName.sendKeys("Test");
        departmentPage.departmentCode.sendKeys("1234");
        departmentPage.saveButton.click();

        Thread.sleep(500);

        String actualMessage=departmentPage.successMessage.getText().trim();
        String expectedMessage="Department added successfully.";
        Assert.assertEquals(actualMessage, expectedMessage);

        }
    }


