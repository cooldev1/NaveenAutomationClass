package My_TestListeners;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(My_TestListeners.ITestListnere.class)


public class Listnere_methodsClass extends Base_Class {
	//public WebDriver driver;
public	String Dest = "BOM";
public	String via = "BLR";
	
@BeforeMethod(groups="browserOpen")
public void SelectMenu() throws InterruptedException, IOException {
	  Openbrowser();
	
	  		driver.findElement(By.xpath("//div[@class='slider round']")).click();
		
	//Click to new order Tab
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("parent_1"))).build().perform();//New order Option selection
		driver.findElement(By.xpath("//a[@href='/create-booking']")).click(); // click on New order
		Thread.sleep(2000);		
		Assert.assertEquals("https://qa.thespicetag.com/create-booking", driver.getCurrentUrl());
		
	// To Rest Booking Page		
		driver.findElement(By.xpath("//button[@title='Refresh']")).click(); 
		Thread.sleep(2000);
	}


@Test(priority=1, groups="Booking_lable")
public void BookingLabelCheck() throws InterruptedException {
	
// Destination Testing
	
	//--------------Check CreatBooking name--------------
			WebElement Firstcontainer_lab = driver.findElement(By.xpath("//*[text()='Create Booking']"));
			Assert.assertEquals("Create Booking", Firstcontainer_lab.getText());
			System.out.println(Firstcontainer_lab.getText());
	//Check bookingType name
			WebElement bookingType_lab = driver.findElement(By.xpath("//*[contains(text(),'Booking Type')]"));
			Assert.assertEquals("Booking Type", bookingType_lab.getText());
			System.out.println(bookingType_lab.getText());
	//Check Partner Prefix name
			WebElement PartnerPrefix_lab = driver.findElement(By.xpath("//*[contains(text(),'Partner Prefix')]"));
			Assert.assertEquals("Partner Prefix*", PartnerPrefix_lab.getText());	
			System.out.println(PartnerPrefix_lab.getText());
	//Check AWB_# name
			WebElement AWB_lab = driver.findElement(By.xpath("//*[contains(text(),'AWB #')]"));
			Assert.assertEquals("AWB #", AWB_lab.getText());
			System.out.println(AWB_lab.getText());
	//Check PartnerCode name
			WebElement PartnerCode_lab = driver.findElement(By.xpath("//*[contains(text(),'Partner Code')]"));
			Assert.assertEquals("Partner Code*", PartnerCode_lab.getText());
			System.out.println(PartnerCode_lab.getText());
			
//---------Consignment Details-----------------
			
	//Check Consignment Details lable
			WebElement ConsignmentDetails_lab = driver.findElement(By.xpath("//*[contains(text(),'Consignment Details')]"));
			Assert.assertEquals("Consignment Details", ConsignmentDetails_lab.getText());
			System.out.println(ConsignmentDetails_lab.getText());
	//Check origin name
		WebElement org_lab = driver.findElement(By.xpath("//label[contains(text(),'Origin')][1]"));
		Assert.assertEquals("Origin*", org_lab.getText());
		System.out.println(org_lab.getText());
	//Check Destnation name
		WebElement des_lab = driver.findElement(By.xpath("//label[contains(text(),'Destination')][1]"));
		Assert.assertEquals("Destination*", des_lab.getText());
		System.out.println(des_lab.getText());
	//Check Commodity Code name
			WebElement com_lab = driver.findElement(By.xpath("//label[contains(text(),'Commodity Code')]"));
			Assert.assertEquals("Commodity Code*", com_lab.getText());
			System.out.println(com_lab.getText());
	//Check Payment Mode name
			WebElement PaymentMode_lab = driver.findElement(By.xpath("//label[contains(text(),'Payment Mode')]"));
			Assert.assertEquals("Payment Mode", PaymentMode_lab.getText());
			System.out.println(PaymentMode_lab.getText());
	//Check Bill To name
			WebElement BillTo_lab = driver.findElement(By.xpath("//label[contains(text(),'Bill To')][1]"));
			Assert.assertEquals("Bill To", BillTo_lab.getText());
			System.out.println(BillTo_lab.getText());		
	//Check Bill To Name 
			WebElement BillToName_lab = driver.findElement(By.xpath("//label[contains(text(),'Bill To Name')][1]"));
			Assert.assertEquals("Bill To Name", BillToName_lab.getText());
			System.out.println(BillToName_lab.getText());
	//Check Shipper Name 
			WebElement Shipper_lab = driver.findElement(By.xpath("//label[contains(text(),'Shipper')]"));
			Assert.assertEquals("Shipper", Shipper_lab.getText());
			System.out.println(Shipper_lab.getText());
	//Check Consignee Name 
			WebElement Consignee_lab = driver.findElement(By.xpath("//label[contains(text(),'Consignee')]"));
			Assert.assertEquals("Consignee*", Consignee_lab.getText());
			System.out.println(Consignee_lab.getText());
	//Check Customer Name 
			WebElement Customer_lab = driver.findElement(By.xpath("//label[contains(text(),'Customer')]"));
			Assert.assertEquals("Customer*", Customer_lab.getText());
			System.out.println(Customer_lab.getText());	
	//Check Pieces Name 
			WebElement Pieces_lab = driver.findElement(By.xpath("//label[contains(text(),'Pieces')]"));
			Assert.assertEquals("Pieces*", Pieces_lab.getText());
			System.out.println(Pieces_lab.getText());	
	//Check Gross Weight (Kg) Name 
			WebElement GrossWeight_lab = driver.findElement(By.xpath("//label[contains(text(),'Gross Weight (Kg)')]"));
			Assert.assertEquals("Gross Weight (Kg)", GrossWeight_lab.getText());
			System.out.println(GrossWeight_lab.getText());
	//Check Freight Forwarder Name 
			WebElement FreightForwarder_lab = driver.findElement(By.xpath("//label[contains(text(),'Freight Forwarder')]"));
			Assert.assertEquals("Freight Forwarder", FreightForwarder_lab.getText());
			System.out.println(FreightForwarder_lab.getText());
	//---------------Shipper Details------------------------------ 
			WebElement ShipperDetails_lab = driver.findElement(By.xpath("//b[contains(text(),'Shipper Details')]"));
			Assert.assertEquals("Shipper Details", ShipperDetails_lab.getText());
			System.out.println(ShipperDetails_lab.getText());	
	//Check Shpr Inv. No. Name 
			WebElement ShprInv_lab = driver.findElement(By.xpath("//label[contains(text(),'Shpr Inv. No.')]"));
			Assert.assertEquals("Shpr Inv. No.", ShprInv_lab.getText());
			System.out.println(ShprInv_lab.getText());		
	//-------------Other Details Name 
			WebElement OtherDetails_lab = driver.findElement(By.xpath("//b[contains(text(),'Other Details')]"));
			Assert.assertEquals("Other Details", OtherDetails_lab.getText());
			System.out.println(OtherDetails_lab.getText());	
	//DV For Carriage Name 
			WebElement DVForCarriage_lab = driver.findElement(By.xpath("//label[contains(text(),'DV For Carriage')]"));
			Assert.assertEquals("DV For Carriage", DVForCarriage_lab.getText());
			System.out.println(DVForCarriage_lab.getText());			
}


@Test(priority=2, groups="Positive_Flow")
public void Positive_Flow() throws InterruptedException {
	String des = "bom";
	//To Enter value
		WebElement desxpath = driver.findElement(By.xpath("//input[@name='destination']"));
		desxpath.sendKeys(des);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='mat-autocomplete-0']//child::mat-option")).click();
		
		
//------To Enter value Commodity code
				WebElement comm = driver.findElement(By.xpath("//input[@name='commodity_code']"));
				comm.sendKeys("GEN");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//div[@id='mat-autocomplete-1'][1]//child::mat-option[1]")).click();
								
	////Shipper code
				WebElement shipp = driver.findElement(By.xpath("//input[@name='shipperCode']"));
				shipp.sendKeys("TESTDELDO");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//div[@id='mat-autocomplete-2']//child::mat-option[1]")).click();
								
	
	//Consignee code
				WebElement cons = driver.findElement(By.xpath("//input[@name='consigneeCode']"));
				cons.sendKeys("TESTBOMDO");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='mat-autocomplete-3'][1]//child::mat-option[1]")).click();
					
   //----To Enter value customer code
	//			WebElement cust = driver.findElement(By.xpath("//input[@name='customer']"));
	//			cust.sendKeys("TESTDELDO");
	//			Thread.sleep(2000);
	//			driver.findElement(By.xpath("//div[@id='mat-autocomplete-4']//child::mat-option")).click();
	//			System.out.println("customer is clickable");
	//----To Enter value total_pieces code
				WebElement pic = driver.findElement(By.xpath("//input[@name='total_pieces']"));
				pic.sendKeys("1");
				Thread.sleep(1000);
	//----To Enter value gross_weight code
				WebElement gros = driver.findElement(By.xpath("//input[@name='gross_weight']"));
				gros.sendKeys("10");
				Thread.sleep(1000);			
//-----------------------------------Shipper Details---------------------------
		//----To Enter value invoice_number code
		//		WebElement invoice = driver.findElement(By.xpath("//input[@name='invoice_number']"));
		//		invoice.sendKeys("4321");
		//		Thread.sleep(2000);			
