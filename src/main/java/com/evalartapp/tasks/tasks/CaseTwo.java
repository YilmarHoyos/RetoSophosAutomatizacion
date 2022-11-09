package com.evalartapp.tasks.tasks;

import com.evalartapp.tasks.interactions.ExplicitWait;
import com.evalartapp.tasks.userInterfaces.CaseOneUI;
import com.evalartapp.tasks.userInterfaces.CaseTwoUI;
import com.evalartapp.tasks.utils.Excel;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import java.io.IOException;

public class CaseTwo implements Task {
    Excel excel = new Excel();
    @Override
    public <T extends Actor> void performAs(T actor) {


        String num = "";
        String cantidad = "";
        String date = "";
        try {
            num = excel.leerDatoExcel("Datos", "Data.xlsx", 2, 0);
            cantidad = excel.leerDatoExcel("Datos", "Data.xlsx", 2, 1);
            date = excel.leerDatoExcel("Datos", "Data.xlsx", 2, 2);
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
        actor.attemptsTo(
                ExplicitWait.here(3),
                Enter.theValue(cantidad).into(CaseTwoUI.TXT_TEXT),
                Enter.theValue(date).into(CaseTwoUI.CLD_DATE),
                SelectFromOptions.byValue(num).from(CaseTwoUI.LST_MATH),
                Click.on(CaseTwoUI.RDB_MATH),
                Click.on(CaseTwoUI.BTN_SUBMIT),
                ExplicitWait.here(2)
        );
    }

    public static CaseTwo on() {
        return Instrumented.instanceOf(CaseTwo.class).withProperties();
    }
}