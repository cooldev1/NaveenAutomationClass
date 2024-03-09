import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Spicejet_Datepicker_JavaScript {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chorme.driver",
				"D:\\Selenium libraby\\Sever Libarby\\chromedriver_win32\\chromedriver.exe");
		//	WebDriver driver = new ChromeDriver();	
		//	driver.manage().window().maximize();
		//	driver.manage().deleteAllCookies();
		//	driver.get("https://www.spicejet.com");
		//	Thread.sleep(3000);
			
			DateFormat formatdate = new SimpleDateFormat("dd/MM/YYYY");
			Date SystemDate = new Date();
			String Dateofsystem = formatdate.format(SystemDate);	
			System.out.println(Dateofsystem);
			
	}

}
