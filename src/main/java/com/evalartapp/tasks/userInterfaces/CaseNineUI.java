package com.evalartapp.tasks.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CaseNineUI {
    public static final Target TXT_TEXT = Target.the("Caja de texto donde se debe digitar el texto de cactus").locatedBy("//textarea[@name='text']");

    public static final Target RDB_MATH = Target.the("Radio button del calculo matemático").locatedBy("//label//input[@value='2310']");
    public static final Target LST_MATH = Target.the("Lista desplegable del resultado matemático").locatedBy("//select[@name='select']");
    public static final Target CHK_NUMBER = Target.the("Checkbox del número múltiplo de 7, 147").locatedBy("//input[@value='{0}']");
    public static final Target BTN_SUBMIT = Target.the("Botón enviar").locatedBy("//button[contains(text(),'Enviar')]");

}
