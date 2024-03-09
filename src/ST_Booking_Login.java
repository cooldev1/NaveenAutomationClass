import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ST_Booking_Login extends Global_Class_Varivals {

	
	
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium libraby\\Sever Libarby\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();	
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("https://qa.thespicetag.com/login"); // For QA Server
	
			driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys("Devendra.singh1@spicejet.com");//User name Xpath for QA
		    driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("Welcome@123"); // (Password Xpath - QA Server)
			driver.findElement(By.xpath("//button[@class='btn btnColor btn-block auth-form-btn']")).click(); // login Button Xpath
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			
	// Change the dark mode 	
			
			WebElement dmode =driver.findElement(By.xpath("//div[@class='slider round']"));
			//driver.findElement(By.xpath("//div[@class='slider round']")).click(); //To Change the color mode
			checkEleVisibilty(driver, dmode, 1);
			eleclick(driver, dmode, 1);
			//Thread.sleep(2000);
	
			//Click to new order Tab
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.id("parent_1"))).build().perform();//New order Option selection
			WebElement neworderele = driver.findElement(By.xpath("//a[@href='/create-order']"));
			eleclick(driver, neworderele, 5);
			//driver.findElement(By.xpath("//a[@href='/create-order']")).click(); // click on New order
			//Thread.sleep(2000);
			
		//To Select Station Name
			String orgwh = "ND1";
			String orgWH = "DL1";
			String Org = "DEL";
			String Deswh = "Bl1";
			String Des = "BLR";
			String com = "GEN";
			String shippercode = "TESTDL1DD";
			String customercode = "TESTDL1DD";
			String consigneecode = "TESTBL1DD";
			String piece = "10";
			String Gweight = "10";
//TO Dimension	
			String dLength = "10";
			String dWidth  = "10";
			String dHeight = "10";
			
//To click on reset buttion			
			WebElement reset = driver.findElement(By.xpath("//*[@title='Reset']"));
			eleclick(driver, reset, 3);

//To Select Warehouse ND1
			WebElement warehouseele = driver.findElement(By.xpath("//*[@id='mat-select-0']"));
			eleclick(driver, warehouseele, 5);
			driver.findElement(By.xpath("//*[@placeholder='Enter station']")).sendKeys(orgwh,Keys.ENTER);
			WebDriverWait wait = new WebDriverWait(driver,2);
			WebElement warehousewait = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mat-option-773")));
			eleclick(driver, warehousewait, 2);
			
//To Select Destination	
			//Thread.sleep(2000);
			String deswh = "BO1";
			driver.findElement(By.xpath("//*[@id='mat-select-12']")).click();
			Thread.sleep(1000);
			WebElement desele = driver.findElement(By.xpath("//*[@placeholder='Please enter destination']"));
			driver.findElement(By.xpath("//*[@placeholder='Please enter destination']")).sendKeys(deswh);
			empwait(driver, desele, 2);
			//Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@placeholder='Please enter destination']")).sendKeys(Keys.ENTER);
		
	/*		// Select commudity code:-
			
			driver.findElement(By.xpath("//div[@id='mat-select-value-15']")).click();
			driver.findElement(By.xpath("//input[@placeholder='Please enter commodity']")).sendKeys(com);
			//Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='Please enter commodity']")).sendKeys(Keys.ENTER);
			//Thread.sleep(2000);
			
//Shipper Code Enter:-
			
			driver.findElement(By.xpath("//div[@id='mat-select-value-17']")).click();
			driver.findElement(By.xpath("//input[@placeholder='Please enter shipper']")).sendKeys(shippercode);
			//Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='Please enter shipper']")).sendKeys(Keys.ENTER);
			//Thread.sleep(2000);
			
//Consignee Code Enter:-
			
			driver.findElement(By.xpath("//div[@id='mat-select-value-19']")).click();
			driver.findElement(By.xpath("//input[@placeholder='Please enter consignee']")).sendKeys(consigneecode);
			//Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='Please enter consignee']")).sendKeys(Keys.ENTER);
			//Thread.sleep(2000);

//TO Customer Code Enter:-
			
			driver.findElement(By.xpath("//div[@id='mat-select-value-21']")).click();
			driver.findElement(By.xpath("//input[@placeholder='Please enter customer']")).sendKeys(customercode);
			//Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='Please enter customer']")).sendKeys(Keys.ENTER);
			//Thread.sleep(2000);	

	*/			  	   
	}

}
