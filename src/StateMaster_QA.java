import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class StateMaster_QA {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium libraby\\Sever Libarby\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();	
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
  //To Enter User Name	
			driver.get("https://qa.thespicetag.com/login"); // For QA Server
			//driver.get("https://www.thespicetag.com/login"); // For Live Server
			//driver.get("http://dev.thespicetag.com/login");// For Dev Server
			String loginurl = driver.getCurrentUrl();
			String loginurlup = loginurl +1;
			//System.out.println(loginurl);
			//driver.findElement(By.xpath(title));
			driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys("Devendra.singh1@spicejet.com");//User name Xpath for QA
		
	//To enter password	
			//driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("Spice@123"); // (Password Xpath - Live Server)
		      driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("Welcome@123"); // (Password Xpath - QA Server)
			//driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("Welcome@123"); // (Password Xpath - Dev Server)

		    driver.findElement(By.xpath("//button[@class='btn btnColor btn-block auth-form-btn']")).click(); // login Button Xpath
			Thread.sleep(3000);
			//System.out.println(driver.getCurrentUrl());
			
			
			if(loginurlup.equals(driver.getCurrentUrl()))
			{
	
				
					//---------------------------
					
					System.out.println("Wrong password");
					//Take screenshot and store as a file formant
					Thread.sleep(2000);
					WebElement borderline = driver.findElement(By.xpath("//*[@class='alert alert-danger reqd alert_main']"));
					JavascriptExecutor js = ((JavascriptExecutor) driver);
					js.executeScript("arguments[0].style.border = '3px solid red'",borderline );
					
					Thread.sleep(2000);
					File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					//now copy screenshot to desired location using copyFile //method
					Files.copy (src, new File("C:\\Users\\devendra.singh1\\eclipse-workspace\\230_class\\Screenshot\\WrongPassword.png"));
					System.out.println("Login Test Case is fail ! Please check User Name and Password");
					
			}		

			else
			{

				int Statecount = 1;
				
				// Change the dark mode 
				System.out.println("booking flow is working");
				driver.findElement(By.xpath("//div[@class='slider round']")).click(); //To Change the color mode
				Thread.sleep(2000);
					
				
		//Click to new order Tab
				Actions action = new Actions(driver);
				action.moveToElement(driver.findElement(By.id("parent_8"))).build().perform();//New order Option selection
				action.moveToElement(driver.findElement(By.id("child_8"))).build().perform();//New order Option selection
				driver.findElement(By.xpath("//a[@href='/state/list']")).click();
				driver.findElement(By.xpath("//*[@class='fas fa-sliders-h']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[contains(text(),' Create State ')]")).click();
				Thread.sleep(2000);
			
		// State code input		
				String Statecode = "08";
				String Statename = "Testing";
				String CountryCode = "IN-India";
				String Statetype = "ST";
				String status ="ACTIVE";
				
				for(int i=0; i<Statecount;i++) 
				{
		//To Enter StateCode
				driver.findElement(By.xpath("//*[@formcontrolname='state_code']")).sendKeys(Statecode);
		//To Enter StateName
				driver.findElement(By.xpath("//*[@formcontrolname='state_name']")).sendKeys(Statename);
				//Thread.sleep(3000);
		//To Enter CountryCode
				//driver.findElement(By.xpath("//*[@formcontrolname='country_code']")).click();
				Select selcetcon = new Select(driver.findElement(By.xpath("//*[@formcontrolname='country_code']")));
				selcetcon.selectByVisibleText(CountryCode);
				//Thread.sleep(3000);
		//TO State Type
				Select selcettype = new Select(driver.findElement(By.xpath("//*[@formcontrolname='state_type']")));
				selcettype.selectByVisibleText(Statetype);
				//Thread.sleep(3000);
		//TO State Type
				Select selectstatus = new Select(driver.findElement(By.xpath("//*[@formcontrolname='status']")));
				selectstatus.selectByVisibleText(status);				
				Thread.sleep(2000);
		//Click on Submin Button
				driver.findElement(By.xpath("//*[@class='btn btnColor ng-star-inserted']")).click();
		
		// To Click Error snapshot	
				Thread.sleep(2000);
				WebElement borderline = driver.findElement(By.xpath("//*[@id='toast-container']"));
				JavascriptExecutor js = ((JavascriptExecutor) driver);
				js.executeScript("arguments[0].style.border = '3px solid red'",borderline );
				
				File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				//now copy screenshot to desired location using copyFile //method
				Files.copy (src, new File("C:\\Users\\devendra.singh1\\eclipse-workspace\\230_class\\Screenshot\\StateCreationStatus"+i+".png"));
				//driver.findElement(By.xpath("//*[@class='ng-tns-c59-15 toast-title ng-star-inserted']"));
				
				
				}
				
			}
	}

}
