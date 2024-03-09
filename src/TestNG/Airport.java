package TestNG;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
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
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;



public class Airport {

	public WebDriver driver;
	@BeforeMethod
	
	public void AirportGUI() throws InterruptedException
	
	{
		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium libraby\\Sever Libarby\\chromedriver_win32\\chromedriver.exe");
		    driver = new ChromeDriver();	
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			String url = "https://qa.thespicetag.com/login";
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//login
		if(url.equals(driver.getCurrentUrl())) {	//To QA Server
			WebElement useridxpath = driver.findElement(By.xpath("//*[@formcontrolname='name']")); // To userid xpath
			WebElement passxpath = driver.findElement(By.xpath("//*[@formcontrolname='password']")); //To Password xpath
			WebElement loginxpath = driver.findElement(By.xpath("//button[@class='btn btnColor btn-block auth-form-btn']")); //To Login xpath
			
			
			useridxpath.sendKeys("devendra.singh1@spicejet.com");
			passxpath.sendKeys("Welcome@123");
			loginxpath.click();
		}
		else if(url.equals(driver.getCurrentUrl())) //To Live Server
		{
			WebElement useridxpath = driver.findElement(By.xpath("//*[@formcontrolname='name']")); // To userid xpath
			WebElement passxpath = driver.findElement(By.xpath("//*[@formcontrolname='password']")); //To Password xpath
			WebElement loginxpath = driver.findElement(By.xpath("//button[@class='btn btnColor btn-block auth-form-btn']")); //To Login xpath
			
			
			useridxpath.sendKeys("devendra.singh1@spicejet.com");
			passxpath.sendKeys("Spice@123");
			loginxpath.click();
			
		}
		else if(url.equals(driver.getCurrentUrl())) //to Dev Server
		{
			WebElement useridxpath = driver.findElement(By.xpath("//*[@formcontrolname='name']")); // To userid xpath
			WebElement passxpath = driver.findElement(By.xpath("//*[@formcontrolname='password']")); //To Password xpath
			WebElement loginxpath = driver.findElement(By.xpath("//button[@class='btn btnColor btn-block auth-form-btn']")); //To Login xpath
			
			
			useridxpath.sendKeys("devendra.singh1@spicejet.com");
			passxpath.sendKeys("Welcome@123");
			loginxpath.click();
		}
 // To change color mode
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='slider round']")).click();
			
