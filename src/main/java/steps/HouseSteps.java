package steps;

import com.fasterxml.jackson.databind.ser.Serializers;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;
import pages.HousePage;

/**
 * Created by Nikita Blokhin.
 */
public class HouseSteps {

    @Step("выбран рассчет ипотеки")
    public void selectCalculate(){
        new HousePage().selectCalculate();
    }
}