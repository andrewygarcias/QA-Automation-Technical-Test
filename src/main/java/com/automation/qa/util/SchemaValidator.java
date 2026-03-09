package com.automation.qa.util;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;


public class SchemaValidator {
    private String schemaName;
    private Response response;

    public SchemaValidator(Response response, String schemaName) {
        this.response = response;
        this.schemaName = schemaName;
    }

    public boolean validateSchema() {
        try {
            System.out.println("Schema usado: " + schemaName);
            response.then()
                    .assertThat()
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/" + schemaName + ".json"));

            return true;

        } catch (AssertionError e) {

            throw new AssertionError(
                    "Error en validación de JSON Schema:\n" + e.getMessage()
            );
        }
    }
}

