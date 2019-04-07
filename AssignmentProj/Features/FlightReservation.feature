Feature: Validate the booking functionality of the web page
  I want to book hotels through this web site

  
  Scenario Outline: Checking for VALID and missed inputs to the fields
    Given User is on the chrome browser
    And   User go to the flight application
    When  User enters the details as "<place>" and selects as "<Full Place>" into the fields
    And   User selects the date as "<checkIn>" and date as "<checkOut>" date
    And   User selects the "<number>" for number of person
    Then  User clicks the search
    And   Checks the page
    And   Browser closes
		
		Examples:
		|place|Full Place|checkIn | checkOut | number |
 		|London|London Bridge| 12 | 7 | 1 Adult |
		|Manchester|Manchester Arena| 15 |  | 2 Adults |
		|CB1 0EN|   | 23 | 2 | 2 Adults, 1 Child |
		|London|    | 23 | 9 | more options |
		
	