package SavingCalculator;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

/**
 * Created by Bhavesh Patel on 17/06/2017.
 */
public class HomePage extends Utils {

    public void userShouldAbleToVerifyCookiesPresent(){

        //Verify if use is on homepage - by checking if the 'See your score' button is present
        //Assert.assertTrue(driver.findElement(By.xpath("//a[@id='cta-btn-hero']/span")).getText().contains("See your score"),"USer is not on homepage yet");
        Assert.assertTrue(getTextFromElement(By.xpath("//a[@id='cta-btn-hero']/span")).contains("See your score"),"USer is not on homepage yet");

        //check if 'We use cookies' cookie notification is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='cs-cookie show']")).isDisplayed());

    }

    public void userShouldAbleToDismissTheCookie(){

        //accept cookie
        clickOnElement(By.xpath("//span[contains(.,'No problem')]"));
        //verify no more cookie notification is present after accepting it
        try {
            Assert.assertFalse(driver.findElement(By.xpath("//div[@class='cs-cookie show']")).isDisplayed());
        }catch (NoSuchElementException e){
            System.out.println("'We have cookies-' notification is not visible after accepting it");
        }
        //even we navigate to another page there is no 'We use cookies notification'
        driver.navigate().to("https://www.clearscore.com/users/signup");
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='cs-cookie show']")).isDisplayed());
    }
}
