
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class WD_Methods {
	public static WebDriver driver;
		public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				"D:\\Selenium libraby\\Sever Libarby\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions chromeOptions = new ChromeOptions();
	    chromeOptions.addArguments("--remote-allow-origins=*");
	    driver = new ChromeDriver(chromeOptions);
		//	WebDriver driver = new ChromeDriver();	
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("https://www.thespicetag.com/login");
			Thread.sleep(3000);
			
			WebElement signin = driver.findElement(By.xpath("//button[@class='btn btnColor btn-block auth-form-btn']"));
			System.out.println("Calse Name ="+signin.getAttribute("class"));
			System.out.println("TagName ="+ signin.getTagName());
			System.out.println("Sigin color =" + signin.getCssValue("color"));
			System.out.println("Sigin font-Size="+signin.getCssValue("font-size"));
			System.out.println("Sigin Text="+signin.getText());
			System.out.println("Sigin is display="+signin.isDisplayed());
			System.out.println("Sigin is enabled="+signin.isEnabled());
			System.out.println("Sigin loaction="+signin.getLocation());
			Dimension signinsize = signin.getSize();
			int height = signinsize.height;
			int widht = signinsize.width;
			System.out.println("Signin Hight is =" + height + " "+"Signin Width is =" +widht);
			Point sigininlocation = signin.getLocation();
			int x = sigininlocation.x;
			int y = sigininlocation.y;
			System.out.println("Sign in x="+x+" "+ "Sign in y"+y);
			Thread.sleep(3000);
		
		/*	TakesScreenshot ts = (TakesScreenshot)driver;
			File file = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("C:\\Users\\devendra.singh1\\eclipse-workspace\\230_class\\Screenshot\\LoginScreenShort.png"));
			System.out.println("Screenshort captured");
			*/
			
	}

}
