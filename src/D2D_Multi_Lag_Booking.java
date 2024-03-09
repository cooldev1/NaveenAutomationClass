import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

public class D2D_Multi_Lag_Booking extends Global_Class_Varivals {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium libraby\\Sever Libarby\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();	
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("https://qa.thespicetag.com/login"); // For QA Server
			//driver.get("https://www.thespicetag.com/login"); // For Live Server
			//driver.get("http://dev.thespicetag.com/login");// For Dev Server
			
			String loginurl = driver.getCurrentUrl();
			String loginurlup = loginurl +1;
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//System.out.println(loginurl);
			//driver.findElement(By.xpath(title));
			 
			driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys("Devendra.singh1@spicejet.com");//User name Xpath for QA
			//driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("Spice@123"); // (Password Xpath - Live Server)
		      driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("Dev@123"); // (Password Xpath - QA Server)
			//driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("Welcome@123"); // (Password Xpath - Dev Server)
		      
		    driver.findElement(By.xpath("//button[@class='btn btnColor btn-block auth-form-btn']")).click(); // login Button Xpath
		    //Thread.sleep(3000);
			//System.out.println(driver.getCurrentUrl());
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
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
				System.out.println("booking flow is working");
				WebElement colorchange = driver.findElement(By.xpath("//div[@class='slider round']")); //To Change the color mode
				CheckEleStatus(driver, colorchange, 2);
				eleclick(driver, colorchange, 2);
				//Thread.sleep(2000);
					
				
		//Click to new order Tab
				Actions action = new Actions(driver);
				action.moveToElement(driver.findElement(By.id("parent_1"))).build().perform();//New order Option selection
				driver.findElement(By.xpath("//a[@href='/create-order']")).click(); // click on New order
				String Neworderurl = driver.getCurrentUrl();
			//	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
		//To Select Station Name
				String orgWH = "ND1";
				String Org = "DEL";
				driver.findElement(By.xpath("//*[@id='mat-select-value-1']")).click();
				driver.findElement(By.xpath("//*[@placeholder='Enter station']")).sendKeys(orgWH,Keys.ENTER);
				driver.findElement(By.xpath("//*[@class='mat-option mat-focus-indicator ng-star-inserted']")).click();//for QA Server
			    //driver.findElement(By.xpath("//*[@class='drop_option ng-tns-c68-2']//child::mat-option")).click();//for live 
				
