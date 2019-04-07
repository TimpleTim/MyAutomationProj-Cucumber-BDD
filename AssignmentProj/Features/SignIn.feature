
Feature: Validate the SIGN IN functionality of an application
To test the sign in function in the application

  
  Scenario: To test with valid login credentials
    Given User is on the chrome browser
    Given User is presented in the application
    And   User click the sign In
    When  User enters the credentials timpletim23@gmail.com and timple1234tim
    And   Clicks the sign in button
    Then  User should be logged in
    And   Browser closes
		
  Scenario: To test with invalid login credentials
    Given User is on the chrome browser
    Given User is presented in the application
    And   User click the sign In
    When  User enters the credentials test@test.com and qwert
    And   Clicks the sign in button
    Then  User should get error message
    And   Browser closes
    
  Scenario: To test with null values in login credentials
    Given User is on the chrome browser
    Given User is presented in the application
    And   User click the sign In
    When  User enters the null values    
    And   Clicks the sign in button
    Then  User should get error message for null values entered
    And   Browser closes   
    
  
  Scenario: To test with only password entered leaving username blank
    Given User is on the chrome browser
    Given User is presented in the application
    And   User click the sign In
    When  User enters only password
    And   Clicks the sign in button
    Then  User should get error message to enter the missing textfield
    And   Browser closes   
    
  Scenario: To test with only username entered leaving password blank
    Given User is on the chrome browser
    Given User is presented in the application
    And   User click the sign In
    When  User enters only the username
    And   Clicks the sign in button
    Then  User should get error message to enter the missing textfield
    And   Browser closes   
    
  Scenario: To test with short password
    Given User is on the chrome browser
    Given User is presented in the application
    And   User click the sign In
    When  User enters the credentials test@test.com and qwe
    And   Clicks the sign in button
    Then  User should get error message for password length
    And   Browser closes   
    
    