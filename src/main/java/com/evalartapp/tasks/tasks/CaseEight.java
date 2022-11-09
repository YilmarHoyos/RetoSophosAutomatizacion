package com.evalartapp.tasks.tasks;

import com.evalartapp.tasks.interactions.ExplicitWait;
import com.evalartapp.tasks.userInterfaces.CaseEightUI;
import com.evalartapp.tasks.utils.Excel;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.io.IOException;

public class CaseEight implements Task {
   Excel excel = new Excel();
    @Override
    public <T extends Actor> void performAs(T actor) {
        String num ="";
        String text ="";
        String date= "";
        try {
            num = excel.leerDatoExcel("Datos","Data.xlsx", 24, 0);
            text = excel.leerDatoExcel("Datos","Data.xlsx", 24, 1);
            date = excel.leerDatoExcel("Datos","Data.xlsx", 24, 2);



        } catch (
                IOException e)
        {
            throw new RuntimeException(e);
        }
        actor.attemptsTo(
                Click.on(CaseEightUI.RDB_MATH),
                Enter.theValue(date).into(CaseEightUI.CLD_DATE),
                Enter.theValue(text).into(CaseEightUI.TXT_TEXT),
                Enter.theValue(num).into(CaseEightUI.TXT_NUMBER),
                Click.on(CaseEightUI.BTN_SUBMIT),

                ExplicitWait.here(2)

        );
    }
    public static CaseEight on(){
        return Instrumented.instanceOf(CaseEight.class).withProperties();
    }

}
