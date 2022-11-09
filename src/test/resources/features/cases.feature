Feature: El usuario desea realizar los casos en Evalartapp


  Background: Solución de casos de la página Evalartapp
    Given El usuario registrado abre la pagina de inicio de Evalartapp
    When el ingresa las credenciales de acceso

  Scenario: El usuario desea realizar los casos
    When El usuario se encuentra en la pagina y resuelve los casos
    Then El usuario valida que los casos se hayan realizado satisfactoriamente