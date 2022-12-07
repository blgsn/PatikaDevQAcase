

import org.junit.jupiter.api.Assertions; 
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailPage;
import pages.ProductPage;

public class AddCartProductTest extends BaseTest {

    HomePage homePage ;
    ProductPage productsPage ;
    ProductDetailPage productDetailPage ;
    CartPage cartPage ;
    LoginPage loginPage;

    @Test
    @Order(1)
//    @Disabled("Due to BUG-123 disabled")
    public void search_a_product(){
        homePage = new HomePage(driver);
        homePage.acceptCookies();
        homePage.searchBox().search("kaşık maması");
        productsPage = new ProductPage(driver);
        Assertions.assertTrue(productsPage.isOnProductPage() ,  //shows error message if we are not on product search result page
                "Not on products page!");
    }

    @Test
    @Order(2)
    public void select_a_product(){
        productDetailPage = new ProductDetailPage(driver);
        productsPage.selectProduct(43);
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage(),  //shows error message if we are not on product detail page
                "Not on product detail page!");
    }

    @Test
    @Order(3)
    public void add_product_to_cart(){
        productDetailPage.addToCart();
        Assertions.assertTrue(homePage.isProductCountUp(),  //shows an error message if the number of items in the cart has not increased
                "Product count did not increase!");
    }

    @Test
    @Order(4)
    public void go_to_cart(){
        cartPage = new CartPage(driver);
        productDetailPage.goToCart();
        Assertions.assertTrue(cartPage.checkIfProductAdded() ,//shows error message If the product is not added to the cart
                "Product was not added to cart!");
    }
    
    @Test
    @Order(5)
    public void shop_ending(){
    	//Creating object of Login page
    	loginPage = new LoginPage(driver);
    			cartPage.endShopping();
        Assertions.assertTrue(loginPage.isCorrectLoginPage() , //shows error message if we are not on login page
                "Not on login page!");
    }
    
    @Test
    @Order(6)
    public void correct_login(){
    	//Creating object of Login page
    	loginPage.loginWithEmail();
    			 loginPage.enterUsername("Bilge.su.arslan17@gmail.com");
    			 loginPage.submitLogin();
        loginPage.enterPassword("Ayicik.17");
        loginPage.submitPassword();
        Assertions.assertTrue(homePage.isCorrectLogin() , //shows error message if login failed
                "Wrong email or password!");
    }
}
