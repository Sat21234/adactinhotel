package adactin.stepdefinition;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.adactin.baseclass.BaseClassAdactin;
import com.pomManager.AdactinPomManager;

import adactin.propertyManager.AdactinFileManager;
import adactin.propertyReader.AdactinConfigReader;
import adactin.runner.AdactinTestRunner;
import io.cucumber.java.en.*;

public class AdactinSteps extends BaseClassAdactin {
	
	public static WebDriver driver = AdactinTestRunner.driver;
	AdactinPomManager pm = new AdactinPomManager(driver);
	
	@Given("this is background statement")
	public void this_is_background_statement() {
		System.out.println("This is a background statement");
	}
	
	// Positive Login Page test Scenario
	@Given("^User launch the application$")
	 public void user_launch_the_application() throws Throwable {
		getUrl(pm.conReader().getURL());
	}
	
	@When("User enters the {string} in the username field")
	public void user_enters_the_in_the_username_field(String username) {
			sendkeys(pm.loginpage().getUsertxt(),username);
	}

	@When("^User enters the valid password in the password field$")
	public void user_enters_the_valid_password_in_the_password_field() {
			sendkeys(pm.loginpage().getPasstxt(),"adactinhotel");
	}

	@When("^User clicks on the login button$")
	public void user_clicks_on_the_login_button(){
	   click(pm.loginpage().getLoginbutton());
	}
	
