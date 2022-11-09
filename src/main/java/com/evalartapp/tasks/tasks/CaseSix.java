package com.evalartapp.tasks.tasks;

import com.evalartapp.tasks.interactions.ExplicitWait;
import com.evalartapp.tasks.userInterfaces.CaseFiveUI;
import com.evalartapp.tasks.userInterfaces.CaseSixUI;
import com.evalartapp.tasks.utils.Excel;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import java.io.IOException;

public class CaseSix implements Task {
    Excel excel = new Excel();
    @Override
    public <T extends Actor> void performAs(T actor) {
        String num ="";
        String date ="";
        String valueOne = "";
        String valueTwo = "";
        String value = "";

        try {
            num = excel.leerDatoExcel("Datos","Data.xlsx", 11, 0);
            date = excel.leerDatoExcel("Datos","Data.xlsx", 11, 2);
            valueOne = excel.leerDatoExcel("Datos","Data.xlsx", 11, 3);
            valueTwo = excel.leerDatoExcel("Datos","Data.xlsx",12, 3);
            value = excel.leerDatoExcel("Datos","Data.xlsx", 11, 1);



        } catch (
                IOException e)
        {
            throw new RuntimeException(e);
        }
        actor.attemptsTo(
                JavaScriptClick.on(CaseSixUI.CHK_NUMBER.of(valueOne)),
                JavaScriptClick.on(CaseSixUI.CHK_NUMBER.of(valueTwo)),
                Enter.theValue(date).into(CaseSixUI.CLD_DATE),
                Enter.theValue(num).into(CaseSixUI.TXT_NUMBER),
                SelectFromOptions.byValue(value).from(CaseSixUI.LST_MATH),
                Click.on(CaseSixUI.BTN_SUBMIT),
                ExplicitWait.here(2)
        );
    }
    public static CaseSix on(){
        return Instrumented.instanceOf(CaseSix.class).withProperties();
    }

}
