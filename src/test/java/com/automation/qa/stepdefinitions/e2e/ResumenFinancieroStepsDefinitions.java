package com.automation.qa.stepdefinitions.e2e;

import com.automation.qa.question.e2e.ValidateBalance;
import com.automation.qa.question.e2e.ValidateColorValue;
import com.automation.qa.question.e2e.ValidateCreditAvailable;
import com.automation.qa.question.e2e.ValidateTransactions;
import com.automation.qa.tasks.e2e.commons.Init;
import com.automation.qa.tasks.e2e.login.Login;
import com.automation.qa.ui.LoginHomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.Visibility;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class ResumenFinancieroStepsDefinitions {
    @Dado("que {word} se encuentra registrada en applitools")
    public void queSandraSeEncuentraRegistradaEnApplitools(String actorName) {
        OnStage.theActorCalled(actorName).wasAbleTo(
                Init.platform());

    }
    @Cuando("ingresa la información solicitada para su login")
    public void ingresaLaInformaciónSolicitadaParaSuLogin(DataTable data) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.user(data.transpose().asList(String.class))
        );

    }
    @Entonces("Debería ver su login exitoso junto con el resumen financiero")
    public void deberíaVerSuLoginExitosoJuntoConElResumenFinanciero() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(Visibility.of(LoginHomePage.ELEMENT_LOGIN_SUCEES), equalTo(true))

        );

        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidateTransactions.onTable(), equalTo(6))

        );

        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidateBalance.onHome(), equalTo("350"))

        );

        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidateCreditAvailable.matches(), equalTo("17,800"))

        );

        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidateColorValue.onTable(), equalTo(true))

        );


    }
}
