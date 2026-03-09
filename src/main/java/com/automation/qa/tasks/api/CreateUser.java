package com.automation.qa.tasks.api;

import com.automation.qa.models.UserManagement.request.ReqCreateUser;
import com.automation.qa.models.UserManagement.response.ResCreateUser;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.TheValue;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.apache.http.HttpStatus;

import java.util.List;

import static com.automation.qa.constants.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class CreateUser implements Task {
    private String name;
    private String job;

    public CreateUser(List<String> data) {
        this.name = data.get(0);
        this.job = data.get(1);
    }

    public static CreateUser with(List<String> data) {
        return  instrumented(CreateUser.class,data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        ReqCreateUser body = new ReqCreateUser(name,job);
        actor.attemptsTo(
                Post.to(ENDPOINT_CREATEUSER).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON.withCharset("UTF-8"))
                                .header(APIKEY, APIKEY_VALUE)
                                .body(body)
                )
        );
        actor.should(seeThatResponse(MESSAGE_STATUS_CODE_CREATION_OK, response -> response.statusCode(HttpStatus.SC_CREATED)));
        ResCreateUser responseCreateUserOk = OnStage.theActorInTheSpotlight().asksFor(LastResponse.received()).as(ResCreateUser.class);
        assertThat(responseCreateUserOk.getId()).isNotNull();
        OnStage.theActorInTheSpotlight().remember(IDUSERCREATE,responseCreateUserOk.getId());

        actor.should(
                seeThat(
                        TheValue.of(VALIDATENAMEUSER, responseCreateUserOk.getName()),
                        equalTo(body.getName())),

                seeThat(
                        TheValue.of(VALIDATEJOBUSER, responseCreateUserOk.getJob()),
                        equalTo(body.getJob()))

        );
    }
}
