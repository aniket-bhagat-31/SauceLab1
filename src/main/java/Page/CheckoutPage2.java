package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class CheckoutPage2 extends TestBase{

	@FindBy(xpath="//span[text()='2']") private WebElement cartLogoCount;
	@FindBy(xpath="//span[text()='Checkout: Overview']") private WebElement checkoutLabel;
	@FindBy(xpath="//button[@id='cancel']") private WebElement cancelButton;
	@FindBy(xpath="//input[@id='continue']") private WebElement continueButton;
	@FindBy(xpath="//button[text()='Finish']") private WebElement finishButton;
	@FindBy(xpath="//button[@id='checkout']") private WebElement checkoutBtn;
	@FindBy(xpath="//div[text()='Payment Information:']") private WebElement paymentInfo;
	@FindBy(xpath="//div[text()='Shipping Information:']") private WebElement shippingInfo;
	@FindBy(xpath="//div[text()='Price Total']") private WebElement priceTotal;
	@FindBy(xpath="//input[@id='first-name']") private WebElement firstName;
	@FindBy(xpath="//input[@id='last-name']") private WebElement lastName;
	@FindBy(xpath="//input[@id='postal-code']") private WebElement postalCode;
	
	public CheckoutPage2()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyFinishPage()
	{
		cancelButton.click();
		cartLogoCount.click();
		checkoutBtn.click();
		firstName.sendKeys("avcd");
		lastName.sendKeys("sdcf");
		postalCode.sendKeys("12343");
		continueButton.click();
		finishButton.click();
		return driver.getCurrentUrl();
	}
	public boolean VerifyCheckoutLabel()
	{
		return checkoutLabel.isDisplayed();
	}
	public boolean verifyUserInfo()
	{
		if(priceTotal.isDisplayed()&&paymentInfo.isDisplayed()&&shippingInfo.isDisplayed())
		{
			return true;
		}
		return false;
	}
}
