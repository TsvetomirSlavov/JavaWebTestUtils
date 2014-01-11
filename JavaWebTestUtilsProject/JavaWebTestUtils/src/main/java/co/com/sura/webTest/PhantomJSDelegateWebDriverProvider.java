package co.com.sura.webTest;

import org.jbehave.web.selenium.DelegatingWebDriverProvider;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PhantomJSDelegateWebDriverProvider extends DelegatingWebDriverProvider {
	
	
	
	private DesiredCapabilities capabilities = null;
	
	private PhantomJSDelegateWebDriverProvider(DesiredCapabilities capabilties) 
	{
		this.capabilities = capabilties;
	}
	
	public static PhantomJSDelegateWebDriverProvider createDriverProvider(DesiredCapabilities capabilties){
		return new PhantomJSDelegateWebDriverProvider(capabilties);		
	}

	





	public void initialize() {
		DesiredCapabilities capabilities = this.capabilities;				

		PhantomJSDriver driver = new PhantomJSDriver(capabilities); 
		//Por custiones del PhantomJS se debe auentar el tamanho de la ventana para que los 
		//elementos sean visibles. Sin esto, fallan algunas aplicaciones
		aumentarTamanoDeVentanaEnPhantonJS(driver);
		System.out.println("cargo el driver=" + driver);
		delegate.set(driver);
		
	}

	
	
	private void aumentarTamanoDeVentanaEnPhantonJS(PhantomJSDriver driver) {
		driver.manage().window().setSize( new Dimension(1024, 768));
	}

}
