package co.com.calc.pages;

import org.jbehave.web.selenium.WebDriverProvider;

import co.com.webtest.config.AbstractPage;

public class PaginaCalculadora extends AbstractPage {
	
	public PaginaCalculadora(WebDriverProvider driverProvider) {
		super(driverProvider);		
	}
	
	public PaginaCalculadora open(){
		
		get("http://localhost:8080/webapp/");		
		return this;
	}
	


	public boolean contieneBienvenida() {
		return getPageSource().contains("Bienvenido");
	}

}
