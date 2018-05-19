package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

/**
 * Created by Nikita Blokhin.
 */
public class MainPage extends BasePageObject{
    @FindBy(xpath="//span[@class='multiline']")
    public WebElement navigationList;

    @FindBy(xpath="//div[@class='alt-menu-collapser__hidder']")
    public WebElement subNavigationList;


    public void selectMainTab(String mainTab){
        Actions action = new Actions(BaseSteps.getDriver());
        WebElement selectMainTab = navigationList.findElement(By.xpath("./ancestor::a[normalize-space(contains(@aria-label, '"+ mainTab +"'))]"));
        action.moveToElement(selectMainTab).perform();
    }
    public void selectSubTab(String subTab){
        WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 3);
        wait.until(ExpectedConditions.visibilityOf(subNavigationList));
        WebElement selectSubTab = new MainPage().subNavigationList.findElement(By.xpath(".//a[text()='"+ subTab +"']"));
        selectSubTab.click();
    }

}
