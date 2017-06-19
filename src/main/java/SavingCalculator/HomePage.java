package SavingCalculator;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

/**
 * Created by Bhavesh Patel on 17/06/2017.
 */
public class HomePage extends Utils {

    private By seeYourScoreButtonField = By.xpath("//a[@id='cta-btn-hero']/span");
    private By cookieNotificationField = By.xpath("//div[@class='cs-cookie show']");
    private By cookieAcceptButtonField = By.xpath("//span[contains(.,'No problem')]");

    public void userShouldAbleToVerifyCookiesPresent(){

        //Verify if use is on homepage - by checking if the 'See your score' button is present
        Assert.assertTrue(getTextFromElement(seeYourScoreButtonField).contains("See your score"),"USer is not on homepage yet");

        //check if 'We use cookies' cookie notification is displayed
        Assert.assertTrue(driver.findElement(cookieNotificationField).isDisplayed());

    }

    public void userShouldAbleToDismissTheCookie(){

        //accept cookie
        clickOnElement(cookieAcceptButtonField);

        //verify no more cookie notification is present after accepting it
        Assert.assertTrue(!driver.findElement(cookieAcceptButtonField).isDisplayed(), "Cookies is still present");
        System.out.println("'We have cookies-' notification is not visible after accepting it");

    }
}
