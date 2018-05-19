package steps;

import io.qameta.allure.Step;
import pages.CreditPage;


public class CreditSteps {

    @Step("проверен заголовок на соответствие {title}")
    public void checkTitle(String title){
        new CreditPage().checkTitle(title);
    }

    @Step("поле {field} заполняется значением {value}")
    public void fillField(String field, String value){
        new CreditPage().fillField(field, value);
    }

    @Step("Отмечается чекбокс {0}")
    public void clickCheckBox(String condition){
        new CreditPage().clickCheckBox(condition);
    }
}
