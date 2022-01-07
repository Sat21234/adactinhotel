package adactin.check;

import org.openqa.selenium.WebElement;

import com.adactin.baseclass.BaseClassAdactin;

import junit.framework.Assert;

public class LoginpageCheck extends BaseClassAdactin{

	public static void main(String[] args) {
		
		//browserLaunch("chrome");
		
		//getUrl("https://adactinhotelapp.com/");
		
		// positive scenario 
		/*
		WebElement user = findElementBy("id","username");
		user.sendKeys("sainath2506");
		WebElement pass = findElementBy("id", "password");
		pass.sendKeys("adactinhotel");
		WebElement loginbutton = findElementBy("id","login");
		click(loginbutton);
		String url = getcurrenturl();
		//System.out.println(url);
		Assert.assertEquals(url,"https://adactinhotelapp.com/SearchHotel.php","not matched");
	*/
		// Negative scenario
		/*
		WebElement user1 = findElementBy("id","username");
		user1.sendKeys("invalidusername");
		WebElement pass1 = findElementBy("id", "password");
		pass1.sendKeys("invalidpassword");
		WebElement loginbutton1 = findElementBy("id","login");
		click(loginbutton1);
		WebElement msg = findElementBy("xpath", "//table[@class='login']/tbody/tr[5]/td[2]/div/b/text()[1]");
		String text = msg.getText();
		
		Assert.assertEquals(text,
		"Invalid Login details or Your Password might have expired. Click here to reset your password",
		"notmatched");
	*/
		
		System.out.println("--before assertion--");	// will execute
		String actual = "welcome";  
		String expected = "welcome";
		org.junit.Assert.assertEquals(actual,expected,"Data Mismatch");
		//Assert.assertEquals(actual, expected,"Data mismatch"); // failed 
		System.out.println("--after asserion--"); // will not execute
	}
}
