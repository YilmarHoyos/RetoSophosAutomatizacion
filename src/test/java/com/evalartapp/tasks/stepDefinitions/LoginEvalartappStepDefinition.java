package com.evalartapp.tasks.stepDefinitions;
import com.evalartapp.tasks.questions.IsLogged;
import com.evalartapp.tasks.tasks.Login;
import com.evalartapp.tasks.utils.Excel;
import com.evalartapp.tasks.utils.WebDriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import java.io.IOException;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class LoginEvalartappStepDefinition {
    Excel excel = new Excel();

    @Before
    public void prepareActorStage() {
        OnStage.setTheStage(new OnlineCast());}

    @Given("El usuario registrado abre la pagina de inicio de Evalartapp")
    public void elUsuarioRegistradoAbreLaPaginaDeInicioDeEvalartapp() throws IOException {
        OnStage.setTheStage(Cast.whereEveryoneCan(BrowseTheWeb.with(WebDriverFactory.goToWeb(excel.leerDatoExcel("Dominios","Data.xlsx",1,0)))));

    }
    @When("el ingresa las credenciales de acceso")
    public void elIngresaLasCredencialesDeAcceso() {
        OnStage.theActorCalled("actor").attemptsTo(Login.on());


    }
    @Then("el deberia poder ver el menu principal")
    public void elDeberiaPoderVerElMenuPrincipal() throws IOException {
        OnStage.theActorInTheSpotlight().should(seeThat(IsLogged.onTheSite(), equalTo(excel.leerDatoExcel("Validaciones", "Data.xlsx", 1, 0))));


    }
}
