Feature: Inicio de Sesion en Evalartapp


  Scenario: Inicio de sesion exitoso en Evalartapp
    Given El usuario registrado abre la pagina de inicio de Evalartapp
    When el ingresa las credenciales de acceso
    Then el deberia poder ver el menu principal
