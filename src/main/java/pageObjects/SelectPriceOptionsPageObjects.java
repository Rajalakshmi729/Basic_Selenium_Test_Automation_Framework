package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class SelectPriceOptionsPageObjects extends TestBase{
	
	@FindBy(id = "nextsendquote")
	WebElement nxt_btn;
	
	
	public SelectPriceOptionsPageObjects() {
		
		PageFactory.initElements(driver, this);
	}
	// To get price based on selected option or plan
	public String getPriceForSelectedOption(String plan) {
		
	//	String dataXpath = "//table[@id = ‘priceTable’]//tr[1]//td[@data-label = ‘Silver’]/span";
		String dataXpath = "//table[@id = ‘priceTable’]//tr[1]//td[@data-label = ‘"+plan+"’]/span";
			return driver.findElement(By.xpath(dataXpath)).getText();
			
		
	}
	
	//If in case we want data from next row ie, Online claim, we can use above method just change the row value.
	
	//public string getPriceForSelectedOptiononline(String OnlineClaim) {
		
		//	String dataXpath = "//table[@id = ‘priceTable’]//tr[1]//td[@data-label = ‘Silver’]/span";
		//	String dataXpath = "//table[@id = ‘priceTable’]//tr[2]//td[@data-label = ‘"+OnlineClaim+"’]/span";
			//		return driver.findElement(By.xpath(dataXpath));
		//}
	// below xpath we pass value through parameterizaed that's why it is used in driver.findElement.
     public void selectPriceOption(String plan) {
    	 
    	// String dataXpath = "//input[@name = ‘Select Option’ and @value = ‘Gold’]";
    //	 String dataXpath = "//input[@name = ‘Select Option’ and @value = ‘"+plan+"’]";
    	 String dataXpath = "//input[@name = ‘Select Option’ and @value = ‘"+plan+"’]/parent::label";
    	 driver.findElement(By.xpath(dataXpath)).click();
    	 
     }
     
     public void clickOnNextButton() {
    	 
    	 nxt_btn.click();	 
     }
}
