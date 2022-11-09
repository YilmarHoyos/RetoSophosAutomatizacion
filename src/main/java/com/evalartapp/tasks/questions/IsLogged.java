package com.evalartapp.tasks.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.evalartapp.tasks.userInterfaces.LoginUI.LBL_HOME;

public class IsLogged implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return LBL_HOME.resolveFor(actor).getText();    }
    public static Question<String> onTheSite() {
        return new IsLogged();}
}