//--------------------------------------Others Details---------------------------------------------------------------
		//----To Enter value dv_for_carriage code
		//		WebElement dvcarri = driver.findElement(By.xpath("//input[@name='dv_for_carriage']"));
		//		dvcarri.sendKeys("123");
		//		Thread.sleep(2000);			

				//--------------Route Selection---------------------------------------------------------------------------------			
		// Add Single Route Flight 
				 Select select = new Select(driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable no-footer']//child::tbody//child::tr//child::td//child::div//child::select")));
				 select.selectByVisibleText("Flight");
				 Thread.sleep(1000);
				 
//------------------------Select Route Destination-----------------------------------------------------------------
				 // Add Single Route Flight 
				// Select select1 = new Select(driver.findElement(By.xpath("//select[@name='route_type']")));
				 driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable no-footer']//child::tbody//child::tr//child::td//child::div//child::select")).sendKeys(Keys.TAB,Keys.TAB,des);
				// select1.selectByVisibleText(des);
				 Thread.sleep(1000);
			//To Select Destination	 
				 driver.findElement(By.xpath("//div[@id='mat-autocomplete-7']//child::mat-option")).click();  
				   
			//To Get Today Date
				  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
					Date SystemDate = new Date();
					String Dateofsystem = formatdate.format(SystemDate);	
					System.out.println(Dateofsystem);
					String arr[]=Dateofsystem.split("/");
					String day = arr[0];
					System.out.println("This is the current day for today date:- "+day);
				  
					//To Click the Datepicker in Route From Date
				  JavascriptExecutor js =(JavascriptExecutor)driver;
				  WebElement datepicker = driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable no-footer']//child::tbody//child::tr//child::td[6]//child::input"));
				  js.executeScript("arguments[0].click()", datepicker);
				  
				  //To click the date in route date
				  
				  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
				
				  for(WebElement ele:alldaate) 
				  {
					 
					  String dt = ele.getText();
					 int dt1 = Integer.valueOf(dt);
					 if(dt1<10) {
					  String dt2 = "0"+dt;
					  System.out.println("it's less then 10:-"+ dt2);
					 }
					  else if(dt.equals(day))
					  {
						  ele.click();
						  break;
					  }
				  }
				  
				  //Select Flight Code
				    
				  	   Thread.sleep(1000);
				  	   driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable no-footer']//child::tbody//child::tr//child::td[7]//child::div//child::div//child::div//child::select")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER, Keys.ARROW_DOWN);
				  	   Thread.sleep(1000);
				  	//To Click on Save button
				  			WebElement clickbutton = driver.findElement(By.xpath("//*[@title='Save Booking']"));
				  			clickbutton.click();   
  		//alertErorrMsg
				  			Thread.sleep(2000);
				  			WebElement fltselError = driver.findElement(By.xpath("//*[@id='toast-container']"));
				  			String fltselErrorText = fltselError.getText();
				  			System.out.println("Popup msg:- " +fltselErrorText);
				  			// To splite error msg 
				  			String fltselErrorValue = fltselErrorText.substring(20,33);
				  			System.out.println("it's pieces error msg:-" +fltselErrorValue);
				  			Assert.assertEquals(fltselErrorValue, "Successfully ");
			
}


@Test(priority=3, groups="Destination_Errormsg")
public void DestinationFill_Errormsg() throws InterruptedException {
	String des = "bom";
	//To Enter value
		WebElement desxpath = driver.findElement(By.xpath("//input[@name='destination']"));
		desxpath.sendKeys(des);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='mat-autocomplete-0']//child::mat-option")).click();
		
	//To Click on Save button
		WebElement clickbutton = driver.findElement(By.xpath("//*[@title='Save Booking']"));
		clickbutton.click();
		System.out.println("submit buttion is working");
	//-------//----To get alertErorrMsg
		Thread.sleep(2000);
		WebElement ComError = driver.findElement(By.xpath("//*[@id='toast-container']"));
		String ComErrorText = ComError.getText();
		// To splite error msg 
		String ComErrorValue = ComErrorText.substring(ComErrorText.indexOf("Please"));
		Assert.assertEquals(ComErrorValue, "Please enter commodity code");
		System.out.println("it's commodity error msg:-" +ComErrorValue);
}

@Test(priority=4, groups="Destination_Errormsg")
public void Des_comFill_Errormsg() throws InterruptedException {
	String des = "bom";
	//To Enter value
		WebElement desxpath = driver.findElement(By.xpath("//input[@name='destination']"));
		desxpath.sendKeys(des);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='mat-autocomplete-0']//child::mat-option")).click();
		
		//To Enter commodity value
		WebElement comm = driver.findElement(By.xpath("//input[@name='commodity_code']"));
		comm.sendKeys("GEN");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='mat-autocomplete-1'][1]//child::mat-option[1]")).click();
		
	//To Click on Save button
		WebElement clickbutton = driver.findElement(By.xpath("//*[@title='Save Booking']"));
		clickbutton.click();
		//System.out.println("submit buttion is working");
	//-------//----To get alertErorrMsg
		Thread.sleep(2000);
		WebElement ComError = driver.findElement(By.xpath("//*[@id='toast-container']"));
		String ComErrorText = ComError.getText();
		// To splite error msg 
		String ComErrorValue = ComErrorText.substring(ComErrorText.indexOf("Please"));
		Assert.assertEquals(ComErrorValue, "Please enter consignee name");
		System.out.println("it's commodity error msg:-" +ComErrorValue);
}

@Test(priority=5, groups="Destination_Errormsg")
public void Des_com_shipFill_Errormsg() throws InterruptedException {
	String des = "bom";
	//Destination Enter 
		WebElement desxpath = driver.findElement(By.xpath("//input[@name='destination']"));
		desxpath.sendKeys(des);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='mat-autocomplete-0']//child::mat-option")).click();
		
	//commodity enter 
		WebElement comm = driver.findElement(By.xpath("//input[@name='commodity_code']"));
		comm.sendKeys("GEN");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='mat-autocomplete-1'][1]//child::mat-option[1]")).click();
	
	//Shipper enter
		WebElement shipp = driver.findElement(By.xpath("//input[@name='shipperCode']"));
		shipp.sendKeys("TESTDELDO");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='mat-autocomplete-2']//child::mat-option[1]")).click();	
		
		
	//To Click on Save button
		WebElement clickbutton = driver.findElement(By.xpath("//*[@title='Save Booking']"));
		clickbutton.click();
		System.out.println("submit buttion is working");
	//-------//----To get alertErorrMsg
		Thread.sleep(2000);
		WebElement shippError = driver.findElement(By.xpath("//*[@id='toast-container']"));
		String shippErrorText = shippError.getText();
		// To splite error msg 
		String shippErrorValue = shippErrorText.substring(shippErrorText.indexOf("Please"));
		Assert.assertEquals(shippErrorValue, "Please enter consignee name");
		System.out.println("it's consignee error msg:-" +shippErrorValue);
}

@Test(priority=6, groups="Destination_Errormsg")
public void Des_com_ship_ConFill_Errormsg() throws InterruptedException {
	String des = "bom";
	//Destination Enter 
		WebElement desxpath = driver.findElement(By.xpath("//input[@name='destination']"));
		desxpath.sendKeys(des);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='mat-autocomplete-0']//child::mat-option")).click();
		
	//commodity enter 
		WebElement comm = driver.findElement(By.xpath("//input[@name='commodity_code']"));
		comm.sendKeys("GEN");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='mat-autocomplete-1'][1]//child::mat-option[1]")).click();
	
	//Shipper enter
	//	WebElement shipp = driver.findElement(By.xpath("//input[@name='shipperCode']"));
	//	shipp.sendKeys("TESTDELDO");
	//	Thread.sleep(2000);
	//	driver.findElement(By.xpath("//div[@id='mat-autocomplete-2']//child::mat-option[1]")).click();	
	
	//Consignee code
		WebElement cons = driver.findElement(By.xpath("//input[@name='consigneeCode']"));
		cons.sendKeys("TESTBOMDO");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='mat-autocomplete-3'][1]//child::mat-option[1]")).click();
		
	//To Click on Save button
		WebElement clickbutton = driver.findElement(By.xpath("//*[@title='Save Booking']"));
		clickbutton.click();
		System.out.println("submit buttion is working");
	//-------//----To get alertErorrMsg
		Thread.sleep(2000);
		WebElement ConError = driver.findElement(By.xpath("//*[@id='toast-container']"));
		String ConErrorText = ConError.getText();
		// To splite error msg 
		String ConErrorValue = ConErrorText.substring(ConErrorText.indexOf("Please"));
		Assert.assertEquals(ConErrorValue, "Please select customer");
		System.out.println("it's consignee error msg:-" +ConErrorValue);
}


@Test(priority=6, groups="Destination_Errormsg")
public void Des_com_ship_Con_CusFill_Errormsg() throws InterruptedException {
	String des = "bom";
	//Destination Enter 
		WebElement desxpath = driver.findElement(By.xpath("//input[@name='destination']"));
		desxpath.sendKeys(des);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='mat-autocomplete-0']//child::mat-option")).click();
		
	//commodity enter 
		WebElement comm = driver.findElement(By.xpath("//input[@name='commodity_code']"));
		comm.sendKeys("GEN");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='mat-autocomplete-1'][1]//child::mat-option[1]")).click();
	
	//Shipper enter
		WebElement shipp = driver.findElement(By.xpath("//input[@name='shipperCode']"));
		shipp.sendKeys("TESTDELDO");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='mat-autocomplete-2']//child::mat-option[1]")).click();	
	
	//Consignee code
		WebElement cons = driver.findElement(By.xpath("//input[@name='consigneeCode']"));
		cons.sendKeys("TESTBOMDO");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='mat-autocomplete-3'][1]//child::mat-option[1]")).click();
   //customer code
