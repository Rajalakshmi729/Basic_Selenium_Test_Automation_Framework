package pageObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import testBase.TestBase;

public class EnterVehicleDataPageObjects extends TestBase {
	
	@FindBy(id = "make")
	WebElement dd_make;
	
	@FindBy(xpath = "//select[@id='make']")
	WebElement dd_model;
	
	@FindBy(xpath = "//input[@id='cylindercapacity']/following-sibling::span@class='error']")
	WebElement error_cylinderCapacity;
	
	//Note: default will be visible inside the same class even if we extend this class in some other class.
	// If we make it public then only it will be visible to the other class while extending.

	@FindBy(id = "cylindercapacity")
	WebElement txt_cylindercapacity;
	
	@FindBy(id = "engineperformance")
	WebElement txt_engineperformance;
	
	@FindBy(id ="dateofmanufacture")
	WebElement date_dateofmanufacture;
	
	@FindBy(id = "numberofseatsmotorcycle")
	WebElement dd_numberofseatsmotorcycle;
	
	@FindBy(id = "listprice")
	WebElement txt_listprice;
	
	@FindBy(id = "annualmileage")
	WebElement txt_annualmileage;
	
	@FindBy(id = "nextenterinsurantdata")
	WebElement nxt_btn;
	
	public EnterVehicleDataPageObjects() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void enterCylinderCapacity(String cylinderCap) {
		
		txt_cylindercapacity.sendKeys(cylinderCap);
	}

	public String getErrorMessageOnCylinderCapacity() {
		return error_cylinderCapacity.getText();
	}
	public List<String> getDropdownOption_model(){
		return cm.getDropdownOption_model(dd_model);
	}
	public List<String> getDropdownOption_make(){
		return cm.getDropdownOption_model(dd_make);
	}
	// move this method to common method
	//public void selectDropdownOption() {
		
		//Select os = new Select(dd_make);
		//os.selectByVisibleText("BMW");
	//}
	
	public void enterVehicleData(HashMap<String, String> testData) throws Exception {
		
		//cm.selectDropdownOption(dd_make, "BMW");
		cm.selectDropdownOption(dd_make, testData.get("Vehicle_Make"));
		//cm.selectDropdownOption(dd_model, "Moped");
		cm.selectDropdownOption(dd_model, testData.get("Vehicle_Model"));
	//	txt_cylindercapacity.sendKeys("333");
		txt_cylindercapacity.sendKeys(testData.get("Vehicle_CylinderCapacity"));
	//	txt_engineperformance.sendKeys("555");
		txt_engineperformance.sendKeys(testData.get("Vehicle_Engine Performance"));
	//	date_dateofmanufacture.sendKeys("12/12/2006");
		date_dateofmanufacture.sendKeys(testData.get("Vehicle_Date of Manufacture"));
		// cm.selectDropdownOption(dd_numberofseatsmotorcycle, "2");
		cm.selectDropdownOption(dd_numberofseatsmotorcycle, testData.get("Vehicle_No of Seats_motorcycle"));
		//txt_listprice.sendKeys("600");
		txt_listprice.sendKeys(testData.get("Vehicle_List Price"));
		//txt_annualmileage.sendKeys("555");		
		txt_annualmileage.sendKeys(testData.get("Vehicle_Annual Mileage"));
		
	}
	public void clickOnNextButton() {
	
		nxt_btn.click();
	}
}
