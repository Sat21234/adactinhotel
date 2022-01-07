package com.adactin.baseclass;
import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassAdactin {

		public static WebDriver driver;

	
		public static WebDriver browserLaunch(String browsername) {
		
		long timeout = 30 ;
			
		if (browsername.equalsIgnoreCase("chrome")) 
		  {
			WebDriverManager.chromedriver().setup();
		   driver = new ChromeDriver();
		  } 
		else if (browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
		   System.out.println("Driver is not defined properly");
		  }
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);	// this is deprecated
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
		return driver;
		  }
		
		public static void getUrl(String url) {
			try {
				driver.get(url);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


		public static void sendkeys(WebElement element, String value) {
			try {
				element.sendKeys(value);
	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void cleartext(WebElement element) {
			element.clear();	
			}

		public static void click(WebElement element) {
			element.click();
		}
		
		public static WebElement findElementBy(String locator, String value) {
			try {
				switch (locator) {
				case "id":
					return driver.findElement(By.id(value));				
				case "name":
					return driver.findElement(By.name(value));				
				case "className":
					return driver.findElement(By.className(value));
				case "tagName":
					return driver.findElement(By.tagName(value));
				case "xpath":
				    return driver.findElement(By.xpath(value));
				case "cssSelector":
					return driver.findElement(By.cssSelector(value));				
				case "linkText":
					return driver.findElement(By.linkText(value));
				case "partialLinkText":
					return driver.findElement(By.partialLinkText(value));				
				default:
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		public static List<WebElement> findElementsBy(String locator, String value) {
			
			switch (locator) {
			case "id":
				return driver.findElements(By.id(value));				
			case "name":
				return driver.findElements(By.name(value));				
			case "className":
				return driver.findElements(By.className(value));
			case "tagName":
				return driver.findElements(By.tagName(value));
			case "xpath":
			    return driver.findElements(By.xpath(value));
			case "cssSelector":
				return driver.findElements(By.cssSelector(value));				
			case "linkText":
				return driver.findElements(By.linkText(value));
			case "partialLinkText":
				return driver.findElements(By.partialLinkText(value));				
			default:
				break;
			}
			return null;
		
			
		}

	///////  Navigate methods    /////////
		public static void navigate() {
			driver.navigate();   // can also return driver 
		}
		
		public static void navigateback() {
			driver.navigate().back();   // can also return driver 
		}
		
		public static void navigateforward() {
			driver.navigate().forward();		
		}
		
		public static void navigateTo(String value) {
			driver.navigate().to(value);
		}
		
		public static void navigateRefresh() {
			driver.navigate().refresh();
		}

	///////    Drop-Down  functions    /////////	
		public static void dropdown(WebElement element, String valueOrText, String value) {
			
			Select sl = new Select(element);
			try {
			switch (valueOrText) {
			 case "value": 
				sl.selectByValue(value);
				break;
			 case "text":
				sl.selectByVisibleText(value);
				break;
			 default:
				break;
				 }
		  } catch (Exception e) {
			e.printStackTrace();
		}
		}
		
		public static void dropdown(WebElement element, int index) {
			
			Select sl = new Select(element);
			sl.selectByIndex(index);
		}
		
		public static void getoptions(WebElement element) {   
			Select sl = new Select(element);
			List<WebElement> options = sl.getOptions();        // print all options-- selected + unselected 
			ArrayList<Object> al = new ArrayList<>();
		    for (WebElement all_options : options) {
				String allOptions = all_options.getText();
				al.add(allOptions);		
			}
		    System.out.println("All available Options: "+ al );
		}
		
		public static void getfirstselectedoption(WebElement element) {
			Select sl = new Select(element);
			WebElement SelectedOption = sl.getFirstSelectedOption();
			String firstSelectedOption = SelectedOption.getText();
			System.out.println("First Selected Option: "+ firstSelectedOption ); // print only first/last selected options (single or multiple)
		}
		
		public static void getallselectedoptions(WebElement element) {
			Select sl = new Select(element);
		    List<WebElement> SelectedOptions = sl.getAllSelectedOptions();
		    ArrayList<Object> al = new ArrayList<>();
		    for (WebElement all_options : SelectedOptions) {
				String allSelectedOptions = all_options.getText();
				al.add(allSelectedOptions);
			}	
		    System.out.println("All Selected Options: "+ al);
		}
		
		public static void ismultiple(WebElement element) {
			Select sl = new Select(element);
			boolean multiple = sl.isMultiple();  // To check whether drop-down box supports multiple select options or not
			System.out.println("supports multiple options? " + multiple);  // returns true or false/null
		}
		
	///  alert   ///	
		public static void alert(String OkorCancel, String value) {
			Alert alert = driver.switchTo().alert();	
			try {
				switch (OkorCancel) {
				case "ok":
					alert.accept();
					break;
				case "cancel":
					alert.dismiss();
					break;
				case "type":
					alert.sendKeys(value);    //cannot getText the entered value  // only window message can be printed
					alert.accept();
					break;
				case "text":
					String text = alert.getText();
					System.out.println(text);
					break;
				default:
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	//////  iframes  ///////
		public static void iframes(WebElement frameElement ) {
			
			driver.switchTo().frame(frameElement);
		}
		
		public static void iframes(String NameOrId) {
			// TODO PASS NAME OR ID OF THE FRAME
			driver.switchTo().frame(NameOrId);
		}
		
		public static void iframes(int index) {
			
			driver.switchTo().frame(index);
		}
		
	// size()  // 	
		public static void size(List<WebElement> elements) {
			System.out.println(elements.size());	// returns int 		
		}
		
	//  getCurrentUrl  &&  getTitle  methods 	
		public static String getcurrenturl() {
			String current_url = driver.getCurrentUrl();
			//System.out.println("Active Tab url: "+ current_url);
			return current_url;
		}
		
		public static void gettitle() {
			String active_title = driver.getTitle();
			System.out.println("Active Tab title "+ active_title);
		}

	//  getText  &&  getAttibute 	
		public static void  gettext(WebElement element) {
			String text = element.getText();
			System.out.println("Text message: "+ text);   // get only the visible text // inapplicable for dynamic text
		
		}	
		public static void getattribute(WebElement element, String attribute) {
			String attribute_text = element.getAttribute(attribute);    // get the invisible text and value of the attribute
			System.out.println("Attribute Text message:" + attribute_text);				// applicable for dynamic text
		}
	// Screenshot 	
		public static void screenshot(String path) throws IOException {
			TakesScreenshot tss = (TakesScreenshot) driver;
			
			File img = tss.getScreenshotAs(OutputType.FILE);
			File destination = new File(path);    // enter the entire path of the folder and name of the image.png
			FileUtils.copyFile(img, destination);
		}
	 //  Scrolling functions ///	
		public static void scroll(String x, String y) {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scroll(" +x+ "," +y+ ")");
			
		}
		public static void scroll(WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		}
		
		public static void scroll(String TopOrBottom) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			switch (TopOrBottom) {
			case "bottom":
				js.executeScript("window.scrollTo(0,document.body.scrollHeight)", " ");
				break;
			case "top":
				js.executeScript("window.scrollTo(0,-document.body.scrollHeight)", " ");
			default:
				break;
			}
		}
//////////	    Actions  - mouse functions   ////////	
		
		public static void movetoelement(WebElement element) {
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();	
		}
		
		public static void contextclick(WebElement element)  {
			Actions builder = new Actions(driver);
			builder.contextClick(element).perform();
		}
		
		public static void doubleclick(WebElement element) {
			Actions builder = new Actions(driver);
			builder.doubleClick(element).perform();
		}
		
		public static void draganddrop(WebElement source, WebElement target) {
			Actions builder = new Actions(driver);
			builder.dragAndDrop(source, target).perform();
			
		}
		
		public static void draganddropby(WebElement element, int x, int y) {
			Actions builder = new Actions(driver);
			builder.dragAndDropBy(element, x, y).perform();
		}

	////// Robot - keyboard functions //////
		
		public static void keypress(int value) throws AWTException {
			Robot robot = new Robot();
			robot.keyPress(value);	
		}
		
		public static void keyrelease(int value ) throws AWTException {   // AWT - Abstract Window Toolkit
			Robot robot = new Robot();
			robot.keyRelease(value);	
		}
		
	//// Window handling ////	
		
		public static String windowhandle() {
			String handle = driver.getWindowHandle();
			return handle;
		}
		
		public static Set<String> windowhandles() {
			Set<String> handles = driver.getWindowHandles();
			return handles;
		}

		// Switch to window by index 
		public static void switchtowindow(Collection<? extends String> windowhandles, int index) {
			List<String> list = new ArrayList();
			list.addAll(windowhandles);
			driver.switchTo().window(list.get(index));		
		}
		
		// Switch to window by handle name
		public static void switchtowindow(String handle) {
			driver.switchTo().window(handle);
		}
		
		// Switch to window by page title
		public static void switchtowindow(Set<String> windowhandles, String title) {
			
			for (String each : windowhandles) {
				if (driver.switchTo().window(each).getTitle().equals(title)) 
				{
					break;
				}		
			}
		}
		
		// To get the titles of all the windows & Automatically switch to last window
		public static void alltitles(Set<String> windowhandles) {
			ArrayList<Object> al= new ArrayList<>();
			for (String each_window : windowhandles) {
				String titles = driver.switchTo().window(each_window).getTitle();       // automatically switched to last window (child2)
				al.add(titles);		
			}
			System.out.println("Titles of each windows: " + al);
		}
		
		// Close particular tab by Title
		public static void closetab(Set<String> windowhandles, String title) {
			for (String close : windowhandles) 
			{
				String close_titles = driver.switchTo().window(close).getTitle();
				
				if (close_titles.contains(title))
				{
					driver.close();	 
				}
			}
		}
		
		//close particular tab by index 
		public static void closetab(Collection<? extends String> windowhandles, int index) {
			List<String> list = new ArrayList();
			list.addAll(windowhandles);
			driver.switchTo().window(list.get(index)).close();		
		}
		
		// close particular tab by handle name
		public static void closetab(String windowhandles) {
			driver.switchTo().window(windowhandles).close();
		}
		
		// close all Tabs except PARENT Tab
		public static void closetabexcept(Set<String> windowhandles, String parentwindow ) {
			for (String childs : windowhandles) 
			{
			  if(!childs.equals(parentwindow))   // child != parent --> close()
			  {    
				  driver.switchTo().window(childs).close();    // switchTo child and close  ---> done for all the childs except parent
				  										
			  }							
			}
		}
		
// Wait 
		// Implicit wait 
		public static void implicitWait(long seconds) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
		}
		
		// Explicit wait
		public static  WebDriverWait explicitWait(WebDriver driver, long seconds) {
		WebDriverWait wait=	new WebDriverWait(driver, Duration.ofSeconds(seconds));
			return wait;
			
		}
		
	///// print function ///	
		public static void println(String value) {
			System.out.println(value);
		}	
		public static void println(Set<String> value) {
			System.out.println(value);
		}
		public static void println(List<String> value) {
			System.out.println(value);
		}
		
		public static void number(int num) {
			int i = num;
			System.out.println(i);
		}
}