package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@class=\"cartWrap ng-star-inserted\"]")
	private List<WebElement> prodsInCart;
	@FindBy(xpath = "//*[contains(text(),\"Checkout\")]")
	private WebElement checkout;
	
	By prodsNameInCart= By.tagName("h3");

	// List<WebElement> productsInCart =
	// driver.findElements(By.xpath("//*[@class=\"cart\"] //h3"));

	public List<WebElement> getProductsInCart() {
		return prodsInCart;

	}
	
	public boolean verifyProductInCart(String product) {
		return prodsInCart.stream().anyMatch(s->s.findElement(prodsNameInCart).getText().equals(product));
		
	}
	
	public CheckoutPage goToCheckout() {
		checkout.click();
		return new CheckoutPage(driver);
		
	}
	
	

}
