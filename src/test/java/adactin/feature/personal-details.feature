@Personaldetails
Feature: Testing Adactin hotel room booking

Scenario: Verify that user is able to login the application	
	Given User launch the application 
    When  User enters the "sainath2506" in the username field
    And   User enters the valid password in the password field
    And   User clicks on the login button
    
    
Scenario: Verify that user is able to book the hotel room 

	Given User selects the location
     When User selects the hotel  
     Then User selects the room type
      And User selects the number of rooms
      And User selects the check-in date
      And User selects the check-out date
      And User selects the adult per room
      And User selects the child per room
      And User clicks the submit button


Scenario: User select the hotel and click continue
	Given user select the hotel
	 Then user clicks the continue button
	  And verify that user navigates to personal details section
	  
@Personaldetails
Scenario: User gives their personal details in the respective fields
	Given user enters the first name 
	 Then user enters the last name
	  And user enters the billing address
	  And user enters the sixteen digit credit card number 
	  And user selects the credit card type
	  And user selects the expiry date of the credit given credit card
	  And user enters the cvv number of the given credit card
	  And user enters the book now button	 
	  And verify that user navigates to booking confirmation page

