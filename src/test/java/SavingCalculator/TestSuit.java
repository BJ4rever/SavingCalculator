package SavingCalculator;


import org.testng.annotations.Test;

/**
 * Unit test for simple BasePage.
 */

public class TestSuit extends BaseTest {

    Saving_Calculator saving_calculator = new Saving_Calculator();


    @Test
    public void userShouldAbleToUseSavingCalculator(){
        saving_calculator.userShouldAbleToUseSavingCalculator();
    }

    @Test
    public void userShouldAbleToSetCookie(){

//        The “We use cookies” notification is present
//        The “We use cookies” notification can be dismissed
//        The “We use cookies” notification does not reappear after being dismissed
//        The appropriate cookie(s) are set

    }

}
