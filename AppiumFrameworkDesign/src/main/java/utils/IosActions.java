package utils;

import io.appium.java_client.ios.IOSDriver;

public class IosActions extends AppiumUtils {
	public IOSDriver driver;

	public IosActions(IOSDriver driver) {
		this.driver = driver;
	}
}
