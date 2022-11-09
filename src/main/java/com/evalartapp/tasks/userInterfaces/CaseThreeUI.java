package com.evalartapp.tasks.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CaseThreeUI {
    public static final Target TXT_NUMBER = Target.the("Caja de texto donde se debe digitar el número de cactus").locatedBy("//input[@name='number']");
    public static final Target LST_MATH = Target.the("Lista desplegable del resultado matemático").locatedBy("//select[@name='select']");
    public static final Target CLD_DATE = Target.the("Calendario").locatedBy("//input[@name='date']");
    public static final Target CHK_NUMBER = Target.the("Checkbox del número múltiplo de 4, 68").locatedBy("//label//input[@value='{0}']");
    public static final Target BTN_SUBMIT = Target.the("Botón enviar").locatedBy("//button[contains(text(),'Enviar')]");





}
