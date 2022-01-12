package insuranceCalculation_Motorcycle;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import testBase.TestBase;

public class ErrorTests_motorcycle extends TestBase {
	
	
	@Test (enabled = false)
	public void errorMessage_PayLoadField() throws InterruptedException {
		// Open browser and navigate handled in before method.
		// click on motor cycle, present on home page.
		Thread.sleep(2000);
		home.clickOnMotorCycleLink();
		// Enter cylinder capacity value.
		//Note: As per the business logic we will not get send value using senkeys in test case so we will create a method in "EnterVehicleDataPage"
		// and send fetch value from there.
		//vehData.txt_cylindercapacity.sendKeys("33333");
		vehData.enterCylinderCapacity("33333");
		// log the status
		test.log(Status.PASS, "Cylinder capacity is filled with data: 33333");
		
		// verify error message
		
		String actualErrorMessage = vehData.getErrorMessageOnCylinderCapacity();
		String expectederrorMessage = "dummy";
		Assert.assertEquals(actualErrorMessage, expectederrorMessage, "Error message is not as expected on cylinder capacity field");
		// Note: before above steps we need to extend the test base in all pages class as we need driver.
	}

	@Test (enabled = true)
	public void verifyModelDropdownOptions() throws InterruptedException {
		
		// click on motorcyclelink
		Thread.sleep(10000);
		home.clickOnMotorCycleLink();
		
		// get drop down list content
		List<String> actualvalues = vehData.getDropdownOption_model();
		
		test.log(Status.INFO, "Actual dd contents for model dd is:" +actualvalues);
		// Expected values
		List<String> expectedvalues = Arrays.asList("- please select -", "Scooter", "Three-Wheeler", "Moped", "Motorcycle");
		test.log(Status.INFO, "Expected dd contents for model dd is:" +expectedvalues);
		// compare assert
		Assert.assertEquals(actualvalues, expectedvalues, "Error in DropDown options compare at model dropdown");
		
		
	}
}
