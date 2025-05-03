package TestClasses;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Page.CartPage;
import Page.CheckoutPage1;
import Page.CheckoutPage2;
import Page.InventoryPage;
import Page.LoginPage;
import Page.FinishPage;

public class FinishPageTest extends TestBase{
	
	LoginPage login;
	InventoryPage inventory;
	CartPage cart;
	CheckoutPage1 checkout1;
    CheckoutPage2 checkout2;
    FinishPage finish;
	
	@BeforeMethod
	public void setup() throws Exception
	{
		initialization();
		login = new LoginPage();
		inventory = new InventoryPage();
		cart = new CartPage();
		checkout1 = new CheckoutPage1();
		checkout2 = new CheckoutPage2();
		finish = new FinishPage();
		login.verifyLogin();
		inventory.verifySort();
		inventory.verifyCartFunctionality();
		cart.verifyCheckoutPage1();
		checkout1.verifyCustomerInfo();
		
	}
	
	@Test
	public void verifyCheckoutCompleteLabelTest()
	{
		boolean actRes = finish.verifyCheckoutCompleteLabel();
		assertEquals(actRes, true);
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
	
	
}
