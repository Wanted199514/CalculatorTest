package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest extends BaseTest {

    private void secondPartCount() {
        calculatorPage.clickOnCosButton();
        calculatorPage.clickOnPiButton();
        calculatorPage.clickOnParanRButton();
        calculatorPage.clickOnCalcButton();
    }

    @Test
    public void firstPart() {
        Assert.assertEquals(calculatorPage.calculatorPageIsLoaded(), calculatorPage.calculatorURL(),"Calculator page is not loaded.");
        calculatorPage.clickOnAgreeButton();
        calculatorPage.inputData("35*999+(100/4)");
        calculatorPage.clickOnOpenHistoryListButton();
        Assert.assertEquals(calculatorPage.answerIsCorrect(),"= 34990", "Answer is not correct.");
    }

    @Test
    public void secondPart() {
        Assert.assertEquals(calculatorPage.calculatorPageIsLoaded(), calculatorPage.calculatorURL(),"Calculator page is not loaded.");
        calculatorPage.clickOnAgreeButton();
        secondPartCount();
        calculatorPage.clickOnOpenHistoryListButton();
        Assert.assertEquals(calculatorPage.answerIsCorrect(),"= -1", "Answer is not correct.");
    }

    @Test
    public void thirdPart() {
        Assert.assertEquals(calculatorPage.calculatorPageIsLoaded(), calculatorPage.calculatorURL(),"Calculator page is not loaded.");
        calculatorPage.clickOnAgreeButton();
        calculatorPage.inputData("sqrt(81)");
        calculatorPage.clickOnOpenHistoryListButton();
        Assert.assertEquals(calculatorPage.answerIsCorrect(),"= 9", "Answer is not correct.");
    }

    @Test
    public void fourthPart() {
        Assert.assertEquals(calculatorPage.calculatorPageIsLoaded(), calculatorPage.calculatorURL(),"Calculator page is not loaded.");
        calculatorPage.clickOnAgreeButton();
        calculatorPage.inputData("35*999+(100/4)");

        calculatorPage.clearField();
        secondPartCount();

        calculatorPage.clearField();
        calculatorPage.inputData("sqrt(81)");

        calculatorPage.clickOnOpenHistoryListButton();
        Assert.assertEquals(calculatorPage.getQuantity(),3,"History list is not correct.");
    }
}
