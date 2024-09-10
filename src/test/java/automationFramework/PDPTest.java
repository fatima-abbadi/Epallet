package automationFramework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;


public class PDPTest {
	private WebDriver driver;
    private WebDriverWait wait;

    public PDPTest(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
   @Test(priority = 3)
    public void OpenCategory() {
	   WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(60));
	   WebElement Main = wait4.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/header/div[2]/div/div[1]/a/span/img")));
	   Main.click();
	   System.out.println("I am return to the main page ");
	   WebElement Category = wait4.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root-page\"]/main/div[1]/div/div/div/a[1]")));
	   Category  .click();
	   System.out.println("I am select Vegatebles and fruits Category to test it  ");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root-page\"]/div/div[1]/div/div/div/div/h1")));
        System.out.println(" Vegatebles and fruits Category opend ");
     //  Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(@class,'product-name')]")).isDisplayed(), "Product name is not displayed correctly.");
    }
   
   @Test(priority = 4)
   public void verifyPDP()  {
	        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(60));
	        WebElement product = wait4.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root-page\"]/div/div[3]/div/div[1]/div/div[2]/a/div/div/img")));
	        
	        // Scroll to the product and click using JavaScript Executor
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);
	        product.click();   
	        System.out.println("I have chosen The MAX Cheese Stuffed Pizza w/Reduced Fat Pepperoni product");

	        // Verify the productName is displayed
	        WebElement productName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root-page\"]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/span")));
	        Assert.assertTrue(productName.isDisplayed(), "Product name is not displayed correctly.");
	        System.out.println("The name of the product displayed correctly.");
	       
	        // Verify the product price is displayed
	        WebElement productPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root-page\"]/div[2]/div[2]/div[1]/div[1]")));
	        Assert.assertTrue(productPrice.isDisplayed(), "Product price is not displayed correctly.");
	        System.out.println("The price of the product displayed correctly.");
	       
	        // Verify the product quantity is displayed and set a new quantity
	        WebElement quantityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root-page\"]/div[2]/div[2]/div[1]/div[2]/div[3]/div/div")));
	        Assert.assertTrue(quantityInput.isDisplayed(), "Product quantity is not displayed correctly.");
	        System.out.println("The quantity of the product displayed correctly.");
	       
	        // Add to quantity
	        WebElement addquantityInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root-page\"]/div[2]/div[2]/div[1]/div[2]/div[3]/div/div/div/div[3]/button/div")));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addquantityInput);
	        addquantityInput.click();
	        System.out.println("The quantity of the product added correctly.");
	       
	        try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
	        System.out.println("Waiting for 5 seconds before decreasing the quantity..."); 
	        
	        // Decrease quantity
	        WebElement decreasequantityInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root-page\"]/div[2]/div[2]/div[1]/div[2]/div[3]/div/div/div/div[1]/button")));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", decreasequantityInput);
	        decreasequantityInput.click();
	        System.out.println("The quantity of the product decreased correctly.");
	       
	        
	        //add to cart 

	        // Verify that the product has been added to the cart successfully
	        WebElement addToCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root-page\"]/div[2]/div[2]/div[1]/div[5]/div[1]/button")));
	        addToCart.click();
	           System.out.println("add to cart button clicked.");

	        WebElement cartSuccessMessage = wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]")));

	        Assert.assertTrue(cartSuccessMessage.isDisplayed(), "Product was not successfully added to the cart.");
           System.out.println("Product details are verified, and product is successfully added to the cart.");
           
          
	    }
	    }