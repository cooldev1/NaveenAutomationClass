package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Agent_code_RemoveID {
 public WebDriver driver;


	@Test
	public void airportlogin() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium libraby\\Sever Libarby\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://qa.thespicetag.com/login"); // For QA Server		
		driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys("Devendra.singh1@spicejet.com");//User name Xpath for QA
	    driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("Password@123"); // (Password Xpath - QA Server)	
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
		
			// To change color mode
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='slider round']")).click();
			
			//To Click on Airport menu		
					Actions acn = new Actions(driver);
					acn.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Organize')]"))).build().perform();
					acn.moveToElement(driver.findElement(By.xpath("//A[contains(text(),'Ratefiling ')]"))).build().perform();
					driver.findElement(By.xpath("//a[contains(text(),'Rate Line ')]")).click();	
					
					
					//To Click on create button
					Thread.sleep(2000);
					driver.findElement(By.xpath("//span[contains(text(),' Rate List ')]")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("//button[@title='Create Rate Line']")).click();
					
		}
 
}