//		WebElement cust = driver.findElement(By.xpath("//input[@name='customer']"));
//		cust.sendKeys("TESTDELDO");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//div[@id='mat-autocomplete-4']//child::mat-option")).click();
//		Thread.sleep(2000);
	//To Click on Save button
		WebElement clickbutton = driver.findElement(By.xpath("//*[@title='Save Booking']"));
		clickbutton.click();
		System.out.println("submit buttion is working");
	//-------//----To get alertErorrMsg
		Thread.sleep(2000);
		WebElement CusError = driver.findElement(By.xpath("//*[@id='toast-container']"));
		String CusErrorText = CusError.getText();
		// To splite error msg 
		String ComErrorValue = CusErrorText.substring(CusErrorText.indexOf("Please"));
		Assert.assertEquals(ComErrorValue, "Please enter pieces");
		System.out.println("it's pieces error msg:-" +ComErrorValue);
}

@Test(priority=7, groups="Destination_Errormsg")
public void Des_com_ship_Con_Cus_picFill_Errormsg() throws InterruptedException {
	String des = "bom";
	//Destination Enter 
		WebElement desxpath = driver.findElement(By.xpath("//input[@name='destination']"));
		desxpath.sendKeys(des);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='mat-autocomplete-0']//child::mat-option")).click();
		
	//commodity enter 
		WebElement comm = driver.findElement(By.xpath("//input[@name='commodity_code']"));
		comm.sendKeys("GEN");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='mat-autocomplete-1'][1]//child::mat-option[1]")).click();
	
	//Shipper enter
		WebElement shipp = driver.findElement(By.xpath("//input[@name='shipperCode']"));
		shipp.sendKeys("TESTDELDO");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='mat-autocomplete-2']//child::mat-option[1]")).click();	
	
	//Consignee code
		WebElement cons = driver.findElement(By.xpath("//input[@name='consigneeCode']"));
		cons.sendKeys("TESTBOMDO");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='mat-autocomplete-3'][1]//child::mat-option[1]")).click();
   //customer code
	//	WebElement cust = driver.findElement(By.xpath("//input[@name='customer']"));
	//	cust.sendKeys("TESTDELDO");
	//	Thread.sleep(2000);
	//	driver.findElement(By.xpath("//div[@id='mat-autocomplete-4']//child::mat-option")).click();
	//	Thread.sleep(2000);
		
	//Pieces code
		WebElement pic = driver.findElement(By.xpath("//input[@name='total_pieces']"));
		pic.sendKeys("1");
		Thread.sleep(2000);	
		
	//To Click on Save button
		WebElement clickbutton = driver.findElement(By.xpath("//*[@title='Save Booking']"));
		clickbutton.click();
		System.out.println("submit buttion is working");
	//-------//----To get alertErorrMsg
		Thread.sleep(2000);
		WebElement picError = driver.findElement(By.xpath("//*[@id='toast-container']"));
		String picErrorText = picError.getText();
		// To splite error msg 
		String picErrorValue = picErrorText.substring(picErrorText.indexOf("Please"));
		Assert.assertEquals(picErrorValue, "Please enter gross weight");
		System.out.println("it's pieces error msg:-" +picErrorValue);
}

@Test(priority=8, groups="Destination_Errormsg")
public void Des_com_ship_Con_Cus_pic_grossFill_Errormsg() throws InterruptedException {
	String des = "bom";
	//Destination Enter 
		WebElement desxpath = driver.findElement(By.xpath("//input[@name='destination']"));
		desxpath.sendKeys(des);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='mat-autocomplete-0']//child::mat-option")).click();
		
	//commodity enter 
		WebElement comm = driver.findElement(By.xpath("//input[@name='commodity_code']"));
		comm.sendKeys("GEN");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='mat-autocomplete-1'][1]//child::mat-option[1]")).click();
	
	//Shipper enter
		WebElement shipp = driver.findElement(By.xpath("//input[@name='shipperCode']"));
		shipp.sendKeys("TESTDELDO");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='mat-autocomplete-2']//child::mat-option[1]")).click();	
	
	//Consignee code
		WebElement cons = driver.findElement(By.xpath("//input[@name='consigneeCode']"));
		cons.sendKeys("TESTBOMDO");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='mat-autocomplete-3'][1]//child::mat-option[1]")).click();
   //customer code
	//	WebElement cust = driver.findElement(By.xpath("//input[@name='customer']"));
	//	cust.sendKeys("TESTDELDO");
	//	Thread.sleep(2000);
	//	driver.findElement(By.xpath("//div[@id='mat-autocomplete-4']//child::mat-option")).click();
	//	Thread.sleep(2000);
		
	//Pieces code
		WebElement pic = driver.findElement(By.xpath("//input[@name='total_pieces']"));
		pic.sendKeys("1");
		Thread.sleep(2000);	
	//Gross_weight code
		WebElement gros = driver.findElement(By.xpath("//input[@name='gross_weight']"));
		gros.sendKeys("10");
		Thread.sleep(2000);	
		
	//To Click on Save button
		WebElement clickbutton = driver.findElement(By.xpath("//*[@title='Save Booking']"));
		clickbutton.click();
		//System.out.println("submit buttion is working");
	//-------//----To get alertErorrMsg
		Thread.sleep(2000);
		WebElement grossError = driver.findElement(By.xpath("//*[@id='toast-container']"));
		String grossErrorText = grossError.getText();
		System.out.println("Error msg for route" +grossErrorText);
		// To splite error msg 
		String grossErrorValue = grossErrorText.substring(grossErrorText.indexOf("Route"));
		System.out.println("Route blank:-" +grossErrorValue);
		Assert.assertEquals(grossErrorValue, "Route type cannot be empty");
		
}


@Test(priority=9, groups="Destination_Errormsg")
public void Des_com_ship_Con_Cus_pic_gross_flgtSelFill_Errormsg() throws InterruptedException {
	String des = "bom";
	//Destination Enter 
		WebElement desxpath = driver.findElement(By.xpath("//input[@name='destination']"));
		desxpath.sendKeys(des);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='mat-autocomplete-0']//child::mat-option")).click();
		
	//commodity enter 
		WebElement comm = driver.findElement(By.xpath("//input[@name='commodity_code']"));
		comm.sendKeys("GEN");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='mat-autocomplete-1'][1]//child::mat-option[1]")).click();
	
	//Shipper enter
		WebElement shipp = driver.findElement(By.xpath("//input[@name='shipperCode']"));
		shipp.sendKeys("TESTDELDO");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='mat-autocomplete-2']//child::mat-option[1]")).click();	
	
	//Consignee code
		WebElement cons = driver.findElement(By.xpath("//input[@name='consigneeCode']"));
		cons.sendKeys("TESTBOMDO");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='mat-autocomplete-3'][1]//child::mat-option[1]")).click();
   //customer code
	//	WebElement cust = driver.findElement(By.xpath("//input[@name='customer']"));
	//	cust.sendKeys("TESTDELDO");
	//	Thread.sleep(2000);
	//	driver.findElement(By.xpath("//div[@id='mat-autocomplete-4']//child::mat-option")).click();
	//	Thread.sleep(2000);
		
	//Pieces code
		WebElement pic = driver.findElement(By.xpath("//input[@name='total_pieces']"));
		pic.sendKeys("1");
		Thread.sleep(2000);	
	//Gross_weight code
		WebElement gros = driver.findElement(By.xpath("//input[@name='gross_weight']"));
		gros.sendKeys("10");
		Thread.sleep(2000);	
		
	//Flight select 
			 Select select = new Select(driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable no-footer']//child::tbody//child::tr//child::td//child::div//child::select")));
			 select.selectByVisibleText("Flight");
			 Thread.sleep(2000);
		
//Click on Save button
		WebElement clickbutton = driver.findElement(By.xpath("//*[@title='Save Booking']"));
		clickbutton.click();
		System.out.println("submit buttion is working");
//alertErorrMsg
		Thread.sleep(2000);
		WebElement fltselError = driver.findElement(By.xpath("//*[@id='toast-container']"));
		String fltselErrorText = fltselError.getText();
		// To splite error msg 
		String fltselErrorValue = fltselErrorText.substring(fltselErrorText.indexOf("Flight"));
		Assert.assertEquals(fltselErrorValue, "Flight destination cannot be empty");
		System.out.println("it's pieces error msg:-" +fltselErrorValue);
}


