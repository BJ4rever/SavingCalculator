package SavingCalculator;


import cucumber.api.Scenario;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

/**
 * Created by Bhavesh on 17/06/2017.
 */
public class BaseTest extends BasePage {

    BrowserSelector browserSelector = new BrowserSelector();

    @BeforeMethod
    public void openBrowser(){
        browserSelector.selectBrowser();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://clearscore.com/");
    }

    @AfterMethod
    public void closeBrowser(){
        Utils.printScreenShot("src\\test\\Resources\\ScreenShot");
        driver.quit();
    }
}