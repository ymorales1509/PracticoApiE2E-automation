@petstore
Feature: PetStore User API - CRUD Operations

  Background:
    * url 'https://petstore.swagger.io/v2'
    * header Content-Type = 'application/json'
    * header Accept = 'application/json'

  @smoke @regression @crud
  Scenario: Create, retrieve, update and delete a user

    # Generate dynamic test data
    * def userId = new Date().getTime()
    * def username = 'qa_user_' + userId

    * def userRequest =
    """
    {
      "id": #(userId),
      "username": "#(username)",
      "firstName": "Antonio",
      "lastName": "Automation",
      "email": "qa@example.com",
      "password": "Test123456",
      "phone": "0999999999",
      "userStatus": 1
    }
    """

    * print 'Test username:', username
    * print 'Test user ID:', userId

    @smoke @regression @crud
    Scenario: Createusuario
    Given path 'user'
    And request userRequest
    When method post
    Then status 200
    And match response.code == 200
    * print 'Create user response:', response

    @smoke @regression @crud
    Scenario: Retrieve created user
    Given path 'user', username
    When method get
    Then status 200
    And match response == userRequest
    * print 'Created user response:', response

    @smoke @regression @crud
    Scenario: Update user
    * copy updatedUser = userRequest
    * set updatedUser.firstName = 'UpdatedName'
    * set updatedUser.email = 'updated@example.com'

    Given path 'user', username
    And request Update user
    When method put
    Then status 200
    And match response.code == 200
    * print 'Update user response:', response

    @smoke @regression @crud
    Scenario: Retrieve created user
    Given path 'user', username
    When method get
    Then status 200
    And match response == updatedUser
    * print 'Updated user response:', response

    # TC05 - Delete user
    Given path 'user', username
    When method delete
    Then status 200
    And match response.code == 200
    * print 'Delete user response:', response

    # TC06 - Verify user deletion
    Given path 'user', username
    When method get
    Then status 404
    * print 'Deleted user verification:', response
