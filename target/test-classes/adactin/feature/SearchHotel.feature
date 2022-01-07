@searchhotel
Feature: Testing Adactin hotel room booking

Background: 
		 Given this is background statement

Scenario: Verify that user is able to login the application	
	Given User launch the application 
    When  User enters the "sainath2506" in the username field
    And   User enters the valid password in the password field
    And   User clicks on the login button

@Registration 
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
     Then verify the user navigates to confirmation page 
     
@BookedItinerary
Scenario: verify that user is able to navigate to Booked Itinerary page
	Given User clicks the booked iternary link 
	Then  Verify that user navigates to booked itinerary page
	
@ChangePassword	
Scenario: verify that user is able to change the password 
	Given User clicks the change password link 
	Then  Verify that user navigates to change password page

@Logout
Scenario: verify that user is able to logout
	Given User clicks the logout link 
	 Then Verify that user navigates to logout page	
	 Then verify that user can navigate back to previous page from logout page
	