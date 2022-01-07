package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPagePOM {

	public WebDriver driver;
	
	public LoginPagePOM(WebDriver ldriver) {
		driver = ldriver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(id ="username")    
	private  WebElement usertxt;
	
	@FindBy(id ="password")
	private  WebElement passtxt;
	
	@FindBy(id ="login")
	private WebElement loginbutton;
	
	@FindBy(xpath ="//table[@class=\"login\"]/tbody/tr[5]/td[2]/div/b")
	private WebElement invalidmsg;
	


	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getUsertxt() {
		return usertxt;
	}

	public WebElement getPasstxt() {
		return passtxt;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}
	
	public WebElement getInvalidmsg() {
		return invalidmsg;
	}


}