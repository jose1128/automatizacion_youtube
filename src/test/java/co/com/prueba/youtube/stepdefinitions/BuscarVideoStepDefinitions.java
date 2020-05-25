package co.com.prueba.youtube.stepdefinitions;

import co.com.prueba.youtube.questions.VisibilidadElemento;
import co.com.prueba.youtube.userinterfaces.InicioPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BuscarVideoStepDefinitions {

    @Managed
    private WebDriver driver;

    @Before
    public void configuracion() {
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActorCalled("User");
        OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(driver));
    }


    @Given("^el usuario se encuentra en youtube$")
    public void elUsuarioSeEncuentraEnYoutube() {
        OnStage.theActorInTheSpotlight().wasAbleTo(
                Open.url("https://www.youtube.com/")
        );
    }

    @When("^ingresa en la barra de busqueda (.*)$")
    public void ingresaEnLaBarraDeBusquedaElNombreDeVideo(String nombreVideo) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(InicioPage.BARRA_BUSQUEDA, WebElementStateMatchers.isEnabled()),
                Enter.theValue(nombreVideo).into(InicioPage.BARRA_BUSQUEDA),
                SendKeys.of(Keys.ENTER).into(InicioPage.BARRA_BUSQUEDA)
        );
    }

    @Then("^el visualizara 1- JENKINS$")
    public void elVisualizaQueElVideoFueReproducido() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(VisibilidadElemento.enYoutube(InicioPage.RESULTADO_BUSQUEDA)));
    }


}
