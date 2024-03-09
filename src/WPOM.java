import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

//import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;

public class WPOM {
public WebDriver driver;	
		
	@Test
	public void browserOpen() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				"D:\\Selenium libraby\\Sever Libarby\\chromedriver_win32\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
		driver.get("https://qa.thespicetag.com/login");
				
				String loginurl = driver.getCurrentUrl();
				driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys("Devendra.singh1@spicejet.com");
				driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("Welcome@123");
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				Thread.sleep(2000);
				
				System.out.println(driver.getCurrentUrl());
				
				if(loginurl.equals(driver.getCurrentUrl())) {
					Assert.assertEquals(loginurl, driver.getCurrentUrl());
					//System.out.println("Passed");
				}
				else {
					System.out.println("please check password");
				}
				
			}
		}


