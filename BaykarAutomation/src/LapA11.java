import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LapA11 {

	public static void main(String[] args) throws Exception {
		Locators locators = new Locators();
		Compares compares = new Compares();
		Posts posts=new Posts();

		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://kariyer.baykartech.com/tr/");
		driver.findElement(By.xpath(locators.trAnaSayfaIletisimAdSoyadTextbox)).sendKeys(posts.trAnaSayfaIletisimAdSoyadTextbox);
		if (!driver.findElement(By.xpath(locators.trAnaSayfaIletisimAdSoyadTextbox)).getTagName().equals(compares.trAnaSayfaIletisimAdSoyadTextbox)) {
			throw new Exception("class ismi input degildir.");
		}
		

	}

}
