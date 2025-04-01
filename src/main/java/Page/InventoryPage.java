package Page;

import java.awt.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.TestBase;
import Utility.Utility;

public class InventoryPage extends TestBase {

	@FindBy(id="add-to-cart-sauce-labs-onesie") private WebElement sauceLabOneSide;
	@FindBy(id="add-to-cart-sauce-labs-bike-light") private WebElement sauceLabBikeLight;
	@FindBy(xpath="//span[text()='Products']") private WebElement productsLogo;
	@FindBy(xpath="//a[@data-test='shopping-cart-link']") private WebElement cartBtn;
	@FindBy(xpath="//button[text()='Open Menu']") private WebElement menu;
	@FindBy(xpath="//nav[@class='bm-item-list']//a") private WebElement links;
	@FindBy(xpath="//select[@data-test='product-sort-container']") private WebElement sort;
	@FindBy(xpath="//span[@data-test='shopping-cart-badge']") private WebElement cartCount;
	public InventoryPage() {
		PageFactory.initElements(driver, this);
	}
	public String verifySort() {
		Utility.selectClass(sort, "Price (high to low)");
//		Select s = new Select(sort);
//		s.selectByVisibleText("Price (high to low)");
		sauceLabOneSide.click();
		sauceLabBikeLight.click();
		return cartCount.getText();
	}
	
	public boolean verifyProductsLogo() {
		return productsLogo.isDisplayed();
	}
	
	public boolean verifyMenuButton() {
		menu.click();
		return links.isDisplayed();
	}
	public String verifyCartFunctionality() {
		 cartBtn.click();
		return  driver.getCurrentUrl();
	}
}
