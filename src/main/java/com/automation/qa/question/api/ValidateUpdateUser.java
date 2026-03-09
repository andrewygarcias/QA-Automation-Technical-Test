package com.automation.qa.question.api;

import com.automation.qa.models.UserManagement.request.ReqCreateUser;
import com.automation.qa.models.UserManagement.response.ResUpdateUser;
import com.automation.qa.util.Assertions;
import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.TheValue;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

import static com.automation.qa.constants.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ValidateUpdateUser implements Question {

    public static ValidateUpdateUser withId() {
        return new ValidateUpdateUser();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        ReqCreateUser user =  actor.recall(USERUPDATE);
        ResUpdateUser responseUpdateUserOk = OnStage.theActorInTheSpotlight().asksFor(LastResponse.received()).as(ResUpdateUser.class);
        OnStage.theActorInTheSpotlight().should(

                seeThat(
                        TheValue.of(VALIDATENAMEUSER, responseUpdateUserOk.getName()),
                        equalTo(user.getName())),
                seeThat(
                        TheValue.of(VALIDATEJOBUSER, responseUpdateUserOk.getJob()),
                        equalTo(user.getJob()))

        );

        assertThat(responseUpdateUserOk.getUpdatedAt()).isNotNull().isNotEmpty();
        Response responseUpdateForSchema = OnStage.theActorInTheSpotlight().asksFor(LastResponse.received());
        Assertions.assertValidAnswer(responseUpdateForSchema, SCHEMAREUPDATEUSER);
        return true;
    }
}
