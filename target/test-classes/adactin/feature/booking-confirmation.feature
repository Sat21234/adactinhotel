@BookingConfirmation
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

@Continue
Scenario: User select the hotel and click continue
	Given user select the hotel
	 Then user clicks the continue button
	  And verify that user navigates to personal details section
	  
@Cancel
Scenario: User select the hotel and click cancel
	Given user select the hotel
	 Then user clicks the cancel button
	  And verify that user navigates back to search hotel page