 //To Click on Airport menu		
			Actions acn = new Actions(driver);
			acn.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Organize')]"))).build().perform();
			acn.moveToElement(driver.findElement(By.xpath("//A[contains(text(),'Masters')]"))).build().perform();
			driver.findElement(By.xpath("//a[contains(text(),'Airport/Warehouse')]")).click();			
//To Click advance filter
			driver.findElement(By.xpath("//i[@class='fas fa-sliders-h']")).click();
			
//To Click on create airport
			driver.findElement(By.xpath("//button[contains(text(),'Create Airport')]")).click();

//To Reset size of screen
//			Actions acn1 = new Actions(driver);
//			acn1.sendKeys(Keys.CONTROL).build().perform();
//			acn1.sendKeys(Keys.SUBTRACT);
//			Thread.sleep(2000);
		
//To Click Submit Buttion to check all error msg
//			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
//			submitbuttion.click();
//			System.out.println("submit buttion clicked");
//			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
	}

				//-------------Airpot Creation WebElements

	@Test(priority=1, groups="Airport_lable")
	public void codeLabelCheck() throws InterruptedException, IOException
	{

			
	//To Check label of code		
			String codelab = "Code*";
			//WebElement code = driver.findElement(By.xpath("//*[@for='code' and text()='Code']"));
			WebElement codel = driver.findElement(By.xpath("//*[@class='col-md-2']//child::div//child::label[1]"));//To Lable
			Assert.assertEquals(codelab, codel.getText());
			System.out.println("Code- Lable is correct");
			//To Enter code
			WebElement codexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[1]//child::div//child::input[1]"));
			codexpath.sendKeys("dev");
	//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();

//----To check mandetry fields Error msg
			
			//To capture the error msg for Name			
			WebElement nameerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[2]//child::div//child::app-control-message//span"));
			nameerror.isDisplayed();
			Assert.assertEquals(nameerror.getText(), "Required");	
			System.out.println("Erorr message for name -" +nameerror.getText());
				
			//To capture the error msg for Type			
			WebElement Typeerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[3]//child::div//child::app-control-message//span"));
			Typeerror.isDisplayed();
			Assert.assertEquals(Typeerror.getText(), "Required");	
			System.out.println("Erorr message for Type  -" +Typeerror.getText());
			
			//To capture the error msg for Pincode			
			WebElement Pincoderror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[4]//child::div//child::app-control-message//span"));
			Pincoderror.isDisplayed();
			Assert.assertEquals(Pincoderror.getText(), "Required");	
			System.out.println("Erorr message for Pincode  -" +Pincoderror.getText());
			
			//To capture the error msg for Full Address			
			WebElement Fulladdresserror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[5]//child::div//child::app-control-message//span"));
			Fulladdresserror.isDisplayed();
			Assert.assertEquals(Fulladdresserror.getText(), "Required");	
			System.out.println("Erorr message for Full Address  -" +Fulladdresserror.getText());
			
			//To capture the error msg for City			
			WebElement Cityerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[6]//child::div//child::app-control-message//span"));
			Cityerror.isDisplayed();
			Assert.assertEquals(Cityerror.getText(), "Required");	
			System.out.println("Erorr message for City  -" +Cityerror.getText());
			
			//To capture the error msg for Country Code			
			WebElement CountryCodeerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[7]//child::div//child::app-control-message//span"));
			CountryCodeerror.isDisplayed();
			Assert.assertEquals(CountryCodeerror.getText(), "Required");	
			System.out.println("Erorr message for Country Code  -" +CountryCodeerror.getText());
			
			//To capture the error msg for State
			WebElement Stateerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[8]//child::div//child::app-control-message//span"));
			Stateerror.isDisplayed();
			Assert.assertEquals(Stateerror.getText(), "Required");	
			System.out.println("Erorr message for State  -" +Stateerror.getText());
			
			//To capture the error msg for Region
			WebElement Regionerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[9]//child::div//child::app-control-message//span"));
			Regionerror.isDisplayed();
			Assert.assertEquals(Regionerror.getText(), "Required");	
			System.out.println("Erorr message for Region  -" +Regionerror.getText());
			
			//To capture the error msg for Latitude
			WebElement Latitudeerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[19]//child::div//child::app-control-message//span"));
			Latitudeerror.isDisplayed();
			Assert.assertEquals(Latitudeerror.getText(), "Required");	
			System.out.println("Erorr message for Latitude  -" +Latitudeerror.getText());
			
			//To capture the error msg for Longitude
			WebElement Longitudeerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[20]//child::div//child::app-control-message//span"));
			Longitudeerror.isDisplayed();
			Assert.assertEquals(Longitudeerror.getText(), "Required");	
			System.out.println("Erorr message for Longitude  -" +Longitudeerror.getText());
			
			//To capture the error msg for Status
			WebElement Statuserror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[21]//child::div//child::app-control-message//span"));
			Statuserror.isDisplayed();
			Assert.assertEquals(Statuserror.getText(), "Required");	
			System.out.println("Erorr message for Status  -" +Statuserror.getText());
			
			//To capture the error msg for UOM
			WebElement UOMerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[26]//child::div//child::app-control-message//span"));
			UOMerror.isDisplayed();
			Assert.assertEquals(UOMerror.getText(), "Required");	
			System.out.println("Erorr message for UOM  -" +UOMerror.getText());
			
			//To capture the error msg for Time Zone
			WebElement TimeZoneerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[29]//child::div//child::app-control-message//span"));
			TimeZoneerror.isDisplayed();
			Assert.assertEquals(TimeZoneerror.getText(), "Required");	
			System.out.println("Erorr message for Time Zone  -" +TimeZoneerror.getText());
	
	// Screen Shot for Execute		
			  Thread.sleep(1000);
			  File src2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//now copy screenshot to desired location using copyFile //method
			  Files.copy (src2, new File("C:\\Users\\devendra.singh1\\eclipse-workspace\\230_class\\Screenshot\\1_Code.png"));	
	}
	
	@Test(priority=2)
	public void Namelabel() throws InterruptedException, IOException
	{
			String Namelab = "Name*";			
			WebElement Namel = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[2]//child::div//child::label"));
			Assert.assertEquals(Namelab, Namel.getText());
			System.out.println("Name- Label is correct");
			
			//To Enter Name xpath
			WebElement Namexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[2]//child::div//child::input"));
			Namexpath.sendKeys("Devendra Singh");
  //To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();
			
//----To check mandetry fields Error msg
			
			//To capture the error msg for Code			
			WebElement nameerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[1]//child::div//child::app-control-message//span"));
			nameerror.isDisplayed();
			Assert.assertEquals(nameerror.getText(), "Required");	
			System.out.println("Erorr message for name -" +nameerror.getText());
				
			//To capture the error msg for Type			
			WebElement Typeerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[3]//child::div//child::app-control-message//span"));
			Typeerror.isDisplayed();
			Assert.assertEquals(Typeerror.getText(), "Required");	
			System.out.println("Erorr message for Type  -" +Typeerror.getText());
			
			//To capture the error msg for Pincode			
			WebElement Pincoderror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[4]//child::div//child::app-control-message//span"));
			Pincoderror.isDisplayed();
			Assert.assertEquals(Pincoderror.getText(), "Required");	
			System.out.println("Erorr message for Pincode  -" +Pincoderror.getText());
			
			//To capture the error msg for Full Address			
			WebElement Fulladdresserror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[5]//child::div//child::app-control-message//span"));
			Fulladdresserror.isDisplayed();
			Assert.assertEquals(Fulladdresserror.getText(), "Required");	
			System.out.println("Erorr message for Full Address  -" +Fulladdresserror.getText());
			
			//To capture the error msg for City			
			WebElement Cityerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[6]//child::div//child::app-control-message//span"));
			Cityerror.isDisplayed();
			Assert.assertEquals(Cityerror.getText(), "Required");	
			System.out.println("Erorr message for City  -" +Cityerror.getText());
			
			//To capture the error msg for Country Code			
			WebElement CountryCodeerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[7]//child::div//child::app-control-message//span"));
			CountryCodeerror.isDisplayed();
			Assert.assertEquals(CountryCodeerror.getText(), "Required");	
			System.out.println("Erorr message for Country Code  -" +CountryCodeerror.getText());
			
			//To capture the error msg for State
			WebElement Stateerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[8]//child::div//child::app-control-message//span"));
			Stateerror.isDisplayed();
			Assert.assertEquals(Stateerror.getText(), "Required");	
			System.out.println("Erorr message for State  -" +Stateerror.getText());
			
			//To capture the error msg for Region
			WebElement Regionerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[9]//child::div//child::app-control-message//span"));
			Regionerror.isDisplayed();
			Assert.assertEquals(Regionerror.getText(), "Required");	
			System.out.println("Erorr message for Region  -" +Regionerror.getText());
			
			//To capture the error msg for Latitude
			WebElement Latitudeerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[19]//child::div//child::app-control-message//span"));
			Latitudeerror.isDisplayed();
			Assert.assertEquals(Latitudeerror.getText(), "Required");	
			System.out.println("Erorr message for Latitude  -" +Latitudeerror.getText());
			
			//To capture the error msg for Longitude
			WebElement Longitudeerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[20]//child::div//child::app-control-message//span"));
			Longitudeerror.isDisplayed();
			Assert.assertEquals(Longitudeerror.getText(), "Required");	
			System.out.println("Erorr message for Longitude  -" +Longitudeerror.getText());
			
			//To capture the error msg for Status
			WebElement Statuserror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[21]//child::div//child::app-control-message//span"));
			Statuserror.isDisplayed();
			Assert.assertEquals(Statuserror.getText(), "Required");	
			System.out.println("Erorr message for Status  -" +Statuserror.getText());
			
			//To capture the error msg for UOM
			WebElement UOMerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[26]//child::div//child::app-control-message//span"));
			UOMerror.isDisplayed();
			Assert.assertEquals(UOMerror.getText(), "Required");	
			System.out.println("Erorr message for UOM  -" +UOMerror.getText());
			
			//To capture the error msg for Time Zone
			WebElement TimeZoneerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[29]//child::div//child::app-control-message//span"));
			TimeZoneerror.isDisplayed();
			Assert.assertEquals(TimeZoneerror.getText(), "Required");	
			System.out.println("Erorr message for Time Zone  -" +TimeZoneerror.getText());

			// Screen Shot for Execute		
			  Thread.sleep(1000);
			  File src2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//now copy screenshot to desired location using copyFile //method
			  Files.copy (src2, new File("C:\\Users\\devendra.singh1\\eclipse-workspace\\230_class\\Screenshot\\2_Name.png"));	
			
	}

	
		@Test(priority=3)
	public void TypeLable() throws InterruptedException, IOException
	{
			String Typelab = "Type*";
			WebElement typel = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[3]//child::div//child::label[1]"));
			Assert.assertEquals(Typelab, typel.getText());
			System.out.println("Type- Label is correct");
			
			//To select Types (Airport/Warehoue)	
			WebElement Typepath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[3]//child::div//child::select"));
			Select sel = new Select(Typepath);
			sel.selectByIndex(2);
//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();	
			
//----To check mandetry fields Error msg
			
			//To capture the error msg for Type		
			WebElement nameerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[1]//child::div//child::app-control-message//span"));
			nameerror.isDisplayed();
			Assert.assertEquals(nameerror.getText(), "Required");	
			System.out.println("Erorr message for name -" +nameerror.getText());
				
			//To capture the error msg for Type			
			WebElement Typeerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[2]//child::div//child::app-control-message//span"));
			Typeerror.isDisplayed();
			Assert.assertEquals(Typeerror.getText(), "Required");	
			System.out.println("Erorr message for Type  -" +Typeerror.getText());
			
			//To capture the error msg for Pincode			
			WebElement Pincoderror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[4]//child::div//child::app-control-message//span"));
			Pincoderror.isDisplayed();
			Assert.assertEquals(Pincoderror.getText(), "Required");	
			System.out.println("Erorr message for Pincode  -" +Pincoderror.getText());
			
			//To capture the error msg for Full Address			
			WebElement Fulladdresserror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[5]//child::div//child::app-control-message//span"));
			Fulladdresserror.isDisplayed();
			Assert.assertEquals(Fulladdresserror.getText(), "Required");	
			System.out.println("Erorr message for Full Address  -" +Fulladdresserror.getText());
			
			//To capture the error msg for City			
			WebElement Cityerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[6]//child::div//child::app-control-message//span"));
			Cityerror.isDisplayed();
			Assert.assertEquals(Cityerror.getText(), "Required");	
			System.out.println("Erorr message for City  -" +Cityerror.getText());
			
			//To capture the error msg for Country Code			
			WebElement CountryCodeerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[7]//child::div//child::app-control-message//span"));
			CountryCodeerror.isDisplayed();
			Assert.assertEquals(CountryCodeerror.getText(), "Required");	
			System.out.println("Erorr message for Country Code  -" +CountryCodeerror.getText());
			
			//To capture the error msg for State
			WebElement Stateerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[8]//child::div//child::app-control-message//span"));
			Stateerror.isDisplayed();
			Assert.assertEquals(Stateerror.getText(), "Required");	
			System.out.println("Erorr message for State  -" +Stateerror.getText());
			
			//To capture the error msg for Region
			WebElement Regionerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[9]//child::div//child::app-control-message//span"));
			Regionerror.isDisplayed();
			Assert.assertEquals(Regionerror.getText(), "Required");	
			System.out.println("Erorr message for Region  -" +Regionerror.getText());
			
			//To capture the error msg for Latitude
			WebElement Latitudeerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[19]//child::div//child::app-control-message//span"));
			Latitudeerror.isDisplayed();
			Assert.assertEquals(Latitudeerror.getText(), "Required");	
			System.out.println("Erorr message for Latitude  -" +Latitudeerror.getText());
			
			//To capture the error msg for Longitude
			WebElement Longitudeerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[20]//child::div//child::app-control-message//span"));
			Longitudeerror.isDisplayed();
			Assert.assertEquals(Longitudeerror.getText(), "Required");	
			System.out.println("Erorr message for Longitude  -" +Longitudeerror.getText());
			
			//To capture the error msg for Status
			WebElement Statuserror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[21]//child::div//child::app-control-message//span"));
			Statuserror.isDisplayed();
			Assert.assertEquals(Statuserror.getText(), "Required");	
			System.out.println("Erorr message for Status  -" +Statuserror.getText());
			
			//To capture the error msg for UOM
			WebElement UOMerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[26]//child::div//child::app-control-message//span"));
			UOMerror.isDisplayed();
			Assert.assertEquals(UOMerror.getText(), "Required");	
			System.out.println("Erorr message for UOM  -" +UOMerror.getText());
			
			//To capture the error msg for Time Zone
			WebElement TimeZoneerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[29]//child::div//child::app-control-message//span"));
			TimeZoneerror.isDisplayed();
			Assert.assertEquals(TimeZoneerror.getText(), "Required");	
			System.out.println("Erorr message for Time Zone  -" +TimeZoneerror.getText());

			// Screen Shot for Execute		
			  Thread.sleep(1000);
			  File src2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//now copy screenshot to desired location using copyFile //method
			  Files.copy (src2, new File("C:\\Users\\devendra.singh1\\eclipse-workspace\\230_class\\Screenshot\\3_labType.png"));		

	}

		
	@Test(priority=4)
	public void PincodeLable()
	{
			String Pincodelab = "Pincode*";
			WebElement pincodel = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[4]//child::div//child::label"));
			Assert.assertEquals(Pincodelab, pincodel.getText());
			System.out.println("Pincode- Label is correct");
	
			//To Enter Pincode xpath
			WebElement Pincodexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[4]//child::div//child::input"));
			Pincodexpath.sendKeys("122017");
			
			//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();
			
	}

	
		@Test(priority=5)
	public void FullAddress()
	{
			String FullAddresslab= "Full Address*";
			WebElement Fulladdressl = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[5]//child::div//child::label"));
			Assert.assertEquals(FullAddresslab, Fulladdressl.getText());
			System.out.println("Full Address- Label is correct");
			
			//To Enter Full Address xpath
			WebElement Full_Addressxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[5]//child::div//child::input"));
			Full_Addressxpath.sendKeys("122017");
			
			//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();
	}	
			@Test(priority=6)
	public void CityLable()
	{
			String Citylab = "City*";
			WebElement cityl = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[6]//child::div//child::label"));
			Assert.assertEquals(Citylab, cityl.getText());
			System.out.println("City- Label is correct");
			
			//To Enter City xpath
			WebElement Cityxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[6]//child::div//child::input"));
			Cityxpath.sendKeys("Delhi");
			
			//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();
	
	}
			
	@Test(priority=7)
	public void CountryCodeLable()
	{
			String CountryCodeLab = "Country Code*";
			WebElement countrycodel = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[7]//child::div//child::label"));
			Assert.assertEquals(CountryCodeLab, countrycodel.getText());
			System.out.println("Country- Label is correct");
			
			//To Select Country Code xpath
			WebElement Country_Codexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[7]//child::div//child::select"));
			Select sel = new Select(Country_Codexpath);
			sel.selectByIndex(1);
			//Country_Codexpath.sendKeys("IN-INDIA");
			
			//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();
	}
				
	@Test(priority=8)
	public void StateLable()
	{
			String Statelab = "State*";
			WebElement statel = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[8]//child::div//child::label"));
			Assert.assertEquals(Statelab, statel.getText());
			System.out.println(statel.getText());
			System.out.println("State- Label is correct");
			
			//To Enter State xpath
			WebElement Statexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[8]//child::div//child::select"));
			Select sel = new Select(Statexpath);
			sel.selectByIndex(2);
			//Statexpath.sendKeys("07-DELHI");
			
			//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();
	}
	@Test(priority=9)
	public void RegionLable()
	{
			String Regionlab = "Region*";
			WebElement regionl = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[9]//child::div//child::label"));
			Assert.assertEquals(Regionlab, regionl.getText());
			System.out.println("Region- Label is correct");
			System.out.println(regionl.getText());
			//To Enter Region xpath
			WebElement Regionxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[9]//child::div//child::select"));
			Select sel = new Select(Regionxpath);
			sel.selectByIndex(1);
			//Regionxpath.sendKeys("East");
			
			//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();
	}
	@Test(priority=10)
	public void ManagerNameLable()
	{
			String ManagerNamelab = "Manager Name";
			WebElement Managernamel = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[10]//child::div//child::label"));
			Assert.assertEquals(ManagerNamelab, Managernamel.getText());
			System.out.println("ManagerName- Label is correct");
			//To Enter Manager Name xpath
			WebElement ManagerNamexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[10]//child::div//child::input"));
			ManagerNamexpath.sendKeys("Anand Bhardwaj");
			
			//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();
	}		
	@Test(priority=11)
	public void ManagerEmailID()
	{
			
			String ManagerEmailIDlab = "Manager Email ID";
			WebElement ManagerEmailIDl = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[11]//child::div//child::label"));
			Assert.assertEquals(ManagerEmailIDlab, ManagerEmailIDl.getText());
			System.out.println("ManagerEmailID- Label is correct");
			//To Enter ManagerEmailID xpath
			WebElement ManagerEmailIDxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[11]//child::div//child::input"));
			ManagerEmailIDxpath.sendKeys("avdesh@spicejet.com");
			
			//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();
	}		
	@Test(priority=12)
	public void ManagerContactNo()
	{
	
			String ManagerContactNolab = "Manager Contact No";
			WebElement ManagerContactNol = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[12]//child::div//child::label"));
			Assert.assertEquals(ManagerContactNolab, ManagerContactNol.getText());
			System.out.println("ManagerContactNo- Label is correct");
			//To Enter ManagerContactNo xpath
			WebElement ManagerContactNoxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[12]//child::div//child::input"));
			ManagerContactNoxpath.sendKeys("9871280848");
			
			//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();
	}		
	
	@Test(priority=13)
	public void StationEmailID()
	{	
			String StationEmailIDlab = "Station Email ID";
			WebElement StationEmailIDl = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[13]//child::div//child::label"));
			Assert.assertEquals(StationEmailIDlab, StationEmailIDl.getText());
			System.out.println("StationEmailID- Label is correct");
			//To Enter StationEmailID xpath
			WebElement StationEmailIDlxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[13]//child::div//child::input"));
			StationEmailIDlxpath.sendKeys("devendra.singh@gmail.com");
			
			//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();
	}
	@Test(priority=14)
	public void ShiftContactNo()
	{	
			String ShiftContactNolab = "Shift Contact No";
			WebElement ShiftContactNol = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[14]//child::div//child::label"));
			Assert.assertEquals(ShiftContactNolab, ShiftContactNol.getText());
			System.out.println("ShiftContactNo- Label is correct");
			//To Enter ShiftContactNo xpath
			WebElement ShiftContactNoxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[14]//child::div//child::input"));
			ShiftContactNoxpath.sendKeys("devendra.singh@gmail.com");
			
			//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();
	}		
	@Test(priority=15)
	public void LandlineNo()
	{
		String LandlineNolab = "Landline No";
		WebElement LandlineNol = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[15]//child::div//child::label"));
		Assert.assertEquals(LandlineNolab, LandlineNol.getText());
		System.out.println("LandlineNo- Label is correct");
		//To Enter LandlineNo xpath
		WebElement LandlineNoxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[15]//child::div//child::input"));
		LandlineNoxpath.sendKeys("devendra.singh@gmail.com");
		
		//To Click Submit Buttion to check all error msg
		WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
		submitbuttion.click();
	}
	@Test(priority=16)
	public void OfficeTime()
	{
			String OfficeTimelab = "Office Time";
			WebElement OfficeTimel = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[16]//child::div//child::label"));
			Assert.assertEquals(OfficeTimelab, OfficeTimel.getText());
			System.out.println("OfficeTime- Label is correct");
			//To Enter OfficeTime xpath
			WebElement OfficeTimexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[16]//child::div//child::input"));
			OfficeTimexpath.sendKeys("devendra.singh@gmail.com");
			
			//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();
	}
	
	@Test(priority=17)
	public void GLAccountCode()
	{
			//It will be faild because of no dropdown data
			String GLAccountCodelab = "GL Account Code";
			WebElement GLAccountCodel = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[17]//child::div//child::label"));
			Assert.assertEquals(GLAccountCodelab, GLAccountCodel.getText());
			System.out.println("GLAccountCode- Label is correct");
			System.out.println(GLAccountCodel.getText());
			//To Enter GLAccountCode xpath
	//		WebElement GLAccountCodexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[17]//child::div//child::select"));
	//		Select sel = new Select(GLAccountCodexpath);
	//		sel.selectByIndex(1);
			
			//To Click Submit Buttion to check all error msg
	//		WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
	//		submitbuttion.click();
	}
	@Test(priority=18)
	public void ULDEnabled()
	{
			String ULDEnabledlab ="ULD Enabled";
			WebElement ULDEnabledl = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[18]//child::div//child::label"));
			Assert.assertEquals(ULDEnabledlab, ULDEnabledl.getText());
			System.out.println("ULDEnabled- Label is correct");
			System.out.println(ULDEnabledl.getText());
			//To Enter ULDEnabled xpath
			WebElement ULDEnabledxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[18]//child::div//child::select"));
			Select sel = new Select(ULDEnabledxpath);
			sel.selectByIndex(1);
			
			//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();
	}
	@Test(priority=19)
	public void Latitude()
	{
			String Latitudelab = "Latitude*";
			WebElement Latitudel = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[19]//child::div//child::label"));
			Assert.assertEquals(Latitudelab, Latitudel.getText());
			System.out.println("Latitude- Label is correct");
			//To Enter Latitude xpath
			WebElement Latitudexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[19]//child::div//child::input"));
			Latitudexpath.sendKeys("111.2345");
			
			//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();
	}
	@Test(priority=20)
	public void Longitude()
	{
			String Longitudelab = "Longitude*";
			WebElement Longitudel = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[20]//child::div//child::label"));
			Assert.assertEquals(Longitudelab, Longitudel.getText());
			System.out.println("Longitude- Label is correct");
			//To Enter Longitude xpath
			WebElement Longitudexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[20]//child::div//child::input"));
			Longitudexpath.sendKeys("111.2345");
			
			//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();
	}
	@Test(priority=21)
	
	public void Status()
	{
			String Statuslab = "Status*";
			WebElement Statusl = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[21]//child::div//child::label"));
			Assert.assertEquals(Statuslab, Statusl.getText());
			System.out.println("Status- Label is correct");
			System.out.println(Statusl.getText());
			//To Enter Status xpath
			WebElement Statusxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[21]//child::div//child::select"));
			Select sel = new Select(Statusxpath);
			sel.selectByIndex(1);
			
			//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();
	}
	@Test(priority=22)
	public void MWBAgent()
	{
			String MWBAgentlab = "MWB Agent";
			WebElement MWBAgentl = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[22]//child::div//child::label"));
			Assert.assertEquals(MWBAgentlab, MWBAgentl.getText());
			System.out.println("MWBAgent- Label is correct");
			//To Enter MWBAgent xpath
			WebElement MWBAgentxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[22]//child::div//child::input"));
			MWBAgentxpath.sendKeys("MWBAgent");
			
			//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();
	}
	@Test(priority=23)
	public void MWBConsignee()
	{
			String MWBConsigneelab = "MWB Consignee";
			WebElement MWBConsigneel = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[23]//child::div//child::label"));
			Assert.assertEquals(MWBConsigneelab, MWBConsigneel.getText());
			System.out.println("MWBConsignee- Label is correct");
			//To Enter MWBConsignee xpath
			WebElement MWBConsigneexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[23]//child::div//child::input"));
			MWBConsigneexpath.sendKeys("MWBConsignee");
			
			//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();
	}	
	@Test(priority=24)
	public void MWBShipper()
	{
			String MWBShipperlab = "MWB Shipper";
			WebElement MWBShipperl = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[24]//child::div//child::label"));
			Assert.assertEquals(MWBShipperlab, MWBShipperl.getText());
			System.out.println("MWBShipper- Label is correct");
			//To Enter MWBShipper xpath
			WebElement MWBShipperxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[24]//child::div//child::input"));
			MWBShipperxpath.sendKeys("MWBShipper");
			
			//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();
			
	}
	@Test(priority=25)
	public void ProfitCenter()
	{
			String ProfitCenterlab = "Profit Center";
			WebElement ProfitCenterl = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[25]//child::div//child::label"));
			Assert.assertEquals(ProfitCenterlab, ProfitCenterl.getText());
			System.out.println("ProfitCenter- Label is correct");
			//To Enter ProfitCenter xpath
			WebElement ProfitCenterxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[25]//child::div//child::input"));
			ProfitCenterxpath.sendKeys("ProfitCenter");
			
			//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();
	}
	
	@Test(priority=26)
	public void UOM()
	{
			String UOMlab = "UOM*";
			WebElement UOMl = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[26]//child::div//child::label"));
			Assert.assertEquals(UOMlab, UOMl.getText());
			System.out.println("UOM- Label is correct");
			System.out.println(UOMl.getText());
			//To Enter UOM xpath
			WebElement UOMxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[26]//child::div//child::select"));
			Select sel = new Select(UOMxpath);
			sel.selectByIndex(1);
			//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();
	}
	@Test(priority=27)
	public void DimsUOM()
	{
			String DimsUOMLab = "Dims UOM";
			WebElement DimsUOMl = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[27]//child::div//child::label"));
			Assert.assertEquals(DimsUOMLab, DimsUOMl.getText());
			System.out.println("DimsUOMl- Label is correct");
			System.out.println(DimsUOMl.getText());
			//To Enter DimsUOM xpath
			WebElement DimsUOMxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[27]//child::div//child::select"));
			Select sel = new Select(DimsUOMxpath);
			sel.selectByIndex(1);
			//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();
	}
	@Test(priority=28)
	public void Metro()
	{
			String Metrolab = "Metro";
			WebElement Metrol = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[28]//child::div//child::label"));
			Assert.assertEquals(Metrolab, Metrol.getText());
			System.out.println("DimsUOMl- Label is correct");
			System.out.println(Metrol.getText());
			//To Enter Metro xpath
			WebElement Metroxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[28]//child::div//child::select"));
			Select sel = new Select(Metroxpath);
			sel.selectByIndex(1);
			//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();
	}
	@Test(priority=29)
	public void TimeZone()
	{
			String TimeZonelab = "Time Zone*";
			WebElement TimeZonel = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[29]//child::div//child::label"));
			Assert.assertEquals(TimeZonelab, TimeZonel.getText());
			System.out.println("TimeZone- Label is correct");
			System.out.println(TimeZonel.getText());
			//To Enter TimeZone xpath
			WebElement TimeZonexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[29]//child::div//child::select"));
			Select sel = new Select(TimeZonexpath);
			sel.selectByIndex(1);
			//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();
	}
	
	@Test(priority=30)
	public void AgingDaysfrom()
	{
			String AgingDaysfromlab = "Aging Days";
			WebElement AgingDaysfroml = driver.findElement(By.xpath("//input[@formcontrolname='aging_days_1']//following-sibling::label"));
			Assert.assertEquals(AgingDaysfromlab, AgingDaysfroml.getText());
			System.out.println("AgingDays- Label is correct");
			//To Enter AgingDaysfrom xpath
			WebElement AgingDaysfromxpath = driver.findElement(By.xpath("//input[@formcontrolname='aging_days_1']"));
			AgingDaysfromxpath.sendKeys("11");
			
			//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();
	}
	@Test(priority=31)
	public void AgingDaysTO()
	{
			String AgingDaysTOlab = "Aging Days";
			WebElement AgingDaysTOl = driver.findElement(By.xpath("//input[@formcontrolname='aging_days_2']//following-sibling::label"));
			Assert.assertEquals(AgingDaysTOlab, AgingDaysTOl.getText());
			System.out.println("AgingDaysTO- Label is correct");
			//To Enter AgingDaysTO xpath
			WebElement AgingDaysTOxpath = driver.findElement(By.xpath("//input[@formcontrolname='aging_days_2']"));
			AgingDaysTOxpath.sendKeys("2");
			
			//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();
	}
	@Test(priority=32)
	public void TransitTimehh()
	{
			String TransitTimehhlab = "Transit Time";
			WebElement TransitTimehhl = driver.findElement(By.xpath("//input[@formcontrolname='transit_time_1']//following-sibling::label"));
			Assert.assertEquals(TransitTimehhlab, TransitTimehhl.getText());
			System.out.println("TransitTimehh- Label is correct");
			//To Enter TransitTimehh xpath
			WebElement TransitTimehhxpath = driver.findElement(By.xpath("//input[@formcontrolname='transit_time_1']"));
			TransitTimehhxpath.sendKeys("12");
			
			//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();
	}
	@Test(priority=33)
	public void TransitTimemm()
	{
			String TransitTimelabmm = "Transit Time";
			WebElement TransitTimemml = driver.findElement(By.xpath("//input[@formcontrolname='transit_time_2']//following-sibling::label"));
			Assert.assertEquals(TransitTimelabmm, TransitTimemml.getText());
			System.out.println("TransitTimemm- Label is correct");
			//To Enter TransitTimemm xpath
			WebElement TransitTimemmxpath = driver.findElement(By.xpath("//input[@formcontrolname='transit_time_2']"));
			TransitTimemmxpath.sendKeys("50");

			//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();
	}
	
	@Test(priority=34)
	public void CutOffTimehh()
	{
			String CutOffTimelabhh = "CutOff Time";
			WebElement CutOffTimehhl = driver.findElement(By.xpath("//input[@formcontrolname='cut_off_time_1']//following-sibling::label"));
			Assert.assertEquals(CutOffTimelabhh, CutOffTimehhl.getText());
			System.out.println("CutOffTimehh- Label is correct");
			//To Enter CutOffTimehh xpath
			WebElement CutOffTimehhxpath = driver.findElement(By.xpath("//input[@formcontrolname='cut_off_time_1']"));
			CutOffTimehhxpath.sendKeys("1o");

			//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();

	}
	@Test(priority=35)
	public void CutOffTimemm()
	{
			String CutOffTimelabmm = "CutOff Time";
			WebElement CutOffTimemml = driver.findElement(By.xpath("//input[@formcontrolname='cut_off_time_2']//following-sibling::label"));
			Assert.assertEquals(CutOffTimelabmm, CutOffTimemml.getText());
			System.out.println("CutOffTimemm- Label is correct");
			//To Enter CutOffTimemm xpath
			WebElement CutOffTimemmxpath = driver.findElement(By.xpath("//input[@formcontrolname='cut_off_time_2']"));
			CutOffTimemmxpath.sendKeys("25");

			//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();
	}		
	
