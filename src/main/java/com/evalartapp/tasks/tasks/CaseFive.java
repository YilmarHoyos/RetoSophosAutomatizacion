package com.evalartapp.tasks.tasks;

import com.evalartapp.tasks.interactions.ExplicitWait;
import com.evalartapp.tasks.userInterfaces.CaseFiveUI;
import com.evalartapp.tasks.userInterfaces.CaseFourUI;
import com.evalartapp.tasks.utils.Excel;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;

import java.io.IOException;

public class CaseFive implements Task {
    Excel excel = new Excel();
    @Override
    public <T extends Actor> void performAs(T actor) {
        String num ="";
        String text ="";
        String valueOne = "";
        String valueTwo = "";
        String valueThree = "";
        String valueFour = "";
        try {
            num = excel.leerDatoExcel("Datos","Data.xlsx", 5, 0);
            text = excel.leerDatoExcel("Datos","Data.xlsx", 5, 1);
            valueOne = excel.leerDatoExcel("Datos","Data.xlsx", 7, 3);
            valueTwo = excel.leerDatoExcel("Datos","Data.xlsx", 8, 3);
            valueThree = excel.leerDatoExcel("Datos","Data.xlsx", 9, 3);
            valueFour = excel.leerDatoExcel("Datos","Data.xlsx", 10, 3);


        } catch (
                IOException e)
        {
            throw new RuntimeException(e);
        }
    actor.attemptsTo(
            JavaScriptClick.on(CaseFiveUI.CHK_NUMBER.of(valueOne)),
            JavaScriptClick.on(CaseFiveUI.CHK_NUMBER.of(valueTwo)),
            JavaScriptClick.on(CaseFiveUI.CHK_NUMBER.of(valueThree)),
            JavaScriptClick.on(CaseFiveUI.CHK_NUMBER.of(valueFour)),
            Enter.theValue(num).into(CaseFiveUI.TXT_NUMBER),
            Click.on(CaseFiveUI.RDB_MATH),
            Enter.theValue(text).into(CaseFiveUI.TXT_TEXT),
            Click.on(CaseFiveUI.BTN_SUBMIT),
            ExplicitWait.here(2)
    );
    }
    public static CaseFive on(){
        return Instrumented.instanceOf(CaseFive.class).withProperties();
    }

}
