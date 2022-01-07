package adactin.stepdefinition;
import com.adactin.baseclass.BaseClassAdactin;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;

public class AdactinHooks extends BaseClassAdactin{

	@Before
	public void beforeHooks(Scenario scenario) {
		String name = scenario.getName();    	
		System.out.println("Scenario title: "+ name);
	
		
	}
	
	@After
	public void afterHooks(Scenario scenario) throws Throwable {
		Status status = scenario.getStatus();
		System.out.println("Scenario status: "+ status);
		
		if (scenario.isFailed()) {
			screenshot("C:\\Users\\HP\\eclipse-workspace\\Adactin-project\\Failed Screenshot\\img.png");
		}
	}
	
}


// Note: Scenario --> Interface, import from cucumber
// @Before - import from cucumber