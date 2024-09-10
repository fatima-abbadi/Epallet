package automationFramework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
	 private WebDriver driver;
	 private WebDriverWait wait;

	    public LoginTest(WebDriver driver, WebDriverWait wait) {
	        this.driver = driver;
	        this.wait = wait;
	    }
  
  @Test (priority = 1)
  public void LogIn() {

	        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(60));
	      WebElement signInLink = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/header/div[2]/div/div[2]/div[2]/a[1]/button")));
	  signInLink.click();
	         System.out.println("SignIn Link opend");
	         WebElement emailField = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"Email\"]")));
	         WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"Password\"]"));
	         WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[4]/form/div/div[6]/button"));
       
	         emailField.sendKeys("Qa.itg6.2021@gmail.com");
	         passwordField.sendKeys("9Aug1997@@ ");
	         System.out.println("Email and Pssword Enterd");
	         loginButton.click();
	         System.out.println("login button clicked ");
//	         
//	         WebElement UsrerName = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\\\"root-page\\\"]/main/div[1]/div/div/h1")));
//	         Assert.assertEquals(UsrerName.getText(), "Welcome back, Qa", "User Name match");
//	         System.out.println("the user name correct");
	        } 
  }

