
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.asynchttpclient.util.Assertions;
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

public class ST_QA_Booking {  				//Single Lag Route in A2A Booking

	
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium libraby\\Sever Libarby\\chromedriver_win32\\chromedriver.exe");
		
			WebDriver driver = new ChromeDriver();	
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
//--------To Select Server		
			driver.get("https://qa.thespicetag.com/login"); // For QA Server
			//driver.get("https://www.thespicetag.com/login"); // For Live Server
			//driver.get("http://dev.thespicetag.com/login");// For Dev Server
			String loginurl = driver.getCurrentUrl();
			String loginurlup = loginurl +1;
			System.out.println(loginurl);
			//driver.findElement(By.xpath(title));
			driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys("Devendra.singh1@spicejet.com");//User name Xpath for QA
//--------To Select Password	
			//driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("Spice@123"); // (Password Xpath - Live Server)
		    driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("Password@123"); // (Password Xpath - QA Server)
			//driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("Welcome@123"); // (Password Xpath - Dev Server)
			driver.findElement(By.xpath("//button[@class='btn btnColor btn-block auth-form-btn']")).click(); // login Button Xpath
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			//Thread.sleep(3000);
			System.out.println(driver.getCurrentUrl());
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
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

				int bookingcount = 1;
				
				// Change the dark mode 	
				driver.findElement(By.xpath("//div[@class='slider round']")).click(); //To Change the color mode
				Thread.sleep(2000);
				
				//Click to new order Tab
				Actions action = new Actions(driver);
				action.moveToElement(driver.findElement(By.id("parent_1"))).build().perform();//New order Option selection
				driver.findElement(By.xpath("//a[@href='/create-booking']")).click(); // click on New order
				String Neworderurl = driver.getCurrentUrl();
				Thread.sleep(2000);
				
				for(int i=0;i<bookingcount;i++) {
					
				driver.get(Neworderurl);
				System.out.println("Welcome to spicetag QA server");
				
				driver.findElement(By.xpath("//button[@title='Refresh']")).click(); // To Rest Booking Page
				Thread.sleep(2000);
				
			//Select Destination
				String Des = "Bom";
				driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(Des);
				//driver.findElement(By.xpath("//div[@id='mat-select-value-13']")).click();
				//driver.findElement(By.xpath("//input[@placeholder='Please enter destination']")).sendKeys(Des);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//mat-option[@id='mat-option-593']")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
				Thread.sleep(2000);
				
			// Select commudity code:-
			
				String com = "GEN";
				driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
				driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='mat-autocomplete-3']//child::mat-option[1]")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				Thread.sleep(2000);
				
