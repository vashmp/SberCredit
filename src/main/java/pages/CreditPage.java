package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import java.util.ArrayList;

public class CreditPage extends BasePageObject{

    @FindBy(xpath="//div[@id='topline']")
    public WebElement topline;

    @FindBy(xpath="//h1")
    public WebElement header;

    @FindBy(xpath="//div[@class='dcCalc_input-row-desktop__input']")
    public WebElement targetSpan;

    @FindBy(xpath="//div[@class='Select-menu-outer']")
    public WebElement targetSelect;

    @FindBy(xpath="//input[@id='estateCost']")
    public WebElement estateCost;

    @FindBy(xpath="//input[@id='initialFee']")
    public WebElement initialFee;

    @FindBy(xpath="//input[@id='creditTerm']")
    public WebElement creditTerm;

    @FindBy(xpath="//div[@class='dcCalc_switch-desktop__description']")
    public WebElement checkbox;

    public void checkTitle(String title){
        ArrayList tabs2 = new ArrayList (BaseSteps.getDriver().getWindowHandles());
        BaseSteps.getDriver().switchTo().window(String.valueOf(tabs2.get(1)));
       // ((JavascriptExecutor) BaseSteps.getDriver()).executeScript("arguments[0].scrollIntoView(true);", header);
        Assert.assertEquals("Название", title , header.getText());
    }
    public void fillField(String fieldName, String value){
        switch (fieldName){
            case  "Цель кредита":
                WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 3);
                wait.until(ExpectedConditions.elementToBeClickable(targetSpan));
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                targetSpan.click();
                wait.until(ExpectedConditions.visibilityOf(targetSelect));
                WebElement select = targetSelect.findElement(By.xpath(".//div[contains(text(), '" + value + "')]"));
                wait.until(ExpectedConditions.visibilityOf(select));
                select.click();
                break;
            case  "Стоимость недвижимости":
                fillField(estateCost, value);
                break;
            case  "Первоначальный взнос":
                fillField(initialFee, value);
                break;
            case  "Срок кредита":
                fillField(creditTerm, value);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                break;
            default:  throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }
    public void clickCheckBox(String condition){
        checkbox.findElement(By.xpath("//div[contains(text(),'" + condition + "')]/../following-sibling::div//label")).click();
        WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 3);
        wait.until(ExpectedConditions.invisibilityOf(checkbox
                .findElement(By.xpath("//div[contains(text(),'" + condition + "')]/../following-sibling::div//label/span[contains(@class, 'icon-on')]"))));

    }

}
