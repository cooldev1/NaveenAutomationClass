import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Global_Class_Varivals {

	
		public WebDriver driver;
		
		public static WebDriverWait wait;
		
		public static void ewait(WebDriver driver, int sec)
		{
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
		}
	
		public static void checkEleVisibilty(WebDriver driver, WebElement ele, int sec) 
		{
			
			wait=new WebDriverWait(driver, sec);
			wait.until(ExpectedConditions.visibilityOf(ele));
		}
		
		public static void entervalue(WebDriver driver, WebElement ele, String Value, int sec) 
		{
			wait=new WebDriverWait(driver, sec);
			wait.until(ExpectedConditions.visibilityOf(ele)).sendKeys(Value);
		}
		
		public static void CheckEleStatus(WebDriver driver,WebElement ele,int sec)
		{
			wait=new WebDriverWait(driver, sec);
			boolean elestatus=wait.until(ExpectedConditions.visibilityOf(ele)).isEnabled();
			System.out.println(elestatus);
		}
		
		public static void eleclick(WebDriver driver, WebElement ele, int sec)
		{
			wait=new WebDriverWait(driver, sec);
			wait.until(ExpectedConditions.visibilityOf(ele)).click();
		}
		public static void enterele(WebDriver driver, WebElement ele, int sec)
		{
			wait=new WebDriverWait(driver, sec);
			wait.until(ExpectedConditions.visibilityOf(ele)).sendKeys(Keys.ENTER);
		}
		
		public static void empwait(WebDriver driver, WebElement ele, int sec)
		{
			wait=new WebDriverWait(driver, sec);
			wait.until(ExpectedConditions.visibilityOf((ele)));
		}
		
	}


