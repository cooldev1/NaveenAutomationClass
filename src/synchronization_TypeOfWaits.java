import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class synchronization_TypeOfWaits extends Global_Class_Varivals {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium libraby\\Sever Libarby\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();	
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
			//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			//driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			driver.get("https://qa.thespicetag.com/login");
			
			//WebDriverWait wait = new WebDriverWait(driver,10);
			//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@formcontrolname='name']")));
			//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@formcontrolname='name']")));	
			
			WebElement username = driver.findElement(By.xpath("//input[@formcontrolname='name']"));
			WebElement pass = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
			WebElement login = driver.findElement(By.xpath("//button[@class='btn btnColor btn-block auth-form-btn']"));
			
			checkEleVisibilty(driver, username, 5);
			entervalue(driver, username, "Devendra.singh1@spicejet.com", 2);
			checkEleVisibilty(driver, pass, 2);
			entervalue(driver, pass, "Welcome@123", 2);
			checkEleVisibilty(driver, login, 3);
			eleclick(driver, login, 2);
			
			
			
	}

}
