package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
	
    SearchBox searchBox ;
    By cartCountLocator = new By.ByCssSelector("#iconMiniCart > .number");
    WebElement element = driver.findElement(By.cssSelector(".ins-close-button-c2703"));
    
    By loginLocator = new By.ByCssSelector("ul[class=nav nav-pills]");

    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
    }
public void acceptCookies(){
    	if (element.isDisplayed() && element.isEnabled()) {
    	    element.click();
    	} 
    }

    public SearchBox searchBox(){
        return this.searchBox;
    }

    public boolean isProductCountUp() {
        return getCartCount() > 0 ;
    }

    private int getCartCount(){
        String count = find(cartCountLocator).getText();
        return Integer.parseInt(count);
    }
    
    public boolean isCorrectLogin() {
        return isDisplayed(loginLocator);
    }
}
