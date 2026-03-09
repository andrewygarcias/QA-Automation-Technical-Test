package com.automation.qa.stepdefinitions.api;

import com.automation.qa.models.UserManagement.request.ReqCreateUser;
import com.automation.qa.question.api.ValidateGetUser;
import com.automation.qa.question.api.ValidateUpdateUser;
import com.automation.qa.tasks.api.CreateUser;
import com.automation.qa.tasks.api.DeleteUser;
import com.automation.qa.tasks.api.GetUser;
import com.automation.qa.tasks.api.UpdateUser;
import com.automation.qa.util.Assertions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.ast.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.apache.http.HttpStatus;


import static com.automation.qa.constants.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;


public class GestionUsuariosStepDefinitions {

    @Dado("que {word} es el administrador del backoffice")
    public void queCarlosEsElAdministradorDelBackoffice(String actorName) {
        OnStage.theActorCalled(actorName);
        String url = OnStage.theActorCalled(actorName).recall(BASEURLAPI);
        Serenity.recordReportData()
                .withTitle("Url base")
                .andContents(url);
    }
    @Cuando("ingresa la información solicitada para crear un usuario")
    public void ingresaLaInformaciónSolicitadaParaCrearUnUsuario(DataTable data) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CreateUser.with(data.transpose().asList(String.class))
        );
    }
    @Cuando("consulta la información de un usuario por id {int}")
    public void consultaLaInformaciónDeUnUsuarioPorId(int id) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                GetUser.withId(id)
        );

    }

    @Cuando("realice la actualizacion del usuario {int} con nombre {string} y trabajo {string}")
    public void realiceLaActualizacionDelUsuarioConNombreYTrabajo(int id, String name, String job) {
        ReqCreateUser user = ReqCreateUser.builder().name(name).job(job).build();
        OnStage.theActorInTheSpotlight().remember(USERUPDATE,user);
        OnStage.theActorInTheSpotlight().attemptsTo(
                UpdateUser.withId(id,user)
        );
    }

    @Cuando("realice la eliminacion de un usuario por id {int}")
    public void realiceLaEliminacionDeUnUsuarioPorId(int id) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                DeleteUser.withId(id));
    }



    @Entonces("Debería ver que la información del usuario fue borrada con exito")
    public void deberíaVerQueLaInformaciónDelUsuarioFueBorradaConExito() {
        OnStage.theActorInTheSpotlight().should(
                seeThatResponse(MESSAGE_STATUS_DELETE_GET_OK, response -> response.statusCode(HttpStatus.SC_NO_CONTENT)));

    }

    @Entonces("Debería ver la información actualizada de manera exitosa")
    public void deberíaVerLaInformaciónActualizadaDeManeraExitosa() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidateUpdateUser.withId(), equalTo(true))

        );

    }



    @Entonces("Debería ver la información del usuario consultado")
    public void deberíaVerLaInformaciónDelUsuarioConsultado() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidateGetUser.withId(), equalTo(true))

        );


    }
    @Entonces("Debería ver que el usuario se guardo con exito con los datos ingresados")
    public void deberíaVerQueElUsuarioSeGuardoConExitoConLosDatosIngresados() {
        String idUser = OnStage.theActorInTheSpotlight().recall(IDUSERCREATE);
        OnStage.theActorInTheSpotlight().should(
                seeThat(VALIDATEIDUSER,
                        actor -> idUser,
                        notNullValue())
                );
        Response responseCreateUserOk = OnStage.theActorInTheSpotlight().asksFor(LastResponse.received());
        Assertions.assertValidAnswerCreate(responseCreateUserOk, SCHEMARESCREATEUSER);


    }
}
