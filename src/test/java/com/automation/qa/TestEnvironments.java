package com.automation.qa;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.util.EnvironmentVariables;

public class TestEnvironments {
    private final EnvironmentVariables environmentVariables;

    public TestEnvironments(EnvironmentVariables environmentVariables) {
        this.environmentVariables = environmentVariables;
    }

    public String getRestBaseUrl() {
        return EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("base.url");
    }
    public String getRestBaseUrlApi() {
        return EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("url");
    }
}