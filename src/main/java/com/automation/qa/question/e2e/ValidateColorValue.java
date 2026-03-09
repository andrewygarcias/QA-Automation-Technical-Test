package com.automation.qa.question.e2e;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

import static com.automation.qa.constants.Constants.*;
import static com.automation.qa.ui.LoginHomePage.TABLE_VALUES;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


public class ValidateColorValue implements Question {

    public static ValidateColorValue onTable() {
        return new ValidateColorValue();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        List<WebElementFacade> valuesTable = TABLE_VALUES.resolveAllFor(actor);

        valuesTable.forEach(value -> {
            String label = value.getText();
            String color = value.getCssValue(CSSCOLORPROPERTY);
            if (label.contains(POSITIVEVALUES) ) {

                assertThat(color, equalTo(CSSVERDE));

            } else if (label.contains(NEGATIVEVALUES)) {

                assertThat(color, equalTo(CSSROJO));
            }
        });
        return true;
    }
}
