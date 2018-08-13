package demo;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class Demo {
	
	public static IOSDriver<MobileElement> driver1 = null;
	public static AndroidDriver<MobileElement> driver2 = null;
	public static WebDriver driver3 = null;
	
	Thread thread1 = new Thread() {
	    public void run() {
	    	try {
	    		DesiredCapabilities caps = new DesiredCapabilities();
	            caps.setCapability("automationName", "XCUITest");
	            caps.setCapability("platformName", "iOS");
	            caps.setCapability("platformVersion", "11.3");
	            caps.setCapability("deviceName","Admin’s iPad");
	            caps.setCapability("udid", "auto");
	            caps.setCapability("noReset", "true");
	            caps.setCapability("browserName","safari");
	            caps.setCapability("autoWebview", "true");
	            caps.setCapability("startIWDP", true);
	            caps.setCapability("newCommandTimeout", 60*30);	
	            driver1 = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4722/wd/hub"), caps);
	            driver1.get("http://hva-wholesale-frontend-staging.s3-website.us-east-2.amazonaws.com/");
	    	}
	    	catch(Exception e) {
	    		System.err.println("Exception in Thread 1"+e);
	    	}
	    }
	};
	Thread thread2 = new Thread() {
	    public void run() {
	    	try {
	    		DesiredCapabilities caps = new DesiredCapabilities();
	            caps.setCapability("automationName", "Appium");
	            caps.setCapability("platformName", "Android");
	            caps.setCapability("platformVersion", "8.1.0");
	            caps.setCapability("deviceName","Nokia 6");
	            caps.setCapability("browserName","chrome");
	            caps.setCapability("newCommandTimeout", 60*30);	
	            driver2 = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	            driver2.get("http://hva-wholesale-frontend-staging.s3-website.us-east-2.amazonaws.com/");
	    	}
	    	catch(Exception e) {
	    		System.err.println("Exception in Thread 2"+e);
	    	}
	    }
	};
	Thread thread3 = new Thread() {
	    public void run() {
	    	try {
	            driver3 = new ChromeDriver();
	            driver3.manage().window().maximize();
	            driver3.get("http://hva-wholesale-frontend-staging.s3-website.us-east-2.amazonaws.com/");
	    	}
	    	catch(Exception e) {
	    		System.err.println("Exception in Thread 3"+e);
	    	}
	    }
	};
	public static void main(String ar[]) throws IOException, InterruptedException{
		Demo ob = new Demo();
		ob.thread1.start();
		ob.thread2.start();
		ob.thread3.start();
		
		ob.thread1.join();
		ob.thread2.join();
		ob.thread3.join();
		System.out.println("END");
	}
	
}
