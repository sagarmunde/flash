package com.training;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartOrder {
	public static ChromeDriver driver;

	@BeforeClass
	public void launchBrowser()
	{
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\a4tech\\Music\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://www.flipkart.com");
	}

	  @Test(priority = 0)
	  public void searchComputers() throws InterruptedException
	  { 
	    WebDriverWait wait = new WebDriverWait(driver, 40);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@title='Search for products, brands and more']")));
	  driver.findElement(By.xpath("//div[@class='O8ZS_U']/input")).sendKeys("laptops");
	  driver.findElement(By.xpath("//div[@class='O8ZS_U']/input")).sendKeys(Keys.ENTER);
	  Thread.sleep(4000);
	  driver.findElement(By.xpath("(//a[contains(text(),'Laptops')])[4]")).click();

	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div//div[@title='HP']//div[@class='_1p7h2j']")));
	  Thread.sleep(1000);
	  JavascriptExecutor jse = (JavascriptExecutor)driver;
	  jse.executeScript("window.scrollBy(0,250)", "");
	  driver.findElement(By.xpath("//div[@title='HP']//div[@class='_1p7h2j']")).click();
	}

	 @Test(priority = 1)
	 public void searchHPComputers() throws InterruptedException
	 {
	   Thread.sleep(2000);
	  WebDriverWait wait1 = new WebDriverWait(driver, 40);
	  wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[text()='Newest First']")));
	  Thread.sleep(1000);
	  List<WebElement> element =  driver.findElements(By.xpath("//div[@class='_1vC4OE _2rQ-NK']"));
	  for(WebElement web : element)
	  {
	     String amount =  web.getText();
	     int length = amount.length();
	     String price = amount.substring(1, length);
	     System.out.println("Amount : "+ price);
	     Thread.sleep(1000);
	  }
	 }}

//	}


//	 @AfterClass
//	 public void closeBrowser() throws InterruptedException
//	 {
//	  Thread.sleep(2000);
//	  driver.close();
//	  driver.quit();
//	 }
//}
