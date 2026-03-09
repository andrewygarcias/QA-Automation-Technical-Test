package com.automation.qa.util;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Assume;


public class Assertions {
    private static SchemaValidator schemaValidator;
    private static final String VERIFICATION_MSG = "Validación de que el código httpStatus sea ";
    private static final String CODE_OBTAINED = " Código obtenido: " ;


    private Assertions() {
        super();
    }

    public static void assertValidAnswer(Response response, String schemaName) {
        schemaValidator = new SchemaValidator(response, schemaName);
        Assert.assertEquals(VERIFICATION_MSG + HttpStatus.SC_OK + CODE_OBTAINED + response.statusCode(),HttpStatus.SC_OK,response.statusCode());
        Assert.assertTrue(
                "Validación de Esquema de respuesta fallida", schemaValidator.validateSchema());
    }
    public static void assertValidAnswerCreate(Response response, String schemaName) {
        schemaValidator = new SchemaValidator(response, schemaName);
        Assert.assertEquals(VERIFICATION_MSG + HttpStatus.SC_CREATED + CODE_OBTAINED + response.statusCode(), HttpStatus.SC_CREATED, response.statusCode());
        Assert.assertTrue(
                "Validación de Esquema de respuesta fallida", schemaValidator.validateSchema());
    }

}
