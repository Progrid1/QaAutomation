package mertkanCompany;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import mertkanCompany.testUtils.AndroidBaseTest;
import pageObjects.android.CartPage;
import pageObjects.android.ProductCatalogue;

public class ECommerceTestCase4 extends AndroidBaseTest {

	@BeforeMethod(alwaysRun = true)
	public void preSetupGeneralStore() {
		fp.preSetupGeneralStore();

	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") +"//src//main//java//testData//eCommerce.json");
		return new Object[][] { {data.get(0)}, {data.get(1)} };
	}

	@Test(dataProvider = "getData", groups = {"Regression"})
	public void fillForm(HashMap<String, String> input) throws InterruptedException {

		ProductCatalogue pc;
		CartPage cp;

		fp.setNameField(input.get("name"));
		fp.setGender(input.get("gender"));
		fp.setCountry(input.get("country"));
		pc = fp.submitForm();
		pc.addToCartByIndex(0);
		pc.addToCartByIndex(1);
		cp = pc.goToCartPage();
		double productsSum = cp.getSumProductsPrices();
		double total = cp.displaySum();
		cp.compare(productsSum, total);
		cp.longPressTermsButton();
		cp.checkSendMeEmailCheckBox();
		cp.completePurchase();

	}

	@Test(enabled = false)
	public void fillForm2() throws InterruptedException {

		ProductCatalogue pc;
		CartPage cp;

		fp.setNameField("Rümeysa");
		fp.setGender("female");
		fp.setCountry("Argentina");
		pc = fp.submitForm();
		pc.addToCartByIndex(0);
		pc.addToCartByIndex(1);
		cp = pc.goToCartPage();
		double productsSum = cp.getSumProductsPrices();
		double total = cp.displaySum();
		cp.compare(productsSum, total);
		cp.longPressTermsButton();
		cp.checkSendMeEmailCheckBox();
		cp.completePurchase();

	}
}