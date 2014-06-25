package co.com.webtest.config;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;



public abstract class ChromeConfig extends AbstractConfig{
	
	private String chromeDriverPath = "";

	@Override
	protected WebDriverProvider getWebDriver()
	{
		DesiredCapabilities capabilities = createDesiredCapabilites();
		ChromeDelegateWebDriverProvider driverProvider = ChromeDelegateWebDriverProvider.createDriverProvider(capabilities);
		return driverProvider;
	}
	
	private ChromeOptions createChromeOptions(){
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		return options;
	}
	
	@Override
	protected DesiredCapabilities createDesiredCapabilites() {
		
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setJavascriptEnabled(true);
		capabilities.setCapability("takesScreenshot", true);
		capabilities.setCapability(ChromeOptions.CAPABILITY,createChromeOptions());
		
		System.out.println("chromeDriverPath="+chromeDriverPath);
		if (chromeDriverPath  != "") {
			capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, 
				chromeDriverPath);		
		}
		return capabilities;
	}
	
}

