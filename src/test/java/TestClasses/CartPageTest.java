package TestClasses;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Page.CartPage;
import Page.InventoryPage;
import Page.LoginPage;
import dev.failsafe.internal.util.Assert;

public class CartPageTest extends TestBase {
	
	LoginPage login;
	InventoryPage inventory;
	CartPage cart;
	@BeforeMethod
	public void setup() throws Exception
	{
		initialization();
		login = new LoginPage();
		inventory = new InventoryPage();
		cart = new CartPage();
		login.verifyLogin();
		inventory.verifyCartFunctionality();
		driver.switchTo().alert().accept();
	}
	@Test
	public void verifyCartCountTest()
	{
		String actRes = cart.verifyCartCount();
		String expRes = "2";
		assertEquals(actRes, expRes);
	}
	@Test
	public void verifyAppLogoTest()
	{
		boolean actRes = cart.verifyAppLogo();
		assertEquals(actRes, true);
	}
	@Test
	public void verifyCartAfterProductRemovalTest() throws Exception
	{
		String actRes = cart.verifyCartAfterProductRemoval();
		String expRes = "0";
		assertEquals(actRes, expRes);
	}
	@Test
	public void verifyContinueBtnTest() 
	{
		String actRes = cart.verifyContinueBtn();
		String expRes = "2";
		assertEquals(actRes, expRes);
	}
	@Test 
	public void verifyCheckoutPage1Test() throws Exception
	{
		String actRes = cart.verifyCheckoutPage1();
		String expRes = "https://www.saucedemo.com/v1/checkout-step-one.html";
		assertEquals(actRes, expRes);
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}

}
