package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import steps.BaseSteps;

public class HousePage extends BasePageObject{

    @FindBy(xpath="//span[text()='Рассчитать']")
    public WebElement calculate;

    public void selectCalculate(){
  /*    Actions actions = new Actions(BaseSteps.getDriver());
        actions.moveToElement(calculate);
        actions.perform();*/
        ((JavascriptExecutor) BaseSteps.getDriver()).executeScript("arguments[0].scrollIntoView(true);", calculate);
        calculate.click();

    }
}
