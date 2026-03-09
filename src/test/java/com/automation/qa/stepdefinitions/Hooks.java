package com.automation.qa.stepdefinitions;

import com.automation.qa.actors.WebCast;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.model.util.EnvironmentVariables;

public class Hooks {
    private EnvironmentVariables environmentVariables;

    @Before(order = 0)
    public void settingTheStage(){
        OnStage.setTheStage(new WebCast(environmentVariables));
    }


}