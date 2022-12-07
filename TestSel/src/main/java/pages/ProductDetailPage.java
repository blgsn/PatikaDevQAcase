package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage{

    By addToCartButtonLocator = By.id("addToCartBtn");
    By cartContainerLocator = By.id("btnShowCart");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }
//Checking if we are on the product detail page
    public boolean isOnProductDetailPage() {
        return isDisplayed(addToCartButtonLocator);
    }
//method of add to cart
    public void addToCart() {
        click(addToCartButtonLocator);
    }
//method of go to cart
    public void goToCart() {
        click(cartContainerLocator); 
    }
}
