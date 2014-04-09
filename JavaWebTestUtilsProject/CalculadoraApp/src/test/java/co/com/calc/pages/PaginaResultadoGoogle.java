package co.com.calc.pages;

import org.jbehave.web.selenium.WebDriverProvider;

import co.com.webtest.config.AbstractPage;

public class PaginaResultadoGoogle extends AbstractPage {
	
	public PaginaResultadoGoogle(WebDriverProvider driverProvider) {
		super(driverProvider);		
	}
	
	public PaginaResultadoGoogle open(){	
		return this;
	}
	
	public boolean contieneResultado() {
		return getPageSource().contains("jubel");
	}

}
