package mertkanCompany.testUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import pageObjects.android.FormPage;
import utils.AppiumUtils;

public class AndroidBaseTest extends AppiumUtils {

	public AndroidDriver driver;
	public FormPage fp;

	@BeforeClass(alwaysRun = true)
	public void configureAppium() throws IOException {
		Properties prop = new Properties();
		FileInputStream inputStream = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		prop.load(inputStream);
		
		String ipAdress=System.getProperty("ipAdress")!=null ? System.getProperty("ipAdress") : prop.getProperty("ipAdress");
		
		//String ipAdress = prop.getProperty("ipAdress");
		String port = prop.getProperty("port");
		String browser = prop.getProperty("browser");
		String androidDeviceName = prop.getProperty("androidDeviceName");
		
		service = startAppiumServer(ipAdress, Integer.parseInt(port));

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(androidDeviceName); // Emulator
		// options.setDeviceName("Android Device"); //Real Device
		options.setChromedriverExecutable("C:\\asd\\chromedriver103\\chromedriver.exe");
		options.setApp(System.getProperty("user.dir") + "\\src\\test\\java\\resources\\General-Store.apk");

		driver = new AndroidDriver(service.getUrl(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		fp = new FormPage(driver);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
		service.stop();
	}
}
