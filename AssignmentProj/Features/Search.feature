
Feature: Validate the search functionality of the application ScienceDirect
  I want to use the search option for different inputs

  
  Scenario Outline: Search option functionality
    Given User is on the chrome browser
    Given User is presented in the application
    When  user enters keyword as "<keyword>" author name as "<authorname>" Book title as "<Booktitle>" volume as "<volume>" issue as "<issue>" pages as "<pages>" in text fields.
    Then  user clicks the search button
    And   user verfies the entry made
		And   Browser closes

    Examples: 
      | keyword    				 | authorname | Booktitle  				         |volume|issue|pages|
      | School Performance | Masood     | Telematics and Informatics |    34|	 	 8|1433 |
      | Schhol Performance | Masood     | Telematics and Informatics |    24|	   3|443	|
      | Nerves|              |  |  |  |  |
      |       | Tulika Gupta |  |  |  |  |
      |agterhy|              |  |  |  |  |
      
   
 
   Scenario: Send the string inside the number only field
   Given User is on the chrome browser
   Given User is presented in the application
   When  User enters the string inside the volume field
   Then  User should get error message for entering string
   And   Browser closes