package com.automation.qa.actors;

import com.automation.qa.TestEnvironments;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import net.thucydides.model.util.EnvironmentVariables;
import org.openqa.selenium.WebDriver;

import static com.automation.qa.constants.Constants.BASEURL;
import static com.automation.qa.constants.Constants.BASEURLAPI;

public class WebCast extends Cast {
    private final TestEnvironments testEnvironments;

    public WebCast(EnvironmentVariables environmentVariables) {
        this.testEnvironments = new TestEnvironments(environmentVariables);
    }

    @Override
    public Actor actorNamed(String actorName, Ability... abilities) {
        Actor theActor = null;

        switch (actorName.toLowerCase()) {
            case "carlos":
                theActor = super
                        .actorNamed(actorName, CallAnApi.at(testEnvironments.getRestBaseUrlApi()));
                theActor.remember(BASEURLAPI, testEnvironments.getRestBaseUrlApi());
                break;
            default:
                theActor =
                        super.actorNamed(actorName, BrowseTheWeb.with(theDefaultBrowserFor(actorName)))
                                .describedAs("Usuario que ha obtenido los privilegios para usar la web");
                theActor.remember(BASEURL, testEnvironments.getRestBaseUrl());
                break;
        }
        return theActor;

    }

    private WebDriver theDefaultBrowserFor(String actorName) {
        return ThucydidesWebDriverSupport.getWebdriverManager().getWebdriverByName(actorName);
    }
}
