package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotel {

	public WebDriver driver;
	
	
	public SearchHotel(WebDriver ldriver) {
		driver = ldriver;
		PageFactory.initElements(driver, this);
	}
	
	

	@FindBy(id = "location")
	private WebElement location;

	@FindBy(id = "hotels")
	private WebElement hotel;
	
	@FindBy(id = "room_type")
	private WebElement roomtype;
	
	@FindBy(id = "room_nos")
	private WebElement roomnos;
	
	@FindBy(id = "datepick_in")
	private WebElement datein;
	
	@FindBy(id = "datepick_out")
	private WebElement dateout;
	
	@FindBy(id = "adult_room")
	private WebElement adultroom;
	
	@FindBy(id = "child_room")
	private WebElement childroom;
	
	@FindBy(id = "Submit")
	private WebElement submit;
	
	@FindBy(id = "Reset")
	private WebElement reset;
	
// Book Itinerary 
	@FindBy(xpath = "//a[text()='Booked Itinerary']" )		//link text --> xpath
	private WebElement bookedItinerary;
	
// Change password
	@FindBy(linkText = "Change Password" )	//link text
	private WebElement changePassword;
	
// Logout
	@FindBy(linkText = "Logout" )		   //link text
	private WebElement logout;
	
	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotel() {
		return hotel;
	}

	public WebElement getRoomtype() {
		return roomtype;
	}

	public WebElement getRoomnos() {
		return roomnos;
	}

	public WebElement getDatein() {
		return datein;
	}

	public WebElement getDateout() {
		return dateout;
	}

	public WebElement getAdultroom() {
		return adultroom;
	}

	public WebElement getChildroom() {
		return childroom;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public WebElement getReset() {
		return reset;
	}
	
	public WebElement getBookedItinerary() {
		return bookedItinerary;
	}

	public WebElement getChangePassword() {
		return changePassword;
	}

	public WebElement getLogout() {
		return logout;
	}
	
}

