package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import java.util.ArrayList;

public class CreditPage extends BasePageObject{

    @FindBy(xpath="//div[@id='topline']")
    public WebElement topline;

    @FindBy(xpath="//h1")
    public WebElement header;

    @FindBy(xpath="//*[contains(text(),'Цель кредита')]/..//label/..")
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

    @FindBy(xpath="//span[@data-test-id='amountOfCredit']")
    public WebElement sumCredit;

    @FindBy(xpath="//span[@data-test-id='monthlyPayment']")
    public WebElement monthlyPayment;

    @FindBy(xpath="//span[@data-test-id='rate']")
    public WebElement rate;

    @FindBy(xpath="//span[@data-test-id='requiredIncome']")
    public WebElement requiredIncome;

    public void checkTitle(String title){
        ArrayList tabs2 = new ArrayList (BaseSteps.getDriver().getWindowHandles());
        BaseSteps.getDriver().switchTo().window(String.valueOf(tabs2.get(1)));
        Assert.assertEquals("Название", title , header.getText());
        scrollToElement(topline);
    }
    public void fillField(String fieldName, String value){
        switch (fieldName){
            case  "Цель кредита":
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                scrollToElement(targetSpan);
                WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 30);
                wait.until(ExpectedConditions.elementToBeClickable(targetSpan));
                targetSpan.click();
                wait.until(ExpectedConditions.visibilityOf(targetSelect));
                WebElement select = targetSelect.findElement(By.xpath(".//div[contains(text(), '" + value + "')]"));
                wait.until(ExpectedConditions.elementToBeClickable(select));
                select.click();
                WebElement input = BaseSteps.getDriver().findElement(By.xpath("//*[contains(text(),'Цель кредита')]/..//label/..//input"));
                new WebDriverWait(BaseSteps.getDriver(), 5).until(ExpectedConditions.attributeContains(input, "value", value));
                break;
            case  "Стоимость недвижимости":
                fillField(estateCost, value);
                break;
            case  "Первоначальный взнос":
                WebDriverWait wait2 = new WebDriverWait(BaseSteps.getDriver(), 3);
                wait2.until(ExpectedConditions.textToBe(By.xpath("//span[@data-test-id='amountOfCredit']"), "5 000 000 \u20BD"));
                fillField(initialFee, value);
                wait2.until(ExpectedConditions.textToBe(By.xpath("//span[@data-test-id='amountOfCredit']"), "3 000 000 \u20BD"));

                break;
            case  "Срок кредита":
                fillField(creditTerm, value);
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

    public String getFillField(String fieldName){
        switch (fieldName){
            case  "Сумма кредита":
                return sumCredit.getText();
            case  "Ежемесячный платеж":
                return monthlyPayment.getText();
            case  "Процентная ставка":
                return rate.getText();
            case  "Необходимый доход":
                return requiredIncome.getText();
        }
        throw new AssertionError("Поле не объявлено на странице");
    }

}
