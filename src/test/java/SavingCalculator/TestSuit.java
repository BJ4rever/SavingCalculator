package SavingCalculator;


import org.testng.annotations.Test;

/**
 * Unit test for simple BasePage.
 */

public class TestSuit extends BaseTest {

    HomePage homePage = new HomePage();
    Saving_Calculator saving_calculator = new Saving_Calculator();


    @Test
    public void userShouldAbleToUseSavingCalculator(){

        saving_calculator.userShouldAbleToUseSavingCalculator();
    }

    @Test
    public void userShouldAbleToSetCookie(){

        homePage.userShouldAbleToVerifyCookiesPresent();
        homePage.userShouldAbleToDismissTheCookie();

    }

}
