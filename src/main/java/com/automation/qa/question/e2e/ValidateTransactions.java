package com.automation.qa.question.e2e;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.automation.qa.ui.LoginHomePage.TABLE_ROWS;

public class ValidateTransactions implements Question {


    public static ValidateTransactions onTable() {
        return new ValidateTransactions();
    }

    @Override
    public Integer answeredBy(Actor actor) {
        int cantidad = TABLE_ROWS.resolveAllFor(actor).size();
        return cantidad;
    }
}
