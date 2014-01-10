package co.com.sura.webTest;

import org.jbehave.web.selenium.DelegatingWebDriverProvider;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PhantomJSDelegateWebDriverProvider extends DelegatingWebDriverProvider {
	
	private String phantomJSDriverPath;
	
	private PhantomJSDelegateWebDriverProvider(String phantomJSDriverPath) 
	{
		this.phantomJSDriverPath = phantomJSDriverPath;
	}
	
	public static PhantomJSDelegateWebDriverProvider getDriver(String phantomJSDriverPath){
		return new PhantomJSDelegateWebDriverProvider(phantomJSDriverPath);
		
	}

	public void initialize() {
		DesiredCapabilities capabilities = DesiredCapabilities
				.internetExplorer();
		capabilities.setJavascriptEnabled(true);
		capabilities.setCapability("takesScreenshot", true);
		capabilities.setCapability(
						PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
						phantomJSDriverPath);						

		PhantomJSDriver driver = new PhantomJSDriver(capabilities); 
		//Por custiones del PhantomJS se debe auentar el tamaño de la ventana para que los 
		//elementos sean visibles. Sin esto, fallan algunas aplicaciones
		aumentarTamanoDeVentanaEnPhantonJS(driver);
		System.out.println("cargo el driver=" + driver);
		delegate.set(driver);
		
	}
	
	private void aumentarTamanoDeVentanaEnPhantonJS(PhantomJSDriver driver) {
		driver.manage().window().setSize( new Dimension(1024, 768));
	}

}
