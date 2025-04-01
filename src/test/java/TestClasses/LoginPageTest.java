package TestClasses;

import static org.testng.Assert.assertEquals;

import java.sql.Driver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Page.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage login;
	
	@BeforeMethod(alwaysRun=true)
	public void setup() throws Exception {
		initialization();
		login = new LoginPage();
	}

	@Test(enabled =true)
	public void verifyTitleTest() {
		String actRes = login.verifyTitle();
		String expRes = "Swag Labs";
		assertEquals(actRes, expRes);
	}
	@Test(enabled =true, invocationCount=3)
	public void verifyLoginPageURLTest() {
		String actRes = login.VerifyLoginPageURL();
		String expRes = "https://www.saucedemo.com/";
		assertEquals(actRes, expRes);
	}
	
	@Test(enabled=true)
	public void verifySwagLabLogoTest() {
		boolean actRes = login.verifySwagLabLogo();
		assertEquals(true, actRes);
	}
	@Test(dependsOnMethods="verifySwagLabLogoTest", enabled =true)
	public void verifyLoginTest() throws Exception {
		Thread.sleep(2000);
		String actRes =login.verifyLogin();
		String expRes = "https://www.saucedemo.com/inventory.html";
		assertEquals(actRes, expRes);
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeBrowser() {
		driver.close();
	}

}
