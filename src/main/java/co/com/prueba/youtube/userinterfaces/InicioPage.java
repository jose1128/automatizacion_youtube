package co.com.prueba.youtube.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class InicioPage {
    public static final Target BARRA_BUSQUEDA = Target.the("Barra de busqueda").locatedBy("//input[@id = 'search']");
    public static final Target RESULTADO_BUSQUEDA = Target.the("Barra de busqueda").locatedBy("//*[contains(text(), '1- JENKINS')]");
}
