package com.automation.qa.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginHomePage {
    public static final Target ELEMENT_LOGIN_SUCEES = Target.the("Elemento de validacion de login exitoso").located(By.xpath("//h6[@class='element-header' and contains (text(),'Financial Overview')]"));
    public static final Target TABLE_ROWS = Target.the("Registros de la tabla").located(By.xpath("//tbody//child::tr"));
    public static final Target TOTAL_BALANCE_VALLUE = Target.the("Total Balance").located(By.xpath("//div[@id='totalBalance']//child::div[@class='balance-value']//span"));
    public static final Target CREDIT_AVAILABLE_VALLUE = Target.the("Crédito Disponible").located(By.xpath("//div[@id='creditAvailable']//child::div[@class='balance-value']"));
    public static final Target TABLE_VALUES = Target.the("Valores Tabla").located(By.xpath("//tbody//child::tr//td[@class='text-right bolder nowrap']//child::span"));
}
