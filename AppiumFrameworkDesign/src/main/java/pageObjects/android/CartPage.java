package pageObjects.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidActions;

public class CartPage extends AndroidActions {
	AndroidDriver driver;

	public CartPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/productAddCart")
	private List<WebElement> addToCartButton;
	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cartButton;
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productsPrice;
	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement total;
	@AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
	private WebElement termsButton;
	@AndroidFindBy(id = "android:id/button1")
	private WebElement termsButtonClose;
	@AndroidFindBy(className = "android.widget.CheckBox")
	private WebElement sendMeEmailCheckBox;
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
	private WebElement proceedButton;

	public double getSumProductsPrices() {
		double sum = 0;
		for (int i = 0; i < productsPrice.size(); i++) {
			sum = sum + Double.parseDouble(productsPrice.get(i).getText().substring(1));
		}
		return sum;
	}

	public double displaySum() {
		return Double.parseDouble(total.getText().substring(1));
	}

	public void compare(double x, double y) {
		Assert.assertEquals(x, y);
	}

	public void longPressTermsButton() {
		longPressGesture(termsButton);
		termsButtonClose.click();
	}

	public void checkSendMeEmailCheckBox() {
		sendMeEmailCheckBox.click();
	}

	public void completePurchase() {
		proceedButton.click();
	}

}
