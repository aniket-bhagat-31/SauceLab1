package TestClasses;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.expectThrows;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Base.TestBase;
import Page.CartPage;
import Page.CheckoutPage1;
import Page.InventoryPage;
import Page.LoginPage;

public class CheckoutPage1Test extends TestBase{
	
	LoginPage login;
	InventoryPage inventory;
	CartPage cart;
	CheckoutPage1 checkout1;
	
	@BeforeMethod
	public void setup() throws Exception
	{
		initialization();
		login = new LoginPage();
		inventory= new InventoryPage();
		cart = new CartPage();
		checkout1= new CheckoutPage1();
        login.verifyLogin();
        inventory.verifySort();
        inventory.verifyCartFunctionality();
        cart.verifyCheckoutPage1();
	}
	
	@Test(enabled =true)
	public void verifyYourInfoLogoTest()
	{
		boolean actRes = checkout1.verifyYourInfoLogo();
		assertEquals(actRes, true);
	}
	@Test(enabled =true)
	public void verifyCartLogoCountTest()
	{
		boolean actRes = checkout1.verifyCartLogoCount();
		assertEquals(actRes, true);
	}
	@Test(enabled =true)
	public void verifyCancelButtonTest() throws Exception
	{
		String actRes = checkout1.verifyCancelButton();
		String expRes = "2";
		assertEquals(actRes, expRes);
	}
	@Test(enabled =true)
	public void verifyCustomerInfoTest() throws Exception
	{
		String actRes = checkout1.verifyCustomerInfo();
		String expRes = "https://www.saucedemo.com/checkout-step-two.html";
		assertEquals(actRes, expRes);
		
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}

}
