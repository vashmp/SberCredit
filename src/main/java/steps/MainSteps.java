package steps;

import io.qameta.allure.Step;
import pages.MainPage;

/**
 * Created by Nikita Blokhin.
 */
public class MainSteps {

    @Step("выбран пункт меню {mainTab} и выбран пункт подменю {subTab}")
    public void selectDeoposit(String mainTab, String subTab) {
        MainPage mainPage = new MainPage();
        mainPage.selectMainTab(mainTab);
        mainPage.selectSubTab(subTab);
    }

}