			// Shipper Code Enter:-
				String shippercode = "TESTDELDO";
				driver.findElement(By.xpath("//div[@id='mat-select-value-17']")).click();
				driver.findElement(By.xpath("//input[@placeholder='Please enter shipper']")).sendKeys(shippercode);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@placeholder='Please enter shipper']")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				Thread.sleep(2000);
				
			// Consignee Code Enter:-
				String consigneecode = "TESTBOMDO";
				driver.findElement(By.xpath("//div[@id='mat-select-value-19']")).click();
				driver.findElement(By.xpath("//input[@placeholder='Please enter consignee']")).sendKeys(consigneecode);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@placeholder='Please enter consignee']")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				Thread.sleep(2000);

			// Customer Code Enter:-
				String customercode = "TESTDELDO";
				driver.findElement(By.xpath("//div[@id='mat-select-value-21']")).click();
				driver.findElement(By.xpath("//input[@placeholder='Please enter customer']")).sendKeys(customercode);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@placeholder='Please enter customer']")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				Thread.sleep(2000);
				
				// Pieces Code Enter:-
				String piece = "5";
				driver.findElement(By.xpath("//input[@formcontrolname='total_pieces']")).sendKeys(piece);
				
				//Gross Weight Code Enter:-
				String Gweight = "50";
				driver.findElement(By.xpath("//input[@formcontrolname='gross_weight']")).sendKeys(Gweight);
				//driver.findElement(By.xpath("//input[@formcontrolname='gross_weight']")).sendKeys(Keys.TAB);
				//Thread.sleep(2000);
				
			/*	//Gross Weight Window Open
				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
				Thread.sleep(2000);
				 driver.findElement(By.xpath("//input[@id='mat-input-18']")).sendKeys("10"); //Length
				 driver.findElement(By.xpath("//input[@id='mat-input-19']")).sendKeys("10"); //Width
				 driver.findElement(By.xpath("//input[@id='mat-input-20']")).sendKeys("10"); //Height
				
				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
				 Thread.sleep(2000);
				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
				 Thread.sleep(2000);
				*/
				
				 // Add Single Route Flight 
				 Select select = new Select(driver.findElement(By.xpath("//select[@formcontrolname='route_type']")));
				 select.selectByVisibleText("Flight");
				 Thread.sleep(2000);
				 
				 //Select Route Destination
				 driver.findElement(By.xpath("//input[@formcontrolname='flight_origin']")).sendKeys(Keys.TAB, Des);  
				   
			//To Get Today Date
				  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
					Date SystemDate = new Date();
					String Dateofsystem = formatdate.format(SystemDate);	
					System.out.println(Dateofsystem);
					String arr[]=Dateofsystem.split("/");
					String day = arr[0];	
					System.out.println("This is the current day for today date"+day);
				  
					//To Click the Datepicker in Route From Date
				  JavascriptExecutor js =(JavascriptExecutor)driver;
				  WebElement datepicker = driver.findElement(By.xpath("//tr[@class='mat-row cdk-row ng-star-inserted']//child::td//following-sibling::td[5]//child::div//input"));
				  js.executeScript("arguments[0].click()", datepicker);
				  
				  //To click the date in route date
				  
				  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
				  for(WebElement ele:alldaate) 
				  {
					  String dt = ele.getText();
					 // System.out.println(dt);
					  if(dt.equals(day))
					  {
						  ele.click();
						  break;
					  }
				  }
				  
				  //Select Flight Code
				    
				  	   Thread.sleep(2000);
				  	   driver.findElement(By.xpath("//tr[@class='mat-row cdk-row ng-star-inserted']//child::td//following-sibling::td[5]//child::div//input")).sendKeys(Keys.TAB, Keys.ENTER, Keys.ENTER, Keys.ARROW_DOWN);
				  	   Thread.sleep(2000);
				  	
				  
				  	//To Save Booking
				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
				  		
				/* // To Scrolling pageup 	
					  WebElement loginbtn=driver.findElement(By.xpath("//*[@class='slider round']"));
					  js.executeScript("arguments[0].scrollIntoView(true);",loginbtn);
					*/				
				//To capture Save booking screenshort
				  	  Thread.sleep(2000);
					  File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			         //now copy screenshot to desired location using copyFile //method
					  Files.copy (src, new File("C:\\Users\\devendra.singh1\\eclipse-workspace\\230_class\\Screenshot\\AWBScreenShort"+i+".png"));
					  
					  String BookingStatus = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
					  System.out.println(BookingStatus);
					  Thread.sleep(4000);
					  		  
					// To Execute The AWB		  
						  driver.findElement(By.xpath("//button[contains(text(),'Execute ')]")).sendKeys(Keys.ENTER);
						  Thread.sleep(2000);
						   
					// Screen Shot for Execute	
						  File src1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
						//now copy screenshot to desired location using copyFile //method
						  Files.copy (src1, new File("C:\\Users\\devendra.singh1\\eclipse-workspace\\230_class\\Screenshot\\ExecuteScreenShort"+i+".png"));
						  
						 String ExcuteStatus = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
						 System.out.println(ExcuteStatus);
						 Thread.sleep(4000);
						  
				  //To Accpet the AWB
						
						driver.findElement(By.xpath("//*[@formcontrolname='accept_piece']")).sendKeys(piece);  //Enter Pieces in accept Field
						driver.findElement(By.xpath("//*[@formcontrolname='accept_weight']")).sendKeys(Gweight); // Enter Gweight in accept Field
						Thread.sleep(2000);
						driver.findElement(By.xpath("//button[contains(text(),'Accept')]")).sendKeys(Keys.ENTER);
				  		Thread.sleep(2000);
					    String AcceptStatus = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
					    System.out.println(AcceptStatus);
						  
				  	// Screen Shot for Execute		
						  Thread.sleep(1000);
						  File src2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
						//now copy screenshot to desired location using copyFile //method
						  Files.copy (src2, new File("C:\\Users\\devendra.singh1\\eclipse-workspace\\230_class\\Screenshot\\AcceptScreenShort"+i+".png"));		

				   // To Scrolling pageup 	
						  WebElement loginbtn=driver.findElement(By.xpath("//div[@class='slider round']"));
						  js.executeScript("arguments[0].scrollIntoView(true);",loginbtn);
										
						  // driver.navigate().refresh();
						  driver.findElement(By.xpath("//button[@title='Reset']")).click();
					      
				}
			}
	
	}

		
}

