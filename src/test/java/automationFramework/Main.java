package automationFramework;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
     
import io.github.bonigarcia.wdm.WebDriverManager;
public class Main {     
 
	private WebDriver driver;
    private WebDriverWait wait;
	
	  @Test(priority = 1)
	 public void setUp() {
		  WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	        driver.manage().window().maximize();
	        driver.get("https://customer-staging.epallet.com/");
	       System.out.println("Successfully opened the website");
	        }
 

	  @Test(priority = 2)
  public void runAllTests() { 
      LoginTest loginTest = new LoginTest(driver, wait);
      loginTest.LogIn();
     

      MyAccountTest myAccountTest=new MyAccountTest(driver, wait);
      myAccountTest.verifyMyAccount();
      
      PDPTest pDPTest=new PDPTest(driver, wait);
      pDPTest.OpenCategory();
      pDPTest.verifyPDP();
      
      PlaceOrder placeOrder=new PlaceOrder(driver, wait);
      placeOrder.verifyPlaceOrder();
}
	  

}
