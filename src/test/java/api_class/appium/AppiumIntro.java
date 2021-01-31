package api_class.appium;

//import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumIntro {

    @Test
    public void test1() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName","Jazgul");
        desiredCapabilities.setCapability("platformName", "android");
        URL serverURL=new URL("http://localhost:4723/wd/hub");
       // AndroidDriver androidDriver=new AndroidDriver(serverURL, desiredCapabilities);


    }

}
