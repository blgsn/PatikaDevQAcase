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
    public void acceptCookies(){
        if (isDisplayed(acceptCookiesLocator)){
        	click(acceptCookiesLocator);
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
