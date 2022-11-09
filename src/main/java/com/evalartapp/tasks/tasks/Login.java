package com.evalartapp.tasks.tasks;

import com.evalartapp.tasks.interactions.ExplicitWait;
import com.evalartapp.tasks.userInterfaces.LoginUI;
import com.evalartapp.tasks.utils.Excel;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.io.IOException;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Login implements Task {
    Excel excel = new Excel();
    @Override
    public <T extends Actor> void performAs(T actor) {
        String user ="";
        String password ="";
        try {
             user = excel.leerDatoExcel("Credenciales","Data.xlsx", 1, 0);
             password = excel.leerDatoExcel("Credenciales","Data.xlsx", 1, 1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        actor.attemptsTo(
                WaitUntil.the(LoginUI.BTN_SEND, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(user).into(LoginUI.TXT_ACCOUNT),
                Enter.theValue(password).into(LoginUI.TXT_PASSWORD),
                Click.on(LoginUI.BTN_SEND),
                ExplicitWait.here(2)
        );

    }
    public static Login on(){
        return Instrumented.instanceOf(Login.class).withProperties();
    }
}