@Test(priority=10, groups="Destination_Errormsg")
public void Des_com_ship_Con_Cus_pic_gross_fltSel_fltdesFill_Errormsg() throws InterruptedException {
	String des = "bom";
	//Destination Enter 
		WebElement desxpath = driver.findElement(By.xpath("//input[@name='destination']"));
		desxpath.sendKeys(des);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='mat-autocomplete-0']//child::mat-option")).click();
		
	//commodity enter 
		WebElement comm = driver.findElement(By.xpath("//input[@name='commodity_code']"));
		comm.sendKeys("GEN");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='mat-autocomplete-1'][1]//child::mat-option[1]")).click();
	
	//Shipper enter
		WebElement shipp = driver.findElement(By.xpath("//input[@name='shipperCode']"));
		shipp.sendKeys("TESTDELDO");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='mat-autocomplete-2']//child::mat-option[1]")).click();	
	
	//Consignee code
		WebElement cons = driver.findElement(By.xpath("//input[@name='consigneeCode']"));
		cons.sendKeys("TESTBOMDO");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='mat-autocomplete-3'][1]//child::mat-option[1]")).click();
   //customer code
	//	WebElement cust = driver.findElement(By.xpath("//input[@name='customer']"));
	//	cust.sendKeys("TESTDELDO");
	//	Thread.sleep(2000);
	//	driver.findElement(By.xpath("//div[@id='mat-autocomplete-4']//child::mat-option")).click();
	//	Thread.sleep(2000);
		
	//Pieces code
		WebElement pic = driver.findElement(By.xpath("//input[@name='total_pieces']"));
		pic.sendKeys("1");
		Thread.sleep(2000);	
	//Gross_weight code
		WebElement gros = driver.findElement(By.xpath("//input[@name='gross_weight']"));
		gros.sendKeys("10");
		Thread.sleep(2000);	
		
	//Flight select 
			 Select select = new Select(driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable no-footer']//child::tbody//child::tr//child::td//child::div//child::select")));
			 select.selectByVisibleText("Flight");
			 Thread.sleep(2000);

	//To Destination
			 driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable no-footer']//child::tbody//child::tr//child::td//child::div//child::select")).sendKeys(Keys.TAB,Keys.TAB,des);
			Thread.sleep(2000);	 
			 driver.findElement(By.xpath("//div[@id='mat-autocomplete-7']//child::mat-option")).click();
		 
		
//Click on Save button
		WebElement clickbutton = driver.findElement(By.xpath("//*[@title='Save Booking']"));
		clickbutton.click();
		System.out.println("submit buttion is working");
//alertErorrMsg
		Thread.sleep(2000);
		WebElement fltselError = driver.findElement(By.xpath("//*[@id='toast-container']"));
		String fltselErrorText = fltselError.getText();
		// To splite error msg 
		String fltselErrorValue = fltselErrorText.substring(fltselErrorText.indexOf("Flight"));
		Assert.assertEquals(fltselErrorValue, "Flight date cannot be empty");
		System.out.println("it's pieces error msg:-" +fltselErrorValue);
}


@Test(priority=11, groups="Destination_Errormsg")
public void Des_com_ship_Con_Cus_pic_gross_fltSel_fltdes_fltdateFill_Errormsg() throws InterruptedException {
	String des = "bom";
	//Destination Enter 
		WebElement desxpath = driver.findElement(By.xpath("//input[@name='destination']"));
		desxpath.sendKeys(des);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='mat-autocomplete-0']//child::mat-option")).click();
		
	//commodity enter 
		WebElement comm = driver.findElement(By.xpath("//input[@name='commodity_code']"));
		comm.sendKeys("GEN");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='mat-autocomplete-1'][1]//child::mat-option[1]")).click();
	
	//Shipper enter
		WebElement shipp = driver.findElement(By.xpath("//input[@name='shipperCode']"));
		shipp.sendKeys("TESTDELDO");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='mat-autocomplete-2']//child::mat-option[1]")).click();	
	
	//Consignee code
		WebElement cons = driver.findElement(By.xpath("//input[@name='consigneeCode']"));
		cons.sendKeys("TESTBOMDO");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='mat-autocomplete-3'][1]//child::mat-option[1]")).click();
   //customer code
	//	WebElement cust = driver.findElement(By.xpath("//input[@name='customer']"));
	//	cust.sendKeys("TESTDELDO");
	//	Thread.sleep(2000);
	//	driver.findElement(By.xpath("//div[@id='mat-autocomplete-4']//child::mat-option")).click();
	//	Thread.sleep(2000);
		
	//Pieces code
		WebElement pic = driver.findElement(By.xpath("//input[@name='total_pieces']"));
		pic.sendKeys("1");
		Thread.sleep(2000);	
	//Gross_weight code
		WebElement gros = driver.findElement(By.xpath("//input[@name='gross_weight']"));
		gros.sendKeys("10");
		Thread.sleep(2000);	
		
	//Flight select 
			 Select select = new Select(driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable no-footer']//child::tbody//child::tr//child::td//child::div//child::select")));
			 select.selectByVisibleText("Flight");
			 Thread.sleep(2000);

	//To Destination
			 driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable no-footer']//child::tbody//child::tr//child::td//child::div//child::select")).sendKeys(Keys.TAB,Keys.TAB,des);
			Thread.sleep(2000);	 
			 driver.findElement(By.xpath("//div[@id='mat-autocomplete-7']//child::mat-option")).click();
			 
	//To Get Today Date
			  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
				Date SystemDate = new Date();
				String Dateofsystem = formatdate.format(SystemDate);	
				System.out.println(Dateofsystem);
				String arr[]=Dateofsystem.split("/");
				String day = arr[0];
				System.out.println("This is the current day for today date:- "+day);
			  
				//To Click the Datepicker in Route From Date
			  JavascriptExecutor js =(JavascriptExecutor)driver;
			  WebElement datepicker = driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable no-footer']//child::tbody//child::tr//child::td[6]//child::input[1]"));
			  js.executeScript("arguments[0].click()", datepicker);
			  Thread.sleep(2000);
			  
			  //To click the date in route date
			  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
			  for(WebElement ele:alldaate) 
			  {
				  String dt = ele.getText();
				  //String dt1 = "0"+dt;
				  System.out.println(dt);
				  if(dt.equals(day))
				  {
					  ele.click();
					  break;
				  }
			  }
	 
		
//Click on Save button
		WebElement clickbutton = driver.findElement(By.xpath("//*[@title='Save Booking']"));
		clickbutton.click();
		System.out.println("submit buttion is working");
//alertErorrMsg
		Thread.sleep(2000);
		WebElement fltselError = driver.findElement(By.xpath("//*[@id='toast-container']"));
		String fltselErrorText = fltselError.getText();
		// To splite error msg 
		String fltselErrorValue = fltselErrorText.substring(fltselErrorText.indexOf("Flight"));
		Assert.assertEquals(fltselErrorValue, "Flight cannot be empty");
		System.out.println("it's pieces error msg:-" +fltselErrorValue);
}

@Test(priority=12, groups="Destination_Errormsg")
public void SuccessfullBooking_Without_Errormsg() throws InterruptedException {
	String des = "bom";
	//Destination Enter 
		WebElement desxpath = driver.findElement(By.xpath("//input[@name='destination']"));
		desxpath.sendKeys(des);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='mat-autocomplete-0']//child::mat-option")).click();
		
	//commodity enter 
		WebElement comm = driver.findElement(By.xpath("//input[@name='commodity_code']"));
		comm.sendKeys("GEN");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='mat-autocomplete-1'][1]//child::mat-option[1]")).click();
	
	//Shipper enter
		WebElement shipp = driver.findElement(By.xpath("//input[@name='shipperCode']"));
		shipp.sendKeys("TESTDELDO");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='mat-autocomplete-2']//child::mat-option[1]")).click();	
	
	//Consignee code
		WebElement cons = driver.findElement(By.xpath("//input[@name='consigneeCode']"));
		cons.sendKeys("TESTBOMDO");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='mat-autocomplete-3'][1]//child::mat-option[1]")).click();
   //customer code
	//	WebElement cust = driver.findElement(By.xpath("//input[@name='customer']"));
	//	cust.sendKeys("TESTDELDO");
	//	Thread.sleep(1000);
	//	driver.findElement(By.xpath("//div[@id='mat-autocomplete-4']//child::mat-option")).click();
	//	Thread.sleep(2000);
		
	//Pieces code
		WebElement pic = driver.findElement(By.xpath("//input[@name='total_pieces']"));
		pic.sendKeys("1");
		//Thread.sleep(1000);	
	//Gross_weight code
		WebElement gros = driver.findElement(By.xpath("//input[@name='gross_weight']"));
		gros.sendKeys("10");
		//Thread.sleep(1000);	
		
	//Flight select 
			 Select select = new Select(driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable no-footer']//child::tbody//child::tr//child::td//child::div//child::select")));
			 select.selectByVisibleText("Flight");  
			 Thread.sleep(1000);

	//To Destination
			 driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable no-footer']//child::tbody//child::tr//child::td//child::div//child::select")).sendKeys(Keys.TAB,Keys.TAB,des);
			Thread.sleep(1000);	 
			 driver.findElement(By.xpath("//div[@id='mat-autocomplete-7']//child::mat-option")).click();
			 
	//To Get Today Date
			  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
				Date SystemDate = new Date();
				String Dateofsystem = formatdate.format(SystemDate);	
				System.out.println(Dateofsystem);
				String arr[]=Dateofsystem.split("/");
				String day = arr[0];
				System.out.println("This is the current day for today date:- "+day);
			  
				//To Click the Datepicker in Route From Date
			  JavascriptExecutor js =(JavascriptExecutor)driver;
			  WebElement datepicker = driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable no-footer']//child::tbody//child::tr//child::td[6]//child::input[1]"));
			  js.executeScript("arguments[0].click()", datepicker);
			  
			  //To click the date in route date
			  
			  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
			  for(WebElement ele:alldaate) 
			  {
				   	 String dt1 = ele.getText();
				   	 System.out.println("it's get text value:-" +dt1);
				   	 	
						  if(dt1.equals(day)) {
						  ele.click();
					  break;
				  }
			  }
//Select Flight Code
			    
		  	   Thread.sleep(1000);
		  	   driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable no-footer']//child::tbody//child::tr//child::td[7]//child::div//child::select")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		  	   Thread.sleep(1000);
	
			  
		
//Click on Save button
		WebElement clickbutton = driver.findElement(By.xpath("//*[@title='Save Booking']"));
		clickbutton.click();
		System.out.println("submit buttion is working");
//alertErorrMsg
		Thread.sleep(2000);
		WebElement fltselError = driver.findElement(By.xpath("//*[@id='toast-container']"));
		String fltselErrorText = fltselError.getText();
		System.out.println("Popup msg:- " +fltselErrorText);
		// To splite error msg 
		String fltselErrorValue = fltselErrorText.substring(20,33);
		System.out.println("it's pieces error msg:-" +fltselErrorValue);
		Assert.assertEquals(fltselErrorValue, "Successfully ");
		
}


