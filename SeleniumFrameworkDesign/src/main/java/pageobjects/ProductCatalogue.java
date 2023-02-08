package pageobjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{
	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	private By productsBy= By.xpath("//*[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']");
	private By textBy= By.tagName("b");
	private By addToCart = By.cssSelector(".card-body button:last-of-type");
	private By toastMessage=By.id("toast-container");
	private By animating= By.cssSelector(".ng-animating");
		
		@FindBy(xpath = "//*[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']")
		private List<WebElement> products;
		
		
		
		public List<WebElement> getProductList() {
			waitForElementToAppear(productsBy);
			return products;
		}
		
		public WebElement getProduct(String productName) {
			
			WebElement pros= getProductList().stream().filter(s -> s.findElement(textBy).getText().equals(productName))
					.findFirst().orElse(null);
			 return pros;
			
		}
		
		public void addProductToCart(String productName) throws InterruptedException {
			WebElement prod = getProduct(productName);
			prod.findElement(addToCart).click();
			waitForElementToAppear(toastMessage);
			waitForElementToDisappear(animating);
		}
		
		
		
		
		
		
		
}