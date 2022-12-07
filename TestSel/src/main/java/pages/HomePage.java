package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	SearchBox searchBox ;
    By cartCountLocator = new By.ByCssSelector("#iconMiniCart > .number");
    By acceptCookiesLocator = By.id("ins-close-button-c2703"); 
    
    By loginLocator = new By.ByCssSelector("ul[class=nav nav-pills]");
    

    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
    }
    public void acceptCookies(){    //If there is a pop up on the page, it will turn it off
        if (isDisplayed(acceptCookiesLocator)){
        	click(acceptCookiesLocator);
        }
    }

    public SearchBox searchBox(){
        return this.searchBox;
    }
    //Checks if the product has been added to the cart, if the number in the cart icon has increased, it has been added
    public boolean isProductCountUp() {  
        return getCartCount() > 0 ;
    }
    //Converts the number in the basket symbol from string to integer
    private int getCartCount(){
        String count = find(cartCountLocator).getText();
        return Integer.parseInt(count);
    }
    //Checking that we are logged in after logging in to the page throws it to the homepage after logging in
    public boolean isCorrectLogin() {
        return isDisplayed(loginLocator);
    }
}