@Test(priority=14, groups="Commudity_Errormsg")
public void CommudityFill_Errormsg() throws InterruptedException {
	//To Enter value
	WebElement comm = driver.findElement(By.xpath("//input[@name='commodity_code']"));
	comm.sendKeys("GEN");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@id='mat-autocomplete-1'][1]//child::mat-option[1]")).click();
		
	//To Click on Save button
		WebElement clickbutton = driver.findElement(By.xpath("//*[@title='Save Booking']"));
		clickbutton.click();
		System.out.println("submit buttion is working");
	//-------//----To get alertErorrMsg
		Thread.sleep(2000);
		WebElement desError = driver.findElement(By.xpath("//*[@id='toast-container']"));
		String desErrorText = desError.getText();
		// To splite error msg 
		String ComErrorValue = desErrorText.substring(desErrorText.indexOf("Please"));
		Assert.assertEquals("Please enter destination", ComErrorValue);
		System.out.println("it's commodity error msg:-" +ComErrorValue);
}


//------------------------------------//--------------------------------------------------------------

@Test(priority=15, groups="DoubleLagRoute")
public void Double_lagRoute() throws InterruptedException {
	String des = "bom";
	String via = "maa";
	//To Enter value
		WebElement desxpath = driver.findElement(By.xpath("//input[@name='destination']"));
		desxpath.sendKeys(des);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='mat-autocomplete-0']//child::mat-option")).click();
		
		
//------To Enter value Commodity code
				WebElement comm = driver.findElement(By.xpath("//input[@name='commodity_code']"));
				comm.sendKeys("GEN");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='mat-autocomplete-1'][1]//child::mat-option[1]")).click();
								
	////Shipper code
				WebElement shipp = driver.findElement(By.xpath("//input[@name='shipperCode']"));
				shipp.sendKeys("TESTDELDO");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='mat-autocomplete-2']//child::mat-option[1]")).click();
								
	
	//Consignee code
				WebElement cons = driver.findElement(By.xpath("//input[@name='consigneeCode']"));
				cons.sendKeys("TESTBOMDO");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='mat-autocomplete-3'][1]//child::mat-option[1]")).click();
					
   //----To Enter value customer code
	//			WebElement cust = driver.findElement(By.xpath("//input[@name='customer']"));
	//			cust.sendKeys("TESTDELDO");
	//			Thread.sleep(2000);
	//			driver.findElement(By.xpath("//div[@id='mat-autocomplete-4']//child::mat-option")).click();
				
	//----To Enter value total_pieces code
				WebElement pic = driver.findElement(By.xpath("//input[@name='total_pieces']"));
				pic.sendKeys("1");
				Thread.sleep(1000);
	//----To Enter value gross_weight code
				WebElement gros = driver.findElement(By.xpath("//input[@name='gross_weight']"));
				gros.sendKeys("10");
				Thread.sleep(1000);			
//-----------------------------------Shipper Details---------------------------
		//----To Enter value invoice_number code
		//		WebElement invoice = driver.findElement(By.xpath("//input[@name='invoice_number']"));
		//		invoice.sendKeys("4321");
		//		Thread.sleep(2000);			
//--------------------------------------Others Details---------------------------------------------------------------
		//----To Enter value dv_for_carriage code
		//		WebElement dvcarri = driver.findElement(By.xpath("//input[@name='dv_for_carriage']"));
		//		dvcarri.sendKeys("123");
		//		Thread.sleep(2000);			

				
//--------------Route Selection---------------------------------------------------------------------------------			
		// Add Single Route Flight 
				 Select select = new Select(driver.findElement(By.xpath("//select[@name='route_type']")));
				 select.selectByVisibleText("Flight");
				 Thread.sleep(1000);
				 
//------------------------Select Route Destination-----------------------------------------------------------------
				 // Add Single Route Flight 
// Select select1 = new Select(driver.findElement(By.xpath("//select[@name='route_type']")));
				 driver.findElement(By.xpath("//input[@name='flight_origin']")).sendKeys(Keys.TAB,via);
				 Thread.sleep(1000);

//To Select Destination	 
				 driver.findElement(By.xpath("//div[@id='mat-autocomplete-7']//child::mat-option")).click();  
				   
			//To Get Today Date
				  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
					Date SystemDate = new Date();
					String Dateofsystem = formatdate.format(SystemDate);	
					System.out.println(Dateofsystem);
					String arr[]=Dateofsystem.split("/");
					String day = arr[0];
					System.out.println("This is the current day for today date:- "+day);
				  
					//To Click the Datepicker in Route From Date
				  JavascriptExecutor js =(JavascriptExecutor)driver;
				  WebElement datepicker = driver.findElement(By.xpath("//input[@name='from']"));
				  js.executeScript("arguments[0].click()", datepicker);
				  
				  //To click the date in route date
				  
				  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
				
				  for(WebElement ele:alldaate) 
				  {
					 
					  String dt = ele.getText();
					   	 System.out.println("it's get text value:-" +dt);
					   	 	
							  if(dt.equals(day)) {
								 ele.click();
						  break;
					  }
				  }
				  
				  //Select Flight Code
				    
				  	   Thread.sleep(1000);
				  	   driver.findElement(By.xpath("//select[@name='flight_code']")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER, Keys.ARROW_DOWN);
				  	   Thread.sleep(1000);

//-------Second lag ------------
				  //Add new route line
				  	   driver.findElement(By.xpath("//button[@title='Add New Route']")).click();
				  	   Thread.sleep(1000);
				  	   System.out.println("New Line Add");
				  	   
				  	   //Select Second lag flight
						 Select select1 = new Select(driver.findElement(By.xpath("//div[@class='datatable-scroll']//child::table//child::tbody//child::tr[2]//child::td[1]//child::div//child::select")));
						 select1.selectByVisibleText("Flight");
						 Thread.sleep(1000);
						 
				  //To Select Destination		 
						 driver.findElement(By.xpath("//div[@class='datatable-scroll']//child::table//child::tbody//child::tr[2]//child::td[1]//child::div//child::select")).sendKeys(Keys.TAB,Keys.TAB,des);
						 Thread.sleep(1000); 
						 driver.findElement(By.xpath("//div[@id='mat-autocomplete-8']//child::mat-option")).click();  

						   
					//To Get Today Date
						  	DateFormat formatdate1 = new SimpleDateFormat("dd/MM/YYYY");
							Date SystemDate1 = new Date();
							String Dateofsystem1 = formatdate1.format(SystemDate1);	
							System.out.println(Dateofsystem1);
							String arr1[]=Dateofsystem.split("/");
							String day1 = arr1[0];
							System.out.println("This is the current day for today date:- "+day1);
						  
							//To Click the Datepicker in Route From Date
						  JavascriptExecutor js1 =(JavascriptExecutor)driver;
						  WebElement datepicker1 = driver.findElement(By.xpath("//div[@class='datatable-scroll']//child::table//child::tbody//child::tr[2]//child::td[6]//input"));
						  js.executeScript("arguments[0].click()", datepicker1);
						  
						  //To click the date in route date
						  
						  List<WebElement> alldaate1 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
						
						  for(WebElement ele1:alldaate1) 
						  {
							  String dt1 = ele1.getText();
							   	 System.out.println("it's get text value:-" +dt1);
							   	 	
									  if(dt1.equals(day)) {
										 ele1.click();
										break;
									  }
						  }
						  
						  //Select Flight Code
						    
						  	   Thread.sleep(1000);
						  	   driver.findElement(By.xpath("//div[@class='datatable-scroll']//child::table//child::tbody//child::tr[2]//child::td[7]//child::select")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER, Keys.ARROW_DOWN);
						  	   Thread.sleep(1000);

				  	   
				  	   //To Click on Save button
				  			WebElement clickbutton = driver.findElement(By.xpath("//*[@title='Save Booking']"));
				  			clickbutton.click();   
  		//alertErorrMsg
				  			Thread.sleep(2000);
				  			WebElement fltselError = driver.findElement(By.xpath("//*[@id='toast-container']"));
				  			String fltselErrorText = fltselError.getText();
				  			System.out.println("Popup msg:- " +fltselErrorText);
				  			// To splite error msg 
				  			String fltselErrorValue = fltselErrorText.substring(20,33);
				  			System.out.println("it's pieces error msg:-" +fltselErrorValue);
				  			Assert.assertEquals(fltselErrorValue, "Successfully ");

}

