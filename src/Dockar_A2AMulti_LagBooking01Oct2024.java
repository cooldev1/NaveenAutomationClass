import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
//import java.util.concurrent.TimeUnit;

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
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

import com.google.common.collect.Table.Cell;
import com.google.common.io.Files;

//import com_st_pages.A2ANewOrder_Page;

public class Dockar_A2AMulti_LagBooking01Oct2024 {
	
	public static void main(String[] args) throws InterruptedException, IOException {
	System.setProperty("webdriver.chrome.driver",
			"D:\\Selenium libraby\\Sever Libarby\\chromedriver_win32\\chromedriver.exe");
	
	int bookingcount = 10;
	//This is for increesing the booking data
	
	int d = 0;
	for(int i=1;i<bookingcount;i++) {
//To Headerless browser Note:- need to enter options object in webdriver		
	//ChromeOptions options = new ChromeOptions();
	//options.addArguments("headless");
		
		WebDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	
		
			
//To select server		
		//driver.get("https://www.thespicetag.com/login"); // Live Server
	//	driver.get("https://qa.thespicetag.com/login"); //QA Server
		driver.get("http://dev.thespicetag.com/login");//Dev Server
		String loginurl = driver.getCurrentUrl();
		String loginurlup = loginurl +1;
		//System.out.println(loginurl);
		//driver.findElement(By.xpath(title));
		driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys("dev.amd");//User name Xpath for QA
//To Select the server password		
		// driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("Spice@123"); //Live Server
	   //  driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("Dev@123"); //QA Server
		driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("Pass@999"); // Dev Server

	    driver.findElement(By.xpath("//button[@class='btn btnColor btn-block auth-form-btn']")).click(); // login Button Xpath
		Thread.sleep(3000);
		//System.out.println(driver.getCurrentUrl());
	//	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
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

			
			// String SheetName ="A2ABookingSingleRoute";
			
			String Filepath = "C:\\Users\\devendra.singh1\\eclipse-workspace\\Spicetag_FrameWorkV1\\src\\main\\java\\com_st_testdata\\A2ABookingSingleRoute.xlsx";
			//FileInputStream fis= new FileInputStream(Filepath);
			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream((new File(Filepath))));
			int lastRowNum = wb.getSheetAt(0).getLastRowNum();
			System.out.println("last row count:-"+lastRowNum);
			
//			
//			for(int j =1; i <lastRowNum; i++ )
//			{
				System.out.println("count of i:- "+i);
			String Org =          wb.getSheetAt(0).getRow(i).getCell(0).getStringCellValue();
			System.out.println("data is-"+Org);
			String Des =          wb.getSheetAt(0).getRow(i).getCell(1).getStringCellValue();
			System.out.println("data is-"+Des);
			String com =          wb.getSheetAt(0).getRow(i).getCell(2).getStringCellValue();
			System.out.println("data is-"+com);
			String shippercode =  wb.getSheetAt(0).getRow(i).getCell(3).getStringCellValue();
			System.out.println("data is-"+shippercode);
			String consigneecode =wb.getSheetAt(0).getRow(i).getCell(4).getStringCellValue();
			System.out.println("data is-"+consigneecode);
		  
			 DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale
			 XSSFCell cell = wb.getSheetAt(0).getRow(i).getCell(5);
			 String piece = formatter.formatCellValue(cell); 
			 
			 DataFormatter formatter1 = new DataFormatter(); //creating formatter using the default locale
			 XSSFCell cell1 = wb.getSheetAt(0).getRow(i).getCell(6);
			 String Gweight = formatter1.formatCellValue(cell1); 
			 
		  //  String piece =        Formatter formatCellValue( wb.getSheetAt(0).getRow(i).getCell(5));
		 //   String Gweight =    wb.getSheetAt(0).getRow(i).getCell(6).getStringCellValue();
		    String via =        wb.getSheetAt(0).getRow(i).getCell(7).getStringCellValue();
		    System.out.println("data is-"+via);
		    String fligh1 =      wb.getSheetAt(0).getRow(i).getCell(8).getStringCellValue();
		    System.out.println("data is-"+fligh1);
		    String fligh2 =      wb.getSheetAt(0).getRow(i).getCell(9).getStringCellValue();
		    System.out.println("data is-"+fligh2);
   
			
		
			
//			//String valnum = "0539";
//			String Org = Org1;
//			   System.out.println("data get is-"+Org);
//			String via = via1;
//			 System.out.println("data get is-"+via);
//			String Des = des1;
//			 System.out.println("data get is-"+Des);
//			String com = com1;
//			 System.out.println("data get is-"+com);
//			String shippercode = shippercode1;
//			 System.out.println("data get is-"+shippercode);
//			//String customercode = "TESTDELDO";
//			String consigneecode =consigneecode1;
//			 System.out.println("data get is-"+consigneecode);
		//	String piece = "100";
			//String Gweight = "100";
//			String fligh1= flighta1;
//			 System.out.println("data get is-"+fligh1);
//			String fligh2 = flighta2;
			// System.out.println("veribals are woring fine");
			
////TO Dimension	
//			String dLength = "10";
//			String dWidth  = "10";
//			String dHeight = "10";
//			
			
//Change the dark mode 
//			System.out.println("A2A Booking flow is working");
//			driver.findElement(By.xpath("//div[@class='slider round']")).click(); //To Change the color mode
//			Thread.sleep(2000);
				
			
//Click to new order Tab
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.id("parent_1"))).build().perform();//New order Option selection
			driver.findElement(By.xpath("//a[@href='/create-booking']")).click(); // click on New order
		//	String Neworderurl = driver.getCurrentUrl();
			Thread.sleep(1000);
