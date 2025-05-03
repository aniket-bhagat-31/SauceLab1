package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class CheckoutPage1 extends TestBase{

	@FindBy(xpath="//span[text()='Checkout: Your Information']") private WebElement yourInfoLogo;
	@FindBy(xpath="//span[text()='2']") private WebElement cartLogoCount;
	@FindBy(xpath="//button[text()='Cancel']") private WebElement cancelButton;
	@FindBy(xpath="//input[@id='continue']") private WebElement continueButton;
	@FindBy(xpath="//input[@id='first-name']") private WebElement firstName;
	@FindBy(xpath="//input[@id='last-name']") private WebElement lastName;
	@FindBy(xpath="//button[@id='checkout']")  WebElement checkoutBtn;
	@FindBy(xpath="//input[@id='postal-code']") private WebElement postalCode;
	
	public CheckoutPage1()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyYourInfoLogo()
	{
		return yourInfoLogo.isDisplayed();
	}
	public boolean verifyCartLogoCount()
	{
		return cartLogoCount.isDisplayed();
	}
	public String verifyCancelButton() throws Exception
	{
		Thread.sleep(2000);
		cancelButton.click();Thread.sleep(2000);
		checkoutBtn.click();Thread.sleep(5000);
		return cartLogoCount.getText();
	}
	
	public String verifyCustomerInfo() throws Exception
	{
		firstName.sendKeys("abcd");Thread.sleep(2000);
		lastName.sendKeys("asdf");Thread.sleep(2000);
		postalCode.sendKeys("123456");
		Thread.sleep(2000);
		continueButton.click();
		return driver.getCurrentUrl();
		
		
	}
	
	
}
