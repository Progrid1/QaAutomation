package mertkanCompany.tests;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.LandingPage;

public class StandAloneTest {

	public static void main(String[] args) {
		String pro = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver.manage().window().maximize();
		LandingPage page= new LandingPage(driver);
		driver.get("https://rahulshettyacademy.com/client");

		driver.findElement(By.id("userEmail")).sendKeys("mertkanakiska94@gmail.com");
		
		driver.findElement(By.id("userPassword")).sendKeys("Mert949494");
		driver.findElement(By.id("login")).click();

		List<WebElement> products = driver.findElements(
				By.xpath("//*[@class=\"col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted\"]"));

		WebElement prod = products.stream().filter(s -> s.findElement(By.tagName("b")).getText().equals(pro))
				.findFirst().orElse(null);

		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		// prod.findElement(By.xpath("//*[@class=\"col-lg-4 col-md-6 col-sm-10
		// offset-md-0 offset-sm-1 mb-3 ng-star-inserted\"] //button[2]")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));

		driver.findElement(By.xpath("/html/body/app-root/app-dashboard/app-sidebar/nav/ul/li[4]/button")).click();

		List<WebElement> productsInCart = driver.findElements(By.xpath("//*[@class=\"cart\"] //h3"));

		Assert.assertTrue(productsInCart.stream().anyMatch(s -> s.getText().equals(pro)));

		driver.findElement(By.xpath("//*[contains(text(),\"Checkout\")]")).click();
		/*
		 * driver.findElement(By.xpath("//*[@placeholder=\"Select Country\"]")).sendKeys
		 * ("tur"); List<WebElement> dd= driver.findElements(By.
		 * xpath("//*[@class=\"ta-item list-group-item ng-star-inserted\"] //span"));
		 * WebElement
		 * turkey=dd.stream().filter(s->s.getText().equals("Turkey")).findFirst().orElse
		 * (null); turkey.click();
		 */

		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//*[@placeholder=\"Select Country\"]")), "turkey").build().perform();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@class=\"ta-results list-group ng-star-inserted\"]")));
		a.click(driver.findElement(By.xpath("//*[@class=\"ta-item list-group-item ng-star-inserted\"][1]"))).build()
				.perform();
		driver.findElement(By.xpath("//*[contains(@class,'action__submit')]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@class,'hero-primary')]")).getText()
				.equals("THANKYOU FOR THE ORDER."));
	}

}
