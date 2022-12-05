package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
	By loginPageLocator = By.id("btnLoginWithEmail");
	By enterPage = By.id("btnSubmitLogin");
	By enterPage1 = By.id("btnSubmitPassword");
	 public LoginPage(WebDriver driver) {
	        super(driver);
	    }
	//Locator for username field
		By uName = By.id("txtEmail");
		
		//Locator for password field
		By pswd = By.id("txtPassword");
		
		public void loginWithEmail() {
			driver.findElement(loginPageLocator).click();
		}
		
		//Method to enter username
		public void enterUsername(String user) {
			driver.findElement(uName).sendKeys(user);
		}
		
		public void submitLogin() {
		driver.findElement(enterPage).click();
		}

		//Method to enter password
		public void enterPassword(String pass) {
			driver.findElement(pswd).sendKeys(pass);
		}
		
		public void submitPassword() {
		driver.findElement(enterPage1).click();
		}
		
		public boolean isCorrectLoginPage() {
	        return isDisplayed(loginPageLocator);
	    }
}
