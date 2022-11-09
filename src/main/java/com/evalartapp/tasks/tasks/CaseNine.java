package com.evalartapp.tasks.tasks;

import com.evalartapp.tasks.interactions.ExplicitWait;
import com.evalartapp.tasks.userInterfaces.CaseFiveUI;
import com.evalartapp.tasks.userInterfaces.CaseNineUI;
import com.evalartapp.tasks.utils.Excel;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import java.io.IOException;

public class CaseNine implements Task {
    Excel excel = new Excel();
    @Override
    public <T extends Actor> void performAs(T actor) {
        String valueOne ="";
        String valueTwo ="";
        String valueThree ="";
        String text ="";
        String num= "";
        try {
            valueOne = excel.leerDatoExcel("Datos","Data.xlsx", 25, 3);
            valueTwo = excel.leerDatoExcel("Datos","Data.xlsx", 26, 3);
            valueThree = excel.leerDatoExcel("Datos","Data.xlsx", 27, 3);
            text = excel.leerDatoExcel("Datos","Data.xlsx", 25, 1);
            num = excel.leerDatoExcel("Datos","Data.xlsx", 25, 0);
        } catch (
                IOException e)
        {
            throw new RuntimeException(e);
        }
        actor.attemptsTo(
                Enter.theValue(text).into(CaseNineUI.TXT_TEXT),
                Click.on(CaseNineUI.RDB_MATH),
                SelectFromOptions.byValue(num).from(CaseNineUI.LST_MATH),
                JavaScriptClick.on(CaseNineUI.CHK_NUMBER.of(valueOne)),
                JavaScriptClick.on(CaseNineUI.CHK_NUMBER.of(valueTwo)),
                JavaScriptClick.on(CaseNineUI.CHK_NUMBER.of(valueThree)),
                Click.on(CaseNineUI.BTN_SUBMIT),
                ExplicitWait.here(2)

        );
    }
    public static CaseNine on(){
        return Instrumented.instanceOf(CaseNine.class).withProperties();
    }

}
