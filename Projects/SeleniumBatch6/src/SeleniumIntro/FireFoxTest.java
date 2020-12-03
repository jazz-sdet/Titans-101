package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.*;

public class FireFoxTest {
    public static void main(String[] args) {

        System.setProperty("webdriver.geckodriver.driver", "geckodriver");
        WebDriver driver=new FirefoxDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/");

        List<WebElement> links=driver.findElements(By.xpath("//li/a"));

        ArrayList <String> webOrder=new ArrayList<>();
        for(WebElement link: links){
            webOrder.add(link.getText());
        }
        Set<String> ascending=new TreeSet<>(webOrder);
        ArrayList<String> ascendingList=new ArrayList<>(webOrder);

        System.out.println(webOrder);
        System.out.println("===========");
        System.out.println(ascending);

        for(int i=0; i<webOrder.size();i++){
            if(!webOrder.get(i).equals(ascendingList.get(i))){
                System.out.println("Text is not following ascending order");
                break;
            }
        }

    }
}
