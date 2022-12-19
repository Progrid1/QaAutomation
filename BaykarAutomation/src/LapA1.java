import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LapA1 {

	public static void main(String[] args) {

		Locators locators = new Locators();
		Compares compares = new Compares();

		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://kariyer.baykartech.com/en/");
		driver.findElement(By.xpath(locators.trButon)).click();

		//Verify
		System.out.println(driver.findElement(By.xpath(locators.trGirisButonu)).getText().equalsIgnoreCase(compares.trGiris));
		//Verify
		System.out.println(driver.findElement(By.xpath(locators.enButon)).getText().equals(compares.enButon));

	}

}
