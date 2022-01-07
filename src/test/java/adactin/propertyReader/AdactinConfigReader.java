package adactin.propertyReader;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileReader;
import java.util.Properties;

public class AdactinConfigReader {
	
	static Properties prop;

	public AdactinConfigReader() throws Throwable {
		File file = new File(".\\src\\test\\java\\adactin\\propertyfile\\Configuration.properties");
		FileInputStream fis = new FileInputStream(file);
		prop = new Properties();
		prop.load(fis);
	}
	
	public String getBrowser() {
		String browser = prop.getProperty("browser");
		return browser;
	}

	public String getURL() {
		String url = prop.getProperty("url");
		return url;
	}
	
	public String getFirstName() {
		String firstName = prop.getProperty("firstname");
		return firstName;
	}
	
	public String getLastName() {
		String lastName = prop.getProperty("lastname");
		return lastName;
	}
	
	public String getBillingAddress() {
		String billingAddress = prop.getProperty("billingaddress");
		return billingAddress;
	}
	
	
	public String getCreditCardNumber() {
		String creditCardNumber = prop.getProperty("credit_card_number");
		return creditCardNumber;
	}
	
	
	public String getCvv() {
		String cvv = prop.getProperty("cvv");
		return cvv;
	}
}
