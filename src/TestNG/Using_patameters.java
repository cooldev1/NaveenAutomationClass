package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import My_TestListeners.ITestListnere;

@Listeners(ITestListnere.class)

public class Using_patameters {
	public WebDriver driver;
	
@Parameters({"testurl"})
@Test(priority=1)
public void browserinit(String url) throws InterruptedException  {
	System.out.println(url);
	if(url.equalsIgnoreCase("https://qa.thespicetag.com")) {
		System.out.println(url);
			System.setProperty("webdriver.chrome.driver",
						  "D:\\Selenium libraby\\Sever Libarby\\chromedriver_win32\\chromedriver.exe");
				 driver = new ChromeDriver();
				 driver.get(url);
				 driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
				 driver.manage().window().maximize();
				 driver.manage().deleteAllCookies();
				
			  //to QA Server
				
					WebElement useridxpath = driver.findElement(By.xpath("//*[@formcontrolname='name']")); // To userid xpath
					WebElement passxpath = driver.findElement(By.xpath("//*[@formcontrolname='password']")); //To Password xpath
					WebElement loginxpath = driver.findElement(By.xpath("//button[@class='btn btnColor btn-block auth-form-btn']")); //To Login xpath
								
					useridxpath.sendKeys("devendra.singh1@spicejet.com");
					passxpath.sendKeys("Welcome@123");
					loginxpath.click();
					System.out.println("Login Sucessfull in QA Server");
					
			// To change color mode
					Thread.sleep(2000);
					driver.findElement(By.xpath("//div[@class='slider round']")).click();
					
		  //Click to new order Tab
					Actions action = new Actions(driver);
					action.moveToElement(driver.findElement(By.id("parent_1"))).build().perform();//New order Option selection
					driver.findElement(By.xpath("//a[@href='/create-booking']")).click(); // click on New order
					Thread.sleep(2000);		
		
					
			// To Rest Booking Page		
					driver.findElement(By.xpath("//button[@title='Refresh']")).click(); 
					Thread.sleep(2000);

				}
	//To Live Server
		else if(url.equalsIgnoreCase("https://thespicetag.com")){
			System.out.println(url);
			System.setProperty("webdriver.chrome.driver",
						  "D:\\Selenium libraby\\Sever Libarby\\chromedriver_win32\\chromedriver.exe");
				 driver = new ChromeDriver();
				 driver.get(url);
				 driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
				 driver.manage().window().maximize();
				 driver.manage().deleteAllCookies();
				
			  //to Dev Server
				
					WebElement useridxpath = driver.findElement(By.xpath("//*[@formcontrolname='name']")); // To userid xpath
					WebElement passxpath = driver.findElement(By.xpath("//*[@formcontrolname='password']")); //To Password xpath
					WebElement loginxpath = driver.findElement(By.xpath("//button[@class='btn btnColor btn-block auth-form-btn']")); //To Login xpath
								
					useridxpath.sendKeys("devendra.singh1@spicejet.com");
					passxpath.sendKeys("Spice@123");
					loginxpath.click();

		  // To change color mode
					Thread.sleep(2000);
					driver.findElement(By.xpath("//div[@class='slider round']")).click();
					
		  //Click to new order Tab
					Actions action = new Actions(driver);
					action.moveToElement(driver.findElement(By.id("parent_1"))).build().perform();//New order Option selection
					driver.findElement(By.xpath("//a[@href='/create-booking']")).click(); // click on New order
					Thread.sleep(2000);		
		
		// To Rest Booking Page		
					driver.findElement(By.xpath("//button[@title='Refresh']")).click(); 
					Thread.sleep(2000);
					
					System.out.println("Login Sucessfull in Live Server");
		
					
	}	
		else if(url.equalsIgnoreCase("https://www.thespicetag.com")){
			System.out.println(url);
			System.setProperty("webdriver.chrome.driver",
						  "D:\\Selenium libraby\\Sever Libarby\\chromedriver_win32\\chromedriver.exe");
				 driver = new ChromeDriver();
				 driver.get(url);
				 //driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
				 driver.manage().window().maximize();
				 driver.manage().deleteAllCookies();
			  //to Dev Server
				
					WebElement useridxpath = driver.findElement(By.xpath("//*[@formcontrolname='name']")); // To userid xpath
					WebElement passxpath = driver.findElement(By.xpath("//*[@formcontrolname='password']")); //To Password xpath
					WebElement loginxpath = driver.findElement(By.xpath("//button[@class='btn btnColor btn-block auth-form-btn']")); //To Login xpath
								
					useridxpath.sendKeys("devendra.singh1@spicejet.com");
					passxpath.sendKeys("Spice@123");
					loginxpath.click();
     		// To change color mode
					Thread.sleep(2000);
					driver.findElement(By.xpath("//div[@class='slider round']")).click();
					
		  //Click to new order Tab
					Actions action = new Actions(driver);
					action.moveToElement(driver.findElement(By.id("parent_1"))).build().perform();//New order Option selection
					driver.findElement(By.xpath("//a[@href='/create-booking']")).click(); // click on New order
					Thread.sleep(2000);
			
		// To Rest Booking Page		
					driver.findElement(By.xpath("//button[@title='Refresh']")).click(); 
					Thread.sleep(2000);
					
					System.out.println("Login Sucessfull in Live Server");
		
	}	
		else {
			System.out.println("User Name and Passowrd is worng!!");
		}

	
	}

//@AfterMethod
//public void browserclosed() {
//	driver.close();
//}
}
