package testBase;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import commonMethods_reusableComponents.CommonMethods;
import pageObjects.EnterInsurantDataPageObjects;
import pageObjects.EnterProductDataPageObjects;
import pageObjects.EnterVehicleDataPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.SelectPriceOptionsPageObjects;

public class ObjectsRepo  {
	
	// static is very first thing get memory, before any objects get created this static will get space in memory
	// ie get initiazed 
	// for every thing we need driver when the driver will get initialized in 
	// LaunchBrowserAndNavigate();
	// that's the reason after launching the browser we are initiliazing the 
	// ex: home = new HomePageObjects and vehData = new EnterVehicalDataPageObjects();
	
	
	public static WebDriver driver;
	
	public static ExtentReports extent;
	
	public static ExtentTest test;
	
	public static HomePageObjects home;
	
	public static EnterVehicleDataPageObjects vehData;
	
	public static EnterInsurantDataPageObjects insData;
	
	public static EnterProductDataPageObjects prodData;
	
	public static SelectPriceOptionsPageObjects priceOptions;
	// and we are initiazing in test base then only we get some value for driver after method
	// launch and navigate().
	
	public CommonMethods cm = new CommonMethods();
	

}
