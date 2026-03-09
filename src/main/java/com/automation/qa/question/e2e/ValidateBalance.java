package com.automation.qa.question.e2e;

import com.automation.qa.ui.LoginHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateBalance implements Question {
    public static ValidateBalance onHome() {
            return new ValidateBalance();
    }

    @Override
    public String answeredBy(Actor actor) {

        return LoginHomePage.TOTAL_BALANCE_VALLUE.resolveFor(actor).getText().substring(1);
    }


}
