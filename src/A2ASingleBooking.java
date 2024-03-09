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

public class A2ASingleBooking {

	public static void main(String[] args) throws InterruptedException, IOException {
	
		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium libraby\\Sever Libarby\\chromedriver_win32\\chromedriver.exe");
		
		int bookingcount = 10;
	
		for(int i=0;i<bookingcount;i++) {
//To Headerless browser Note:- need to enter options object in webdriver		
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("headless");
			WebDriver driver = new ChromeDriver();	
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		
			
				
	//To select server		
			//driver.get("https://www.thespicetag.com/login"); // Live Server
			driver.get("https://qaspicexpress.kargo360tech.com/login"); //QA Server
			//driver.get("http://dev.thespicetag.com/login");//Dev Server
			String loginurl = driver.getCurrentUrl();
			String loginurlup = loginurl +1;
			//System.out.println(loginurl);
			//driver.findElement(By.xpath(title));
			driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys("Devendra.singh1@spicejet.com");//User name Xpath for QA
	//To Select the server password		
			// driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("Spice@123"); //Live Server
		     driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("Pass@999"); //QA Server
			//driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("Pass@233"); // Dev Server

		    driver.findElement(By.xpath("//button[@class='btn btnColor btn-block auth-form-btn']")).click(); // login Button Xpath
			Thread.sleep(3000);
			//System.out.println(driver.getCurrentUrl());
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

				
				
				String valnum = "0539";
				String Org = "BOM";
				String Des = "CCU";
				String com = "PO MAIL S";
				String shippercode = "BOMMAILDO";
				String consigneecode = "BOMMAILDO";
				String piece = "100";
				String Gweight = "100";
				String flight1 = "SG001";
			
				//To increes the day range from current day
				int d = 1;
				
//	//TO Dimension	
//				String dLength = "10";
//				String dWidth  = "10";
//				String dHeight = "10";
//				
				
// Change the dark mode 
//				System.out.println("A2A Booking flow is working");
//				driver.findElement(By.xpath("//div[@class='slider round']")).click(); //To Change the color mode
//				Thread.sleep(2000);
//					
				
//Click to new order Tab
				Actions action = new Actions(driver);
				action.moveToElement(driver.findElement(By.id("parent_1"))).build().perform();//New order Option selection
				driver.findElement(By.xpath("//a[@href='/create-booking']")).click(); // click on New order
				String Neworderurl = driver.getCurrentUrl();
				Thread.sleep(2000);
//To Reset the booking button
//				driver.findElement(By.xpath("//button[@title='Refresh']")).click(); // To Rest Booking Page
//				Thread.sleep(2000);	
//				

//To Select Station BOM Name
				
				driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
				driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(Org);
				//driver.findElement(By.xpath("//*[@class='drop_option ng-tns-c68-2']//child::mat-option")).click();//for live 
	//  driver.findElement(By.xpath("//*[@class='mat-option mat-focus-indicator ng-star-inserted']")).click();//To QA 
				//driver.findElement(By.xpath("//*[@id='mat-option-144']")).click();//Dev Server
			
				
				
					
				//driver.get(Neworderurl);
				//System.out.println("This is A2A Booking");
				
	//Select Destination
			
				//driver.findElement(By.id("mat-select-12")).click();//Dev Server Click on Dev Server
				driver.findElement(By.xpath("//input[@name='destination']")).click(); // QA Server Click on des.
				
				driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(Des);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
			//	Thread.sleep(1000);
				
// Select commudity code:-
						
				driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
				driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
			//	Thread.sleep(1000);
				
// Shipper Code Enter:-
				
				driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
				driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(shippercode);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
			//	Thread.sleep(1000);
				
//Consignee Code Enter:-
				
				driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
				driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(consigneecode);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
			//	Thread.sleep(1000);

//TO Customer Code Enter:-
//				
//				driver.findElement(By.xpath("//input[@name='customer']")).click();
//				driver.findElement(By.xpath("//input[@name='customer']")).sendKeys(customercode);
//				Thread.sleep(2000);
//				driver.findElement(By.xpath("//input[@name='customer']")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//				Thread.sleep(2000);
				
//To Enter Pieces:-
				
				driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(piece);
				//Thread.sleep(1000);
//TO Enter Gross Weight:-
				
				driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(Gweight);
				//driver.findElement(By.xpath("//input[@formcontrolname='gross_weight']")).sendKeys(Keys.TAB);
				//Thread.sleep(1000);

	//To Val Box No			
				
				
//				Select selectvalnum = new Select(driver.findElement(By.xpath("//*[@name='val_box_number']")));
//				selectvalnum.selectByVisibleText(valnum);
//				Thread.sleep(2000);
				
				
				
//				//click on deminsion delete 
//				WebElement routdel = driver.findElement(By.xpath("//button[@class='btn delete-btn btnColor']"));
//				JavascriptExecutor js3 = ((JavascriptExecutor)driver);
//				js3.executeScript("arguments[0].click();", routdel);
//				Thread.sleep(4000);
			
//				//Delete the demision row
//				 driver.findElement(By.xpath("//button[@class='btn delete-btn btnColor']")).click();	
//        		 Thread.sleep(4000);
				
//				 driver.findElement(By.xpath("//button[@title='Add Pieces']")).click();	
//        		 Thread.sleep(4000);

        		 // driver.findElement(By.xpath("//input[@class='form-control ng-pristine ng-valid ng-touched']")).click();
//				 driver.findElement(By.xpath("//table[@class='table deminsion-table']//child::tbody//child::tr[1]//child::td[2]//input")).sendKeys(dLength); //Length
//				 driver.findElement(By.xpath("//table[@class='table deminsion-table']//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(dWidth); //Width
//				 driver.findElement(By.xpath("//table[@class='table deminsion-table']//child::tbody//child::tr[1]//child::td[4]//input")).sendKeys(dHeight); //Height
				
//				 driver.findElement(By.xpath("//button[@title='Add Pieces']")).click();	
//        		 Thread.sleep(4000);
//        		 
//				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
//				 Thread.sleep(2000);
//				 
//				 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
				// Thread.sleep(2000);
			
//		//To Shipper Invoice 
//				 driver.findElement(By.xpath("//input[@name='invoice_number']")).sendKeys("INv1234");
//				 
//		//To DV for Carriage
//				 driver.findElement(By.xpath("//input[@name='dv_for_carriage']")).sendKeys("100");

	//select Flight in route
					Select select_valn = new Select(driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[1]//select")));
					select_valn.selectByVisibleText(" Flight ");
				//	 Thread.sleep(2000);

			//Select Route Destination
					 driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Des);
				//	 Thread.sleep(1000);
					 driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
			//		 Thread.sleep(1000);
					 
			      //To Get Today Date
					  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
					  	Date SystemDate = new Date();
						String Dateofsystem = formatdate.format(SystemDate);	
						//System.out.println(Dateofsystem);
						String arr[]=Dateofsystem.split("/");
						String days = arr[0];		
						int s = (int) Integer.parseInt(days);
						String day=String.valueOf(s+d); 
					//	System.out.println("This is the current day for today date"+ s);
					  
			//To Click the Datepicker in Route From Date
					  JavascriptExecutor js =(JavascriptExecutor)driver;
					  WebElement datepicker = driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[6]//input"));
					  js.executeScript("arguments[0].click()", datepicker);
					  Thread.sleep(2000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele:alldaate) 
					  {
						  String dt = ele.getText();
						//  System.out.println(dt);
						  

						   if(dt.equals(day))
						  {
							//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
							  
							  ele.click();
							  break;
						  }
						 
					  }
					  

			 //Select Flight Code
					    Thread.sleep(2000);
					  Select select_flt = new Select(driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")));
					  select_flt.selectByVisibleText(flight1);
					
						
//				  	   driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer']//child::tbody//child::tr[1]//child::td[7]//select")).click();
//				  	 Thread.sleep(3000);
//				  	 
//				  	   driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);;          
//				  	   Thread.sleep(2000);

				  	//To ScrollInto page
			//			WebElement awbtotal = driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer']//child::tbody//child::tr[1]//child::td[1]//child::select"));
				//		scrollIntoView(driver,awbtotal);
					//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer']//child::tbody//child::tr[1]//child::td[7]//child::select")).sendKeys("100");
	  
	//To Save Booking
				  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();									
//				//To capture Save booking screenshort
				  	  Thread.sleep(5000);
					  File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					  
			         //now copy screenshot to desired location using copyFile //method
					  Files.copy (src, new File("C:\\Users\\devendra.singh1\\eclipse-workspace\\230_class\\Screenshot"+i+".png"));
					  String BookingStatus = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
					 // System.out.println(BookingStatus);
					  Thread.sleep(3000);
				  		  
		// To Execute The AWB		  
						  driver.findElement(By.xpath("//button[@title='Execute']")).click();
						  Thread.sleep(2000);
						  
						  String bookingStatus = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
						 System.out.println(bookingStatus);
				//				 Thread.sleep(7000);
								   
//					// Screen Shot for Execute	
//						  File src1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//						//now copy screenshot to desired location using copyFile //method
//						  Files.copy (src1, new File("C:\\Users\\devendra.singh1\\eclipse-workspace\\230_class\\Screenshot\\ExecuteScreenShort"+i+".png"));
//						  
						 String ExcuteStatus = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
					//	 System.out.println(ExcuteStatus);
						 Thread.sleep(5000);
						  
	 //To Accpet the AWB
						
						driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(piece);  //Enter Pieces in accept Field
						driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(Gweight); // Enter Gweight in accept Field
					//	Thread.sleep(2000);
						driver.findElement(By.xpath("//button[@title='Accept']")).click();
				  		Thread.sleep(1000);
					    String AcceptStatus = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
					//    System.out.println(AcceptStatus);
					    /*					  
				  	// Screen Shot for Execute		
						  Thread.sleep(1000);
						  File src2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
						//now copy screenshot to desired location using copyFile //method
						  Files.copy (src2, new File("C:\\Users\\devendra.singh1\\eclipse-workspace\\230_class\\Screenshot\\AcceptScreenShort"+i+".png"));		
						 
				   // To Scrolling pageup 	
						  WebElement loginbtn=driver.findElement(By.xpath("//div[@class='slider round']"));
						  js.executeScript("arguments[0].scrollIntoView(true);",loginbtn);
			*/							
				//	    driver.close();
						System.out.println("Booking No" + i);
					      
				}
				
				
			}
			
			
				
	}

	private static void scrollIntoView(WebDriver driver, WebElement awbtotal) {
		// TODO Auto-generated method stub
		
	}



}
