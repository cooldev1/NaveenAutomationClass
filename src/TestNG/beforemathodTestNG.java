package TestNG;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class beforemathodTestNG {
  public WebDriver driver;
	
	@BeforeMethod
	public void url() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium libraby\\Sever Libarby\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();	
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("https://qa.thespicetag.com/login");
			
	}

	@Test
	public void vryfytitle() {
		String title = driver.getTitle();
		System.out.println("Page title is-  " + title);
		Assert.assertEquals(title, "SpiceTag");
	}
	
	@AfterMethod
	public void closed() {
		driver.close();
	
	}
	
}
