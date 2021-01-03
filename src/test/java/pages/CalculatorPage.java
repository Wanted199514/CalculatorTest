package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CalculatorPage extends BasePage {

    String calculatorURL = "https://web2.0calc.com/";

    @FindBy(xpath = "//div/div/input[@id='input']")
    private WebElement inputField;

    @FindBy(xpath = "//li[1]/p[@class='r']")
    private WebElement answer;

    @FindBy(xpath = "//button[@class='btn dropdown-toggle pull-right']")
    private WebElement openHistoryListButton;

    @FindBy (xpath = "//p[@class='r']")
    private List<WebElement> historyList;

    @FindBy(xpath = "//button[text()='AGREE']")
    private WebElement agreeButton;

    @FindBy(xpath = "//button[@id='BtnCos']")
    private WebElement cosButton;

    @FindBy(xpath = "//button[@id='BtnPi']")
    private WebElement piButton;

    @FindBy(xpath = "//button[@id='BtnCalc']")
    private WebElement calcButton;

    @FindBy(xpath = "//button[@id='BtnParanR']")
    private WebElement paranRButton;

    public CalculatorPage(WebDriver webDriver) {
        initializationWebElements(webDriver);
    }

    public void openCalculatorPage() {
        webDriver.get(calculatorURL);
    }

    public String calculatorPageIsLoaded() {
        return webDriver.getCurrentUrl();
    }

    public String calculatorURL() {
        return calculatorURL;
    }

    public void inputData(String sumNumber) {
        inputField.click();
        inputField.sendKeys(sumNumber);
        inputField.sendKeys(Keys.ENTER);
    }

    public void clearField() {
        inputField.click();
        inputField.clear();
    }

    public String answerIsCorrect() {
        return answer.getAttribute("textContent");
    }

    public void clickOnAgreeButton() {
        sleep(1500);
        waitUntilElementIsAppear(agreeButton);
        agreeButton.click();
    }

    public void clickOnCosButton() {
        cosButton.click();
    }

    public void clickOnPiButton() {
        piButton.click();
    }

    public void clickOnCalcButton() {
        calcButton.click();
    }

    public void clickOnParanRButton() {
        paranRButton.click();
    }

    public int getQuantity() {
        return historyList.size();
    }

    public void clickOnOpenHistoryListButton() {
        openHistoryListButton.click();
        sleep(1500);
        waitUntilElementIsAppear(answer);
    }
}
