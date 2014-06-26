package co.com.webtest.config.ie;

import org.jbehave.web.selenium.DelegatingWebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IEDelegateWebDriverProvider extends DelegatingWebDriverProvider {
	
	
	
	private DesiredCapabilities capabilities = null;
	
	private IEDelegateWebDriverProvider(DesiredCapabilities capabilties) 
	{
		this.capabilities = capabilties;
	}
	
	public static IEDelegateWebDriverProvider createDriverProvider(DesiredCapabilities capabilties){
		return new IEDelegateWebDriverProvider(capabilties);		
	}

	





	public void initialize() {
		DesiredCapabilities capabilities = this.capabilities;				

		WebDriver driver = new InternetExplorerDriver(capabilities);
		
		delegate.set(driver);
		
	}

	
	

}
