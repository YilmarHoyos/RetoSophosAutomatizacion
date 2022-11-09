package com.evalartapp.tasks.tasks;

import com.evalartapp.tasks.interactions.ExplicitWait;
import com.evalartapp.tasks.userInterfaces.CaseSevenUI;
import com.evalartapp.tasks.utils.Excel;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import java.io.IOException;

public class CaseSeven implements Task {
    Excel excel = new Excel();
    @Override
    public <T extends Actor> void performAs(T actor) {
        String num ="";
        String date ="";
        String text = "";
        String valueOne = "";
        String valueTwo = "";
        String valueThree = "";
        String valueFour = "";
        String valueFive = "";
        String valueSix = "";
        String valueSeven = "";
        String valueEight = "";
        String valueNine = "";
        String valueTen = "";
        String valueEleven = "";
        try {
            num = excel.leerDatoExcel("Datos","Data.xlsx", 13, 0);
            date = excel.leerDatoExcel("Datos","Data.xlsx", 13, 2);
            text = excel.leerDatoExcel("Datos","Data.xlsx", 13, 1);
            valueOne = excel.leerDatoExcel("Datos","Data.xlsx", 13, 3);
            valueTwo = excel.leerDatoExcel("Datos","Data.xlsx", 14, 3);
            valueThree = excel.leerDatoExcel("Datos","Data.xlsx", 15, 3);
            valueFour = excel.leerDatoExcel("Datos","Data.xlsx", 16, 3);
            valueFive = excel.leerDatoExcel("Datos","Data.xlsx", 17, 3);
            valueSix = excel.leerDatoExcel("Datos","Data.xlsx", 18, 3);
            valueSeven = excel.leerDatoExcel("Datos","Data.xlsx", 19, 3);
            valueEight = excel.leerDatoExcel("Datos","Data.xlsx", 20, 3);
            valueNine = excel.leerDatoExcel("Datos","Data.xlsx", 21, 3);
            valueTen = excel.leerDatoExcel("Datos","Data.xlsx", 22, 3);
            valueEleven = excel.leerDatoExcel("Datos","Data.xlsx", 23, 3);


        } catch (
                IOException e)
        {
            throw new RuntimeException(e);
        }
        actor.attemptsTo(
                Enter.theValue(date).into(CaseSevenUI.CLD_DATE),
                Enter.theValue(text).into(CaseSevenUI.TXT_TEXT),
                JavaScriptClick.on(CaseSevenUI.CHK_NUMBER.of(valueOne)),
                JavaScriptClick.on(CaseSevenUI.CHK_NUMBER.of(valueTwo)),
                JavaScriptClick.on(CaseSevenUI.CHK_NUMBER.of(valueThree)),
                JavaScriptClick.on(CaseSevenUI.CHK_NUMBER.of(valueFour)),
                JavaScriptClick.on(CaseSevenUI.CHK_NUMBER.of(valueFive)),
                JavaScriptClick.on(CaseSevenUI.CHK_NUMBER.of(valueSix)),
                JavaScriptClick.on(CaseSevenUI.CHK_NUMBER.of(valueSeven)),
                JavaScriptClick.on(CaseSevenUI.CHK_NUMBER.of(valueEight)),
                JavaScriptClick.on(CaseSevenUI.CHK_NUMBER.of(valueNine)),
                JavaScriptClick.on(CaseSevenUI.CHK_NUMBER.of(valueTen)),
                JavaScriptClick.on(CaseSevenUI.CHK_NUMBER.of(valueEleven)),
                SelectFromOptions.byValue(num).from(CaseSevenUI.LST_MATH),
                Click.on(CaseSevenUI.BTN_SUBMIT),
                ExplicitWait.here(2)
        );
    }
    public static CaseSeven on(){
        return Instrumented.instanceOf(CaseSeven.class).withProperties();
    }

}
