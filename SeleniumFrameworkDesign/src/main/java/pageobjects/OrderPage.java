package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {
	WebDriver driver;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@class=\"cartWrap ng-star-inserted\"]")
	private List<WebElement> prodsInCart;
	@FindBy(xpath = "//*[contains(text(),\"Checkout\")]")
	private WebElement checkout;
	@FindBy(xpath = "//table //*[@class='ng-star-inserted']/td[2]")
	private List<WebElement> prodsNameInOrders;
	
	
	By prodsNameInCart= By.tagName("h3");

	// List<WebElement> productsInCart =
	// driver.findElements(By.xpath("//*[@class=\"cart\"] //h3"));

	public List<WebElement> getProductsInCart() {
		return prodsInCart;

	}
	
	public boolean verifyOrderDisplay(String product) {
		return prodsNameInOrders.stream().anyMatch(s->s.getText().equalsIgnoreCase(product));
		
	}
	
	

}