				for(int i=0;i<bookingcount;i++) {
					
				driver.get(Neworderurl);
				System.out.println(Neworderurl);
				System.out.println("This is D2D Booking");
				
				driver.findElement(By.xpath("//button[@title='Reset']")).click(); // To Rest Booking Page
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				//Thread.sleep(2000);
				
			//Select Destination
				String Deswh = "BO1";
				String Des = "Bom";
				String via = "BLR";
				driver.findElement(By.xpath("//*[@class='mat-select-value ng-tns-c68-15']")).click();
				//driver.findElement(By.xpath("//div[@id='mat-select-value-13']")).click();
				driver.findElement(By.xpath("//input[@placeholder='Please enter destination']")).sendKeys(Deswh);
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//input[@placeholder='Please enter destination']")).sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				
			// Select commudity code:-
			
				String com = "GEN";
				driver.findElement(By.xpath("//div[@id='mat-select-value-15']")).click();
				driver.findElement(By.xpath("//input[@placeholder='Please enter commodity']")).sendKeys(com);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@placeholder='Please enter commodity']")).sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				
			// Shipper Code Enter:-
				String shippercode = "TESTND1DD";
				driver.findElement(By.xpath("//div[@id='mat-select-value-17']")).click();
				driver.findElement(By.xpath("//input[@placeholder='Please enter shipper']")).sendKeys(shippercode);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@placeholder='Please enter shipper']")).sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				
			// Consignee Code Enter:-
				String consigneecode = "TESTBO1DD";
				driver.findElement(By.xpath("//div[@id='mat-select-value-19']")).click();
				driver.findElement(By.xpath("//input[@placeholder='Please enter consignee']")).sendKeys(consigneecode);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@placeholder='Please enter consignee']")).sendKeys(Keys.ENTER);
				Thread.sleep(2000);

			// Customer Code Enter:-
				String customercode = "TESTND1DD";
				driver.findElement(By.xpath("//div[@id='mat-select-value-21']")).click();
				driver.findElement(By.xpath("//input[@placeholder='Please enter customer']")).sendKeys(customercode);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@placeholder='Please enter customer']")).sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				
				// Pieces Code Enter:-
				String piece = "10";
				driver.findElement(By.xpath("//input[@formcontrolname='total_pieces']")).sendKeys(piece);
				
				//Gross Weight Code Enter:-
				String Gweight = "50";
				driver.findElement(By.xpath("//input[@formcontrolname='gross_weight']")).sendKeys(Gweight);
				Thread.sleep(2000);
				
				//Gross Weight Window Open
				driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
				Thread.sleep(2000);
				 driver.findElement(By.xpath("//input[@id='mat-input-18']")).sendKeys("10"); //Length
				 driver.findElement(By.xpath("//input[@id='mat-input-19']")).sendKeys("10"); //Width
				 driver.findElement(By.xpath("//input[@id='mat-input-20']")).sendKeys("10"); //Height
				
				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
				 Thread.sleep(2000);
				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
				 Thread.sleep(2000);
			
		//To Shipper Invoice 
				 driver.findElement(By.xpath("//*[@formcontrolname='invoice_number']")).sendKeys("INv1234");
				 
		//To DV for Carriage
				 driver.findElement(By.xpath("//*[@formcontrolname='dv_for_carriage']")).sendKeys("100");

				//---------to select Truck in route
					Select select = new Select(driver.findElement(By.xpath("//select[@formcontrolname='route_type']")));
					 select.selectByVisibleText("Truck");					 
					 Thread.sleep(2000);
					//Select Route Destination
					 driver.findElement(By.xpath("//input[@formcontrolname='flight_origin']")).sendKeys(Keys.TAB, Org);					 
					 Thread.sleep(3000);
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
					  
					//Select Track Code
					    
					  Thread.sleep(2000);
				  	  // driver.findElement(By.xpath("//*[@id='mat-select-32']")).click();
				  	   driver.findElement(By.xpath("//tr[@class='mat-row cdk-row ng-star-inserted']//child::td//following-sibling::td[5]//child::div//input")).sendKeys(Keys.TAB, Keys.ENTER, Keys.ENTER);
				  	   Thread.sleep(2000);

		      //To Add New route button---
				  	   driver.findElement(By.xpath("//*[contains(text(),'Add New Route')]")).sendKeys(Keys.ENTER);

		//-----------to select flight in route
						Select select1 = new Select(driver.findElement(By.xpath("//*[@Class='mat-row cdk-row ng-star-inserted']//following-sibling::tr//child::td//child::div//child::select")));
						 select1.selectByVisibleText("Flight");                
						 Thread.sleep(2000);
		//Select Route Destination
						 driver.findElement(By.xpath("//input[@formcontrolname='flight_origin']//parent::div//parent::td//parent::tr//following-sibling::tr//child::td[2]//child::div//child::input")).sendKeys(Keys.TAB,via);
						   
						//To Get Today Date
						  	DateFormat formatdate1 = new SimpleDateFormat("dd/MM/YYYY");
							Date SystemDate1 = new Date();
							String Dateofsystem1 = formatdate1.format(SystemDate1);	
							System.out.println(Dateofsystem1);
							String arr1[]=Dateofsystem1.split("/");
							String day1 = arr1[0];	
							System.out.println("This is the current day for today date"+day1);
						  
		//To Click the Datepicker in Route From Date
						  JavascriptExecutor js1 =(JavascriptExecutor)driver;
						  WebElement datepicker1 = driver.findElement(By.xpath("//tr[@class='mat-row cdk-row ng-star-inserted'][1]//following-sibling::tr[1]//child::td//following-sibling::td[5]//child::div//child::input"));
						  js1.executeScript("arguments[0].click()", datepicker1);
						  
				//To click the date in route date
						  
						  List<WebElement> alldaate1 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
						  for(WebElement ele1:alldaate1) 
						  {
							  String dt1 = ele1.getText();
							 // System.out.println(dt1);
							  if(dt1.equals(day1))
							  {
								  ele1.click();
								  break;
							  }
						  }
						  
						//Select Flight Code
						 
					  	   Thread.sleep(2000);
					  	  // driver.findElement(By.xpath("//*[@id='mat-select-32']")).click();
					  	     driver.findElement(By.xpath("//tr[@class='mat-row cdk-row ng-star-inserted'][1]//following-sibling::tr[1]//child::td//following-sibling::td[5]//child::div//child::input")).sendKeys(Keys.TAB, Keys.ENTER, Keys.ENTER);
					  	  
					  	    Thread.sleep(2000);
				//To Add New route button---
					  	   driver.findElement(By.xpath("//*[contains(text(),'Add New Route')]")).sendKeys(Keys.ENTER);	
					  	  
		//-----------to select Truck in route
							Select select2 = new Select(driver.findElement(By.xpath("//*[@Class='mat-row cdk-row ng-star-inserted']//following-sibling::tr[2]//child::td//child::div//child::select")));
							 select2.selectByVisibleText("Flight");                							 
							 Thread.sleep(2000);
							 
							//Select Route Destination
							 driver.findElement(By.xpath("//input[@formcontrolname='flight_origin']//parent::div//parent::td//parent::tr//following-sibling::tr[2]//child::td[2]//child::div//child::input")).sendKeys(Keys.TAB,Des, Keys.ENTER ,Keys.PAGE_DOWN);
						     Thread.sleep(4000);  
					
					//To Get Today Date
							  	DateFormat formatdate2 = new SimpleDateFormat("dd/MM/YYYY");
								Date SystemDate2 = new Date();
								String Dateofsystem2 = formatdate2.format(SystemDate2);	
								System.out.println(Dateofsystem1);
								String arr2[]=Dateofsystem2.split("/");
								String day2 = arr2[0];	
								System.out.println("This is the second truck day:- "+day2);
							  
						//To Click the Datepicker in Route From Date
							  JavascriptExecutor js2 =(JavascriptExecutor)driver;
							  WebElement datepicker2 = driver.findElement(By.xpath("//tr[@class='mat-row cdk-row ng-star-inserted']//following-sibling::tr[2]//child::td//following-sibling::td[5]//child::div//child::input"));
							  js2.executeScript("arguments[0].click()", datepicker2);
							 // datepicker2.click();
							  Thread.sleep(1000);
							  
					//To click the date in route date
							  
							  List<WebElement> alldaate2 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
							  for(WebElement ele2:alldaate2) 
							  {
								  String dt2 = ele2.getText();
								 // System.out.println("secong truck :- "+dt2);
								  if(dt2.equals(day2))
								  {
									  System.out.println("secong truck :- "+dt2);
									  Thread.sleep(1000);
									  //ele2.sendKeys(Keys.ENTER);
									  ele2.click();
									  break;
								  }
							  }
							//Select Track Code
							    
						  	   Thread.sleep(3000);
						  	  // driver.findElement(By.xpath("//*[@id='mat-select-32']")).click();
						  	   driver.findElement(By.xpath("//tr[@class='mat-row cdk-row ng-star-inserted'][1]//following-sibling::tr[2]//child::td//following-sibling::td[5]//child::div//child::input")).sendKeys(Keys.TAB, Keys.ENTER, Keys.ENTER);
						  	 
						  	   Thread.sleep(3000);
								//To Add New route button---
						  	   driver.findElement(By.xpath("//*[contains(text(),'Add New Route')]")).sendKeys(Keys.ENTER);	
						  	  
	//-----------to select Truck in route
								Select select3 = new Select(driver.findElement(By.xpath("//*[@Class='mat-row cdk-row ng-star-inserted']//following-sibling::tr[3]//child::td//child::div//child::select")));
								 select3.selectByVisibleText("Truck");                
								 
								 Thread.sleep(2000);
								 
								//Select Route Destination
								 driver.findElement(By.xpath("//input[@formcontrolname='flight_origin']//parent::div//parent::td//parent::tr//following-sibling::tr[3]//child::td[2]//child::div//child::input")).sendKeys(Keys.TAB,Deswh, Keys.ENTER ,Keys.PAGE_DOWN);
								 
								 Thread.sleep(4000);  
						
						//To Get Today Date
								  	DateFormat formatdate3 = new SimpleDateFormat("dd/MM/YYYY");
									Date SystemDate3 = new Date();
									String Dateofsystem3 = formatdate3.format(SystemDate3);	
									System.out.println(Dateofsystem3);
									String arr3[]=Dateofsystem3.split("/");
									String day3 = arr3[0];	
									System.out.println("This is the second truck day:- "+day3);
								  
							//To Click the Datepicker in Route From Date
								  JavascriptExecutor js3 =(JavascriptExecutor)driver;
								  WebElement datepicker3 = driver.findElement(By.xpath("//tr[@class='mat-row cdk-row ng-star-inserted']//following-sibling::tr[3]//child::td//following-sibling::td[5]//child::div//child::input"));
								  js3.executeScript("arguments[0].click()", datepicker3);
								 // datepicker2.click();
								
								  Thread.sleep(1000);
								  
						//To click the date in route date
								  
								  List<WebElement> alldaate3 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
								  for(WebElement ele3:alldaate3) 
								  {
									  String dt3 = ele3.getText();
									 // System.out.println("secong truck :- "+dt2);
									  if(dt3.equals(day3))
									  {
										  System.out.println("secong truck :- "+dt3);
										
										  Thread.sleep(1000);
										  //ele2.sendKeys(Keys.ENTER);
										  ele3.click();
										  break;
									  }
								  }
								//Select Track Code
								    
								  
							  	   Thread.sleep(3000);
							  	  // driver.findElement(By.xpath("//*[@id='mat-select-32']")).click();
							  	   driver.findElement(By.xpath("//tr[@class='mat-row cdk-row ng-star-inserted'][1]//following-sibling::tr[3]//child::td//following-sibling::td[5]//child::div//child::input")).sendKeys(Keys.TAB, Keys.ENTER, Keys.ENTER);
							  	   
							  	   Thread.sleep(3000);
						  	   
	//-------------------------------------------------------------------------------------------------------------------------------
				  
				  	//To Save Booking
				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();
									
				//To capture Save booking screenshort
				  
				  	  
				  	Thread.sleep(2000);
					  File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			         //now copy screenshot to desired location using copyFile //method
					  Files.copy (src, new File("C:\\Users\\devendra.singh1\\eclipse-workspace\\230_class\\Screenshot\\AWBScreenShort"+i+".png"));
					  String BookingStatus = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
					  System.out.println(BookingStatus);
					 					  
					  Thread.sleep(4000);
	/*				  		  
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
			*/							
						  // driver.navigate().refresh();
						 // driver.findElement(By.xpath("//button[@title='Reset']")).click();
					      
				}
			}


	}

}
