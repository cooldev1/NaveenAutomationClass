package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class QA_A2A_Booking {
	
	WebDriver  driver;
	
	@Test(priority=1)
	public void URL()
	{
		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium libraby\\Sever Libarby\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();	
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("https://qa.thespicetag.com/login");
			
			//	String userid = "devendra.singh1@spicejet.com";
		//	String pass = "Welcome@123";
		//	driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(userid);
		//	driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(pass);
	}
	@Test(priority=2)
	public void Loginpage()
	{
		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium libraby\\Sever Libarby\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://qa.thespicetag.com/login");
		
		WebElement useridxpath = driver.findElement(By.xpath("//*[@formcontrolname='name']")); // To userid xpath
		WebElement passxpath = driver.findElement(By.xpath("//*[@formcontrolname='password']")); //To Password xpath
		WebElement loginxpath = driver.findElement(By.xpath("//button[@class='btn btnColor btn-block auth-form-btn']")); //To Login xpath
		
		
		useridxpath.sendKeys("devendra.singh1@spicejet.com");
		passxpath.sendKeys("Welcome@123");
		loginxpath.click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Secussefully rune");
	}

}
