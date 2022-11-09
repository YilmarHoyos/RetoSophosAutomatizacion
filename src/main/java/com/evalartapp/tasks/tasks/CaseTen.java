package com.evalartapp.tasks.tasks;

import com.evalartapp.tasks.interactions.ExplicitWait;
import com.evalartapp.tasks.userInterfaces.CaseTenUI;
import com.evalartapp.tasks.utils.Excel;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import java.io.IOException;

public class CaseTen implements Task {
    Excel excel = new Excel();
    @Override
    public <T extends Actor> void performAs(T actor) {
        String num ="";
        String text ="";
        String date ="";
        try {
            num = excel.leerDatoExcel("Datos","Data.xlsx", 28, 0);
            text = excel.leerDatoExcel("Datos","Data.xlsx", 28, 1);
            date = excel.leerDatoExcel("Datos","Data.xlsx", 28, 2);
        } catch (
                IOException e)
        {
            throw new RuntimeException(e);
        }
        actor.attemptsTo(
                Enter.theValue(date).into(CaseTenUI.CLD_DATE),
                Click.on(CaseTenUI.RDB_MATH),
                SelectFromOptions.byValue(num).from(CaseTenUI.LST_MATH),
                Enter.theValue(text).into(CaseTenUI.TXT_TEXT),
                Click.on(CaseTenUI.BTN_SUBMIT),
                ExplicitWait.here(2)
                );
    }
    public static CaseTen on(){
        return Instrumented.instanceOf(CaseTen.class).withProperties();
    }

}
