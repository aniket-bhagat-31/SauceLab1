package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Utility.Utility;

public class TestBase {
	
	public static WebDriver driver;
	
	public void initialization() throws Exception {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
	    driver = new ChromeDriver(options);
		driver.manage().window().maximize();
//		driver.get(Utility.readPropertyFile("url"));
		driver.get("https://www.saucedemo.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	
}
