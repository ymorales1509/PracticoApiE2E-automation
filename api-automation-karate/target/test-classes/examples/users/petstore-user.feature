@petstoreapi @crudoperations
Feature: PetStore User API - CRUD Operations

  Background:
    * url 'https://petstore.swagger.io/v2'
    * header Content-Type = 'application/json'
    * header Accept = 'application/json'

  @id1 @smoketest @regression @crud
  Scenario Outline: Crear, consultar, actualizar y eliminar usuario <username>
    # Crear usuario
    * def user =
      """
      {
        "id": "#(parseInt(id))",
        "username": "#(username)",
        "firstName": "#(firstName)",
        "lastName": "#(lastName)",
        "email": "#(email)",
        "password": "#(password)",
        "phone": "#(phone)",
        "userStatus": "#(parseInt(userStatus))"
      }
      """
    Given path 'user'
    And request user
    When method post
    Then status 200
    * print response
    And match response.code == 200

    # Buscar usuario creado
    Given path 'user', username
    When method get
    Then status 200
    * print response
    And match response == user

    # Actualizar nombre y correo
    * copy updatedUser = user
    * set updatedUser.firstName = updatedFirstName
    * set updatedUser.email = updatedEmail
    Given path 'user', username
    And request updatedUser
    When method put
    Then status 200
    And match response.code == 200

    # Buscar usuario actualizado
    Given path 'user', username
    When method get
    Then status 200
    And match response == updatedUser

    # Eliminar usuario y comprobar que ya no existe
    Given path 'user', username
    When method delete
    Then status 200
    And match response.code == 200

    Given path 'user', username
    When method get
    Then status 404

    Examples:
      | read('classpath:examples/users/petstore-users.csv') |
