package com.automation.qa.tasks.api;


import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.apache.http.HttpStatus;

import static com.automation.qa.constants.Constants.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;


public class GetUser implements Task {

    private final int id;

    public GetUser(int id) {
        this.id = id;
    }

    public static GetUser withId(int id) {
        return instrumented(GetUser.class, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Get.resource(ENDPOINT_GETUSERID + "/" + id).with(  requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON.withCharset("UTF-8"))
                                .header(APIKEY, APIKEY_VALUE)
                )
        );
        actor.should(seeThatResponse(MESSAGE_STATUS_CODE_GET_OK, response -> response.statusCode(HttpStatus.SC_OK)));
    }
}