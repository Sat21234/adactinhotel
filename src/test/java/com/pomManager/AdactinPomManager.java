package com.pomManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.adactin.baseclass.BaseClassAdactin;
import com.pom.BookingConfirmationPom;
import com.pom.LoginPagePOM;
import com.pom.PersonalSection;
import com.pom.SearchHotel;

import adactin.propertyReader.AdactinConfigReader;

public class AdactinPomManager {

	public  WebDriver driver;
	private LoginPagePOM lp;
	private BaseClassAdactin bcp;
	private AdactinConfigReader con;
	private SearchHotel sh;
	private BookingConfirmationPom bc;
	private PersonalSection ps;
	
	
	public AdactinPomManager(WebDriver mdriver) {
		this.driver = mdriver;
	}
	
	public BaseClassAdactin baseClass() {
	    bcp = new BaseClassAdactin(); 
	    return bcp;
	}

	public AdactinConfigReader conReader() throws Throwable {
		con = new AdactinConfigReader();
		return con;
	}
	
	public LoginPagePOM loginpage() {
		lp = new LoginPagePOM(driver);
		return lp;
	}
	
	public SearchHotel searchHotel() {
		sh = new SearchHotel(driver);
		return sh;
	}
	
	public BookingConfirmationPom  bookingConfirm() {
		bc = new BookingConfirmationPom(driver);
		return bc;
	}
		
	public PersonalSection  personalSection() {
		ps = new PersonalSection(driver);
		return ps;
	}

		
}