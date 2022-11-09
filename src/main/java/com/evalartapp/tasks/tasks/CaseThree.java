package com.evalartapp.tasks.tasks;

import com.evalartapp.tasks.interactions.ExplicitWait;
import com.evalartapp.tasks.userInterfaces.CaseFourUI;
import com.evalartapp.tasks.userInterfaces.CaseThreeUI;
import com.evalartapp.tasks.utils.Excel;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.io.IOException;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CaseThree implements Task {
   Excel excel = new Excel();
    @Override
    public <T extends Actor> void performAs(T actor) {
        String num ="";
        String cantidad ="";
        String date ="";
        String valueOne ="";
        String valueTwo ="";
        String valueThree ="";

        try {
            num = excel.leerDatoExcel("Datos","Data.xlsx", 3, 0);
            cantidad = excel.leerDatoExcel("Datos","Data.xlsx", 3, 1);
            date = excel.leerDatoExcel("Datos","Data.xlsx", 3, 2);
            valueOne = excel.leerDatoExcel("Datos","Data.xlsx", 1, 3);
            valueTwo = excel.leerDatoExcel("Datos","Data.xlsx", 2, 3);
            valueThree = excel.leerDatoExcel("Datos","Data.xlsx", 3, 3);
        } catch (
                IOException e)
        {
            throw new RuntimeException(e);
        }
        actor.attemptsTo(
                Enter.theValue(num).into(CaseThreeUI.TXT_NUMBER),
                SelectFromOptions.byValue(cantidad).from(CaseThreeUI.LST_MATH),
                Enter.theValue(date).into(CaseThreeUI.CLD_DATE),
                JavaScriptClick.on(CaseThreeUI.CHK_NUMBER.of(valueOne)),
                JavaScriptClick.on(CaseThreeUI.CHK_NUMBER.of(valueTwo)),
                JavaScriptClick.on(CaseThreeUI.CHK_NUMBER.of(valueThree)),
                Click.on(CaseThreeUI.BTN_SUBMIT),
                ExplicitWait.here(2)

        );
    }
    public static CaseThree on(){
        return Instrumented.instanceOf(CaseThree.class).withProperties();
    }
}
