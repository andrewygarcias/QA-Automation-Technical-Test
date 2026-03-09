package com.automation.qa.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    public static final Target INPUT_USER = Target.the("Campo Usuario").located(By.id("username"));
    public static final Target INPUT_PASSWORD = Target.the("Campo Contraseña").located(By.id("password"));
    public static final Target BUTTON_CONTINUES = Target.the("Botón Login").located(By.id("log-in"));

}