//To Reset the booking button
//			driver.findElement(By.xpath("//button[@title='Refresh']")).click(); // To Rest Booking Page
//			Thread.sleep(2000);	
//			

//To Select Station BOM Name
			
			driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).click();
			driver.findElement(By.xpath("//*[@formcontrolname='station_code']")).sendKeys(Org);
			//driver.findElement(By.xpath("//*[@class='drop_option ng-tns-c68-2']//child::mat-option")).click();//for live 
//  driver.findElement(By.xpath("//*[@class='mat-option mat-focus-indicator ng-star-inserted']")).click();//To QA 
			//driver.findElement(By.xpath("//*[@id='mat-option-144']")).click();//Dev Server
		
			
			
				
			//driver.get(Neworderurl);
			System.out.println("This is A2A Booking");
			
//Select Destination
		
			//driver.findElement(By.id("mat-select-12")).click();//Dev Server Click on Dev Server
			driver.findElement(By.xpath("//input[@name='destination']")).click(); // QA Server Click on des.
			
			driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(Des);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(Keys.ARROW_DOWN);
			//Thread.sleep(1000);
			
//Select commudity code:-
					
			driver.findElement(By.xpath("//input[@name='commodity_code']")).click();
			driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(com);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@name='commodity_code']")).sendKeys(Keys.ARROW_DOWN);
			//Thread.sleep(1000);
			
//Shipper Code Enter:-
			
			driver.findElement(By.xpath("//input[@name='shipperCode']")).click();
			driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(shippercode);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@name='shipperCode']")).sendKeys(Keys.ARROW_DOWN);
			//Thread.sleep(1000);
			
//Consignee Code Enter:-
			
			driver.findElement(By.xpath("//input[@name='consigneeCode']")).click();
			driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(consigneecode);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@name='consigneeCode']")).sendKeys(Keys.ARROW_DOWN);
		//	Thread.sleep(1000);

//TO Customer Code Enter:-
//			
//			driver.findElement(By.xpath("//input[@name='customer']")).click();
//			driver.findElement(By.xpath("//input[@name='customer']")).sendKeys(customercode);
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//input[@name='customer']")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//			Thread.sleep(2000);
			
//To Enter Pieces:-
			
			driver.findElement(By.xpath("//input[@name='total_pieces']")).sendKeys(String.valueOf(piece));
			//Thread.sleep(1000);
//TO Enter Gross Weight:-
			
			driver.findElement(By.xpath("//input[@name='gross_weight']")).sendKeys(String.valueOf(Gweight));
			//driver.findElement(By.xpath("//input[@formcontrolname='gross_weight']")).sendKeys(Keys.TAB);
			//Thread.sleep(1000);

//To Val Box No			
			
			
//			Select selectvalnum = new Select(driver.findElement(By.xpath("//*[@name='val_box_number']")));
//			selectvalnum.selectByVisibleText(valnum);
//			Thread.sleep(2000);
			
			
//			//Gross Weight Window Open
//			driver.findElement(By.xpath("//span[@title=\"Add New Dimension\"]")).click();
//			Thread.sleep(4000);
			
