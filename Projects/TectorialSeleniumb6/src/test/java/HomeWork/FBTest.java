package HomeWork;

import Utils.DriverHW;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FBTest extends DriverHW {

    fb fbLogin;

    @BeforeClass
    public void zSetUP(){
        fbLogin=new fb(driver);
    }
    @Test
    public void loginToFB() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        fbLogin.login("bilmek@mail.ru", "928786Kg");

    }

    @Test
    public void srch() throws InterruptedException {
        fbLogin.searching();
        fbLogin.searching();
    }
}