// To Others Contacts Lable for GHA			
	@Test(priority=36)
	public void ghaname()
	{
		String ghanamelab = "Name";
		WebElement ghanamel = driver.findElement(By.xpath("//*[@formcontrolname='gsa_name']//following-sibling::label"));
		Assert.assertEquals(ghanamelab, ghanamel.getText());
		System.out.println("ghaname- Label is correct");
		//To Enter ghaname xpath
		WebElement ghanamexpath = driver.findElement(By.xpath("//*[@formcontrolname='gsa_name']"));
		ghanamexpath.sendKeys("Dev");

		//To Click Submit Buttion to check all error msg
		WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
		submitbuttion.click();

	}
	@Test(priority=37)
	public void ghaSITAAddress()
	{
		String ghaSITAAddresslab = "SITA Address";
		WebElement ghaSITAAddressl = driver.findElement(By.xpath("//*[@formcontrolname='gha_sita_address'][1]//following-sibling::label[1]"));
		Assert.assertEquals(ghaSITAAddresslab, ghaSITAAddressl.getText());
		System.out.println("ghaSITAAddress- Label is correct");
		//To Enter ghaSITAAddress xpath
		WebElement ghaSITAAddressxpath = driver.findElement(By.xpath("//*[@formcontrolname='gha_sita_address'][1]"));
		ghaSITAAddressxpath.sendKeys("SitaAddress37");

		//To Click Submit Buttion to check all error msg
		WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
		submitbuttion.click();

	}
	@Test(priority=38)
	public void ghaContactNo()
	{
		String ghaContactNolab = "Contact No";
		WebElement ghaContactNol = driver.findElement(By.xpath("//*[@formcontrolname='gha_mobile_no']//following-sibling::label"));
		Assert.assertEquals(ghaContactNolab, ghaContactNol.getText());
		System.out.println("ghaContactNo- Label is correct");
		//To Enter ghaContactNo xpath
		WebElement ghaContactNoxpath = driver.findElement(By.xpath("//*[@formcontrolname='gha_mobile_no']"));
		ghaContactNoxpath.sendKeys("9876543210");

		//To Click Submit Buttion to check all error msg
		WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
		submitbuttion.click();

	}
	@Test(priority=39)
	public void ghaEmailID()
	{
		String ghaEmailIDlab = "Email ID";
		WebElement ghaEmailIDl = driver.findElement(By.xpath("//*[@formcontrolname='gha_email_id']//following-sibling::label"));
		Assert.assertEquals(ghaEmailIDlab, ghaEmailIDl.getText());
		System.out.println("ghaEmailID- Label is correct");
		//To Enter ghaEmailID xpath
		WebElement ghaEmailIDxpath = driver.findElement(By.xpath("//*[@formcontrolname='gha_email_id']"));
		ghaEmailIDxpath.sendKeys("demo@gmail.com");

		//To Click Submit Buttion to check all error msg
		WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
		submitbuttion.click();

	}
	@Test(priority=40)
	public void ghaAddress()
	{
			String ghaAddresslab = "Address";
			WebElement ghaAddressl = driver.findElement(By.xpath("//*[@formcontrolname='gha_address']//following-sibling::label"));
			Assert.assertEquals(ghaAddresslab, ghaAddressl.getText());
			System.out.println("ghaAddress- Label is correct");
			//To Enter ghaAddress xpath
			WebElement ghaAddressxpath = driver.findElement(By.xpath("//*[@formcontrolname='gha_address']"));
			ghaAddressxpath.sendKeys("FreeText");

			//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();

	}
	   //To Other Contacts lable for GSA			
	@Test(priority=41)
	public void gsaname()
	{
		String gsanamelab = "Name";
		WebElement gsanamel = driver.findElement(By.xpath("//*[@class='main-box main-2 panelDefault'][2]//child::form//child::div//child::div//child::div//input[@formcontrolname='gsa_name']//following-sibling::label"));
		Assert.assertEquals(gsanamelab, gsanamel.getText());
		System.out.println("gsaname- Label is correct");
		//To Enter gsaname xpath
		WebElement gsanamexpath = driver.findElement(By.xpath("//*[@class='main-box main-2 panelDefault'][2]//child::form//child::div//child::div//child::div//input[@formcontrolname='gsa_name']"));
		gsanamexpath.sendKeys("gsaname");

		//To Click Submit Buttion to check all error msg
		WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
		submitbuttion.click();

	}
	@Test(priority=42)
	public void gsaSITAAddress()
	{
			String gsaSITAAddresslab = "SITA Address";
			WebElement gsaSITAAddressl = driver.findElement(By.xpath("//*[@class='main-box main-2 panelDefault'][2]//child::form//child::div//child::div//child::div//input[@formcontrolname='gha_sita_address']//following-sibling::label"));
			Assert.assertEquals(gsaSITAAddresslab, gsaSITAAddressl.getText());
			System.out.println("gsaSITAAddress- Label is correct");
			//To Enter gsaSITAAddress xpath
			WebElement gsaSITAAddressxpath = driver.findElement(By.xpath("//*[@class='main-box main-2 panelDefault'][2]//child::form//child::div//child::div//child::div//input[@formcontrolname='gha_sita_address']"));
			gsaSITAAddressxpath.sendKeys("gsaSITAAddress");

			//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();

	}
	@Test(priority=43)
	public void gsaContactNo()
	{
			String gsaContactNolab = "Contact No";
			WebElement gsaContactNol = driver.findElement(By.xpath("//*[@class='main-box main-2 panelDefault'][2]//child::form//child::div//child::div//child::div//input[@formcontrolname='gsa_mobile_no']//following-sibling::label"));
			Assert.assertEquals(gsaContactNolab, gsaContactNol.getText());
			System.out.println("gsaContactNo- Label is correct");
			//To Enter gsaContactNo xpath
			WebElement gsaContactNoxpath = driver.findElement(By.xpath("//*[@class='main-box main-2 panelDefault'][2]//child::form//child::div//child::div//child::div//input[@formcontrolname='gsa_mobile_no']"));
			gsaContactNoxpath.sendKeys("9876543210");

			//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();

	}
	@Test(priority=44)
	public void gsaEmailID()
	{
			String gsaEmailIDlab = "Email ID";
			WebElement gsaEmailIDl = driver.findElement(By.xpath("//*[@class='main-box main-2 panelDefault'][2]//child::form//child::div//child::div//child::div//input[@formcontrolname='gsa_email_id']//following-sibling::label"));
			Assert.assertEquals(gsaEmailIDlab, gsaEmailIDl.getText());
			System.out.println("gsaEmailID- Label is correct");
			//To Enter gsaEmailID xpath
			WebElement gsaEmailIDxpath = driver.findElement(By.xpath("//*[@class='main-box main-2 panelDefault'][2]//child::form//child::div//child::div//child::div//input[@formcontrolname='gsa_email_id']"));
			gsaEmailIDxpath.sendKeys("gsademo@gmail.com");

			//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();

	}
	@Test(priority=45)
	public void gsaAddress()
	{
			String gsaAddresslab = "Address";
			WebElement gsaAddressl = driver.findElement(By.xpath("//*[@class='main-box main-2 panelDefault'][2]//child::form//child::div//child::div//child::div//input[@formcontrolname='gsa_address']//following-sibling::label"));
			Assert.assertEquals(gsaAddresslab, gsaAddressl.getText());
			System.out.println("gsaAddress- Label is correct");
			//To Enter gsaAddress xpath
			WebElement gsaAddresslxpath = driver.findElement(By.xpath("//*[@class='main-box main-2 panelDefault'][2]//child::form//child::div//child::div//child::div//input[@formcontrolname='gsa_address']"));
			gsaAddresslxpath.sendKeys("gsaAddress");

			//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();

	}
	  //To Other Contacts lable for APM
	@Test(priority=46)
	public void apmName()
	{
			String apmNamelab = "Name";
			WebElement apmNamel = driver.findElement(By.xpath("//*[@class='main-box main-2 panelDefault'][3]//child::form//child::div//child::div//child::div//child::input[@formcontrolname='apm_name']//following-sibling::label"));
			Assert.assertEquals(apmNamelab, apmNamel.getText());
			System.out.println("apmName- Label is correct");
			//To Enter apmName xpath
			WebElement apmNamexpath = driver.findElement(By.xpath("//*[@class='main-box main-2 panelDefault'][3]//child::form//child::div//child::div//child::div//child::input[@formcontrolname='apm_name']"));
			apmNamexpath.sendKeys("apmName");

			//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();

	}
	@Test(priority=47)
	public void apmSITAAddress()
	{
		String apmSITAAddresslab = "SITA Address";
		WebElement apmSITAAddressl = driver.findElement(By.xpath("//*[@class='main-box main-2 panelDefault'][3]//child::form//child::div//child::div//child::div//child::input[@formcontrolname='apm_sita_address']//following-sibling::label"));
		Assert.assertEquals(apmSITAAddresslab, apmSITAAddressl.getText());
		System.out.println("apmSITAAddress- Label is correct");
		//To Enter apmSITAAddress xpath
		WebElement apmSITAAddresslxpath = driver.findElement(By.xpath("//*[@class='main-box main-2 panelDefault'][3]//child::form//child::div//child::div//child::div//child::input[@formcontrolname='apm_sita_address']"));
		apmSITAAddresslxpath.sendKeys("apmSITAAddress");

		//To Click Submit Buttion to check all error msg
		WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
		submitbuttion.click();

	}
	@Test(priority=48)
	public void apmContactNo()
	{
		String apmContactNolab = "Contact No";
		WebElement apmContactNol = driver.findElement(By.xpath("//*[@class='main-box main-2 panelDefault'][3]//child::form//child::div//child::div//child::div//child::input[@formcontrolname='apm_mobile_no']//following-sibling::label"));
		Assert.assertEquals(apmContactNolab, apmContactNol.getText());
		System.out.println("apmContactNo- Label is correct");
		//To Enter apmContactNo xpath
		WebElement apmContactNolxpath = driver.findElement(By.xpath("//*[@class='main-box main-2 panelDefault'][3]//child::form//child::div//child::div//child::div//child::input[@formcontrolname='apm_mobile_no']"));
		apmContactNolxpath.sendKeys("apmContactNol");

		//To Click Submit Buttion to check all error msg
		WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
		submitbuttion.click();

	}
	@Test(priority=49)
	public void apmEmailID()
	{
		String apmEmailIDlab = "Email ID";
		WebElement apmEmailIDl = driver.findElement(By.xpath("//*[@class='main-box main-2 panelDefault'][3]//child::form//child::div//child::div//child::div//child::input[@formcontrolname='apm_email_id']//following-sibling::label"));
		Assert.assertEquals(apmEmailIDlab, apmEmailIDl.getText());
		System.out.println("apmEmailID- Label is correct");
		//To Enter apmEmailID xpath
		WebElement apmEmailIDlxpath = driver.findElement(By.xpath("//*[@class='main-box main-2 panelDefault'][3]//child::form//child::div//child::div//child::div//child::input[@formcontrolname='apm_email_id']"));
		apmEmailIDlxpath.sendKeys("apmEmailIDl");

		//To Click Submit Buttion to check all error msg
		WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
		submitbuttion.click();

	}
	@Test(priority=50)
	public void apmAddress()
	{
			String apmAddresslab = "Address";
			WebElement apmAddressl = driver.findElement(By.xpath("//*[@class='main-box main-2 panelDefault'][3]//child::form//child::div//child::div//child::div//child::input[@formcontrolname='apm_address']//following-sibling::label"));
			Assert.assertEquals(apmAddresslab, apmAddressl.getText());
			System.out.println("apmAddress- Label is correct");
			//To Enter apmAddress xpath
			WebElement apmAddresslxpath = driver.findElement(By.xpath("//*[@class='main-box main-2 panelDefault'][3]//child::form//child::div//child::div//child::div//child::input[@formcontrolname='apm_address']"));
			apmAddresslxpath.sendKeys("apmAddress");

			//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();

	}
	@Test(priority=51)
	public void apmAdditionalInformation()
	{
		String apmAdditionalInformationlab = "Additional Information";
		WebElement apmAdditionalInformationl = driver.findElement(By.xpath("//*[@formcontrolname='apm_additional_information']//following-sibling::label"));
		Assert.assertEquals(apmAdditionalInformationlab, apmAdditionalInformationl.getText());
		System.out.println("apmAdditionalInformation- Label is correct");
		//To Enter apmAdditionalInformation xpath
		WebElement apmAdditionalInformationlxpath = driver.findElement(By.xpath("//*[@formcontrolname='apm_additional_information']"));
		apmAdditionalInformationlxpath.sendKeys("apmAdditionalInformationl");

		//To Click Submit Buttion to check all error msg
		WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
		submitbuttion.click();

	}


