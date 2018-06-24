package package1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class Class1 {

	public static WebDriver driver ;
	
	public static void BrowserOpenYoutube() {
		
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
		driver.get("https://www.youtube.com");
	}
	
	public static void driverClose() {
		driver.close();
	}
}
