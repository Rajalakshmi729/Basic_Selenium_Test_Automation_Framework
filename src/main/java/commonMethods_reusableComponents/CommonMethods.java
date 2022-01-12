package commonMethods_reusableComponents;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods {
	
	
public void selectDropdownOption(WebElement element, String valueToBeSelected) throws Exception {
	// Common method to select dropdown value	
	// either you pass general exception or pass some custom exception as meaningful 
		Select os = new Select(element);
		try {
		os.selectByVisibleText(valueToBeSelected);
		} catch(Exception e) {
			throw new Exception("value is not present in dropdown for webelement: "+element+ "value to be selected is:"+valueToBeSelected);
		}
	}
// selecting checkboxes
public void selectCheckBoxes(List<WebElement> element, String checks) {
	
	// In excel we will be getting data as comma separated speeding,other so we need to split it
	String[] checksArray = checks.split(",");
	for(String str:checksArray) { // Speeding, other
		for(WebElement ele:element) {
			 if(ele.getText().equalsIgnoreCase(str)) {
				 ele.click();
				 break; //once it finds the element we have to break then only it will go to
				 // outer for loop otherwise it will keep iterating in inner for loop.
			 }
		}
	}
}

public void selectRadioButtonValue(List<WebElement> element, String valueToBeSelected) {
	for(WebElement ref: element) {
		 if(ref.getText().equalsIgnoreCase(valueToBeSelected)) {
			 ref.click();
			 break; // break usage if in mid we find the value we can stop from that point else 
			 // it will continue to iterate remaining value in the list.
		 }
	}
	
}
	
	public List<String> getDropdownOption_model(WebElement element) {
		Select os = new Select(element);
		List<WebElement> list_webElement_model = os.getOptions();
		List<String> actualContents = new ArrayList<String>();
		
		for(WebElement ref:list_webElement_model ) {
			
			actualContents.add(ref.getText());
		}
		return actualContents;
	}

}
                    