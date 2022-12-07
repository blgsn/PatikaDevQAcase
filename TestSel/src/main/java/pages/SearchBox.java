package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchBox extends BasePage{
	
    By searchBoxLocator = By.id("txtSearchBox");  //search box 
    
    public SearchBox(WebDriver driver) {
        super(driver);
    }
   //method of send text to searchbox
    public void search(String text) {
        type(searchBoxLocator,text);
       
    }

	
}
