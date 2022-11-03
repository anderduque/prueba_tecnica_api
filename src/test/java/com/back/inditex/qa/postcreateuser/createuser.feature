#Author Anderson Duque
@PruebaTecnicaApi
Feature: This can only be done by the logged in user.
  Background:
    * url urlApi
    * string apiPath = '/user'
    * path apiPath
    * def data = read('classpath:com/back/inditex/qa/postcreateuser/dataTest.json')

  @TEST-004 @RC-HP
  Scenario: CP - Crer un usuario con credenciales validas y username valido
  Dado que el username es valido y se encuentra disponible
  Cuando se envien los datos para crear el usuario habrá exito
  Entonces el servicio guarda correctamente los datos del nuevo usuario

    * json dataTest = data[datajson].sc01
    * def apiRequest = read('classpath:com/back/inditex/qa/postcreateuser/request.json')
    * print apiRequest
    * headers var_headers

    Given request apiRequest
    When method post
    Then status 200

    * print response
    * print responseTime

    And assert response.code == 200
    And assert response.type == 'unknown'
    And assert response.message == '1'

