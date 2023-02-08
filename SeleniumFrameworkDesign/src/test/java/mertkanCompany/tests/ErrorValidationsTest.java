package mertkanCompany.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import mertkanCompany.testComponents.BaseTest;
import pageobjects.CartPage;
import pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest {
	@Test(groups = {"ErrorHandling"}, retryAnalyzer =  mertkanCompany.testComponents.Retry.class  )
	public void loginErrorValidation() throws IOException, InterruptedException {
		landingPage.loginApplication("mertkanakiska94@gmail.com", "wrong");
		Assert.assertEquals(landingPage.getErrorMessage(), "Incorrect email or password.");
	}
	
	@Test
	public void productErrorValidation() throws IOException, InterruptedException {
		String pro = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("mertkanakiska94@gmail.com", "Mert949494");
		List<WebElement> prods = productCatalogue.getProductList();
		productCatalogue.addProductToCart(pro);
		CartPage cartPage = productCatalogue.goToCartPage();
		Assert.assertFalse(cartPage.verifyProductInCart("wrong"));

	}
	
	

}