//------------------------------------//--------------------------------------------------------------

@Test(priority=16, groups="DeletefirstRoute")
public void DeleteFist_Route() throws InterruptedException, IOException {
	String des = "bom";
	String via = "maa";
	String com = "GEN";
	String ship = "TESTDELDO";
	String con = "TESTBOMDO";
	String cus = "TESTDELDO";
	String pics = "1";
	String gross = "10";
	//---------------Get Data from Excel File------------------------------
	
	
	//--------------- To change color mode
	
	
			
	//To Enter value
		WebElement desxpath = driver.findElement(By.xpath("//input[@name='destination']"));
		desxpath.sendKeys(des);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='mat-autocomplete-0']//child::mat-option")).click();
		
		
//------To Enter value Commodity code
				WebElement comm = driver.findElement(By.xpath("//input[@name='commodity_code']"));
				comm.sendKeys(com);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='mat-autocomplete-1'][1]//child::mat-option[1]")).click();
								
	////Shipper code
				WebElement shipp = driver.findElement(By.xpath("//input[@name='shipperCode']"));
				shipp.sendKeys(ship);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='mat-autocomplete-2']//child::mat-option[1]")).click();
								
	
	//Consignee code
				WebElement cons = driver.findElement(By.xpath("//input[@name='consigneeCode']"));
				cons.sendKeys(con);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='mat-autocomplete-3'][1]//child::mat-option[1]")).click();
					
 //----To Enter value customer code
	//			WebElement cust = driver.findElement(By.xpath("//input[@name='customer']"));
	//			cust.sendKeys(cus);
	//			Thread.sleep(2000);
	//			driver.findElement(By.xpath("//div[@id='mat-autocomplete-4']//child::mat-option")).click();
				
	//----To Enter value total_pieces code
				WebElement pic = driver.findElement(By.xpath("//input[@name='total_pieces']"));
				pic.sendKeys(pics);
				Thread.sleep(1000);
	//----To Enter value gross_weight code
				WebElement gros = driver.findElement(By.xpath("//input[@name='gross_weight']"));
				gros.sendKeys(gross);
				Thread.sleep(1000);			
//-----------------------------------Shipper Details---------------------------
		//----To Enter value invoice_number code
		//		WebElement invoice = driver.findElement(By.xpath("//input[@name='invoice_number']"));
		//		invoice.sendKeys("4321");
		//		Thread.sleep(2000);			
//--------------------------------------Others Details---------------------------------------------------------------
		//----To Enter value dv_for_carriage code
		//		WebElement dvcarri = driver.findElement(By.xpath("//input[@name='dv_for_carriage']"));
		//		dvcarri.sendKeys("123");
		//		Thread.sleep(2000);			

//---------------- Delete first route by delete button
				driver.findElement(By.xpath("//button[@class='btn delete-btn btnColor'][1]")).click();
				Thread.sleep(3000);
				
	  //Add new route line
			  	   driver.findElement(By.xpath("//button[@title='Add New Route']")).click();
			  	   Thread.sleep(1000);
			  	   System.out.println("New Line Add");
				
				
//--------------Route Selection---------------------------------------------------------------------------------			
		// Add Single Route Flight 
				 Select select = new Select(driver.findElement(By.xpath("//select[@name='route_type']")));
				 select.selectByVisibleText("Flight");
				 Thread.sleep(2000);
				 
//------------------------Select Route Destination-----------------------------------------------------------------
				 // Add Single Route Flight 
//Select select1 = new Select(driver.findElement(By.xpath("//select[@name='route_type']")));
				 driver.findElement(By.xpath("//input[@name='flight_origin']")).sendKeys(Keys.TAB,via);
				 Thread.sleep(2000);
				 driver.findElement(By.xpath("//div[@id='mat-autocomplete-8']//child::mat-option")).click();  
				   
			//To Get Today Date
				  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
					Date SystemDate = new Date();
					String Dateofsystem = formatdate.format(SystemDate);	
					System.out.println(Dateofsystem);
					String arr[]=Dateofsystem.split("/");
					String day = arr[0];
					System.out.println("This is the current day for today date:- "+day);
				  
					//To Click the Datepicker in Route From Date
				  JavascriptExecutor js =(JavascriptExecutor)driver;
				  WebElement datepicker = driver.findElement(By.xpath("//input[@name='from']"));
				  js.executeScript("arguments[0].click()", datepicker);
				  
				  //To click the date in route date
				  
				  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
				
				  for(WebElement ele:alldaate) 
				  {
					 
					  String dt = ele.getText();
					   	 System.out.println("it's get text value:-" +dt);
					   	 	
							  if(dt.equals(day)) {
								 ele.click();
						  break;
					  }
				  }
				  
				  //Select Flight Code
				    
				  	   Thread.sleep(2000);
				  	   driver.findElement(By.xpath("//select[@name='flight_code']")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER, Keys.ARROW_DOWN);
				  	   Thread.sleep(2000);

//-------Second lag ------------
				  //Add new route line
				  	   driver.findElement(By.xpath("//button[@title='Add New Route']")).click();
				  	   Thread.sleep(2000);
				  	   System.out.println("New Line Add");
				  	   
				  	   //Select Second lag flight
						 Select select1 = new Select(driver.findElement(By.xpath("//div[@class='datatable-scroll']//child::table//child::tbody//child::tr[2]//child::td[1]//child::div//child::select")));
						 select1.selectByVisibleText("Flight");
						 Thread.sleep(2000);
						 
				  //To Select Destination		 
						 driver.findElement(By.xpath("//div[@class='datatable-scroll']//child::table//child::tbody//child::tr[2]//child::td[1]//child::div//child::select")).sendKeys(Keys.TAB,Keys.TAB,des);
						 Thread.sleep(2000); 
						 driver.findElement(By.xpath("//div[@id='mat-autocomplete-9']//child::mat-option")).click();  

						   
					//To Get Today Date
						  	DateFormat formatdate1 = new SimpleDateFormat("dd/MM/YYYY");
							Date SystemDate1 = new Date();
							String Dateofsystem1 = formatdate1.format(SystemDate1);	
							System.out.println(Dateofsystem1);
							String arr1[]=Dateofsystem.split("/");
							String day1 = arr1[0];
							System.out.println("This is the current day for today date:- "+day1);
						  
							//To Click the Datepicker in Route From Date
						  JavascriptExecutor js1 =(JavascriptExecutor)driver;
						  WebElement datepicker1 = driver.findElement(By.xpath("//div[@class='datatable-scroll']//child::table//child::tbody//child::tr[2]//child::td[6]//input"));
						  js.executeScript("arguments[0].click()", datepicker1);
						  
						  //To click the date in route date
						  
						  List<WebElement> alldaate1 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
						
						  for(WebElement ele1:alldaate1) 
						  {
							  String dt1 = ele1.getText();
							   	 System.out.println("it's get text value:-" +dt1);
							   	 	
									  if(dt1.equals(day)) {
										 ele1.click();
										break;
									  }
						  }
						  
		  //Select Flight Code
						    
						  	   Thread.sleep(2000);
						  	   driver.findElement(By.xpath("//div[@class='datatable-scroll']//child::table//child::tbody//child::tr[2]//child::td[7]//child::select")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER, Keys.ARROW_DOWN);
						  	   Thread.sleep(2000);

				  	   
				  	   //To Click on Save button
				  			WebElement clickbutton = driver.findElement(By.xpath("//*[@title='Save Booking']"));
				  			clickbutton.click();   

		//alertErorrMsg
				  			Thread.sleep(2000);
				  			WebElement fltselError = driver.findElement(By.xpath("//*[@id='toast-container']"));
				  			String fltselErrorText = fltselError.getText();
				  			System.out.println("Popup msg:- " +fltselErrorText);
				  			// To splite error msg 
				  			String fltselErrorValue = fltselErrorText.substring(20,33);
				  			System.out.println("it's pieces error msg:-" +fltselErrorValue);
				  			Assert.assertEquals(fltselErrorValue, "Successfully ");


}


//--------------Deleting second route after filling first route-------------------------------------
@Test(priority=17, groups="DeletesecondtRoute")
public void DeleteSecond_Route() throws InterruptedException, IOException {
	String des = "bom";
	String via = "maa";
	String com = "GEN";
	String ship = "TESTDELDO";
	String con = "TESTBOMDO";
	String cus = "TESTDELDO";
	String pics = "1";
	String gross = "10";
	
	//To Enter Destination value
		WebElement desxpath = driver.findElement(By.xpath("//input[@name='destination']"));
		desxpath.sendKeys(des);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='mat-autocomplete-0']//child::mat-option")).click();
		
		
