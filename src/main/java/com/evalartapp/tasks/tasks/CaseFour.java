package com.evalartapp.tasks.tasks;

import com.evalartapp.tasks.interactions.ExplicitWait;
import com.evalartapp.tasks.userInterfaces.CaseFourUI;
import com.evalartapp.tasks.utils.Excel;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import java.io.IOException;

public class CaseFour implements Task {
    Excel excel = new Excel();
    @Override
    public <T extends Actor> void performAs(T actor) {
        String num ="";
        String date ="";
        String valueOne= "";
        String valueTwo= "";
        String valueThree= "";
        try {
            num = excel.leerDatoExcel("Datos","Data.xlsx", 4, 0);
            date = excel.leerDatoExcel("Datos","Data.xlsx", 4, 2);
            valueOne=excel.leerDatoExcel("Datos","Data.xlsx", 4, 3);
            valueTwo=excel.leerDatoExcel("Datos","Data.xlsx", 5, 3);
            valueThree=excel.leerDatoExcel("Datos","Data.xlsx", 6, 3);
        } catch (
                IOException e)
        {
            throw new RuntimeException(e);
        }
        actor.attemptsTo(
                Enter.theValue(date).into(CaseFourUI.CLD_DATE),
                Click.on(CaseFourUI.RDB_MATH),
                JavaScriptClick.on(CaseFourUI.CHK_NUMBER.of(valueOne)),
                JavaScriptClick.on(CaseFourUI.CHK_NUMBER.of(valueTwo)),
                JavaScriptClick.on(CaseFourUI.CHK_NUMBER.of(valueThree)),
                Enter.theValue(num).into(CaseFourUI.TXT_NUMBER),
                Click.on(CaseFourUI.BTN_SUBMIT),
                ExplicitWait.here(2)


        );
    }
    public static CaseFour on(){
        return Instrumented.instanceOf(CaseFour.class).withProperties();
    }
}
