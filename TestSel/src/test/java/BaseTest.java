
import io.github.bonigarcia.wdm.WebDriverManager;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import testLogger.TestResultLogger;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(TestResultLogger.class)
public class BaseTest {
	
    WebDriver driver ;
   
    @BeforeAll
    public void setUp(){
        WebDriverManager.chromedriver().setup();
      //Create a instance of ChromeOptions class
        ChromeOptions options = new ChromeOptions();

        //Add chrome switch to disable notification - "**--disable-notifications**"
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        
        driver.get("https://www.e-bebek.com/");
        driver.manage().window().maximize();
        
    }

    @AfterAll
    public void tearDown(){
        driver.quit();
    }


}
