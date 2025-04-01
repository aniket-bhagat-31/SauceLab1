package TestClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.TestBase;
import Page.InventoryPage;
import Page.LoginPage;
import Utility.Utility;

public class InventoryPageTest extends TestBase{

	LoginPage login;
	InventoryPage inventory;
	
	@BeforeMethod(alwaysRun = true)
	public void setup() throws Exception {
		initialization();
		login = new LoginPage();
		inventory = new InventoryPage();
		login.verifyLogin();
	}
	@Test
	public void verifySortTest() {
		String actRes =inventory.verifySort();
		String expRes = "2";
		Assert.assertEquals(actRes, expRes);
		Reporter.log("actual count: " + actRes);
	}
	
	@Test(groups="sanity")
	public void verifyProductsLogoTest() {
		System.out.println("Execution started");
		SoftAssert soft = new SoftAssert();
		boolean actRes = inventory.verifyProductsLogo();
		soft.assertEquals(false, actRes);
		System.out.println("Execution ended");
		System.out.println(10/0);
		System.out.println(null+"add");
//		soft.assertAll();
		
		
	}
	@Test(enabled=false, groups="sanity")
	public void verifyMenuButtonTest() {
		boolean actRes = inventory.verifyMenuButton();
		Assert.assertEquals(true, actRes);
	}
	@Test
	public void verifyCartFunctionalityTest() {
		String actRes = inventory.verifyCartFunctionality();
		String expRes = "https://www.saucedemo.com/cart.html1";
		Assert.assertEquals(actRes, expRes);
		Reporter.log("actual String: " + actRes);

	}
	
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult result) throws Exception {
		if(ITestResult.FAILURE==result.getStatus())
		Utility.captureScreenshot(result.getName());
		driver.close();
	}
}