//To Currency fields----(Booking Currency)
	
	@Test(priority=52)
	public void Booking_Currency() throws InterruptedException
	{
		//To Click on Currency Tab
		driver.findElement(By.xpath("//*[@class=\"nav nav-tabs\"]//child::li[2]//child::a")).click();
		Thread.sleep(1000);
		String BookingCurrencylab = "Booking Currency";
		WebElement BookingCurrencyl = driver.findElement(By.xpath("//*[@formcontrolname='booking_currency']//following-sibling::label"));
		Assert.assertEquals(BookingCurrencylab, BookingCurrencyl.getText());
		System.out.println("BookingCurrencylab- Label is correct");
		
		//To Enter Booking_Currency xpath
		WebElement BookingCurrencyxpath = driver.findElement(By.xpath("//*[@formcontrolname='booking_currency']"));
		Select sel = new Select(BookingCurrencyxpath);
		sel.selectByIndex(1);
		
		//To Click Submit Buttion to check all error msg
		WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
		submitbuttion.click();

	}

	@Test(priority=53)
	public void Booking_Currency_Type() throws InterruptedException
	{
		//To Click on Currency Tab
		driver.findElement(By.xpath("//*[@class=\"nav nav-tabs\"]//child::li[2]//child::a")).click();
		//Thread.sleep(1000);
		
		String Booking_Currency_Typelab = "Booking Currency Type";
		WebElement Booking_Currency_Typel = driver.findElement(By.xpath("//*[@formcontrolname='booking_currency_type']//following-sibling::label"));
		Assert.assertEquals(Booking_Currency_Typelab, Booking_Currency_Typel.getText());
		System.out.println("Booking_Currency_Type- Label is correct");
		
		//To Enter Booking_Currency_Type xpath
		WebElement Booking_Currency_Typexpath = driver.findElement(By.xpath("//*[@formcontrolname='booking_currency_type']"));
		Select sel = new Select(Booking_Currency_Typexpath);
		sel.selectByIndex(1);
		
		//To Click Submit Buttion to check all error msg
		WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
		submitbuttion.click();

	}

	// To Invoice Currency
	
	@Test(priority=54)		
	public void Invoice_Currency() throws InterruptedException
	{
		//To Click on Currency Tab
		driver.findElement(By.xpath("//*[@class=\"nav nav-tabs\"]//child::li[2]//child::a")).click();
		Thread.sleep(1000);
		
		String Invoice_Currencylab = "Invoice Currency";
		WebElement Invoice_Currencyl = driver.findElement(By.xpath("//select[@formcontrolname='invoice_currency']//following-sibling::label"));
		Assert.assertEquals(Invoice_Currencylab, Invoice_Currencyl.getText());
		System.out.println("Booking_Currency_Type- Label is correct");
		
		//To Enter Invoice_Currency xpath
		WebElement Invoice_Currencylxpath = driver.findElement(By.xpath("//select[@formcontrolname='invoice_currency']"));
		Select sel = new Select(Invoice_Currencylxpath);
		sel.selectByIndex(1);
		
		//To Click Submit Buttion to check all error msg
		WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
		submitbuttion.click();

	}
	
	@Test(priority=55)		
	public void Invoice_Currency_Type() throws InterruptedException
	{
		//To Click on Currency Tab
		driver.findElement(By.xpath("//*[@class=\"nav nav-tabs\"]//child::li[2]//child::a")).click();
		Thread.sleep(1000);
		
		String Invoice_Currency_Typelab = "Invoice Currency Type";
		WebElement Invoice_Currency_Typel = driver.findElement(By.xpath("//select[@formcontrolname='invoice_currency_type']//following-sibling::label"));
		Assert.assertEquals(Invoice_Currency_Typelab, Invoice_Currency_Typel.getText());
		System.out.println("Invoice_Currency_Type- Label is correct");
		
		//To Enter Invoice_Currency_Type xpath
		WebElement Invoice_Currency_Typelxpath = driver.findElement(By.xpath("//select[@formcontrolname='invoice_currency_type']"));
		Select sel = new Select(Invoice_Currency_Typelxpath);
		sel.selectByIndex(1);
		
		//To Click Submit Buttion to check all error msg
		WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
		submitbuttion.click();

	}

