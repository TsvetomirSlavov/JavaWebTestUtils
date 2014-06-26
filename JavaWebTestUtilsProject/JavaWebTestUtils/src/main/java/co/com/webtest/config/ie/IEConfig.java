package co.com.webtest.config.ie;


import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import co.com.webtest.config.AbstractConfig;

import com.google.common.util.concurrent.MoreExecutors;

public abstract class IEConfig extends AbstractConfig{
	
	private String iEDriverPath = "";

	
	public IEConfig() {		
		configuredEmbedder().useExecutorService(MoreExecutors.sameThreadExecutor());
	}
	
	@Override
	protected WebDriverProvider getWebDriver()
	{
		DesiredCapabilities capabilities = createDesiredCapabilites();
		IEDelegateWebDriverProvider driverProvider = IEDelegateWebDriverProvider.createDriverProvider(capabilities);
		return driverProvider;
	}
	
	@Override
	protected DesiredCapabilities createDesiredCapabilites() {
		DesiredCapabilities capabilities = DesiredCapabilities
				.internetExplorer();
		capabilities.setJavascriptEnabled(true);
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capabilities.setCapability("takesScreenshot", true);
		
		if (iEDriverPath  != "") {
			capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, 
				iEDriverPath);		
		}
		return capabilities;
		
		
	}

	

	
	
}
