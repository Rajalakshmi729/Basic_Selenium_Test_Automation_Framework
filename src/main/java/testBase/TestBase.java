package testBase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import commonMethods_reusableComponents.PropertiesOperations;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.EnterInsurantDataPageObjects;
import pageObjects.EnterProductDataPageObjects;
import pageObjects.EnterVehicleDataPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.SelectPriceOptionsPageObjects;

public class TestBase extends ObjectsRepo {

	public void LaunchBrowserAndNavigate() throws IOException {
		//Launch browser
		//navigate URL
		//String browser = "chrome";
		
		String browser = PropertiesOperations.getPropertyValueByKey("browser");
		String url = PropertiesOperations.getPropertyValueByKey("url");
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get(url);
	}	
		@BeforeMethod
		public void setUpMethod() throws IOException {
			LaunchBrowserAndNavigate();
			home = new HomePageObjects();
			 vehData = new EnterVehicleDataPageObjects();
			 insData = new EnterInsurantDataPageObjects();
			 prodData = new EnterProductDataPageObjects();
			priceOptions = new SelectPriceOptionsPageObjects();
		}
		
		@AfterMethod
		public void cleanUp() {
			//driver.quit();
		}
		
		
	}