//------To Enter value Commodity code
				WebElement comm = driver.findElement(By.xpath("//input[@name='commodity_code']"));
				comm.sendKeys(com);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='mat-autocomplete-1'][1]//child::mat-option[1]")).click();
								
	////Shipper code
				WebElement shipp = driver.findElement(By.xpath("//input[@name='shipperCode']"));
				shipp.sendKeys(ship);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='mat-autocomplete-2']//child::mat-option[1]")).click();
								
	
	//Consignee code
				WebElement cons = driver.findElement(By.xpath("//input[@name='consigneeCode']"));
				cons.sendKeys(con);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='mat-autocomplete-3'][1]//child::mat-option[1]")).click();
					
 //customer code
	//			WebElement cust = driver.findElement(By.xpath("//input[@name='customer']"));
	//			cust.sendKeys(cus);
	//			Thread.sleep(2000);
	//			driver.findElement(By.xpath("//div[@id='mat-autocomplete-4']//child::mat-option")).click();
				
	//pieces 
				WebElement pic = driver.findElement(By.xpath("//input[@name='total_pieces']"));
				pic.sendKeys(pics);
				Thread.sleep(1000);
	//gross_weight
				WebElement gros = driver.findElement(By.xpath("//input[@name='gross_weight']"));
				gros.sendKeys(gross);
				Thread.sleep(1000);			
				
	//invoice_number code
		//		WebElement invoice = driver.findElement(By.xpath("//input[@name='invoice_number']"));
		//		invoice.sendKeys("4321");
		//		Thread.sleep(2000);			

	//dv_for_carriage code
		//		WebElement dvcarri = driver.findElement(By.xpath("//input[@name='dv_for_carriage']"));
		//		dvcarri.sendKeys("123");
		//		Thread.sleep(2000);			

				
				
//--------------Route Selection---------------------------------------------------------------------------------			
		// Add Single Route Flight 
				 Select select = new Select(driver.findElement(By.xpath("//div[@class='ng-star-inserted']//child::select")));
				 select.selectByVisibleText("Flight");
				 Thread.sleep(2000);
				 
//----------Select Route Destination-----------------------------------------------------------------
				 // Add Single Route Flight 
//Select select1 = new Select(driver.findElement(By.xpath("//select[@name='route_type']")));
				 driver.findElement(By.xpath("//div[@class='ng-star-inserted']//child::select")).sendKeys(Keys.TAB,Keys.TAB,via);
				 Thread.sleep(2000);
//To Select Destination	 
				 driver.findElement(By.xpath("//div[@id='mat-autocomplete-7']//child::mat-option")).click();  
				   
			//To Get Today Date
				  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
					Date SystemDate = new Date();
					String Dateofsystem = formatdate.format(SystemDate);	
					System.out.println(Dateofsystem);
					String arr[]=Dateofsystem.split("/");
					String day = arr[0];
					System.out.println("This is the current day for today date:- "+day);
				  
					//To Click the Datepicker in Route From Date
				  JavascriptExecutor js =(JavascriptExecutor)driver;
				  WebElement datepicker = driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable no-footer']//child::tbody//child::tr[1]//child::td[6]//child::input[1]"));
				  js.executeScript("arguments[0].click()", datepicker);
				  
				  //To click the date in route date
				  
				  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
				
				  for(WebElement ele:alldaate) 
				  {
					 
					  String dt = ele.getText();
					   	 System.out.println("it's get text value:-" +dt);
					   	 	
							  if(dt.equals(day)) {
								 ele.click();
						  break;
					  }
				  }
				  
				  //Select Flight Code
				    
				  	   Thread.sleep(2000);
				  	   driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable no-footer']//child::tbody//child::tr[1]//child::td[7]//child::div//child::div//child::div//child::select")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER, Keys.ARROW_DOWN);
				  	   Thread.sleep(2000);


//-------Second lag ------------
	  //Add new route line
				  	   driver.findElement(By.xpath("//button[@title='Add New Route']")).click();
				  	   Thread.sleep(2000);
				  	   System.out.println("New Line Add");
				  	   
 	  //Select Second lag flight
						 Select select1 = new Select(driver.findElement(By.xpath("//div[@class='datatable-scroll']//child::table//child::tbody//child::tr[2]//child::td[1]//child::div//child::select")));
						 select1.selectByVisibleText("Flight");
						 Thread.sleep(2000);
						 
	  //To Select Destination		 
						 driver.findElement(By.xpath("//div[@class='datatable-scroll']//child::table//child::tbody//child::tr[2]//child::td[1]//child::div//child::select")).sendKeys(Keys.TAB,Keys.TAB,des);
						 Thread.sleep(2000); 
						 driver.findElement(By.xpath("//div[@id='mat-autocomplete-8']//child::mat-option")).click();  

						   
 	//To Get Today Date
						  	DateFormat formatdate1 = new SimpleDateFormat("dd/MM/YYYY");
							Date SystemDate1 = new Date();
							String Dateofsystem1 = formatdate1.format(SystemDate1);	
							System.out.println(Dateofsystem1);
							String arr1[]=Dateofsystem.split("/");
							String day1 = arr1[0];
							System.out.println("This is the current day for today date:- "+day1);
						  
	//To Click the Datepicker in Route From Date
						  JavascriptExecutor js1 =(JavascriptExecutor)driver;
						  WebElement datepicker1 = driver.findElement(By.xpath("//div[@class='datatable-scroll']//child::table//child::tbody//child::tr[2]//child::td[6]//input"));
						  js.executeScript("arguments[0].click()", datepicker1);
						  
						  //To click the date in route date
						  
						  List<WebElement> alldaate1 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
						
						  for(WebElement ele1:alldaate1) 
						  {
							  String dt1 = ele1.getText();
							   	 System.out.println("it's get text value:-" +dt1);
							   	 	
									  if(dt1.equals(day)) {
										 ele1.click();
										break;
									  }
						  }
						  
  //Select Flight Code
						    
						  	   Thread.sleep(2000);
						  	   driver.findElement(By.xpath("//div[@class='datatable-scroll']//child::table//child::tbody//child::tr[2]//child::td[7]//child::select")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER, Keys.ARROW_DOWN);
						  	   Thread.sleep(2000);

//------Delete second leg----------------------------------
						  	   driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable no-footer']//child::tbody//child::tr[2]//child::td[8]//button")).click();
						  	   Thread.sleep(2000);

			 //Select Flight Code
							    
						  	   Thread.sleep(2000);
						  	   driver.findElement(By.xpath("//table[@class='table datatable-basic dataTable no-footer']//child::tbody//child::tr[1]//child::td[7]//child::div//child::div//child::div//child::select")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER, Keys.ARROW_DOWN);
						  	   Thread.sleep(2000);
						  	   //-----Third leg-------------------
//Add new route line
	     	  	   driver.findElement(By.xpath("//button[@title='Add New Route']")).click();
			  	   Thread.sleep(2000);
			  	   System.out.println("New Line Add");
											  	   
		     	   //Select Second lag flight
					 Select select2 = new Select(driver.findElement(By.xpath("//div[@class='datatable-scroll']//child::table//child::tbody//child::tr[2]//child::td[1]//child::div//child::select")));
						    select2.selectByVisibleText("Flight");
							Thread.sleep(2000);
													 
				  //To Select Destination		 
				 driver.findElement(By.xpath("//div[@class='datatable-scroll']//child::table//child::tbody//child::tr[2]//child::td[1]//child::div//child::select")).sendKeys(Keys.TAB,Keys.TAB,des);
				 Thread.sleep(2000); 
				 driver.findElement(By.xpath("//div[@id='mat-autocomplete-8']//child::mat-option")).click();  

													   
			 	//To Get Today Date
				  	DateFormat formatdate2 = new SimpleDateFormat("dd/MM/YYYY");
					Date SystemDate2 = new Date();
					String Dateofsystem2 = formatdate2.format(SystemDate2);	
					System.out.println(Dateofsystem2);
					String arr2[]=Dateofsystem2.split("/");
					String day2 = arr2[0];
					System.out.println("This is the current day for today date:- "+day2);
													  
			 //To Click the Datepicker in Route From Date
				  JavascriptExecutor js2 =(JavascriptExecutor)driver;
				  WebElement datepicker2 = driver.findElement(By.xpath("//div[@class='datatable-scroll']//child::table//child::tbody//child::tr[2]//child::td[6]//input"));
				  js.executeScript("arguments[0].click()", datepicker2);
													  
			//To click the date in route date
													  
				  List<WebElement> alldaate2 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));		
				  for(WebElement ele2:alldaate2)   {
					  String dt2 = ele2.getText();
				 	 System.out.println("it's get text value:-" +dt2);
														   	 	
					if(dt2.equals(day2)) {
	      			 ele2.click();
						break;
					}
			}
													  
			 //Select Flight Code
										    
				  Thread.sleep(2000);
				  driver.findElement(By.xpath("//div[@class='datatable-scroll']//child::table//child::tbody//child::tr[2]//child::td[7]//child::select")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER, Keys.ARROW_DOWN);
				  Thread.sleep(2000);
								
				  	   
	 	   //To Click on Save button
	  			WebElement clickbutton = driver.findElement(By.xpath("//*[@title='Save Booking']"));
	 			clickbutton.click();   

		//alertErorrMsg
				  			Thread.sleep(2000);
				  			WebElement fltselError = driver.findElement(By.xpath("//*[@id='toast-container']"));
				  			String fltselErrorText = fltselError.getText();
				  			System.out.println("Popup msg:- " +fltselErrorText);
				  			// To splite error msg 
				  			String fltselErrorValue = fltselErrorText.substring(20,33);
				  			System.out.println("it's pieces error msg:-" +fltselErrorValue);
				  			Assert.assertEquals(fltselErrorValue, "Successfully ");


}

//--------------third route testing-------------------------------------
@Test(priority=18, groups="ThirdRoute")
public void Third_Route() throws InterruptedException, IOException {
	String des = "bom";
	String via = "blr";
	String com = "GEN";
	String ship = "TESTDELDO";
	String con = "TESTBOMDO";
	String cus = "TESTDELDO";
	String pics = "1";
	String gross = "10";
	String via1	= "maa";	

	//To Enter Destination value
		WebElement desxpath = driver.findElement(By.xpath("//input[@name='destination']"));
		desxpath.sendKeys(des);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='mat-autocomplete-0']//child::mat-option")).click();
		
		
