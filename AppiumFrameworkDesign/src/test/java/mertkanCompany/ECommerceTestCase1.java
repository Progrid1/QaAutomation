package mertkanCompany;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import mertkanCompany.testUtils.AndroidBaseTest;

public class ECommerceTestCase1 extends AndroidBaseTest {

	@Test(groups = {"Smoke"})
	public void fillForm() {
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name"),
				"Please  your name");

	}
}