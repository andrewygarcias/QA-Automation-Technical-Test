package com.automation.qa.tasks.e2e.commons;

import com.automation.qa.constants.Constants;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static com.automation.qa.constants.Constants.URLUNDERTEST;
import static net.serenitybdd.screenplay.Tasks.instrumented;


public class Init implements Task {
    public static Init platform() {
        return instrumented(Init.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String page = actor.recall(Constants.BASEURL);
        Serenity.recordReportData()
                .withTitle(URLUNDERTEST)
                .andContents(page);
        actor.attemptsTo(Open.url(page));

    }
}
