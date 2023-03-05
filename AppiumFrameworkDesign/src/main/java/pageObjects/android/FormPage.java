package pageObjects.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidActions;

public class FormPage extends AndroidActions {
	AndroidDriver driver;

	public FormPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
	private WebElement femaleOption;
	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
	private WebElement maleOption;
	@AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
	private WebElement countrySelection;
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement letsShopButton;

	public void setNameField(String name) {
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}

	public void setGender(String gender) {
		if (gender.equalsIgnoreCase("male")) {
			maleOption.click();
		} else {
			femaleOption.click();
		}
	}

	public void setCountry(String country) {
		countrySelection.click();
		scrollIntoElement(country);
		driver.findElement(By.xpath("//*[@text='" + country + "']")).click();
	}

	public ProductCatalogue submitForm() {
		letsShopButton.click();
		return new ProductCatalogue(driver);

	}

	public void preSetupGeneralStore() {
		Activity activity = new Activity("com.androidsample.generalstore",
				"com.androidsample.generalstore.MainActivity");
		driver.startActivity(activity);
	}

}
