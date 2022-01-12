package pageObjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class EnterInsurantDataPageObjects extends TestBase {
	
	@FindBy(id = "firstname")
	WebElement txt_firstname;
	
	@FindBy(id = "lastname")
	WebElement txt_lastname;
	
	@FindBy(id = "birthdate")
	WebElement date_birthdate;
	
	@FindBy(xpath = "//input[@name='Gender']/parent::label")
	List<WebElement> rdo_gender;
	
	@FindBy(id = "streetaddress")
	WebElement txt_StAddr;
	
	@FindBy(xpath = "//select[@id ='country']")
	WebElement dd_country;
	
	@FindBy(id = "zipcode")
	WebElement txt_zipcode;
	
	@FindBy(id = "city")
    WebElement txt_city;
	
	@FindBy(xpath = "//select[@id = 'occupation']")
	WebElement dd_occupation;
	
    // same way for hobbies we have 5 options so we can get as List of web elements since we have 5 objects.
	@FindBy(xpath = "//input[@name = 'Hobbies']/parent::label")
	List<WebElement> chk_Hobbies;
	
	@FindBy(id = "nextenterproductdata")
	WebElement nxt_btn;
	
	public EnterInsurantDataPageObjects() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void enterInsurantData(HashMap<String, String> testData) throws Exception {
		//txt_firstname.sendKeys("Raji");
		txt_firstname.sendKeys(testData.get("Insurant_FirstName"));
		txt_lastname.sendKeys("MK");
		date_birthdate.sendKeys("12/12/2006");
		cm.selectRadioButtonValue(rdo_gender, "Female");
		cm.selectDropdownOption(dd_country, "India");
		txt_zipcode.sendKeys("600015");
		txt_city.sendKeys("Chennai");
		cm.selectDropdownOption(dd_occupation, "Farmer");
		// Select check boxes for hobbies
		//cm.selectCheckBoxes(chk_Hobbies, "Speeding,Other");
		cm.selectCheckBoxes(chk_Hobbies, testData.get("Insurant_Hobby"));
		
		// upload file(picture)
		
	}
	
	public void clickOnNextButton() {
		nxt_btn.click();
		
	}
	

}
