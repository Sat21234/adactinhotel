package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalSection {
	public WebDriver driver;
	
	public PersonalSection(WebDriver ldriver) {
		driver = ldriver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(id = "first_name")
	private WebElement firstname;
	
	@FindBy(id = "last_name")
	private WebElement lastname;
	
	@FindBy(id = "address")
	private WebElement address;
	
	@FindBy(id = "cc_num")
	private WebElement creditcardnumber;
	
	@FindBy(id = "cc_type")
	private WebElement creditcardtype;
	
	@FindBy(id = "cc_exp_month")
	private WebElement creditcardexpmonth;
	
	@FindBy(id = "cc_exp_year")
	private WebElement creditcardexpyear;
	
	@FindBy(id = "cc_cvv")
	private WebElement cvvnumber;
	
	@FindBy(id = "book_now")
	private WebElement booknow;
	
	@FindBy(id = "cancel")
	private WebElement cancel;
	
	@FindBy(xpath = "//table[@class='login']/tbody/tr[1]/td/a/text()")
	private WebElement back;
	
	
	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCreditcardnumber() {
		return creditcardnumber;
	}

	public WebElement getCreditcardtype() {
		return creditcardtype;
	}

	public WebElement getCreditcardexpmonth() {
		return creditcardexpmonth;
	}

	public WebElement getCreditcardexpyear() {
		return creditcardexpyear;
	}

	public WebElement getCvvnumber() {
		return cvvnumber;
	}

	public WebElement getBooknow() {
		return booknow;
	}

	public WebElement getCancel() {
		return cancel;
	}

	public WebElement getBack() {
		return back;
	}
	
}
