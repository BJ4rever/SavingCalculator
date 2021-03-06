package SavingCalculator;

import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Bhavesh Patel on 17/06/2017.
 */
public class Utils extends BasePage {


    //Reusable method for Print Screen Shot
    public static void printScreenShot(String filepath){
        try {
            Robot robot = new Robot();
            BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ImageIO.write(screenShot,"jpg",new File(filepath+"\\Photo"+dateStamp()+".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }catch (AWTException e) {
            e.printStackTrace();
        }
    }


    //Reusable Method For DateStamp
    public static String dateStamp(){
        DateFormat dateFormat = new SimpleDateFormat("ddMMMyyHHmm");
        Date date = new Date();
        String date1 = dateFormat.format(date);
        return date1;
    }


    //Reusable method for getText
    public static String getTextFromElement(By by){     //return type as String - why? to store and return the test we are receiving from the element
        String text =  driver.findElement(by).getText();                                                          // so we can reuse the text
        return text;
    }

    // re-usable method for Thread.sleep
    public static void sleep(int i){
        try {
            Thread.sleep(i * 1000);   // we are converting the millisecond into seconds
        } catch (InterruptedException e) {    //Thread.sleep producing Interrupted Exception and we are handling it by using try and catch
            e.printStackTrace();
        }
    }


    //Reusable method for Soft Assert Method
    public static void softAssert(By by, String expectedText, String message){
        SoftAssert assertion = new SoftAssert();
        assertion.assertEquals(getTextFromElement(by), expectedText, message);
        assertion.assertAll();
    }

    // re-usable method to click on element
    public static void clickOnElement(By by){

        driver.findElement(by).click();
    }

    //Reusable method for Fail Test Screenshot for Just Maven Project
    public static void captureFailTestScreenShot(WebDriver driver, String screenShotName){

        try {
            TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
            File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./ScreenShot/" + screenShotName + "." +dateStamp()+ ".png"));
            System.out.println("Screenshot has been taken");
        }
        catch (Exception e){
            System.out.println("Exception while taking screenshot" + e.getMessage());
        }
    }
}
