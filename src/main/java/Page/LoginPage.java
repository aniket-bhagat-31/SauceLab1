package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Utility.Utility;

public class LoginPage extends TestBase {
	
	@FindBy(xpath="//div[text()='Swag Labs']") private WebElement SwagLabLogo;
	@FindBy(xpath="//input[@id='user-name']") private WebElement username;
	@FindBy(xpath="//input[@id='password']") private WebElement password;
	@FindBy(xpath="//input[@id='login-button']") private WebElement loginBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitle() {
		return driver.getTitle();
	}
	public String VerifyLoginPageURL() {
		return driver.getCurrentUrl();
	}
	public boolean verifySwagLabLogo() {
		return SwagLabLogo.isDisplayed();
	}
	public String verifyLogin() throws Exception {
//		username.sendKeys(ReadData.readPropertyFile("username"));
		username.sendKeys(Utility.readExcelData(0, 0));
		Thread.sleep(2000);
//		password.sendKeys(ReadData.readPropertyFile("password"));
		password.sendKeys(Utility.readExcelData(0, 1));
		Thread.sleep(2000);
		loginBtn.click();
		return driver.getCurrentUrl();
	}
	
}
