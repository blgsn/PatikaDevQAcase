package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CartPage extends BasePage {

    By productNameLocator = new By.ByCssSelector("a.cx-link");
    By endShippingButton = By.cssSelector("#btnGoToShippingAddress > .ng-star-inserted");
  	
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkIfProductAdded() {
        return getProducts().size() > 0 ;
    }

    private List<WebElement> getProducts(){
        return findAll(productNameLocator);
    }

	//Method to click on Login button
		public void endShopping() {
			driver.findElement(endShippingButton).click();
		}
		
		public boolean isCorrectCartPage() {
	        return isDisplayed(endShippingButton);
	    }
}