//----------------------------------------------------------	
// To FUNCTIONAL Test Cases
	@Test(priority=56, groups = "mandatory_testing")
	public void mandatory_Without_code_fields() throws InterruptedException 
	{
		
		//To Enter Code
		//WebElement codexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[1]//child::div//child::input[1]"));
		//codexpath.sendKeys("dev");	
		//System.out.println("Code");
		
		//To Enter Name
		WebElement Namexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[2]//child::div//child::input"));
		Namexpath.sendKeys("Devendra Singh");
		System.out.println("Name");
		
		//To Select Type
		WebElement Typepath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[3]//child::div//child::select"));
		Select sel = new Select(Typepath);
		sel.selectByIndex(2);
		System.out.println("Type");
		
		//To Enter Pincode
		WebElement Pincodexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[4]//child::div//child::input"));
		Pincodexpath.sendKeys("0000");
		System.out.println("Pincode");
		
		//To Enter Full Address 
		WebElement Full_Addressxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[5]//child::div//child::input"));
		Full_Addressxpath.sendKeys("122017");
		System.out.println("Full Address");
		
		//To Enter City 
		WebElement Cityxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[6]//child::div//child::input"));
		Cityxpath.sendKeys("Delhi");
		System.out.println("City");
		
		//To Select Country Code 
		WebElement Country_Codexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[7]//child::div//child::select"));
		Select sel1 = new Select(Country_Codexpath);
		sel1.selectByIndex(1);
		System.out.println("Country Code");
	
		//To Enter State xpath
		WebElement Statexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[8]//child::div//child::select"));
		Select sel6 = new Select(Statexpath);
		sel6.selectByIndex(2);
		
		//To Enter Region 
		WebElement Regionxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[9]//child::div//child::select"));
		Select sel2 = new Select(Regionxpath);
		sel2.selectByIndex(1);
		System.out.println("Region");
		
		//To Enter Latitude Name 
		WebElement Latitudexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[19]//child::div//child::input"));
		Latitudexpath.sendKeys("111.2345");
		System.out.println("Latitude");
		
		//To Enter Longitude Name 
		WebElement Longitudexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[20]//child::div//child::input"));
		Longitudexpath.sendKeys("111.2345");
		System.out.println("Longitude");
		
		//To Enter Status
		WebElement Statusxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[21]//child::div//child::select"));
		Select sel3 = new Select(Statusxpath);
		sel3.selectByIndex(1);
		System.out.println("Region");
		
		//To Enter UOM
		WebElement UOMxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[26]//child::div//child::select"));
		Select sel4 = new Select(UOMxpath);
		sel4.selectByIndex(1);
		System.out.println("UOMxpath");
		
		//To Enter TimeZone xpath
		WebElement TimeZonexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[29]//child::div//child::select"));
		Select sel5 = new Select(TimeZonexpath);
		sel5.selectByIndex(1);
		System.out.println("TimeZonexpath");
		
		
		//To Click Submit Buttion to check all error msg
				WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
				submitbuttion.click();
	//To Check Error msg
				WebElement codeerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[1]//child::div//child::app-control-message//span"));
				codeerror.isDisplayed();
				Assert.assertEquals(codeerror.getText(), "Required");	
				System.out.println("Erorr message for name -" +codeerror.getText());
				
}
  			
	@Test(priority=57, groups = "mandatory_testing")
	public void Without_Namefields() throws InterruptedException 
	{
		
		//To Enter Code
		WebElement codexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[1]//child::div//child::input[1]"));
		codexpath.sendKeys("dev");	
		System.out.println("Code");
		
		//To Enter Name
		//WebElement Namexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[2]//child::div//child::input"));
		//Namexpath.sendKeys("Devendra Singh");
		//System.out.println("Name");
		
		//To Select Type
		WebElement Typepath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[3]//child::div//child::select"));
		Select sel = new Select(Typepath);
		sel.selectByIndex(2);
		System.out.println("Type");
		
		//To Enter Pincode
		WebElement Pincodexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[4]//child::div//child::input"));
		Pincodexpath.sendKeys("0000");
		System.out.println("Pincode");
		
		//To Enter Full Address 
		WebElement Full_Addressxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[5]//child::div//child::input"));
		Full_Addressxpath.sendKeys("122017");
		System.out.println("Full Address");
		
		//To Enter City 
		WebElement Cityxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[6]//child::div//child::input"));
		Cityxpath.sendKeys("Delhi");
		System.out.println("City");
		
		//To Select Country Code 
		WebElement Country_Codexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[7]//child::div//child::select"));
		Select sel1 = new Select(Country_Codexpath);
		sel1.selectByIndex(1);
		System.out.println("Country Code");
	
		//To Enter State xpath
		WebElement Statexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[8]//child::div//child::select"));
		Select sel6 = new Select(Statexpath);
		sel6.selectByIndex(2);
		
		//To Enter Region 
		WebElement Regionxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[9]//child::div//child::select"));
		Select sel2 = new Select(Regionxpath);
		sel2.selectByIndex(1);
		System.out.println("Region");
		
		//To Enter Latitude Name 
		WebElement Latitudexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[19]//child::div//child::input"));
		Latitudexpath.sendKeys("111.2345");
		System.out.println("Latitude");
		
		//To Enter Longitude Name 
		WebElement Longitudexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[20]//child::div//child::input"));
		Longitudexpath.sendKeys("111.2345");
		System.out.println("Longitude");
		
		//To Enter Status
		WebElement Statusxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[21]//child::div//child::select"));
		Select sel3 = new Select(Statusxpath);
		sel3.selectByIndex(1);
		System.out.println("Region");
		
		//To Enter UOM
		WebElement UOMxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[26]//child::div//child::select"));
		Select sel4 = new Select(UOMxpath);
		sel4.selectByIndex(1);
		System.out.println("UOMxpath");
		
		//To Enter TimeZone xpath
		WebElement TimeZonexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[29]//child::div//child::select"));
		Select sel5 = new Select(TimeZonexpath);
		sel5.selectByIndex(1);
		System.out.println("TimeZonexpath");
		
		
		//To Click Submit Buttion to check all error msg
				WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
				submitbuttion.click();

				WebElement nameerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[2]//child::div//child::app-control-message//span"));
				nameerror.isDisplayed();
				Assert.assertEquals(nameerror.getText(), "Required");	
				System.out.println("Erorr message for name -" +nameerror.getText());		
}

	@Test(priority=58, groups = "mandatory_testing")
	public void Without_Type_fields() throws InterruptedException 
	{
		
		//To Enter Code
		WebElement codexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[1]//child::div//child::input[1]"));
		codexpath.sendKeys("dev");	
		System.out.println("Code");
		
		//To Enter Name
		WebElement Namexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[2]//child::div//child::input"));
		Namexpath.sendKeys("Devendra Singh");
		System.out.println("Name");
		
		//To Select Type
		//WebElement Typepath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[3]//child::div//child::select"));
		//Select sel = new Select(Typepath);
		//sel.selectByIndex(2);
		//System.out.println("Type");

		//To Enter Pincode
		WebElement Pincodexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[4]//child::div//child::input"));
		Pincodexpath.sendKeys("0000");
		System.out.println("Pincode");
		
		//To Enter Full Address 
		WebElement Full_Addressxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[5]//child::div//child::input"));
		Full_Addressxpath.sendKeys("122017");
		System.out.println("Full Address");
		
		//To Enter City 
		WebElement Cityxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[6]//child::div//child::input"));
		Cityxpath.sendKeys("Delhi");
		System.out.println("City");
		
		//To Select Country Code 
		WebElement Country_Codexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[7]//child::div//child::select"));
		Select sel1 = new Select(Country_Codexpath);
		sel1.selectByIndex(1);
		System.out.println("Country Code");
	
		//To Enter State xpath
		WebElement Statexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[8]//child::div//child::select"));
		Select sel6 = new Select(Statexpath);
		sel6.selectByIndex(2);
		
		//To Enter Region 
		WebElement Regionxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[9]//child::div//child::select"));
		Select sel2 = new Select(Regionxpath);
		sel2.selectByIndex(1);
		System.out.println("Region");
		
		//To Enter Latitude Name 
		WebElement Latitudexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[19]//child::div//child::input"));
		Latitudexpath.sendKeys("111.2345");
		System.out.println("Latitude");
		
		//To Enter Longitude Name 
		WebElement Longitudexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[20]//child::div//child::input"));
		Longitudexpath.sendKeys("111.2345");
		System.out.println("Longitude");
		
		//To Enter Status
		WebElement Statusxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[21]//child::div//child::select"));
		Select sel3 = new Select(Statusxpath);
		sel3.selectByIndex(1);
		System.out.println("Region");
		
		//To Enter UOM
		WebElement UOMxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[26]//child::div//child::select"));
		Select sel4 = new Select(UOMxpath);
		sel4.selectByIndex(1);
		System.out.println("UOMxpath");
		
		//To Enter TimeZone xpath
		WebElement TimeZonexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[29]//child::div//child::select"));
		Select sel5 = new Select(TimeZonexpath);
		sel5.selectByIndex(1);
		System.out.println("TimeZonexpath");
		
		
		//To Click Submit Buttion to check all error msg
				WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
				submitbuttion.click();

				//To capture the error msg for Type			
				WebElement Typeerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[3]//child::div//child::app-control-message//span"));
				Typeerror.isDisplayed();
				Assert.assertEquals(Typeerror.getText(), "Required");	
				System.out.println("Erorr message for Type  -" +Typeerror.getText());		
}
	
	@Test(priority=59, groups = "mandatory_testing")
	public void Without_Pincode_fields() throws InterruptedException 
	{
		
		//To Enter Code
		WebElement codexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[1]//child::div//child::input[1]"));
		codexpath.sendKeys("dev");	
		System.out.println("Code");
		
		//To Enter Name
		WebElement Namexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[2]//child::div//child::input"));
		Namexpath.sendKeys("Devendra Singh");
		System.out.println("Name");
		
		//To Select Type
		WebElement Typepath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[3]//child::div//child::select"));
		Select sel = new Select(Typepath);
		sel.selectByIndex(2);
		System.out.println("Type");
	
		//To Enter Pincode
		//WebElement Pincodexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[4]//child::div//child::input"));
		//Pincodexpath.sendKeys("0000");
		//System.out.println("Pincode");
		
		//To Enter Full Address 
		WebElement Full_Addressxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[5]//child::div//child::input"));
		Full_Addressxpath.sendKeys("122017");
		System.out.println("Full Address");
		
		//To Enter City 
		WebElement Cityxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[6]//child::div//child::input"));
		Cityxpath.sendKeys("Delhi");
		System.out.println("City");
		
		//To Select Country Code 
		WebElement Country_Codexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[7]//child::div//child::select"));
		Select sel1 = new Select(Country_Codexpath);
		sel1.selectByIndex(1);
		System.out.println("Country Code");
	
		//To Enter State xpath
		WebElement Statexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[8]//child::div//child::select"));
		Select sel6 = new Select(Statexpath);
		sel6.selectByIndex(2);
		
		//To Enter Region 
		WebElement Regionxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[9]//child::div//child::select"));
		Select sel2 = new Select(Regionxpath);
		sel2.selectByIndex(1);
		System.out.println("Region");
		
		//To Enter Latitude Name 
		WebElement Latitudexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[19]//child::div//child::input"));
		Latitudexpath.sendKeys("111.2345");
		System.out.println("Latitude");
		
		//To Enter Longitude Name 
		WebElement Longitudexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[20]//child::div//child::input"));
		Longitudexpath.sendKeys("111.2345");
		System.out.println("Longitude");
		
		//To Enter Status
		WebElement Statusxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[21]//child::div//child::select"));
		Select sel3 = new Select(Statusxpath);
		sel3.selectByIndex(1);
		System.out.println("Region");
		
		//To Enter UOM
		WebElement UOMxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[26]//child::div//child::select"));
		Select sel4 = new Select(UOMxpath);
		sel4.selectByIndex(1);
		System.out.println("UOMxpath");
		
		//To Enter TimeZone xpath
		WebElement TimeZonexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[29]//child::div//child::select"));
		Select sel5 = new Select(TimeZonexpath);
		sel5.selectByIndex(1);
		System.out.println("TimeZonexpath");
		
		
		//To Click Submit Buttion to check all error msg
				WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
				submitbuttion.click();

				//To capture the error msg for Pincode			
				WebElement Pincoderror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[4]//child::div//child::app-control-message//span"));
				Pincoderror.isDisplayed();
				Assert.assertEquals(Pincoderror.getText(), "Required");	
				System.out.println("Erorr message for Pincode  -" +Pincoderror.getText());		
}

	@Test(priority=60, groups = "mandatory_testing")
	public void Without_Full_Address_fields() throws InterruptedException 
	{
		
		//To Enter Code
		WebElement codexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[1]//child::div//child::input[1]"));
		codexpath.sendKeys("dev");	
		System.out.println("Code");
		
		//To Enter Name
		WebElement Namexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[2]//child::div//child::input"));
		Namexpath.sendKeys("Devendra Singh");
		System.out.println("Name");
		
		//To Select Type
		WebElement Typepath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[3]//child::div//child::select"));
		Select sel = new Select(Typepath);
		sel.selectByIndex(2);
		System.out.println("Type");
	
		//To Enter Pincode
		WebElement Pincodexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[4]//child::div//child::input"));
		Pincodexpath.sendKeys("0000");
		System.out.println("Pincode");
		
		//To Enter Full Address 
		//WebElement Full_Addressxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[5]//child::div//child::input"));
		//Full_Addressxpath.sendKeys("122017");
		//System.out.println("Full Address");
		
		//To Enter City 
		WebElement Cityxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[6]//child::div//child::input"));
		Cityxpath.sendKeys("Delhi");
		System.out.println("City");
		
		//To Select Country Code 
		WebElement Country_Codexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[7]//child::div//child::select"));
		Select sel1 = new Select(Country_Codexpath);
		sel1.selectByIndex(1);
		System.out.println("Country Code");
	
		//To Enter State xpath
		WebElement Statexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[8]//child::div//child::select"));
		Select sel6 = new Select(Statexpath);
		sel6.selectByIndex(2);
		
		//To Enter Region 
		WebElement Regionxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[9]//child::div//child::select"));
		Select sel2 = new Select(Regionxpath);
		sel2.selectByIndex(1);
		System.out.println("Region");
		
		//To Enter Latitude Name 
		WebElement Latitudexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[19]//child::div//child::input"));
		Latitudexpath.sendKeys("111.2345");
		System.out.println("Latitude");
		
		//To Enter Longitude Name 
		WebElement Longitudexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[20]//child::div//child::input"));
		Longitudexpath.sendKeys("111.2345");
		System.out.println("Longitude");
		
		//To Enter Status
		WebElement Statusxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[21]//child::div//child::select"));
		Select sel3 = new Select(Statusxpath);
		sel3.selectByIndex(1);
		System.out.println("Region");
		
		//To Enter UOM
		WebElement UOMxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[26]//child::div//child::select"));
		Select sel4 = new Select(UOMxpath);
		sel4.selectByIndex(1);
		System.out.println("UOMxpath");
		
		//To Enter TimeZone xpath
		WebElement TimeZonexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[29]//child::div//child::select"));
		Select sel5 = new Select(TimeZonexpath);
		sel5.selectByIndex(1);
		System.out.println("TimeZonexpath");
		
		
		//To Click Submit Buttion to check all error msg
				WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
				submitbuttion.click();

				//To capture the error msg for Full Address			
				WebElement Fulladdresserror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[5]//child::div//child::app-control-message//span"));
				Fulladdresserror.isDisplayed();
				Assert.assertEquals(Fulladdresserror.getText(), "Required");	
				System.out.println("Erorr message for Full Address  -" +Fulladdresserror.getText());		
}

	@Test(priority=61, groups = "mandatory_testing")
	public void Without_City_fields() throws InterruptedException 
	{
		
		//To Enter Code
		WebElement codexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[1]//child::div//child::input[1]"));
		codexpath.sendKeys("dev");	
		System.out.println("Code");
		
		//To Enter Name
		WebElement Namexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[2]//child::div//child::input"));
		Namexpath.sendKeys("Devendra Singh");
		System.out.println("Name");
		
		//To Select Type
		WebElement Typepath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[3]//child::div//child::select"));
		Select sel = new Select(Typepath);
		sel.selectByIndex(2);
		System.out.println("Type");
	
		//To Enter Pincode
		WebElement Pincodexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[4]//child::div//child::input"));
		Pincodexpath.sendKeys("0000");
		System.out.println("Pincode");
		
		//To Enter Full Address 
		WebElement Full_Addressxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[5]//child::div//child::input"));
		Full_Addressxpath.sendKeys("122017");
		System.out.println("Full Address");
		
		//To Enter City 
		//WebElement Cityxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[6]//child::div//child::input"));
		//Cityxpath.sendKeys("Delhi");
		//System.out.println("City");
		
		//To Select Country Code 
		WebElement Country_Codexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[7]//child::div//child::select"));
		Select sel1 = new Select(Country_Codexpath);
		sel1.selectByIndex(1);
		System.out.println("Country Code");
	
		//To Enter State xpath
		WebElement Statexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[8]//child::div//child::select"));
		Select sel6 = new Select(Statexpath);
		sel6.selectByIndex(2);
		
		//To Enter Region 
		WebElement Regionxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[9]//child::div//child::select"));
		Select sel2 = new Select(Regionxpath);
		sel2.selectByIndex(1);
		System.out.println("Region");
		
		//To Enter Latitude Name 
		WebElement Latitudexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[19]//child::div//child::input"));
		Latitudexpath.sendKeys("111.2345");
		System.out.println("Latitude");
		
		//To Enter Longitude Name 
		WebElement Longitudexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[20]//child::div//child::input"));
		Longitudexpath.sendKeys("111.2345");
		System.out.println("Longitude");
		
		//To Enter Status
		WebElement Statusxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[21]//child::div//child::select"));
		Select sel3 = new Select(Statusxpath);
		sel3.selectByIndex(1);
		System.out.println("Region");
		
		//To Enter UOM
		WebElement UOMxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[26]//child::div//child::select"));
		Select sel4 = new Select(UOMxpath);
		sel4.selectByIndex(1);
		System.out.println("UOMxpath");
		
		//To Enter TimeZone xpath
		WebElement TimeZonexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[29]//child::div//child::select"));
		Select sel5 = new Select(TimeZonexpath);
		sel5.selectByIndex(1);
		System.out.println("TimeZonexpath");
		
		
		//To Click Submit Buttion to check all error msg
				WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
				submitbuttion.click();

				//To capture the error msg for City			
				WebElement Cityerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[6]//child::div//child::app-control-message//span"));
				Cityerror.isDisplayed();
				Assert.assertEquals(Cityerror.getText(), "Required");	
				System.out.println("Erorr message for City  -" +Cityerror.getText());		
}


	@Test(priority=62, groups = "mandatory_testing")
	public void Without_Country_Code_fields() throws InterruptedException 
	{
		
		//To Enter Code
		WebElement codexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[1]//child::div//child::input[1]"));
		codexpath.sendKeys("dev");	
		System.out.println("Code");
		
		//To Enter Name
		WebElement Namexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[2]//child::div//child::input"));
		Namexpath.sendKeys("Devendra Singh");
		System.out.println("Name");
		
		//To Select Type
		WebElement Typepath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[3]//child::div//child::select"));
		Select sel = new Select(Typepath);
		sel.selectByIndex(2);
		System.out.println("Type");
	
		//To Enter Pincode
		WebElement Pincodexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[4]//child::div//child::input"));
		Pincodexpath.sendKeys("0000");
		System.out.println("Pincode");
		
		//To Enter Full Address 
		WebElement Full_Addressxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[5]//child::div//child::input"));
		Full_Addressxpath.sendKeys("122017");
		System.out.println("Full Address");
		
		//To Enter City 
		WebElement Cityxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[6]//child::div//child::input"));
		Cityxpath.sendKeys("Delhi");
		System.out.println("City");
		
		//To Select Country Code 
		//WebElement Country_Codexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[7]//child::div//child::select"));
		//Select sel1 = new Select(Country_Codexpath);
		//sel1.selectByIndex(1);
		//System.out.println("Country Code");
	
		//To Enter State xpath
		WebElement Statexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[8]//child::div//child::select"));
		Select sel6 = new Select(Statexpath);
		sel6.selectByIndex(2);
		
		//To Enter Region 
		WebElement Regionxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[9]//child::div//child::select"));
		Select sel2 = new Select(Regionxpath);
		sel2.selectByIndex(1);
		System.out.println("Region");
		
		//To Enter Latitude Name 
		WebElement Latitudexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[19]//child::div//child::input"));
		Latitudexpath.sendKeys("111.2345");
		System.out.println("Latitude");
		
		//To Enter Longitude Name 
		WebElement Longitudexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[20]//child::div//child::input"));
		Longitudexpath.sendKeys("111.2345");
		System.out.println("Longitude");
		
		//To Enter Status
		WebElement Statusxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[21]//child::div//child::select"));
		Select sel3 = new Select(Statusxpath);
		sel3.selectByIndex(1);
		System.out.println("Region");
		
		//To Enter UOM
		WebElement UOMxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[26]//child::div//child::select"));
		Select sel4 = new Select(UOMxpath);
		sel4.selectByIndex(1);
		System.out.println("UOMxpath");
		
		//To Enter TimeZone xpath
		WebElement TimeZonexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[29]//child::div//child::select"));
		Select sel5 = new Select(TimeZonexpath);
		sel5.selectByIndex(1);
		System.out.println("TimeZonexpath");
		
		
		//To Click Submit Buttion to check all error msg
				WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
				submitbuttion.click();

				//To capture the error msg for Country Code			
				WebElement CountryCodeerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[7]//child::div//child::app-control-message//span"));
				CountryCodeerror.isDisplayed();
				Assert.assertEquals(CountryCodeerror.getText(), "Required");	
				System.out.println("Erorr message for Country Code  -" +CountryCodeerror.getText());		
}


	@Test(priority=63, groups = "mandatory_testing")
	public void Without_State_fields() throws InterruptedException 
	{
		
		//To Enter Code
		WebElement codexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[1]//child::div//child::input[1]"));
		codexpath.sendKeys("dev");	
		System.out.println("Code");
		
		//To Enter Name
		WebElement Namexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[2]//child::div//child::input"));
		Namexpath.sendKeys("Devendra Singh");
		System.out.println("Name");
		
		//To Select Type
		WebElement Typepath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[3]//child::div//child::select"));
		Select sel = new Select(Typepath);
		sel.selectByIndex(2);
		System.out.println("Type");
	
		//To Enter Pincode
		WebElement Pincodexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[4]//child::div//child::input"));
		Pincodexpath.sendKeys("0000");
		System.out.println("Pincode");
		
		//To Enter Full Address 
		WebElement Full_Addressxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[5]//child::div//child::input"));
		Full_Addressxpath.sendKeys("122017");
		System.out.println("Full Address");
		
		//To Enter City 
		WebElement Cityxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[6]//child::div//child::input"));
		Cityxpath.sendKeys("Delhi");
		System.out.println("City");
		
		//To Select Country Code 
		WebElement Country_Codexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[7]//child::div//child::select"));
		Select sel1 = new Select(Country_Codexpath);
		sel1.selectByIndex(1);
		System.out.println("Country Code");
	
		//To Enter State xpath
		//WebElement Statexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[8]//child::div//child::select"));
		//Select sel6 = new Select(Statexpath);
		//sel6.selectByIndex(2);
		
		//To Enter Region 
		WebElement Regionxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[9]//child::div//child::select"));
		Select sel2 = new Select(Regionxpath);
		sel2.selectByIndex(1);
		System.out.println("Region");
		
		//To Enter Latitude Name 
		WebElement Latitudexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[19]//child::div//child::input"));
		Latitudexpath.sendKeys("111.2345");
		System.out.println("Latitude");
		
		//To Enter Longitude Name 
		WebElement Longitudexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[20]//child::div//child::input"));
		Longitudexpath.sendKeys("111.2345");
		System.out.println("Longitude");
		
		//To Enter Status
		WebElement Statusxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[21]//child::div//child::select"));
		Select sel3 = new Select(Statusxpath);
		sel3.selectByIndex(1);
		System.out.println("Region");
		
		//To Enter UOM
		WebElement UOMxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[26]//child::div//child::select"));
		Select sel4 = new Select(UOMxpath);
		sel4.selectByIndex(1);
		System.out.println("UOMxpath");
		
		//To Enter TimeZone xpath
		WebElement TimeZonexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[29]//child::div//child::select"));
		Select sel5 = new Select(TimeZonexpath);
		sel5.selectByIndex(1);
		System.out.println("TimeZonexpath");
		
		
		//To Click Submit Buttion to check all error msg
				WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
				submitbuttion.click();

				//To capture the error msg for State
				WebElement Stateerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[8]//child::div//child::app-control-message//span"));
				Stateerror.isDisplayed();
				Assert.assertEquals(Stateerror.getText(), "Required");	
				System.out.println("Erorr message for State  -" +Stateerror.getText());			
}

