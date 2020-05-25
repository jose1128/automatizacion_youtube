Feature: Buscar video

  Scenario: Buscar el video jenkins
    Given el usuario se encuentra en youtube
    When ingresa en la barra de busqueda JENKINS
    Then el visualizara 1- JENKINS