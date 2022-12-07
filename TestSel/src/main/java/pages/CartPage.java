package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CartPage extends BasePage {

    By productNameLocator = new By.ByCssSelector("a.cx-link"); 
    By endShippingButton = By.cssSelector("#btnGoToShippingAddress > .ng-star-inserted");   //complete purchase button
  	
    public CartPage(WebDriver driver) {
        super(driver);
    }
    //The part that checks if the product has been added to the cart
    public boolean checkIfProductAdded() {
        return getProducts().size() > 0 ;  
    }
    //access all products added to cart
    private List<WebElement> getProducts(){
        return findAll(productNameLocator);
    }

	//Method to click on Login button
		public void endShopping() {
			driver.findElement(endShippingButton).click();
		}
		//allows us to check if we are on the right page
		public boolean isCorrectCartPage() {
	        return isDisplayed(endShippingButton);
	    }
}
