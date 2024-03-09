import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FilipKart_automation extends Global_Class_Varivals{

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium libraby\\Sever Libarby\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();	
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("https://www.flipkart.com"); 
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).sendKeys(Keys.ESCAPE);
			//driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
			//WebElement popupclosed = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
			//eleclick(driver, popupclosed, 2);
			
			//Actions action = new Actions(driver);
			//action.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'Fashion')][1]"))).build().perform(); // Fashion
			//action.moveToElement(driver.findElement(By.xpath("//*[@class='_3XS_gI _7qr1OC']//child::a[2]"))).build().perform(); // Men's bottom wear
			//driver.findElement(By.xpath("//*[@class='_3XS_gI']//child::a[2]")).click(); //Click on Men's Jeans
			//Thread.sleep(3000);
			//action.clickAndHold(driver.findElement(By.xpath("//div[@class='_31Kbhn WC_zGJ']"))).moveByOffset(-198, 0).perform();
			driver.findElement(By.xpath("//*[contains(text(),'Travel')]")).click();
			Thread.sleep(3000);
				
			driver.findElement(By.xpath("//input[@class='_1w3ZZo _1YBGQV _2EjOJB lZd1T6 _2vegSu _2mFmU7']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@class='_1w3ZZo _1YBGQV _2EjOJB lZd1T6 _2vegSu _2mFmU7']")).sendKeys("BOM");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class='_24hoQ2 _1EzOls']//child::div")).click();
			
			driver.findElement(By.xpath("//input[@class='_1w3ZZo _1YBGQV _2EjOJB lZd1T6 _2dqBfU _2mFmU7']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@class='_1w3ZZo _1YBGQV _2EjOJB lZd1T6 _2dqBfU _2mFmU7']")).sendKeys("Del");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class='_3uA4ax']")).click();
	}

}
