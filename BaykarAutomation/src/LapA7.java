import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LapA7 {

	public static void main(String[] args) {
		Locators locators = new Locators();
		Compares compares = new Compares();

		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://kariyer.baykartech.com/tr/");
		driver.findElement(By.xpath(locators.trGirisButonu)).click();
		
		//Verifies
		System.out.println(driver.getCurrentUrl().equalsIgnoreCase(compares.TrGirisSayfasiUrl));
		System.out.println(driver.findElement(By.xpath(locators.trGirisSayfasiHeader)).getText()
				.equalsIgnoreCase(compares.trGirisSayfasiHeader));
		System.out.println(driver.findElement(By.xpath(locators.trGirisSayfasiEmailLabel)).getText()
				.equalsIgnoreCase(compares.trGirisSayfasiEmailLabel));
		System.out.println(driver.findElement(By.xpath(locators.trGirisSayfasiEmailTextbox)).isDisplayed());
		
		

	}

}
