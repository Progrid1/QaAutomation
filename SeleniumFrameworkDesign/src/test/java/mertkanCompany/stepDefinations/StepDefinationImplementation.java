package mertkanCompany.stepDefinations;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mertkanCompany.testComponents.BaseTest;
import pageobjects.CartPage;
import pageobjects.CheckoutPage;
import pageobjects.ConfirmationPage;
import pageobjects.LandingPage;
import pageobjects.ProductCatalogue;

public class StepDefinationImplementation extends BaseTest {
	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public CartPage cartPage;
	public ConfirmationPage confirmationPage;

	@Given("I landed on Ecommerce page")
	public void iLandedOnEcommercePage() throws IOException {
		landingPage = launchApplication();
	}

	@Given("^Logged in with username (.*) and password (.*)$")
	public void loggedInWıthUsernameAndPassword(String username, String password) {
		productCatalogue = landingPage.loginApplication(username, password);

	}

	@When("^I add product (.+) to cart$")
	public void iAddProductToCart(String productName) throws InterruptedException {
		List<WebElement> prods = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
	}

	@When("^Checkout (.+) and submit the order$")
	public void checkoutAndSubmitTheOrder(String productName) {
		cartPage = productCatalogue.goToCartPage();
		boolean x = cartPage.verifyProductInCart(productName);
		Assert.assertTrue(x);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.typeCountry("Turkey");
		checkoutPage.selectCountry();
		confirmationPage = checkoutPage.goToOrderSubmit();
	}

	@Then("{string} message is displayed on ConfirmationPage")
	public void messageIsDısplayedOnConfirmationPage(String string) {
		String actualConfirmationMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(actualConfirmationMessage.equalsIgnoreCase(string));
		driver.quit();
	}
	
	@Then ("{string} message is displayed")
	public void errorMessageIsDısplayed(String string) {
		Assert.assertEquals(landingPage.getErrorMessage(), string);
		driver.quit();
	}
}
