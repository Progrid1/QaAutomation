package mertkanCompany.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import mertkanCompany.testComponents.BaseTest;
import pageobjects.CartPage;
import pageobjects.CheckoutPage;
import pageobjects.ConfirmationPage;
import pageobjects.OrderPage;
import pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest {

	@Test(dataProvider = "getData", groups = { "Purchase", "Regression" })
	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {
		String expectedConfirmationMessage = "THANKYOU FOR THE ORDER.";
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> prods = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("productName"));
		CartPage cartPage = productCatalogue.goToCartPage();
		boolean x = cartPage.verifyProductInCart(input.get("productName"));
		Assert.assertTrue(x);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.typeCountry(input.get("country"));
		checkoutPage.selectCountry();
		ConfirmationPage confirmationPage = checkoutPage.goToOrderSubmit();
		String actualConfirmationMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(expectedConfirmationMessage.equalsIgnoreCase(actualConfirmationMessage));

	}

	@Test(dependsOnMethods = "submitOrder")
	public void orderHistoryTest() {
		ProductCatalogue productCatalogue = landingPage.loginApplication("mertkanakiska94@gmail.com", "Mert949494");
		OrderPage orderPage = productCatalogue.goToOrderPage();
		// Assert.assertTrue(orderPage.verifyOrderDisplay(pro));
	}

	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "\\src\\test\\java\\data\\PurchaseOrder.json");

		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

//	HashMap<String, String> item= new HashMap<String, String>();
//	item.put("email", "mertkanakiska94@gmail.com");
//	item.put("password", "Mert949494");
//	item.put("productName", "ZARA COAT 3");
//	item.put("country", "Turkey");
//	
//	HashMap<String, String> item1= new HashMap<String, String>();
//	item1.put("email", "mertkanakiska94@gmail.com");
//	item1.put("password", "Mert949494");
//	item1.put("productName", "IPHONE 13 PRO");
//	item1.put("country", "Turkey");

}
