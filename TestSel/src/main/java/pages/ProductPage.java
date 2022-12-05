package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage extends BasePage {

    By shippingOptionLocator = By.id("btnCategoryFilter");
    By productNameLocator = new By.ByCssSelector("eb-generic-link[class=\"product-item-anchor\"]");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductPage() {
        return isDisplayed(shippingOptionLocator);
    }

    public void selectProduct(int i) {
    	getAllProducts().get(i);
    	List<WebElement> outOfStockItem = driver.findElements(By.cssSelector("span[class=product-item__special-internet product-item__out-of-stock-badge out-of-stock ng-star-inserted]"));
    	if(outOfStockItem.size()>0) {
    		if(getAllProducts().get(i)==outOfStockItem) {
    	    i--;
    	    }}
        else
    		getAllProducts().get(i).click();
    }

    private List<WebElement> getAllProducts(){
        return findAll(productNameLocator);
    }
}
