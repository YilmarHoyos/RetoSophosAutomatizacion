package com.evalartapp.tasks.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CaseFiveUI {
    public static final Target CHK_NUMBER = Target.the("Checkbox del número múltiplo de 7, 147").locatedBy("//input[@value='{0}']");
    public static final Target TXT_NUMBER = Target.the("Caja de texto para ingresar el número de patos que se repiten").locatedBy("//input[@name='number']");
    public static final Target RDB_MATH = Target.the("Radio button del calculo matemático").locatedBy("//label//input[@value='7164920']");
    public static final Target TXT_TEXT = Target.the("Caja de texto donde se debe digitar el texto de cactus").locatedBy("//textarea[@name='text']");

    public static final Target BTN_SUBMIT = Target.the("Botón enviar").locatedBy("//button[contains(text(),'Enviar')]");

}
