package com.automation.qa.tasks.api;

import com.automation.qa.models.UserManagement.request.ReqCreateUser;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;
import org.apache.http.HttpStatus;

import static com.automation.qa.constants.Constants.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class UpdateUser implements Task {

    private final int id;
    private final ReqCreateUser usuario;

    public UpdateUser(int id, ReqCreateUser usuario) {
        this.id = id;
        this.usuario = usuario;
    }

    public static UpdateUser withId(int id, ReqCreateUser usuario) {
        return  instrumented(UpdateUser.class,id,usuario);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to(ENDPOINT_UPDATEUSERID + "/" + id).with(requestSpecification -> requestSpecification
                        .contentType(ContentType.JSON.withCharset("UTF-8"))
                        .header(APIKEY, APIKEY_VALUE)
                        .body(usuario)
                )
        );
        actor.should(seeThatResponse(MESSAGE_STATUS_UPDATE_GET_OK, response -> response.statusCode(HttpStatus.SC_OK)));
    }

}

