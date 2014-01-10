package co.com.calc.jbehave;

import org.jbehave.web.selenium.WebDriverProvider;

import co.com.calc.pages.PaginaCalculadora;


public class Pages {
	

	private WebDriverProvider provider;
	
	private PaginaCalculadora paginaCalculadora;
	

	

	public Pages(WebDriverProvider driverProvider) {
		this.provider = driverProvider;
	}
	
	

	public PaginaCalculadora getPaginaCalculadora() {
		if(paginaCalculadora == null){
			paginaCalculadora = new PaginaCalculadora(provider);
		}
		return paginaCalculadora;
	}
	


	
	
	
}
