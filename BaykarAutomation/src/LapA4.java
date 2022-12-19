
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LapA4 {

	public static void main(String[] args) {
		Locators locators = new Locators();
		Compares compares = new Compares();

		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://kariyer.baykartech.com/tr/");
		driver.findElement(By.xpath(locators.kariyerDropdown)).click();
		//Verify
		System.out.println(driver.findElement(By.xpath(locators.kariyerDropdownIstatistik)).getText()
				.equals(compares.kariyerDropdownIstatistik));
		System.out.println(driver.findElement(By.xpath(locators.kariyerDropdownYerleskelerimiz)).getText()
				.equals(compares.kariyerDropdownYerleskelerimiz));
		System.out.println(driver.findElement(By.xpath(locators.kariyerDropdownSundugumuzFaydalar)).getText()
				.equals(compares.kariyerDropdownSundugumuzFaydalar));
		System.out.println(driver.findElement(By.xpath(locators.kariyerDropdownSosyalAlanlar)).getText()
				.equals(compares.kariyerDropdownSosyalAlanlar));
		
	}

}