	@Then("^User verify the homepage navigates to search hotel$")
	public void user_verify_the_homepage_navigates_to_search_hotel() throws Throwable{
		
		try {
			if (getcurrenturl().contains("SearchHotel")) {
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Logged in with Invalid credentials");
		}
	}
	
	// Negative Login page Test Scenario
	@When("User enters the invalid {string} and invalid {string} in the respective field")
	public void user_enters_the_invalid_and_invalid_in_the_respective_field(String username, String password) {
			sendkeys(pm.loginpage().getUsertxt(), username);
			sendkeys(pm.loginpage().getPasstxt(), password);
	}

	@Then("verify the loginpage display the message for invalid login.")
	public void verify_the_loginpage_display_the_message_for_invalid_login() {
		try {
			if (getcurrenturl().contains("SearchHotel")) {
				Assert.fail("Logged in with Invalid credentials");
			}
		} catch (Exception e) {
			//e.printStackTrace();
		}
		
		
	}
////////  Hotel room booking ///////
	@Given("User selects the location")
	public void user_selects_the_location() {
		dropdown(pm.searchHotel().getLocation(), "value", "Melbourne");
	}

	@When("User selects the hotel")
	public void user_selects_the_hotel() {
		dropdown(pm.searchHotel().getHotel(), "value", "Hotel Sunshine");
	}

	@Then("User selects the room type")
	public void user_selects_the_room_type() {
		dropdown(pm.searchHotel().getRoomtype(), "value", "Deluxe");
	}

	@Then("User selects the number of rooms")
	public void user_selects_the_number_of_rooms() {
		dropdown(pm.searchHotel().getRoomnos(), "value", "1");
	}

	@Then("User selects the check-in date")
	public void user_selects_the_check_in_date() {
		cleartext(pm.searchHotel().getDatein());
		sendkeys(pm.searchHotel().getDatein(),"01-01-2022");
	}

	@Then("User selects the check-out date")
	public void user_selects_the_check_out_date() {
		cleartext(pm.searchHotel().getDateout());
		sendkeys(pm.searchHotel().getDateout(),"07-01-2022");
	}

	@Then("User selects the adult per room")
	public void user_selects_the_adult_per_room() {
		dropdown(pm.searchHotel().getAdultroom(), "value", "2");
	}

	@Then("User selects the child per room")
	public void user_selects_the_child_per_room() {
		dropdown(pm.searchHotel().getChildroom(), "value", "0");
	}

	@Then("User clicks the submit button")
	public void user_clicks_the_submit_button() {
		click(pm.searchHotel().getSubmit());
	}
	
	@Then("verify the user navigates to confirmation page")
	public void verify_the_user_navigates_to_confirmation_page() {
		//Assert.assertEquals("getcurrenturl()","https://adactinhotelapp.com/SelectHotel.php","URL matched");
	}

// Booked Itinerary
	@Given("User clicks the booked iternary link")
	public void user_clicks_the_booked_iternary_link() {
		click(pm.searchHotel().getBookedItinerary());
	}

	@Then("Verify that user navigates to booked itinerary page")
	public void verify_that_user_navigates_to_booked_itinerary_page() {
		try {
			if (getcurrenturl().contains("BookedItinerary")) {
			 	
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("URL not matched");
		}
	}

	@Given("User clicks the change password link")
	public void user_clicks_the_change_password_link() {
		click(pm.searchHotel().getChangePassword());
	}

	@Then("Verify that user navigates to change password page")
	public void verify_that_user_navigates_to_change_password_page() {
		try {
			if (getcurrenturl().contains("ChangePassword")) {
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("URL not matched");
		}
	}

	@Given("User clicks the logout link")
	public void user_clicks_the_logout_link() {
		click(pm.searchHotel().getLogout());
	}

	@Then("Verify that user navigates to logout page")
	public void verify_that_user_navigates_to_logout_page() {
		try {
			if (getcurrenturl().contains("Logout")) {
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("URL not matched");
		}
	}

	@Then("verify that user can navigate back to previous page from logout page")
	public void verify_that_user_can_navigate_back_to_previous_page_from_logout_page() throws Throwable {
		navigateback();
		try {
			if (getcurrenturl().equals(pm.conReader().getURL())) {
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("URL is not matched");
		}
	}
	
// Confirmation page
	@Given("user select the hotel")
	public void user_select_the_hotel() {
		click(pm.bookingConfirm().getSelect_button());
	}
	

	@Then("user clicks the continue button")
	public void user_clicks_the_continue_button() {
		click(pm.bookingConfirm().getContinue_button());
	}

	@Then("verify that user navigates to personal details section")
	public void verify_that_user_navigates_to_personal_details_section() {
		try {
			if (getcurrenturl().contains("BookHotel")) {
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("URL is not matched");
		}
		//navigateback();
	}
	
	@Then("user clicks the cancel button")
	public void user_clicks_the_cancel_button() {
		click(pm.bookingConfirm().getCancel_button());
	}

	@Then("verify that user navigates back to search hotel page")
	public void verify_that_user_navigates_back_to_search_hotel_page() {
//		try {
//			if (getcurrenturl().contains("SearchHotel")) {
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			Assert.fail("URL is not matched");
//		}
	}
	
// Personal details section
	@Given("user enters the first name")
	public void user_enters_the_first_name() throws Throwable {
		sendkeys(pm.personalSection().getFirstname(), pm.conReader().getFirstName());
	}

	@Then("user enters the last name")
	public void user_enters_the_last_name() throws Throwable {
		sendkeys(pm.personalSection().getLastname(), pm.conReader().getLastName());
	}

	@Then("user enters the billing address")
	public void user_enters_the_billing_address() throws Throwable {
		sendkeys(pm.personalSection().getAddress(), pm.conReader().getBillingAddress());
	}

	@Then("user enters the sixteen digit credit card number")
	public void user_enters_the_sixteen_digit_credit_card_number() throws Throwable {
		sendkeys(pm.personalSection().getCreditcardnumber(), pm.conReader().getCreditCardNumber());
	}
	
	@Then("user selects the credit card type")
	public void user_selects_the_credit_card_type() {
		dropdown(pm.personalSection().getCreditcardtype(), "value","VISA");
	}
	

	@Then("user selects the expiry date of the credit given credit card")
	public void user_selects_the_expiry_date_of_the_credit_given_credit_card() {
		dropdown(pm.personalSection().getCreditcardexpmonth(), "text","June");
		dropdown(pm.personalSection().getCreditcardexpyear(), "value","2022");
	}

	@Then("user enters the cvv number of the given credit card")
	public void user_enters_the_cvv_number_of_the_given_credit_card() throws Throwable {
		sendkeys(pm.personalSection().getCvvnumber(), pm.conReader().getCvv());
	}
	
	@Then("user enters the book now button")
	public void user_enters_the_book_now_button() throws Throwable {
		click(pm.personalSection().getBooknow());
		Thread.sleep(3000);
	}
	
	@Then("verify that user navigates to booking confirmation page")
	public void verify_that_user_navigates_to_booking_confirmation_page() throws Throwable {

		//Thread.sleep(3000);													// Thread.sleep can be used
		WebDriverWait wait = BaseClassAdactin.explicitWait(driver,30);			// Explicit wait through baseclass 	
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));	// Explicit wait through object creation	 	
		wait.until(ExpectedConditions.urlToBe("https://adactinhotelapp.com/BookingConfirm.php"));
		try {
			Assert.assertEquals("https://adactinhotelapp.com/BookingConfirm.php",getcurrenturl());
		} catch (Exception e) {
		e.printStackTrace();
		Assert.fail("URL is not matched");
		}
		
	}
}


// Note: 		
//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);    --> this is depricated
//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));		
