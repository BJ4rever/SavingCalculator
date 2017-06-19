package SavingCalculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

/**
 * Created by Bhavesh Patel on 17/06/2017.
 */
public class Saving_Calculator extends Utils {

    private By currentScoreSliderField = By.xpath("/html/body/div[3]/div[2]/div[1]/div/section[3]/div/div/div/div/div[1]/div[1]");
    private By currentScoreField = By.cssSelector("p.cs-scalc__range-slider__curr-val.js-range-current-val");
    private By scoreGoalSliderField = By.xpath("/html/body/div[3]/div[2]/div[1]/div/section[3]/div/div/div/div/div[2]/div[2]");
    private By goalScoreField = By.cssSelector("p.cs-scalc__range-slider__curr-val.js-range-goal-val");


    private By actualCurrentAverageIntRateField = By.cssSelector("td.number-value.js-current-average-rate");
    private By actualCurrentAnnualCostField = By.cssSelector("td.number-value.js-current-annual-cost");
    private By actualCurrentCCAvailableField = By.cssSelector("td.number-value.js-current-cc-available");

    private By acutualGoalAverageIntRateField =  By.cssSelector("td.number-value.js-goal-average-rate");
    private By acutualGoalAnnualCostField =  By.cssSelector("td.number-value.js-goal-annual-cost");
    private By acutualGoalCCAvailableField =  By.cssSelector("td.number-value.js-goal-cc-available");

    private By actualSavingField =  By.cssSelector("span.js-total-saving-value");

    // Method to set current_score and score_goal in order to get all saving_calculator related values
    public void userShouldAbleToUseSavingCalculator(){

        driver.navigate().to("http://clearscore.com/savings-calculator");
        int x=51;

        //Get the locator and size for 'current_score slider' WebElement
        WebElement current_score_slider = driver.findElement(currentScoreSliderField);
        int current_score_width=current_score_slider.getSize().getWidth();
        //Using Actions class to move the 'current_score slider'
        Actions move = new Actions(driver);
        move.moveToElement(current_score_slider, ((current_score_width*(89))/1000), 0).click();
        move.build().perform();
        //Getting the current score value after moving the 'current_score slider'
        int  current_score= Integer.parseInt(getTextFromElement(currentScoreField));
        // Print current_score value (after moving the slider)
        System.out.println("When updating your current score to :"+current_score);

        //Move the score_goal slider to 680
        WebElement score_goal_slider = driver.findElement(scoreGoalSliderField);
        int score_goal_width=score_goal_slider.getSize().getWidth();
        Actions move2 = new Actions(driver);
        move2.moveToElement(score_goal_slider, ((score_goal_width*(866))/1000), 0).click();
        move2.build().perform();
        int goal_score= Integer.parseInt(getTextFromElement(goalScoreField));
        System.out.println("When updating score goal to :"+goal_score);

        //Storing the actual result values after moving both sliders
        String actualCurrentAverageIntRate = getTextFromElement(actualCurrentAverageIntRateField);
        String actualCurrentAnnualCost = getTextFromElement(actualCurrentAnnualCostField);
        String actualCurrentCCAvailable = getTextFromElement(actualCurrentCCAvailableField);

        String acutualGoalAverageIntRate = getTextFromElement(acutualGoalAverageIntRateField);
        String acutualGoalAnnualCost = getTextFromElement(acutualGoalAnnualCostField);
        String acutualGoalCCAvailable = getTextFromElement(acutualGoalCCAvailableField);

        //Store the actual savings text from webpage
        String actualSaving = getTextFromElement(actualSavingField);

        // List the expected values - according to requirements given in the test
        String expectedCurrentAverageIntRate="36.5%";
        String expectedCurrentAnnualCost ="£849";
        String expectedCurrentCCAvailable = "22";

        String expectedGoalAverageIntRate="25%";
        String expectedGoalAnnualCost ="£520";
        String expectedGoalCCAvailable = "241";

        String expectedSaving = "384";

        //Soft Asserting/Verifying all the saving calculator result values with valid validation message

        SoftAssert softAssert= new SoftAssert();

        softAssert.assertEquals(actualCurrentAverageIntRate,expectedCurrentAverageIntRate,"\nCurrent average interest is not matching");
        softAssert.assertEquals(actualCurrentAnnualCost,expectedCurrentAnnualCost,"\nCurrent annual cost is not matching");
        softAssert.assertEquals(actualCurrentCCAvailable,expectedCurrentCCAvailable,"\nCurrent credit card available is not matching");

        softAssert.assertEquals(acutualGoalAverageIntRate,expectedGoalAverageIntRate,"\nGoal average interest is not matching");
        softAssert.assertEquals(acutualGoalAnnualCost,expectedGoalAnnualCost,"\nGoal annual cost is not matching");
        softAssert.assertEquals(acutualGoalCCAvailable,expectedGoalCCAvailable,"\nGoal credit card available is not matching");

        softAssert.assertEquals(actualSaving,expectedSaving,"\nPotential saving is not matching");

        softAssert.assertAll();
    }
}
