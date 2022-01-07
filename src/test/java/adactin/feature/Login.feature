@login
Feature: Testing Adactin login page

@validlogin
Scenario: Verify that user is able to login the application with valid credentials	
	Given User launch the application 
    When  User enters the "sainath2506" in the username field
    And   User enters the valid password in the password field
    And   User clicks on the login button
    Then  User verify the homepage navigates to search hotel  
    
@invalidlogin
Scenario Outline: Verify that user is not able to login the application with invalid credentials
	Given User launch the application 
    When  User enters the invalid "<username>" and invalid "<password>" in the respective field
    And   User clicks on the login button
    Then  User verify the homepage navigates to search hotel
    Then  verify the loginpage display the message for invalid login.
    
    Examples: 
    |username|password|
    |user001|pass001|
    |user002|pass002|
    |user003|pass003|
