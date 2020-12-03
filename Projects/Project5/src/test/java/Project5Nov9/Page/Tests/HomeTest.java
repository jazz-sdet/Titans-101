package Project5Nov9.Page.Tests;

import Project5Nov9.Page.HomePage;
import Project5Nov9.Page.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomeTest extends TestBase {

    public HomePage homePage;
    SoftAssert softAssert;

    @BeforeClass()
    public void setUpp() {
        homePage = new HomePage(driver);
        softAssert = new SoftAssert();

    }

    @Test
    public void testCase1() throws InterruptedException {
        driver.get("https://icehrm-open.gamonoid.com/login.php?");
        homePage.loginPage();
        homePage.switchBtn.click();
        Thread.sleep(1000);
        boolean isDisp = homePage.displayedSwitchMess.isDisplayed();
        System.out.println(isDisp);
        //softAssert.assertTrue(homePage.displayedSwitchMess.isDisplayed());
        String actualSwitchTxt = homePage.displayedSwitchMess.getText();
        String expectedSwitchTxt = "Switch Employee";
        softAssert.assertEquals(actualSwitchTxt, expectedSwitchTxt);

        Thread.sleep(1000);
        boolean selectTxt = homePage.selectText.isDisplayed();
        System.out.println(selectTxt);
        String actualSelectTxt = homePage.selectText.getText();
        String expectedSelectTxt = "Select The Employee to Switch Into";
        softAssert.assertEquals(actualSelectTxt, expectedSelectTxt);
        homePage.selectEmplButton.click();
        Thread.sleep(1000);
        homePage.lalaName.click();
        homePage.lalaSwitchBtn.click();

        Thread.sleep(1000);

        softAssert.assertTrue(homePage.lalaDisplay.isDisplayed());
        softAssert.assertEquals(homePage.lalaDisplay.getText(), "Lala Lamees");

        softAssert.assertEquals(homePage.changedTo.getText(), "Changed To");

        // Verify color of the circle of the selected name
        String actualColor = homePage.brownCircle.getCssValue("color");
        String expectedColor = "rgba(138, 109, 59, 1)";
        softAssert.assertEquals(actualColor, expectedColor);

        softAssert.assertAll();
        // homePage.lalaNameUser.click();


    }

    @Test
    public void testCase2() throws InterruptedException {

        //driver.get("https://icehrm-open.gamonoid.com/?g=admin&n=dashboard&m=admin_Admin");
        // driver.getCurrentUrl();
        homePage.lalaNameUser.click();

        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        Thread.sleep(1000);
        homePage.financeBtn.click();
        Thread.sleep(1000);

        homePage.salaryBtn.click();
        Thread.sleep(500);
        homePage.addNewBtn.click();
        //homePage.salaryCompDropDown.click();

        Thread.sleep(1000);
        Select select = new Select(homePage.salaryCompDropDown);
        select.selectByVisibleText("Fixed Allowance");
        Thread.sleep(500);
//
            homePage.amount.sendKeys("200000");
            homePage.details.sendKeys("Test1");
            homePage.saveBtn.click();

        homePage.addNewBtn.click();



//            homePage.fixedAllowance.click();
    }

//    @Test(dataProvider = "Data")
//    public void test(String amount, String details){



    }






