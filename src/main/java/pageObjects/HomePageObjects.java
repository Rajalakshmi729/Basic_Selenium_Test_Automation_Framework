package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {
	
	WebDriver driver = new ChromeDriver();
	
	@FindBy(id = "nav_automobile")
	WebElement link_Automobile;
	
	@FindBy(id = "nav_truck")
	WebElement link_truck;
	
	@FindBy(id="nav_motorcycle")
	WebElement link_nav_motorcycle;
	
	@FindBy(id = "nav_camper")
	WebElement link_camper;
	
	public HomePageObjects() {
		
		//PageFactory.initElements(driver, this);
		//or 
		//PageFactory.initElements(driver, HomePageObjects.class);
		PageFactory.initElements(driver, this);
	}
	// for click on motorcycle link on homepage
	public void clickOnMotorCycleLink() throws InterruptedException {
		Thread.sleep(2000);
		link_nav_motorcycle.click();
	}
	

}