//			//click on deminsion delete 
//			WebElement routdel = driver.findElement(By.xpath("//button[@class='btn delete-btn btnColor']"));
//			JavascriptExecutor js3 = ((JavascriptExecutor)driver);
//			js3.executeScript("arguments[0].click();", routdel);
//			Thread.sleep(4000);
		
//			//Delete the demision row
//			 driver.findElement(By.xpath("//button[@class='btn delete-btn btnColor']")).click();	
//    		 Thread.sleep(4000);
			
//			 driver.findElement(By.xpath("//button[@title='Add Pieces']")).click();	
//    		 Thread.sleep(4000);

    		 // driver.findElement(By.xpath("//input[@class='form-control ng-pristine ng-valid ng-touched']")).click();
//			 driver.findElement(By.xpath("//table[@class='table deminsion-table']//child::tbody//child::tr[1]//child::td[2]//input")).sendKeys(dLength); //Length
//			 driver.findElement(By.xpath("//table[@class='table deminsion-table']//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(dWidth); //Width
//			 driver.findElement(By.xpath("//table[@class='table deminsion-table']//child::tbody//child::tr[1]//child::td[4]//input")).sendKeys(dHeight); //Height
			
//			 driver.findElement(By.xpath("//button[@title='Add Pieces']")).click();	
//    		 Thread.sleep(4000);
//    		 
//			 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]")).sendKeys(Keys.ENTER); //To Calculate weight
//			 Thread.sleep(2000);
//			 
//			 driver.findElement(By.xpath("//button[contains(text(),'Calculate')]/following-sibling::button")).sendKeys(Keys.ENTER); // To save weight
			// Thread.sleep(2000);
		
//	//To Shipper Invoice 
//			 driver.findElement(By.xpath("//input[@name='invoice_number']")).sendKeys("INv1234");
//			 
//	//To DV for Carriage
//			 driver.findElement(By.xpath("//input[@name='dv_for_carriage']")).sendKeys("100");

