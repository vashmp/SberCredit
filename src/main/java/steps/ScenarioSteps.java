package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by m.baykova on 13.09.2017.
 */
public class ScenarioSteps {

    MainSteps mainPageSteps = new MainSteps();
    HouseSteps housePageSteps = new HouseSteps();
    CreditSteps creditPageSteps = new CreditSteps();

    @When("^выбран пункт меню \"(.+)\" и подпункт меню \"(.+)\"$")
    public void selectDeposit(String mainTab, String subTab){
        mainPageSteps.selectDeoposit(mainTab, subTab);
    }

    @When("^выбран рассчет ипотеки$")
    public void selectCalculate(){
        housePageSteps.selectCalculate();
    }

    @Then("^проверен заголовок на соответствие \"(.+)\"$")
    public void checkTitle(String title){
        creditPageSteps.checkTitle(title);
    }

    @When("^заполняются поля:$")
    public void fillForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> creditPageSteps.fillField(field, value));

    }

    @When("^Отмечается чекбокс \"(.+)\"$")
    public void clickCheckBox(String condition){
        creditPageSteps.clickCheckBox(condition);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Then("^значения полей равны:$")
    public void checkFillForm(DataTable fields){
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> creditPageSteps.checkFillField(field, value));
    }
}
