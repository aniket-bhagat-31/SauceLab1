package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class FinishPage extends TestBase {
	
	@FindBy(xpath="//span[text()='Checkout: Complete!']") private WebElement checkoutCompleteLabel;
	@FindBy(xpath="//h2[text()='Thank you for your order!']") private WebElement thankuLabel;
	@FindBy(xpath="//button[text()='Back Home']") private WebElement backHomeButton;
	@FindBy(xpath="//a[@data-test='shopping-cart-link']") private WebElement cartButton;
	@FindBy(xpath="//div[text()='Swag Labs']") private WebElement swagLab;
	
	
	public FinishPage()
	{
		PageFactory.initElements(driver, this);
	}
	public boolean verifyCheckoutCompleteLabel()
	{
		if(checkoutCompleteLabel.isDisplayed()&&thankuLabel.isDisplayed()&&backHomeButton.isDisplayed()&&cartButton.isDisplayed()&&swagLab.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
}
