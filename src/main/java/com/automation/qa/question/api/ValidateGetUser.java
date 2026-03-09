package com.automation.qa.question.api;

import com.automation.qa.models.UserManagement.response.ResGetUserId;
import com.automation.qa.util.Assertions;
import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.TheValue;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

import static com.automation.qa.constants.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class ValidateGetUser implements Question {

    public static ValidateGetUser withId() {
        return new ValidateGetUser();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        ResGetUserId responseGetUserOk = OnStage.theActorInTheSpotlight().asksFor(LastResponse.received()).as(ResGetUserId.class);
        OnStage.theActorInTheSpotlight().should(
                seeThat(
                        TheValue.of(VALIDATEIDUSER, responseGetUserOk.getData().getId()),
                        equalTo(VALIDATEUSERGETID.getId())),

                seeThat(
                        TheValue.of(VALIDATEEMAILUSER, responseGetUserOk.getData().getEmail()),
                        equalTo(VALIDATEUSERGETID.getEmail())),

                seeThat(
                        TheValue.of(VALIDATEFIRSTNAMEUSER, responseGetUserOk.getData().getFirst_name()),
                        equalTo(VALIDATEUSERGETID.getFirst_name())),
                seeThat(
                        TheValue.of(VALIDATELASTNAMEUSER, responseGetUserOk.getData().getLast_name()),
                        equalTo(VALIDATEUSERGETID.getLast_name())),
                seeThat(
                        TheValue.of(VALIDATEAVATARUSER, responseGetUserOk.getData().getAvatar()),
                        equalTo(VALIDATEUSERGETID.getAvatar()))

        );
        Response responseGetForSchema = OnStage.theActorInTheSpotlight().asksFor(LastResponse.received());
        Assertions.assertValidAnswer(responseGetForSchema, SCHEMAREGETUSER);
        return true;
    }
}