@Test(priority=64, groups = "mandatory_testing")
	public void Without_Region_fields() throws InterruptedException 
	{
		
		//To Enter Code
		WebElement codexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[1]//child::div//child::input[1]"));
		codexpath.sendKeys("dev");	
		System.out.println("Code");
		
		//To Enter Name
		WebElement Namexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[2]//child::div//child::input"));
		Namexpath.sendKeys("Devendra Singh");
		System.out.println("Name");
		
		//To Select Type
		WebElement Typepath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[3]//child::div//child::select"));
		Select sel = new Select(Typepath);
		sel.selectByIndex(2);
		System.out.println("Type");
	
		//To Enter Pincode
		WebElement Pincodexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[4]//child::div//child::input"));
		Pincodexpath.sendKeys("0000");
		System.out.println("Pincode");
		
		//To Enter Full Address 
		WebElement Full_Addressxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[5]//child::div//child::input"));
		Full_Addressxpath.sendKeys("122017");
		System.out.println("Full Address");
		
		//To Enter City 
		WebElement Cityxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[6]//child::div//child::input"));
		Cityxpath.sendKeys("Delhi");
		System.out.println("City");
		
		//To Select Country Code 
		WebElement Country_Codexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[7]//child::div//child::select"));
		Select sel1 = new Select(Country_Codexpath);
		sel1.selectByIndex(1);
		System.out.println("Country Code");
	
		//To Enter State xpath
		WebElement Statexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[8]//child::div//child::select"));
		Select sel6 = new Select(Statexpath);
		sel6.selectByIndex(2);
		
		//To Enter Region 
		//WebElement Regionxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[9]//child::div//child::select"));
		//Select sel2 = new Select(Regionxpath);
		//sel2.selectByIndex(1);
		//System.out.println("Region");
		
		//To Enter Latitude Name 
		WebElement Latitudexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[19]//child::div//child::input"));
		Latitudexpath.sendKeys("111.2345");
		System.out.println("Latitude");
		
		//To Enter Longitude Name 
		WebElement Longitudexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[20]//child::div//child::input"));
		Longitudexpath.sendKeys("111.2345");
		System.out.println("Longitude");
		
		//To Enter Status
		WebElement Statusxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[21]//child::div//child::select"));
		Select sel3 = new Select(Statusxpath);
		sel3.selectByIndex(1);
		System.out.println("Region");
		
		//To Enter UOM
		WebElement UOMxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[26]//child::div//child::select"));
		Select sel4 = new Select(UOMxpath);
		sel4.selectByIndex(1);
		System.out.println("UOMxpath");
		
		//To Enter TimeZone xpath
		WebElement TimeZonexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[29]//child::div//child::select"));
		Select sel5 = new Select(TimeZonexpath);
		sel5.selectByIndex(1);
		System.out.println("TimeZonexpath");
		
		
		//To Click Submit Buttion to check all error msg
				WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
				submitbuttion.click();

				//To capture the error msg for Region
				WebElement Regionerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[9]//child::div//child::app-control-message//span"));
				Regionerror.isDisplayed();
				Assert.assertEquals(Regionerror.getText(), "Required");	
				System.out.println("Erorr message for Region  -" +Regionerror.getText());			
}	

