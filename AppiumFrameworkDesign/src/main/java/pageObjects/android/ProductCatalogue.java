package pageObjects.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidActions;

public class ProductCatalogue extends AndroidActions {
	AndroidDriver driver;

	public ProductCatalogue(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/productAddCart")
	private List<WebElement> addToCartButton;
	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cartButton;
	@AndroidFindBy(xpath = "//*[@text='Cart']")
	private WebElement cartPageLabel;

	public void addToCartByIndex(int index) {
		addToCartButton.get(index).click();
	}

	public CartPage goToCartPage() {
		cartButton.click();
		waitUntilElementVisible(cartPageLabel, driver);
		return new CartPage(driver);
	}

}