//select First Flight in route

				Select select_valn = new Select(driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[1]//select")));
				select_valn.selectByVisibleText("Flight");
			//	 Thread.sleep(2000);

		//Select Route Destination
				 driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(via);
				 Thread.sleep(1000);
				 driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN);
				 Thread.sleep(1000);
				 
		      //To Get Today Date
				  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
				  	Date SystemDate = new Date();
					String Dateofsystem = formatdate.format(SystemDate);	
					System.out.println(Dateofsystem);
					String arr[]=Dateofsystem.split("/");
					String days = arr[0];		
					int s = (int) Integer.parseInt(days);
					String day=String.valueOf(s+d); 
					System.out.println("This is the current day for today date"+ day);
				  
					//To Click the Datepicker in Route From Date
				  JavascriptExecutor js =(JavascriptExecutor)driver;
				  WebElement datepicker = driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[6]//input"));
				  js.executeScript("arguments[0].click()", datepicker);
				  Thread.sleep(1000);
				  
		//To click the date in route date
				  
				  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
				  for(WebElement ele:alldaate) 
				  {
					  String dt = ele.getText();
				//	  System.out.println(dt);
					  

					   if(dt.equals(day))
					  {
						//  System.out.println("inside of if condiction "+day +"calender day:-" + dt);
						  
						  ele.click();
						  break;
					  }
					 
				  }
				  
				 //fligh1
				  
				//select Flight in route
				  Thread.sleep(2000);
					Select select_flt = new Select(driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")));
					select_flt.selectByVisibleText(fligh1);
					// Thread.sleep(1000);
//				  
//			  	   Thread.sleep(5000);
//			  	   driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer']//child::tbody//child::tr[1]//child::td[7]//select")).click();
//			  	   Thread.sleep(3000);
//			  	 
//			  	   driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);;          
//			  	   Thread.sleep(2000);

			  	//To ScrollInto page
					WebElement awbtotal = driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select"));
					scrollIntoView(driver,awbtotal);
				//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[1]//child::td[7]//select")).sendKeys("100");
					 Thread.sleep(1000);
					
//---------Second Route
					
					//-------Add Second lage
					 driver.findElement(By.xpath("//button[@title='Add New Route']")).click();
					Thread.sleep(1000);
					
					//select Flight in route
					Select sselect_flt = new Select(driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[2]//child::td[1]//select")));
					sselect_flt.selectByVisibleText("Flight");
				//	 Thread.sleep(2000);

			//Select Route Destination
					 driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(Des);
					 Thread.sleep(1000);
					 driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[2]//child::td[3]//input")).sendKeys(Keys.ARROW_DOWN);
					 Thread.sleep(1000);
					 
			      //To Get Today Date
					  	DateFormat formatdate1 = new SimpleDateFormat("dd/MM/YYYY");
					  
						Date SystemDate1 = new Date();
					  	String Dateofsystem1 = formatdate1.format(SystemDate1);
						//String Dateofsystem1 = formatdate1.format(SystemDate1);	
					//	System.out.println(Dateofsystem1);
						String arr1[]=Dateofsystem1.split("/");
						String days1 = arr[0];		
						int s1 = (int) Integer.parseInt(days1);
						String day1=String.valueOf(s1+d); 
					//	System.out.println("This is the current day for today date"+ s1);
					  
						//To Click the Datepicker in Route From Date
					  JavascriptExecutor js1 =(JavascriptExecutor)driver;
					  WebElement datepicker1 = driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[2]//child::td[6]//input"));
					  js1.executeScript("arguments[0].click()", datepicker1);
					  Thread.sleep(1000);
					  
			//To click the date in route date
					  
					  List<WebElement> alldaate1 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
					  for(WebElement ele1:alldaate1) 
					  {
						  String dt1 = ele1.getText();
						//  System.out.println(dt1);
						  

						   if(dt1.equals(day1))
						  {
						//	  System.out.println("inside of if condiction "+day1 +"calender day:-" + dt1);
							  
							  ele1.click();
							  break;
						  }
						 
					  }
					  

					  //Select Flight Code
					  
					  
						//select Flight in route
					        Thread.sleep(2000);
							Select select_flt1 = new Select(driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[2]//child::td[7]//select")));
							select_flt1.selectByVisibleText(fligh2);
						//	 Thread.sleep(1000);

//				  	   driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer']//child::tbody//child::tr[2]//child::td[7]//select")).click();
//				  	  Thread.sleep(3000);
//				  	 
//				  	   driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer']//child::tbody//child::tr[2]//child::td[7]//select")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);;          
//				  	   Thread.sleep(2000);

				  	//To ScrollInto page
						WebElement awbtotal1 = driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer route_dv']//child::tbody//child::tr[2]//child::td[7]//select"));
						scrollIntoView(driver,awbtotal1);
					//	driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable datatable-scroll no-footer']//child::tbody//child::tr[2]//child::td[7]//select")).sendKeys("100");

					
//To Save Booking
			  	driver.findElement(By.xpath("//*[contains(text(),'Save Booking ')]")).click();	
			  	System.out.println("Booking save");
//			//To capture Save booking screenshort
			  	  Thread.sleep(8000);
//				  File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//				  
//		         //now copy screenshot to desired location using copyFile //method
//				  Files.copy (src, new File("C:\\Users\\devendra.singh1\\eclipse-workspace\\230_class\\Screenshot"+i+".png"));
				  String BookingStatus = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
				  System.out.println(BookingStatus);
				  Thread.sleep(4000);
			  		  
	// To Execute The AWB		  
					  driver.findElement(By.xpath("//button[@title='Execute']")).click();
					  Thread.sleep(4000);
					  System.out.println("Booking Execute");
				// Screen Shot for Execute	
//					  File src1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//					//now copy screenshot to desired location using copyFile //method
//					  Files.copy (src1, new File("C:\\Users\\devendra.singh1\\eclipse-workspace\\230_class\\Screenshot\\ExecuteScreenShort"+i+".png"));
//					  
					 String ExcuteStatus = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
					 System.out.println(ExcuteStatus);
					 Thread.sleep(7000);
					  
 //To Accpet the AWB
					
					driver.findElement(By.xpath("//*[@name='accept_piece']")).sendKeys(piece);  //Enter Pieces in accept Field
					driver.findElement(By.xpath("//*[@name='accept_weight']")).sendKeys(Gweight); // Enter Gweight in accept Field
//					Thread.sleep(2000);
					driver.findElement(By.xpath("//button[@title='Accept']")).click();
			  		Thread.sleep(2000);
			  		 
				    String AcceptStatus = driver.findElement(By.xpath("//*[@class='toast-top-right toast-container']")).getText();
				    System.out.println(AcceptStatus);
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
		//		    driver.close();
				      
			}
			System.out.println("booking save");	
		}
		
		}
		
//	}
	
		
		
		
	private static void scrollIntoView(WebDriver driver, WebElement awbtotal) {
		// TODO Auto-generated method stub
		
	}

}


