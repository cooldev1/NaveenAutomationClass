package TestNG;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Airport_search {
	
	public WebDriver driver;

	@BeforeMethod
	public void Airport_Search() throws InterruptedException
	
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
		else if(url.equals(driver.getCurrentUrl())) { //to Dev Server
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
			Thread.sleep(2000);
			
	}
	
//---------------------------------------Search--------------------------
@Test(priority=1, groups="search")
public void Search_Code() throws InterruptedException
{
	String  code_searchvalue = "EbB";
	//To find total page count
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	WebElement Total_count = driver.findElement(By.xpath("//div[contains(text(),'Total:')]"));
	String page_c = Total_count.getText(); // Total: 484
	System.out.println(page_c);
	
	//To Get page count from text
	String string_pagecount = page_c.substring(page_c.indexOf(" ")+1);
	System.out.println(string_pagecount);
	
	int totalpage =  Integer.valueOf(string_pagecount);
	System.out.println(totalpage);
	Assert.assertNotEquals(totalpage, 0);
	//Assert.assertEquals(totalpage, 0);
	int page_count = totalpage/10;
	
	System.out.println(page_count);
outer:	
for(int i = 1;i<=page_count+1; i++) {
	
//To  table xpath	
	  String fist_xpath = "//table[@id='DataTables_Table_0']//child::tbody//child::tr[";
	  String Second_xpath = "]//child::td[5]";
	  System.out.println("Manuel code:-"+code_searchvalue);
	  for(int j = 1;j<=10;j++) {
		  WebElement table_xpath = driver.findElement(By.xpath(fist_xpath+ j +Second_xpath)); //Table column Xpath
		  if(code_searchvalue.equalsIgnoreCase(table_xpath.getText()))
		  {
			
			  System.out.println("Test Passed:-"+code_searchvalue);
			  System.out.println("Station Code Match With:-"+table_xpath.getText());
			  break outer;
			    
		  }
		  else{
			  
			  System.out.println(table_xpath.getText());
			  System.out.println("Second loop run:-" +j);
		  }
		 // System.out.println("Second loop run:-" +j);
		  
	  }
	  
	//To Click on next buttion 
	   driver.findElement(By.xpath("//span[contains(text(),'Next ')]")).click();
	  Thread.sleep(1500);
	    //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  
	} 

driver.close();
}	
	
	
	
	//To Enter Code in search box
	
	//WebElement code_ser = driver.findElement(By.xpath("//input[@formcontrolname='code']"));
	//code_ser.sendKeys(code_svalue);
	
	//To Click on search button
	
	//WebElement Search_button = driver.findElement(By.xpath("//button[@title='Search']"));
	//Search_button.click();
//	}	

//@Test(priority=1, groups="search")
//public void Search_name()
//{
	
//}
/*	
	//by name search xpath
	WebElement name_ser = driver.findElement(By.xpath("//input[@formcontrolname='name']"));
	name_ser.sendKeys("Devendra Singh");
	//by type search xpath
	WebElement type_ser = driver.findElement(By.xpath("//select[@formcontrolname='type']"));
	Select sel = new Select(type_ser);
	sel.selectByIndex(1);
	//by city search xpath
	WebElement city_ser = driver.findElement(By.xpath("//input[@formcontrolname='city_code']"));
	city_ser.sendKeys("Delhi");
	//by status search xpath
	WebElement status_ser = driver.findElement(By.xpath("//input[@formcontrolname='is_active']"));
	Select sel1 = new Select(status_ser);
	sel1.selectByIndex(1);
	// Click on Search buttion
	//WebElement search_button = driver.findElement(By.xpath("//button[@title='Search']"));
	*/
}



