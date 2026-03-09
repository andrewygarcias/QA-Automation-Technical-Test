package com.automation.qa.question.e2e;

import com.automation.qa.ui.LoginHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateCreditAvailable implements Question {
    public static ValidateCreditAvailable matches() {
        return new ValidateCreditAvailable();
    }

    @Override
    public String answeredBy(Actor actor) {

        return  LoginHomePage.CREDIT_AVAILABLE_VALLUE.resolveFor(actor).getText().substring(1);
    }
}
