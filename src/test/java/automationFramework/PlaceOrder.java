package automationFramework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

public class PlaceOrder {
	 private WebDriver driver;
	 private WebDriverWait wait;

	    public PlaceOrder(WebDriver driver, WebDriverWait wait) {
	        this.driver = driver;
	        this.wait = wait;
	    }
 
	    
	    @Test (priority = 5)
	    public void verifyPlaceOrder() {
	    	
	    	 WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(60));
		      WebElement cart = wait5.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/header/div[2]/div/div[2]/div[2]/div/button/span/div")));
		      cart.click();
		      System.out.println("clicked to cart icon");
		      
		  
		      WebElement checkout = wait5.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/header/div[2]/div/div[2]/div[2]/div/div/div[3]/div/button[2]")));
		      checkout.click();
		      System.out.println("clicked to checkout button");
		      
		      
		    
		      WebElement placeOrderButton = wait5.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/div[1]/div[6]/button[1]")));

		     
		      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", placeOrderButton);

		      try {
		          Thread.sleep(1000); 
		      } catch (InterruptedException e) {
		          System.out.println("An interruption occurred during the wait: " + e.getMessage());
		      }

		      placeOrderButton.click();
		      System.out.println("Clicked the Place Order button.");
	    }
	    
	    

}
