package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class CartPage extends TestBase {
	
	@FindBy(xpath="//span[text()='2']")  WebElement cartCount;
	@FindBy(xpath="//div[@class='app_logo']")  WebElement appLogo;
	@FindBy(xpath="//button[text()='REMOVE']")  WebElement removeBtn;
	@FindBy(xpath="//a[text()='Continue Shopping']")  WebElement continueShopping;
	@FindBy(xpath="//a[text()='CHECKOUT']")  WebElement checkoutBtn;
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
	public String verifyCartAfterProductRemoval() throws Exception 
	{
		removeBtn.click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		removeBtn.click();
		return cartCount.getText();
	}
	public String verifyContinueBtn() 
	{
//		Thread.sleep(2000);
		continueShopping.click();
		sauceLabBikeLight.click();
		sauceLabOneSide.click();
		cartBtn.click();
		return cartCount.getText();
	}
	
	public String verifyCheckoutPage1() throws Exception
	{
		Thread.sleep(2000);
		checkoutBtn.click();
		return driver.getCurrentUrl();
	}

}
