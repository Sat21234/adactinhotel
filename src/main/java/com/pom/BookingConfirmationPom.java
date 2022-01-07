package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingConfirmationPom {
	
	
	public WebDriver driver;
	
	
	public BookingConfirmationPom(WebDriver ldriver) {
		driver = ldriver;
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getSelect_button() {
		return select_button;
	}

	public WebElement getContinue_button() {
		return continue_button;
	}

	public WebElement getCancel_button() {
		return Cancel_button;
	}


	@FindBy(id ="radiobutton_0")
	private WebElement select_button;
	
	@FindBy(name = "continue")
	private WebElement continue_button;
	
	@FindBy(name = "Cancel")
	private WebElement Cancel_button;
}