@Test(priority=65, groups = "mandatory_testing")
public void Without_Latitude_fields() throws InterruptedException 
{
	
	//To Enter Code
	WebElement codexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[1]//child::div//child::input[1]"));
	codexpath.sendKeys("dev");	
	System.out.println("Code");
	
	//To Enter Name
	WebElement Namexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[2]//child::div//child::input"));
	Namexpath.sendKeys("Devendra Singh");
	System.out.println("Name");
	
	//To Select Type
	WebElement Typepath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[3]//child::div//child::select"));
	Select sel = new Select(Typepath);
	sel.selectByIndex(2);
	System.out.println("Type");

	//To Enter Pincode
	WebElement Pincodexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[4]//child::div//child::input"));
	Pincodexpath.sendKeys("0000");
	System.out.println("Pincode");
	
	//To Enter Full Address 
	WebElement Full_Addressxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[5]//child::div//child::input"));
	Full_Addressxpath.sendKeys("122017");
	System.out.println("Full Address");
	
	//To Enter City 
	WebElement Cityxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[6]//child::div//child::input"));
	Cityxpath.sendKeys("Delhi");
	System.out.println("City");
	
	//To Select Country Code 
	WebElement Country_Codexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[7]//child::div//child::select"));
	Select sel1 = new Select(Country_Codexpath);
	sel1.selectByIndex(1);
	System.out.println("Country Code");

	//To Enter State xpath
	WebElement Statexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[8]//child::div//child::select"));
	Select sel6 = new Select(Statexpath);
	sel6.selectByIndex(2);
	
	//To Enter Region 
	WebElement Regionxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[9]//child::div//child::select"));
	Select sel2 = new Select(Regionxpath);
	sel2.selectByIndex(1);
	System.out.println("Region");
	
	//To Enter Latitude Name 
	//WebElement Latitudexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[19]//child::div//child::input"));
	//Latitudexpath.sendKeys("111.2345");
	//System.out.println("Latitude");
	
	//To Enter Longitude Name 
	WebElement Longitudexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[20]//child::div//child::input"));
	Longitudexpath.sendKeys("111.2345");
	System.out.println("Longitude");
	
	//To Enter Status
	WebElement Statusxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[21]//child::div//child::select"));
	Select sel3 = new Select(Statusxpath);
	sel3.selectByIndex(1);
	System.out.println("Region");
	
	//To Enter UOM
	WebElement UOMxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[26]//child::div//child::select"));
	Select sel4 = new Select(UOMxpath);
	sel4.selectByIndex(1);
	System.out.println("UOMxpath");
	
	//To Enter TimeZone xpath
	WebElement TimeZonexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[29]//child::div//child::select"));
	Select sel5 = new Select(TimeZonexpath);
	sel5.selectByIndex(1);
	System.out.println("TimeZonexpath");
	
	
	//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();

			//To capture the error msg for Latitude
			WebElement Latitudeerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[19]//child::div//child::app-control-message//span"));
			Latitudeerror.isDisplayed();
			Assert.assertEquals(Latitudeerror.getText(), "Required");	
			System.out.println("Erorr message for Latitude  -" +Latitudeerror.getText());			
}	

@Test(priority=66, groups = "mandatory_testing")
public void Without_Longitude_fields() throws InterruptedException 
{
	
	//To Enter Code
	WebElement codexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[1]//child::div//child::input[1]"));
	codexpath.sendKeys("dev");	
	System.out.println("Code");
	
	//To Enter Name
	WebElement Namexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[2]//child::div//child::input"));
	Namexpath.sendKeys("Devendra Singh");
	System.out.println("Name");
	
	//To Select Type
	WebElement Typepath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[3]//child::div//child::select"));
	Select sel = new Select(Typepath);
	sel.selectByIndex(2);
	System.out.println("Type");

	//To Enter Pincode
	WebElement Pincodexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[4]//child::div//child::input"));
	Pincodexpath.sendKeys("0000");
	System.out.println("Pincode");
	
	//To Enter Full Address 
	WebElement Full_Addressxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[5]//child::div//child::input"));
	Full_Addressxpath.sendKeys("122017");
	System.out.println("Full Address");
	
	//To Enter City 
	WebElement Cityxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[6]//child::div//child::input"));
	Cityxpath.sendKeys("Delhi");
	System.out.println("City");
	
	//To Select Country Code 
	WebElement Country_Codexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[7]//child::div//child::select"));
	Select sel1 = new Select(Country_Codexpath);
	sel1.selectByIndex(1);
	System.out.println("Country Code");

	//To Enter State xpath
	WebElement Statexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[8]//child::div//child::select"));
	Select sel6 = new Select(Statexpath);
	sel6.selectByIndex(2);
	
	//To Enter Region 
	WebElement Regionxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[9]//child::div//child::select"));
	Select sel2 = new Select(Regionxpath);
	sel2.selectByIndex(1);
	System.out.println("Region");
	
	//To Enter Latitude Name 
	WebElement Latitudexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[19]//child::div//child::input"));
	Latitudexpath.sendKeys("111.2345");
	System.out.println("Latitude");
	
	//To Enter Longitude Name 
	//WebElement Longitudexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[20]//child::div//child::input"));
	//Longitudexpath.sendKeys("111.2345");
	//System.out.println("Longitude");
	
	//To Enter Status
	WebElement Statusxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[21]//child::div//child::select"));
	Select sel3 = new Select(Statusxpath);
	sel3.selectByIndex(1);
	System.out.println("Region");
	
	//To Enter UOM
	WebElement UOMxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[26]//child::div//child::select"));
	Select sel4 = new Select(UOMxpath);
	sel4.selectByIndex(1);
	System.out.println("UOMxpath");
	
	//To Enter TimeZone xpath
	WebElement TimeZonexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[29]//child::div//child::select"));
	Select sel5 = new Select(TimeZonexpath);
	sel5.selectByIndex(1);
	System.out.println("TimeZonexpath");
	
	
	//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();

			//To capture the error msg for Longitude
			WebElement Longitudeerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[20]//child::div//child::app-control-message//span"));
			Longitudeerror.isDisplayed();
			Assert.assertEquals(Longitudeerror.getText(), "Required");	
			System.out.println("Erorr message for Longitude  -" +Longitudeerror.getText());			
}	
	
