

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class travewithdzone {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", 
				"D:\\Selenium libraby\\Sever Libarby\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();

for(int i= 0; i <100;i++ ) {
			
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
			driver.get("https://www.youtube.com");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Blue Lassi shop इतनी famous क्यों है ? पंजाब से बेहतर लस्सी Blue Lassi shop में मिलती है ?");
			driver.findElement(By.xpath("//button[@aria-label='Search'][1]")).click();
		
			
			
			//driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Portugal+#shots+#travel+#portugal+#viral+by+Travel+With+D+zone");
			//driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Kedarnath+#kedarnathtemple+by+Travel+With+D+zone");
			//driver.findElement(By.xpath("//input[@id='search']")).sendKeys("\r\n"
			//		+ "Top+10+places+in+Pondicherry+|+Pondicherry+tourist+|+Must+visit+places+|+Puducherry+|+Pondy+2022+Travel+With+D+Zone");
			//driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Himachal+â�¤ï¸�â�¤ï¸�Morning+#Shorts+#TravelWithDZone");
			//driver.findElement(By.xpath("//input[@id='search']")).sendKeys("paris+ka+trip+song+by+Remix+songs+with+d+zone");
			//driver.findElement(By.xpath("//input[@id='search']")).sendKeys("remix+songs+with+d+zone");
			//driver.findElement(By.xpath("//input[@id='search']")).sendKeys("travel+with+d+zone");
			//driver.findElement(By.xpath("//input[@id='search']")).sendKeys("#goodmorningstatus #kishorekumarsongs #oldsongshithindi");
			//Thread.sleep(10000);
			//driver.findElement(By.xpath("//button[@id='search-icon-legacy']")).click();
			Thread.sleep(1000);
			//driver.findElement(By.xpath("//a[@title='Ghar se the chale #radheshyam #prabhas #loveshorts #viral #arjitsinghsong #jubin_nautiyal']")).click();
//			driver.findElement(By.xpath("//span[contains(text(),'//a[@href='/watch?v=qcIW7jkt6DU&t=8s'][1]')]")).click();
//			Thread.sleep(2000);
			//driver.findElement(By.xpath("//span[contains(text(),'Mahadev whatsapp status vidoe |mere bhole nath ji ')]")).click();
			//Thread.sleep(40000);
			//driver.findElement(By.xpath("//span[contains(text(),'#kedarnathtemple #kedarnath #kedarnathdham #kedarn')]")).click();
			//driver.findElement(By.xpath("//a[contains(text(),'Surya Kumar Yadav vs South Africa First 50 in T20 ')]")).click();
			//driver.findElement(By.xpath("//span[contains(text(),'#rishikesh #short #viral #trending')]")).click();
			//driver.findElement(By.xpath("//yt-formatted-string[contains(text(),'Kashmir snow fall || Travel With D Zone')]")).click();
			//driver.findElement(By.xpath("//yt-formatted-string[contains(text(),'Portugal #shots #travel #portugal #viral')]")).click();
			//driver.findElement(By.xpath("//yt-formatted-string[contains(text(),'#kedarnathtemple ðŸ”¥ðŸ”¥ðŸ™�ðŸ™�')]")).click();
			//driver.findElement(By.xpath("//yt-formatted-string[contains(text(),'Paris Ka Trip (Video) @Millind Gaba X @Yo Yo Honey Singh | Asli Gold, Mihir G | Bhushan Kumar')]")).click();
			//driver.findElement(By.xpath("//yt-formatted-string[text()='Himachal â�¤ï¸�â�¤ï¸�Morning #Shorts #TravelWithDZone']")).click();
			//driver.findElement(By.xpath("//yt-formatted-string[contains(text(),'à¤¬à¤¦à¥�à¤°à¥€à¤¨à¤¾à¤¥ à¤Ÿà¥‡à¤®à¥�à¤ªà¤² à¤•à¥€ 5 à¤…à¤¨à¤¸à¥�à¤¨à¥€ à¤•à¤¹à¤¾à¤¨à¥€ ðŸ™�ðŸ™�#badrinath')]")).click();
			//driver.findElement(By.xpath("//span[contains(text(),'#goodmorningstatus #kishorekumarsongs #oldsongshithindi')]")).click();
			//driver.findElement(By.xpath("//span[contains(text(),'Kashmir snow fall || Travel With D Zone')]")).click();
		//	System.out.print("Video view count"+i);	
		//	Thread.sleep(2000);
		driver.close();
			
			}

	}

	private static WebDriver getDriver() {
		// TODO Auto-generated method stub
		return null;
	}

}
