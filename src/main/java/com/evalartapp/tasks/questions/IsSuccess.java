package com.evalartapp.tasks.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.evalartapp.tasks.userInterfaces.CaseTenUI.LBL_SUCCESS;


public class IsSuccess implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return LBL_SUCCESS.resolveFor(actor).getText();    }
    public static Question<String> onTheSite() {
        return new IsSuccess();}
}
