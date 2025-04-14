package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Utility.Utility;

public class TestBase {
	
	public static void job() {
		System.out.println("1Work from home");
	}
	public static void job(String loc) {
		System.out.println("1Work from home" +" or " + loc);
	}
	public static void job(int salary) {
		System.out.println("1expecting arround" +" = " + salary +" LPA");
	}
	public static void job(double time) {
		System.out.println("1number of days" +" = " + time + " days");
	}
	public static void job(char ch) {
		System.out.println("1characters" +" = " + ch);
	}
	public static void main(String[] args) {
//		job();
//		job("Pune");
//		job(21);
//		job(3.5);
//		job('A');
	}

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
