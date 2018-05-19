package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

/**
 * Created by Nikita Blokhin.
 */
public class BasePageObject {

    public BasePageObject() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }


    public void fillField(WebElement field, String value){
        scrollToElement(field);
        field.clear();
        WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 3);
        wait.until(ExpectedConditions.attributeToBe(field, "value", ""));
        field.sendKeys(value);
        field.sendKeys(Keys.TAB);
    }
    public void scrollToElement(WebElement element) {
        WebDriver driver = BaseSteps.getDriver();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
    }

}
