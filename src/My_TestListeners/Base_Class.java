package My_TestListeners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.google.common.io.Files;

public class Base_Class {
	
	public static String url = "https://qa.thespicetag.com/login";
	public static WebDriver driver;

	public static void Openbrowser() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				  "D:\\Selenium libraby\\Sever Libarby\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
				
			 driver.get(url);
			 System.out.println(driver.getCurrentUrl());
			 System.out.println(url);
			if(driver.getCurrentUrl().equalsIgnoreCase(url)) //QA server
			{
			driver.findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys("devendra.singh1@spicejet.com");
			driver.findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys("Welcome@123");
			driver.findElement(By.xpath("//button[@class='btn btnColor btn-block auth-form-btn']")).click();
			Thread.sleep(2000);
			Assert.assertEquals("Dashboard D2D", driver.findElement(By.xpath("//span[contains(text(),'Dashboard')]")).getText());
			}
			else if(driver.getCurrentUrl().equalsIgnoreCase(url)) {  // Live Server
				
				driver.findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys("devendra.singh1@spicejet.com");
				driver.findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys("Spice@123");
				driver.findElement(By.xpath("//button[@class='btn btnColor btn-block auth-form-btn']")).click();
				Thread.sleep(2000);
				Assert.assertEquals("Dashboard", driver.findElement(By.xpath("//span[contains(text(),'Dashboard')]")).getText());
			}
			else if(driver.getCurrentUrl().equalsIgnoreCase(url)) {  //Dev Server
				
				driver.findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys("devendra.singh1@spicejet.com");
				driver.findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys("Welcome@123");
				driver.findElement(By.xpath("//button[@class='btn btnColor btn-block auth-form-btn']")).click();
				Thread.sleep(2000);
				Assert.assertEquals("Dashboard", driver.findElement(By.xpath("//span[contains(text(),'Dashboard')]")).getText());
			}
			else {
				System.out.println("Url not match with Live Server, QA Server and Dev Server");
			}

		 }
	
	
	public static void screenshots(String methodname) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //now copy screenshot to desired location using copyFile //method
		  Files.copy (src, new File("C:\\Users\\devendra.singh1\\eclipse-workspace\\230_class\\Screenshot\\AWBScreenShort"+methodname+".png"));
	}
}
