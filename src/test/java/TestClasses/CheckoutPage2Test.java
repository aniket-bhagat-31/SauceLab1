package TestClasses;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.testng.annotations.Parameters;

import Base.TestBase;
import Page.CartPage;
import Page.CheckoutPage1;
import Page.CheckoutPage2;
import Page.InventoryPage;
import Page.LoginPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Utility.Utility;

public class CheckoutPage2Test extends TestBase {

	LoginPage login;
	InventoryPage inventory;
	CartPage cart;
	CheckoutPage1 checkout1;
    CheckoutPage2 checkout2;
	@BeforeMethod
	
	public void setup() throws Exception {
		initialization();
		login = new LoginPage();
		inventory = new InventoryPage();
		cart = new CartPage();
		checkout1 = new CheckoutPage1();
		checkout2 = new CheckoutPage2();
		login.verifyLogin();
		inventory.verifySort();
		inventory.verifyCartFunctionality();
		cart.verifyCheckoutPage1();
		checkout1.verifyCustomerInfo();
		
	}

	@Test(enabled = true)
	public void verifyFinishPageTest() throws Exception {
		String actRes = checkout2.verifyFinishPage();
		String expRes = "https://www.saucedemo.com/checkout-complete.html";
		assertEquals(actRes, expRes);

	}
	@Test(enabled = true)
	public void VerifyCheckoutLabelTest() throws Exception {
		boolean actRes = checkout2.VerifyCheckoutLabel();
		assertEquals(actRes, true);

	}
	@Test(enabled = true)
	public void verifyCustomerInfoTest() throws Exception {
		boolean actRes = checkout2.verifyUserInfo();
		assertEquals(actRes, true);

	}
	

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
