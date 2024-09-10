package automationFramework;

import static org.testng.AssertJUnit.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.Assert;


public class MyAccountTest {
  
  private WebDriver driver;
  private WebDriverWait wait;

  public MyAccountTest(WebDriver driver, WebDriverWait wait) {
      this.driver = driver;
      this.wait = wait;
  }
  
  @Test(priority = 2)
  public void verifyMyAccount() {
	  WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(70));
      WebElement profile = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/header/div[2]/div/div[2]/div[2]/button[1]/a/div")));
  profile.click();
   // Find elements containing account information
  WebElement companyName = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root-page\"]/div/section/section/main/div/div/div[2]/div[1]/div/form/div/div[1]/span/span/input")));
  WebElement email = driver.findElement(By.xpath("//*[@id=\"root-page\"]/div/section/section/main/div/div/div[2]/div[1]/div/form/div/div[2]/span/span/input"));
  WebElement contactName = driver.findElement(By.xpath("//*[@id=\"root-page\"]/div/section/section/main/div/div/div[2]/div[1]/div/form/div/div[3]/span/span/input"));
  WebElement phone = driver.findElement(By.xpath("//*[@id=\"root-page\"]/div/section/section/main/div/div/div[2]/div[1]/div/form/div/div[4]/span/span/input"));

  // Verify the values
  Assert.assertEquals(companyName.getAttribute("value"), "QaITGqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq", "Company Name does not match");
  Assert.assertEquals(email.getAttribute("value"), "qa.itg6.2021@gmail.com", "Email does not match");
  Assert.assertEquals(contactName.getAttribute("value"), "Qa", "Contact Name does not match");
  Assert.assertEquals(phone.getAttribute("value"), "Tesy", "Phone number does not match");
  
  System.out.println("all of informations in My Account dashbord matches");
}

  }


