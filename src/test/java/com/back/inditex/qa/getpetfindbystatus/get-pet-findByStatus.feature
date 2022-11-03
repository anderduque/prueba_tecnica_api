#Author Anderson Duque
@PruebaTecnicaApi
Feature: Multiple status values can be provided with comma separated strings
  Background:
    * url urlApi
    * string apiPath = '/pet/findByStatus'
    * path apiPath
    * def data = read('classpath:com/back/inditex/qa/getpetfindbystatus/dataTest.json')

  @RC-HP @TEST-001
  Scenario: CP - Validar que se pueda obtener informacion con Status available
  Dado que existe información y registros para este estado
  Cuando se ejecute el servicio debe devolver una lista de todas las mascotas vendidas
  Entonces se puede verificar el funcionamiento del servicio

    * json dataTest = data[datajson].sc01
    * headers var_headers
    * form field status = dataTest.status

    Given method get
    Then status 200

    * print response
    * print responseTime

    * def srtResponse = response
    * def id = response[0].id
    * def name = response[0].name

    And match response[0].id == '#number'
    And match response[0].name contains '#notnull'
    * print id
    * print name

    * karate.log('name pets: ' + name + ', '+ ' id pets: ' + id)

  @RC-HP @TEST-002
  Scenario: CP - Validar que se pueda obtener informacion con Status pending
  Dado que existe información y registros para este estado
  Cuando se ejecute el servicio debe devolver una lista de todas las mascotas vendidas
  Entonces se puede verificar el funcionamiento del servicio

    * json dataTest = data[datajson].sc02
    * headers var_headers
    * form field status = dataTest.status

    Given method get
    Then status 200

    * print response
    * print responseTime

    And match response[0].id == '#number'
    And match response[0].name contains '#notnull'

    * def id = response[0].id
    * def name = response[0].name

    * print id
    * print name

    * karate.log('name pets: ' + name + ', '+ ' id pets: ' + id)

  @RC-HP @TEST-003
  Scenario: CP - Validar que se pueda obtener informacion con Status sold
  Dado que existe información y registros para este estado
  Cuando se ejecute el servicio debe devolver una lista de todas las mascotas vendidas
  Entonces se puede verificar el funcionamiento del servicio

    * json dataTest = data[datajson].sc03
    * headers var_headers
    * form field status = dataTest.status

    Given method get
    Then status 200

    * print response
    * print responseTime

    And match response[1].id == '#number'
    And match response[1].name contains '#notnull'

    * def id = response[1].id
    * def name = response[1].name

    * print id
    * print name

    * karate.log('name pets: ' + name + ', '+ ' id pets: ' + id)