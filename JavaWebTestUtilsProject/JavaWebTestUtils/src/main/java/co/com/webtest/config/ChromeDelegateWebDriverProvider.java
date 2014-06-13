package co.com.webtest.config;

import org.jbehave.web.selenium.DelegatingWebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeDelegateWebDriverProvider extends
		DelegatingWebDriverProvider {

	private DesiredCapabilities capabilities = null;

	private ChromeDelegateWebDriverProvider(DesiredCapabilities capabilties) {
		this.capabilities = capabilties;
	}

	public static ChromeDelegateWebDriverProvider createDriverProvider(
			DesiredCapabilities capabilities) {
		return new ChromeDelegateWebDriverProvider(capabilities);
	}

	public void initialize() {
		DesiredCapabilities capabilities = this.capabilities;
		WebDriver driver = new ChromeDriver(capabilities);
		delegate.set(driver);
	}

}
