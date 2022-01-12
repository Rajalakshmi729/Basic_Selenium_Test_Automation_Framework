package insuranceCalculation_Motorcycle;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commonMethods_reusableComponents.ExcelOperations;
import testBase.TestBase;

public class EndToEndTests_motorcycle extends TestBase {
	
	ExcelOperations excel = new ExcelOperations("InsurancePremium");
		
	@Test(dataProvider = "vehData")
	public void insuranceCalculate(Object obj1) throws Exception { 
		
	HashMap<String, String> testData = (HashMap<String, String>) obj1;
	
	test.log(Status.INFO, "Test data used for execution is:"+ testData);
	System.out.println("Test Data is:" + testData);
		home.clickOnMotorCycleLink();
		vehData.enterVehicleData(testData);
		vehData.clickOnNextButton();
		insData.enterInsurantData(testData);
		insData.clickOnNextButton();
		prodData.enterProductData(testData);
		prodData.clickOnNextButton();
		
		String expectedSilverPlanPrice = "333.33";
		String actual = priceOptions.getPriceForSelectedOption("Silver");
		
		//Assert.assertEquals(actual, expectedSilverPlanPrice);
		Assert.assertEquals(priceOptions.getPriceForSelectedOption("Gold"), testData.get("PriceValidation_Gold"), "Pricing for gold plan is not matching");
		Assert.assertEquals(priceOptions.getPriceForSelectedOption("Silver"), testData.get("PriceValidation_Silver"), "Pricing for silver plan is not matching");
		Assert.assertEquals(priceOptions.getPriceForSelectedOption("Platinum"), testData.get("PriceValidation_Platinum"), "Pricing for Platinum plan is not matching");
		Assert.assertEquals(priceOptions.getPriceForSelectedOption("Ultimate"), testData.get("PriceValidation_Ultimate"), "Pricing for Ultimate plan is not matching");
		//priceOptions.selectPriceOption("Silver");
		priceOptions.selectPriceOption(testData.get("SelectOption"));
		priceOptions.clickOnNextButton();
	}
	
	@DataProvider(name = "vehData")
	// note dataprovider can return either object array or string array not as hashmap
	public Object[][] testDataSupplier() throws Exception{
		
		//Object[][] obj = new Object[3][1];
		// why 1 column all cols we are reading in one hash map, instead no.of rows no.of parameters we pass.
		// 3 rows represents three set of data.
		Object[][] obj = new Object[excel.getRowCount()][1];
		
		for(int i=1; i<= excel.getRowCount(); i++) {
			
			HashMap<String, String> testData = excel.getTestDataInMap(i);
			obj[i-1][0] = testData;
			
		}
		
		return obj;
	}
	
	

}
