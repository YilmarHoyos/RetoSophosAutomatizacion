package com.evalartapp.tasks.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class LoginUI {
    public static final Target TXT_ACCOUNT = Target.the("Caja de texto de usuario").locatedBy("//input[@name='username']");
    public static final Target TXT_PASSWORD = Target.the("Caja de texto de contraseña").locatedBy("//input[@name='password']");
    public static final Target BTN_SEND = Target.the("Botón de enviar contraseña y usuario").locatedBy("//button[contains(text(),'Enviar')]");
    public static final Target LBL_HOME = Target.the("Botón de enviar contraseña y usuario").locatedBy("//h1[contains(text(),'Prueba de automatización')]");


}