@Test(priority=67, groups = "mandatory_testing")
public void Without_Status_fields() throws InterruptedException 
{
	
	//To Enter Code
	WebElement codexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[1]//child::div//child::input[1]"));
	codexpath.sendKeys("dev");	
	System.out.println("Code");
	
	//To Enter Name
	WebElement Namexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[2]//child::div//child::input"));
	Namexpath.sendKeys("Devendra Singh");
	System.out.println("Name");
	
	//To Select Type
	WebElement Typepath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[3]//child::div//child::select"));
	Select sel = new Select(Typepath);
	sel.selectByIndex(2);
	System.out.println("Type");

	//To Enter Pincode
	WebElement Pincodexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[4]//child::div//child::input"));
	Pincodexpath.sendKeys("0000");
	System.out.println("Pincode");
	
	//To Enter Full Address 
	WebElement Full_Addressxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[5]//child::div//child::input"));
	Full_Addressxpath.sendKeys("122017");
	System.out.println("Full Address");
	
	//To Enter City 
	WebElement Cityxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[6]//child::div//child::input"));
	Cityxpath.sendKeys("Delhi");
	System.out.println("City");
	
	//To Select Country Code 
	WebElement Country_Codexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[7]//child::div//child::select"));
	Select sel1 = new Select(Country_Codexpath);
	sel1.selectByIndex(1);
	System.out.println("Country Code");

	//To Enter State xpath
	WebElement Statexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[8]//child::div//child::select"));
	Select sel6 = new Select(Statexpath);
	sel6.selectByIndex(2);
	
	//To Enter Region 
	WebElement Regionxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[9]//child::div//child::select"));
	Select sel2 = new Select(Regionxpath);
	sel2.selectByIndex(1);
	System.out.println("Region");
	
	//To Enter Latitude Name 
	WebElement Latitudexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[19]//child::div//child::input"));
	Latitudexpath.sendKeys("111.2345");
	System.out.println("Latitude");
	
	//To Enter Longitude Name 
	WebElement Longitudexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[20]//child::div//child::input"));
	Longitudexpath.sendKeys("111.2345");
	System.out.println("Longitude");
	
	//To Enter Status
	//WebElement Statusxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[21]//child::div//child::select"));
	//Select sel3 = new Select(Statusxpath);
	//sel3.selectByIndex(1);
	//System.out.println("Region");
	
	//To Enter UOM
	WebElement UOMxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[26]//child::div//child::select"));
	Select sel4 = new Select(UOMxpath);
	sel4.selectByIndex(1);
	System.out.println("UOMxpath");
	
	//To Enter TimeZone xpath
	WebElement TimeZonexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[29]//child::div//child::select"));
	Select sel5 = new Select(TimeZonexpath);
	sel5.selectByIndex(1);
	System.out.println("TimeZonexpath");
	
	
	//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();
			
			//To capture the error msg for Status
			WebElement Statuserror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[21]//child::div//child::app-control-message//span"));
			Statuserror.isDisplayed();
			Assert.assertEquals(Statuserror.getText(), "Required");	
			System.out.println("Erorr message for Status  -" +Statuserror.getText());
						
}	

@Test(priority=68, groups = "mandatory_testing")
public void Without_UOM_fields() throws InterruptedException 
{
	
	//To Enter Code
	WebElement codexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[1]//child::div//child::input[1]"));
	codexpath.sendKeys("dev");	
	System.out.println("Code");
	
	//To Enter Name
	WebElement Namexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[2]//child::div//child::input"));
	Namexpath.sendKeys("Devendra Singh");
	System.out.println("Name");
	
	//To Select Type
	WebElement Typepath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[3]//child::div//child::select"));
	Select sel = new Select(Typepath);
	sel.selectByIndex(2);
	System.out.println("Type");

	//To Enter Pincode
	WebElement Pincodexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[4]//child::div//child::input"));
	Pincodexpath.sendKeys("0000");
	System.out.println("Pincode");
	
	//To Enter Full Address 
	WebElement Full_Addressxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[5]//child::div//child::input"));
	Full_Addressxpath.sendKeys("122017");
	System.out.println("Full Address");
	
	//To Enter City 
	WebElement Cityxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[6]//child::div//child::input"));
	Cityxpath.sendKeys("Delhi");
	System.out.println("City");
	
	//To Select Country Code 
	WebElement Country_Codexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[7]//child::div//child::select"));
	Select sel1 = new Select(Country_Codexpath);
	sel1.selectByIndex(1);
	System.out.println("Country Code");

	//To Enter State xpath
	WebElement Statexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[8]//child::div//child::select"));
	Select sel6 = new Select(Statexpath);
	sel6.selectByIndex(2);
	
	//To Enter Region 
	WebElement Regionxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[9]//child::div//child::select"));
	Select sel2 = new Select(Regionxpath);
	sel2.selectByIndex(1);
	System.out.println("Region");
	
	//To Enter Latitude Name 
	WebElement Latitudexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[19]//child::div//child::input"));
	Latitudexpath.sendKeys("111.2345");
	System.out.println("Latitude");
	
	//To Enter Longitude Name 
	WebElement Longitudexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[20]//child::div//child::input"));
	Longitudexpath.sendKeys("111.2345");
	System.out.println("Longitude");
	
	//To Enter Status
	WebElement Statusxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[21]//child::div//child::select"));
	Select sel3 = new Select(Statusxpath);
	sel3.selectByIndex(1);
	System.out.println("Region");
	
	//To Enter UOM
	//WebElement UOMxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[26]//child::div//child::select"));
	//Select sel4 = new Select(UOMxpath);
	//sel4.selectByIndex(1);
	//System.out.println("UOMxpath");
	
	//To Enter TimeZone xpath
	WebElement TimeZonexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[29]//child::div//child::select"));
	Select sel5 = new Select(TimeZonexpath);
	sel5.selectByIndex(1);
	System.out.println("TimeZonexpath");
	
	
	//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();
			
			//To capture the error msg for UOM
			WebElement UOMerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[26]//child::div//child::app-control-message//span"));
			UOMerror.isDisplayed();
			Assert.assertEquals(UOMerror.getText(), "Required");	
			System.out.println("Erorr message for UOM  -" +UOMerror.getText());
						
}	

@Test(priority=69, groups = "mandatory_testing")
public void Without_TimeZone_fields() throws InterruptedException 
{
	
	//To Enter Code
	WebElement codexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[1]//child::div//child::input[1]"));
	codexpath.sendKeys("dev");	
	System.out.println("Code");
	
	//To Enter Name
	WebElement Namexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[2]//child::div//child::input"));
	Namexpath.sendKeys("Devendra Singh");
	System.out.println("Name");
	
	//To Select Type
	WebElement Typepath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[3]//child::div//child::select"));
	Select sel = new Select(Typepath);
	sel.selectByIndex(2);
	System.out.println("Type");

	//To Enter Pincode
	WebElement Pincodexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[4]//child::div//child::input"));
	Pincodexpath.sendKeys("0000");
	System.out.println("Pincode");
	
	//To Enter Full Address 
	WebElement Full_Addressxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[5]//child::div//child::input"));
	Full_Addressxpath.sendKeys("122017");
	System.out.println("Full Address");
	
	//To Enter City 
	WebElement Cityxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[6]//child::div//child::input"));
	Cityxpath.sendKeys("Delhi");
	System.out.println("City");
	
	//To Select Country Code 
	WebElement Country_Codexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[7]//child::div//child::select"));
	Select sel1 = new Select(Country_Codexpath);
	sel1.selectByIndex(1);
	System.out.println("Country Code");

	//To Enter State xpath
	WebElement Statexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[8]//child::div//child::select"));
	Select sel6 = new Select(Statexpath);
	sel6.selectByIndex(2);
	
	//To Enter Region 
	WebElement Regionxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[9]//child::div//child::select"));
	Select sel2 = new Select(Regionxpath);
	sel2.selectByIndex(1);
	System.out.println("Region");
	
	//To Enter Latitude Name 
	WebElement Latitudexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[19]//child::div//child::input"));
	Latitudexpath.sendKeys("111.2345");
	System.out.println("Latitude");
	
	//To Enter Longitude Name 
	WebElement Longitudexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[20]//child::div//child::input"));
	Longitudexpath.sendKeys("111.2345");
	System.out.println("Longitude");
	
	//To Enter Status
	WebElement Statusxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[21]//child::div//child::select"));
	Select sel3 = new Select(Statusxpath);
	sel3.selectByIndex(1);
	System.out.println("Region");
	
	//To Enter UOM
	WebElement UOMxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[26]//child::div//child::select"));
	Select sel4 = new Select(UOMxpath);
	sel4.selectByIndex(1);
	System.out.println("UOMxpath");
	
	//To Enter TimeZone xpath
	//WebElement TimeZonexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[29]//child::div//child::select"));
	//Select sel5 = new Select(TimeZonexpath);
	//sel5.selectByIndex(1);
	//System.out.println("TimeZonexpath");
	
	
	//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();
			
			//To capture the error msg for Time Zone
			WebElement TimeZoneerror = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[29]//child::div//child::app-control-message//span"));
			TimeZoneerror.isDisplayed();
			Assert.assertEquals(TimeZoneerror.getText(), "Required");	
			System.out.println("Erorr message for Time Zone  -" +TimeZoneerror.getText());
						
}	


@Test(priority=70, groups = "mandatory_testing")
public void WithAll_fields() throws InterruptedException 
{
	
	//To Enter Code
	WebElement codexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[1]//child::div//child::input[1]"));
	codexpath.sendKeys("dev");	
	System.out.println("Code");
	
	//To Enter Name
	WebElement Namexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[2]//child::div//child::input"));
	Namexpath.sendKeys("Devendra Singh");
	System.out.println("Name");
	
	//To Select Type
	WebElement Typepath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[3]//child::div//child::select"));
	Select sel = new Select(Typepath);
	sel.selectByIndex(2);
	System.out.println("Type");

	//To Enter Pincode
	WebElement Pincodexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[4]//child::div//child::input"));
	Pincodexpath.sendKeys("0000");
	System.out.println("Pincode");
	
	//To Enter Full Address 
	WebElement Full_Addressxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[5]//child::div//child::input"));
	Full_Addressxpath.sendKeys("122017");
	System.out.println("Full Address");
	
	//To Enter City 
	WebElement Cityxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[6]//child::div//child::input"));
	Cityxpath.sendKeys("Delhi");
	System.out.println("City");
	
	//To Select Country Code 
	WebElement Country_Codexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[7]//child::div//child::select"));
	Select sel1 = new Select(Country_Codexpath);
	sel1.selectByIndex(1);
	System.out.println("Country Code");

	//To Enter State xpath
	WebElement Statexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[8]//child::div//child::select"));
	Select sel6 = new Select(Statexpath);
	sel6.selectByIndex(2);
	
	//To Enter Region 
	WebElement Regionxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[9]//child::div//child::select"));
	Select sel2 = new Select(Regionxpath);
	sel2.selectByIndex(1);
	System.out.println("Region");
	
	//To Enter Latitude Name 
	WebElement Latitudexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[19]//child::div//child::input"));
	Latitudexpath.sendKeys("111.2345");
	System.out.println("Latitude");
	
	//To Enter Longitude Name 
	WebElement Longitudexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[20]//child::div//child::input"));
	Longitudexpath.sendKeys("111.2345");
	System.out.println("Longitude");
	
	//To Enter Status
	WebElement Statusxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[21]//child::div//child::select"));
	Select sel3 = new Select(Statusxpath);
	sel3.selectByIndex(1);
	System.out.println("Region");
	
	//To Enter UOM
	WebElement UOMxpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[26]//child::div//child::select"));
	Select sel4 = new Select(UOMxpath);
	sel4.selectByIndex(1);
	System.out.println("UOMxpath");
	
	//To Enter TimeZone xpath
	WebElement TimeZonexpath = driver.findElement(By.xpath("//*[@class='col-md-12']//child::div//child::div[29]//child::div//child::select"));
	Select sel5 = new Select(TimeZonexpath);
	sel5.selectByIndex(1);
	System.out.println("TimeZonexpath");
	
	//To Click Submit Buttion to check all error msg
			WebElement submitbuttion = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
			submitbuttion.click();
			
			//To capture the error msg
			WebElement Errorsmg = driver.findElement(By.xpath("//div[contains(text(),'Airport already exists')]"));
			Thread.sleep(1000);
			System.out.println("Erorr message for Time Zone  -" +Errorsmg.getText());
			Errorsmg.isDisplayed();
			Assert.assertNotEquals(Errorsmg.getText(), "Airport already exists");		
			
			//Take screenshot and store as a file formant
			Thread.sleep(2000);
			WebElement borderline = driver.findElement(By.xpath("//div[contains(text(),'Airport already exists')]"));
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].style.border = '3px solid red'",borderline );
}


		
/*	@AfterMethod
	public void closedbrowser()
	{
		driver.close();
	}
	*/
}
