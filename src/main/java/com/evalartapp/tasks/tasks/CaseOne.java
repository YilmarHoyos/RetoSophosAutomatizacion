package com.evalartapp.tasks.tasks;

import com.evalartapp.tasks.interactions.ExplicitWait;
import com.evalartapp.tasks.userInterfaces.CaseOneUI;
import com.evalartapp.tasks.utils.Excel;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.io.IOException;

public class CaseOne implements Task {
    Excel excel = new Excel();
    @Override

    public <T extends Actor> void performAs(T actor) {
        String numCactus ="";
        String cantidad ="";
        String date ="";
        try {
            numCactus = excel.leerDatoExcel("Datos","Data.xlsx", 1, 0);
            cantidad = excel.leerDatoExcel("Datos","Data.xlsx", 1, 1);
            date = excel.leerDatoExcel("Datos","Data.xlsx", 1, 2);
        } catch (
                IOException e)
        {
            throw new RuntimeException(e);
        }
        actor.attemptsTo(
                Enter.theValue(numCactus).into(CaseOneUI.TXT_NUMBER),
                Enter.theValue(cantidad).into(CaseOneUI.TXT_TEXT),
                Click.on(CaseOneUI.RDB_MATH),
                Enter.theValue(date).into(CaseOneUI.CLD_DATE),
                Click.on(CaseOneUI.BTN_SUBMIT),
                ExplicitWait.here(2)
        );
    }
    public static CaseOne on(){
        return Instrumented.instanceOf(CaseOne.class).withProperties();
    }
}
