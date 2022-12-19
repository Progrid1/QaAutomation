import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LopA3 {

	public static void main(String[] args) throws InterruptedException {
		Locators locators = new Locators();
		Compares compares = new Compares();
		Posts posts=new Posts();

		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://kariyer.baykartech.com/tr/accounts/login/?next=/tr/dashboard/");
		driver.findElement(By.xpath(locators.trGirisSayfasiEmailTextbox)).sendKeys(posts.trGirisSayfasiEmailTextbox);
		driver.findElement(By.xpath(locators.trGirisSayfasiPasswordTextbox)).sendKeys(posts.trGirisSayfasiPasswordTextbox);
		driver.findElement(By.xpath(locators.trGirisSayfasiReCaptcha)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(locators.trGirisSayfasiGirisButonu)).click();
		
		//Verify
		System.out.println(driver.findElement(By.xpath(locators.trGirisSayfasiHataMesaji)).getText()
				.equalsIgnoreCase(compares.trGirisSayfasiHataMesaji));
	}

}
