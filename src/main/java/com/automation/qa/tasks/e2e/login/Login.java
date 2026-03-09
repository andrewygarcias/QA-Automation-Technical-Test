package com.automation.qa.tasks.e2e.login;

import com.automation.qa.constants.Constants;
import com.automation.qa.ui.LoginPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.List;

import static com.automation.qa.constants.Constants.URLUNDERTEST;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task {

    private String email;
    private String password;

    public Login(List<String> data) {
        this.email = data.get(0);
        this.password = data.get(1);
    }

    public static Login user(List<String> data) {
        return  instrumented(Login.class,data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(email).into(LoginPage.INPUT_USER),
                Enter.theValue(password).into(LoginPage.INPUT_PASSWORD),
                Click.on(LoginPage.BUTTON_CONTINUES)
        );

        actor.attemptsTo(Ensure.thatTheCurrentPage().currentUrl().isEqualTo(Constants.EXPECTEDURL));
        Serenity.recordReportData()
                .withTitle(URLUNDERTEST)
                .andContents(BrowseTheWeb.as(actor).getDriver().getCurrentUrl());
    }
}