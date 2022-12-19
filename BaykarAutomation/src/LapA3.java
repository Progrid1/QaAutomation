import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LapA3 {

	public static void main(String[] args) {
		Locators locators = new Locators();
		Compares compares = new Compares();

		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://kariyer.baykartech.com/tr/");
		driver.findElement(By.xpath(locators.baykarKariyerLogo)).click();
		
		//Verify
		System.out.println(driver.getCurrentUrl().equalsIgnoreCase(compares.baykarTrUrl));
		

	}

}
