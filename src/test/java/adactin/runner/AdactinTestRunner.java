package adactin.runner;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import com.adactin.baseclass.BaseClassAdactin;
import adactin.propertyManager.AdactinFileManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)    
@CucumberOptions(features = "src//test//java//adactin//feature//personal-details.feature",
			glue ="adactin\\stepdefinition",
			dryRun = false,
			monochrome = true,
			//strict = false,
			plugin = {"pretty", "html:reports/adactin-report.html", 
					  "rerun:failed-scenarios/failed-testcases.txt"}
			//tags = ("@Personaldetails")
				)
			
public class AdactinTestRunner {
	public static WebDriver driver;
	
	@BeforeClass
	public static void browser() throws Throwable  {
		String browser = AdactinFileManager.configReader().getBrowser();
		driver = BaseClassAdactin.browserLaunch(browser);
	}
}