//------To Enter value Commodity code
				WebElement comm = driver.findElement(By.xpath("//input[@name='commodity_code']"));
				comm.sendKeys(com);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='mat-autocomplete-1'][1]//child::mat-option[1]")).click();
								
	////Shipper code
				WebElement shipp = driver.findElement(By.xpath("//input[@name='shipperCode']"));
				shipp.sendKeys(ship);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='mat-autocomplete-2']//child::mat-option[1]")).click();
								
	
	//Consignee code
				WebElement cons = driver.findElement(By.xpath("//input[@name='consigneeCode']"));
				cons.sendKeys(con);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='mat-autocomplete-3'][1]//child::mat-option[1]")).click();
					
	//customer code
	//			WebElement cust = driver.findElement(By.xpath("//input[@name='customer']"));
	//			cust.sendKeys(cus);
	//			Thread.sleep(2000);
	//			driver.findElement(By.xpath("//div[@id='mat-autocomplete-4']//child::mat-option")).click();
				
	//pieces 
				WebElement pic = driver.findElement(By.xpath("//input[@name='total_pieces']"));
				pic.sendKeys(pics);
				Thread.sleep(1000);
	//gross_weight
				WebElement gros = driver.findElement(By.xpath("//input[@name='gross_weight']"));
				gros.sendKeys(gross);
				Thread.sleep(1000);			
				
	//invoice_number code
		//		WebElement invoice = driver.findElement(By.xpath("//input[@name='invoice_number']"));
		//		invoice.sendKeys("4321");
		//		Thread.sleep(2000);			

	//dv_for_carriage code
		//		WebElement dvcarri = driver.findElement(By.xpath("//input[@name='dv_for_carriage']"));
		//		dvcarri.sendKeys("123");
		//		Thread.sleep(2000);			

				
				
//Route Selection---------------------------------------------------------------------------------			
		// Add Single Route Flight 
				 Select select = new Select(driver.findElement(By.xpath("//select[@name='route_type']")));
				 select.selectByVisibleText("Flight");
				 Thread.sleep(2000);
				 
//Route Destination-----------------------------------------------------------------
				 // Add Single Route Flight 
				 driver.findElement(By.xpath("//input[@name='flight_origin']")).sendKeys(Keys.TAB,via);
				 Thread.sleep(2000);
//To Select Destination	 
				 driver.findElement(By.xpath("//div[@id='mat-autocomplete-7']//child::mat-option")).click();  
				   
//To Get Today Date
				  	DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
					Date SystemDate = new Date();
					String Dateofsystem = formatdate.format(SystemDate);	
					System.out.println(Dateofsystem);
					String arr[]=Dateofsystem.split("/");
					String day = arr[0];
					System.out.println("This is the current day for today date:- "+day);
				  
//To Click the Datepicker in Route From Date
				  JavascriptExecutor js =(JavascriptExecutor)driver;
				  WebElement datepicker = driver.findElement(By.xpath("//input[@name='from']"));
				  js.executeScript("arguments[0].click()", datepicker);
				  
  //To click the date in route date
				  
				  List<WebElement> alldaate = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
				
				  for(WebElement ele:alldaate) 
				  {
					 
					  String dt = ele.getText();
					   	 System.out.println("it's get text value:-" +dt);
					   	 	
							  if(dt.equals(day)) {
								 ele.click();
						  break;
					  }
				  }
				  
  //Select Flight Code
				    
				  	   Thread.sleep(2000);
				  	   driver.findElement(By.xpath("//select[@name='flight_code']")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER, Keys.ARROW_DOWN);
				  	   Thread.sleep(2000);

//-------Second lag ------------
	  //Add new route line
				  	   driver.findElement(By.xpath("//button[@title='Add New Route']")).click();
				  	   Thread.sleep(2000);
				  	   System.out.println("New Line Add");
				  	   
				  	   //Select Second lag flight
						 Select select1 = new Select(driver.findElement(By.xpath("//div[@class='datatable-scroll']//child::table//child::tbody//child::tr[2]//child::td[1]//child::div//child::select")));
						 select1.selectByVisibleText("Flight");
						 Thread.sleep(2000);
						 
 //To Select Destination		 
						 driver.findElement(By.xpath("//div[@class='datatable-scroll']//child::table//child::tbody//child::tr[2]//child::td[1]//child::div//child::select")).sendKeys(Keys.TAB,Keys.TAB,via1);
						 Thread.sleep(2000); 
						 driver.findElement(By.xpath("//div[@id='mat-autocomplete-8']//child::mat-option")).click();  

						   
//To Get Today Date
						  	DateFormat formatdate1 = new SimpleDateFormat("dd/MM/YYYY");
							Date SystemDate1 = new Date();
							String Dateofsystem1 = formatdate1.format(SystemDate1);	
							System.out.println(Dateofsystem1);
							String arr1[]=Dateofsystem.split("/");
							String day1 = arr1[0];
							System.out.println("This is the current day for today date:- "+day1);
						  
//To Click the Datepicker in Route From Date
						  JavascriptExecutor js1 =(JavascriptExecutor)driver;
						  WebElement datepicker1 = driver.findElement(By.xpath("//div[@class='datatable-scroll']//child::table//child::tbody//child::tr[2]//child::td[6]//input"));
						  js.executeScript("arguments[0].click()", datepicker1);
						  
  //To click the date in route date
						  
						  List<WebElement> alldaate1 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));
						
						  for(WebElement ele1:alldaate1) 
						  {
							  String dt1 = ele1.getText();
							   	 System.out.println("it's get text value:-" +dt1);
							   	 	
									  if(dt1.equals(day)) {
										 ele1.click();
										break;
									  }
						  }
						  
//Select Flight Code
						    
						  	   Thread.sleep(2000);
						  	   driver.findElement(By.xpath("//div[@class='datatable-scroll']//child::table//child::tbody//child::tr[2]//child::td[7]//child::select")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER, Keys.ARROW_DOWN);
						  	   Thread.sleep(2000);
						  	 
//-------------- Third leg-------------------
				  //Add new route line
	     	  	   driver.findElement(By.xpath("//button[@title='Add New Route']")).click();
			  	   Thread.sleep(2000);
			  	   System.out.println("Third leg");
											  	   
   //Select Second lag flight
					 Select select2 = new Select(driver.findElement(By.xpath("//div[@class='datatable-scroll']//child::table//child::tbody//child::tr[3]//child::td[1]//child::div//child::select")));
						    select2.selectByVisibleText("Flight");
							Thread.sleep(2000);
													 
  //To Select Destination		 
				 driver.findElement(By.xpath("//div[@class='datatable-scroll']//child::table//child::tbody//child::tr[3]//child::td[1]//child::div//child::select")).sendKeys(Keys.TAB,Keys.TAB,des);
				 Thread.sleep(2000); 
				 driver.findElement(By.xpath("//div[@id='mat-autocomplete-9']//child::mat-option")).click();  

													   
 //To Get Today Date
				  	DateFormat formatdate2 = new SimpleDateFormat("dd/MM/YYYY");
					Date SystemDate2 = new Date();
					String Dateofsystem2 = formatdate2.format(SystemDate2);	
					System.out.println(Dateofsystem2);
					String arr2[]=Dateofsystem2.split("/");
					String day2 = arr2[0];
					System.out.println("This is the current day for today date:- "+day2);
													  
 //To Click the Datepicker in Route From Date
				  JavascriptExecutor js2 =(JavascriptExecutor)driver;
				  WebElement datepicker2 = driver.findElement(By.xpath("//div[@class='datatable-scroll']//child::table//child::tbody//child::tr[3]//child::td[6]//input"));
				  js.executeScript("arguments[0].click()", datepicker2);
													  
 //To click the date in route date
													  
				  List<WebElement> alldaate2 = driver.findElements(By.xpath("//table[@class='days weeks']//child::td"));		
				  for(WebElement ele2:alldaate2)   {
					  String dt2 = ele2.getText();
				 	 System.out.println("it's get text value:-" +dt2);
														   	 	
					if(dt2.equals(day2)) {
	      			 ele2.click();
						break;
					}
			}
													  
			 //Select Flight Code
										    
				  Thread.sleep(2000);
				  driver.findElement(By.xpath("//div[@class='datatable-scroll']//child::table//child::tbody//child::tr[3]//child::td[7]//child::select")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER, Keys.ARROW_DOWN);
				  Thread.sleep(2000);
				 	   //To Click on Save button
				  			WebElement clickbutton = driver.findElement(By.xpath("//*[@title='Save Booking']"));
				 			clickbutton.click();   

					//alertErorrMsg
					Thread.sleep(2000);
					WebElement fltselError = driver.findElement(By.xpath("//*[@id='toast-container']"));
					String fltselErrorText = fltselError.getText();
					System.out.println("Popup msg:- " +fltselErrorText);
		  			// To splite error msg 
		  			String fltselErrorValue = fltselErrorText.substring(20,33);
		  			System.out.println("it's pieces error msg:-" +fltselErrorValue);
		  			Assert.assertEquals(fltselErrorValue, "Successfully ");

	}


@AfterMethod(groups="BrowserClosed")
public void BrowserClosed() {
	driver.close();

}

}
	