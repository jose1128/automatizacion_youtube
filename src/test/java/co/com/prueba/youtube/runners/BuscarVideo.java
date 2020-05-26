package co.com.prueba.youtube.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src\\test\\resources\\features\\buscar_video.feature",
        glue = "co.com.prueba.youtube.stepdefinitions",
        snippets = SnippetType.CAMELCASE
        
)

public class BuscarVideo {
}
