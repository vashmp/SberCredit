package steps;

import io.qameta.allure.Step;
import pages.CreditPage;

import static org.junit.Assert.assertTrue;


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
    @Step("поле {field} заполнено значением {value}")
    public void checkFillField(String field, String value){
        String actual = new CreditPage().getFillField(field);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
                actual.equals(value));
    }
}
