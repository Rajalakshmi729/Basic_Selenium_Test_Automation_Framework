package pageObjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class EnterProductDataPageObjects extends TestBase{
	
	
	@FindBy(id = "startdate")
	WebElement date_start;
	
	@FindBy(xpath = "//select[@id='insurancesum']")
	WebElement dd_insurancesum;
	
	@FindBy(xpath = "//select[@id='damageinsurance']")
	WebElement dd_damageinsurance;
	
	@FindBy(xpath = "//input[@name = 'Optional Products[]']/parent::label")
	List<WebElement> chk_OptionalProducts;
	
	@FindBy(id = "nextselectpriceoption")
	WebElement nxt_btn;
	public EnterProductDataPageObjects() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterProductData(HashMap<String, String> testData) throws Exception {
		//date_start.sendKeys("02/01/2021");
		date_start.sendKeys(testData.get("Product_startdate"));
		//cm.selectDropdownOption(dd_insurancesum, "5.000.000,00");
		cm.selectDropdownOption(dd_insurancesum, testData.get("Product_insurancesum"));
	//	cm.selectDropdownOption(dd_damageinsurance, "Full Coverage");
		cm.selectDropdownOption(dd_damageinsurance, testData.get("Product_damageinsurance"));
		//cm.selectCheckBoxes(chk_OptionalProducts, "Euro Protection");
		cm.selectCheckBoxes(chk_OptionalProducts, testData.get("Product_OptionalProducts"));
	}
	public void clickOnNextButton() {
		
		nxt_btn.click();
	}

}
