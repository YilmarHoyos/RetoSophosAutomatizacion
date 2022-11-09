package com.evalartapp.tasks.stepDefinitions;

import com.evalartapp.tasks.questions.IsLogged;
import com.evalartapp.tasks.questions.IsSuccess;
import com.evalartapp.tasks.tasks.*;
import com.evalartapp.tasks.utils.Excel;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.io.IOException;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class CasesStepDefinition {
    Excel excel = new Excel();

    @Before
    public void prepareActorStage() {
        OnStage.setTheStage(new OnlineCast());
    }
    @When("El usuario se encuentra en la pagina y resuelve los casos")
    public void elUsuarioSeEncuentraEnLaPaginaYResuelveLosCasos() {
        OnStage.theActorInTheSpotlight().attemptsTo(CaseOne.on());
        OnStage.theActorInTheSpotlight().attemptsTo(CaseTwo.on());
        OnStage.theActorInTheSpotlight().attemptsTo(CaseThree.on());
        OnStage.theActorInTheSpotlight().attemptsTo(CaseFour.on());
        OnStage.theActorInTheSpotlight().attemptsTo(CaseFive.on());
        OnStage.theActorInTheSpotlight().attemptsTo(CaseSix.on());
        OnStage.theActorInTheSpotlight().attemptsTo(CaseSeven.on());
        OnStage.theActorInTheSpotlight().attemptsTo(CaseEight.on());
        OnStage.theActorInTheSpotlight().attemptsTo(CaseNine.on());
        OnStage.theActorInTheSpotlight().attemptsTo(CaseTen.on());    }
    @Then("El usuario valida que los casos se hayan realizado satisfactoriamente")
    public void elUsuarioValidaQueLosCasosSeHayanRealizadoSatisfactoriamente() throws IOException {
        OnStage.theActorInTheSpotlight().should(seeThat(IsSuccess.onTheSite(), equalTo(excel.leerDatoExcel("Validaciones", "Data.xlsx", 1, 1))));


    }
}
