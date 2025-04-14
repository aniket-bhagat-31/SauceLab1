package Page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class CartPage extends TestBase {
	
	@FindBy(xpath="//span[text()='2']")  WebElement cartCount;
	@FindBy(xpath="//div[@class='app_logo']")  WebElement appLogo;
	@FindBy(xpath="//button[text()='Remove']")  WebElement removeBtn;
	@FindBy(xpath="//button[@id='continue-shopping']")  WebElement continueShopping;
	@FindBy(xpath="//button[@id='checkout']")  WebElement checkoutBtn;
	@FindBy(id="add-to-cart-sauce-labs-onesie")  WebElement sauceLabOneSide;
	@FindBy(id="add-to-cart-sauce-labs-bike-light")  WebElement sauceLabBikeLight;
	@FindBy(xpath="//a[@data-test='shopping-cart-link']")  WebElement cartBtn;

	public CartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyCartCount()
	{
		return cartCount.getText();
	}
	public boolean verifyAppLogo()
	{
		return appLogo.isDisplayed();
	}
	
	public String verifyContinueBtn() throws Exception 
	{
		Thread.sleep(1000);
		removeBtn.click();
		Thread.sleep(1000);
		driver.navigate().refresh();
		removeBtn.click();
		Thread.sleep(1000);
		continueShopping.click();
		Thread.sleep(1000);
		sauceLabBikeLight.click();
		Thread.sleep(1000);
		sauceLabOneSide.click();
		Thread.sleep(1000);
		cartBtn.click();
		return cartCount.getText();
	}
	
	public String verifyCheckoutPage1() throws Exception
	{
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	     js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(2000);
		checkoutBtn.click();
		return driver.getCurrentUrl();
	}

}
