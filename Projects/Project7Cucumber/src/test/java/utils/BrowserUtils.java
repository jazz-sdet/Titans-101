package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class BrowserUtils {
    /*
     * closeWindows() method will close all the windows
     * other than parent window*/

    public static void closeWindows(WebDriver driver, String parentWindowId) {

        Set<String> ids = driver.getWindowHandles();
        for (String id : ids) {
            if (!id.equals(parentWindowId)) {
                driver.switchTo().window(id);
                driver.close();
            }
        }
        driver.switchTo().window(parentWindowId);

    }

    //this method swithces the driver to the new window until finding the new window
    public static void switchByURL(WebDriver driver, String targetURL) {
        Set<String> ids = driver.getWindowHandles();
        for (String id : ids) {
            if (!driver.getCurrentUrl().equals(targetURL)) {
                driver.switchTo().window(id);
            }
        }
    }

    public static void switchByTitle(WebDriver driver, String targetTitle) {
        Set<String> ids = driver.getWindowHandles();
        for (String id : ids) {
            if (!driver.getTitle().equals(targetTitle)) {
                driver.switchTo().window(id);
            }
        }
    }

    public static void switchByID(WebDriver driver, String pageID) {
        Set<String> ids = driver.getWindowHandles();
        for (String id : ids) {
            if (pageID.equals(id)) {
                driver.switchTo().window(id);
            }
        }
    }

    public static void click(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.click(element).perform();
    }

    public static void jsClick(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click", element);

    }

    public static void takeScreenShot(WebDriver driver, String testCaseName) throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        long timeStamp = System.currentTimeMillis();
        File destinationDir = new File("screenShots/"+testCaseName + timeStamp + ".png");
        FileUtils.copyFile(file, destinationDir);

    }


}


