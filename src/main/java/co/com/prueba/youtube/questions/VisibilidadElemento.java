package co.com.prueba.youtube.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class VisibilidadElemento implements Question<Boolean> {
    private Target mensajeVideo;

    public VisibilidadElemento(Target mensajeVideo) {
        this.mensajeVideo = mensajeVideo;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(mensajeVideo).viewedBy(actor).asBoolean();
    }

    public static VisibilidadElemento enYoutube(Target mensajeVideo) {
        OnStage.theActorInTheSpotlight().attemptsTo(WaitUntil.the(mensajeVideo, WebElementStateMatchers.isVisible()));
        return new VisibilidadElemento(mensajeVideo);
    }
}
