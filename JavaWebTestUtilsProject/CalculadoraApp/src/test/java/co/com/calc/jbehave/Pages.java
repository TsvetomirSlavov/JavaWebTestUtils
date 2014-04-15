package co.com.calc.jbehave;

import org.jbehave.web.selenium.WebDriverProvider;

import co.com.calc.pages.PaginaCalculadora;
import co.com.calc.pages.ServicioAmazon;


public class Pages {
	

	private WebDriverProvider provider;
	
	private PaginaCalculadora paginaCalculadora;
	private ServicioAmazon servicioAmazon;

	

	public Pages(WebDriverProvider driverProvider) {
		this.provider = driverProvider;
	}
	
	

	public PaginaCalculadora getPaginaCalculadora() {
		if(paginaCalculadora == null){
			paginaCalculadora = new PaginaCalculadora(provider);
		}
		return paginaCalculadora;
	}


	public ServicioAmazon getServicioAmazon(){
		if(servicioAmazon == null){
			servicioAmazon = new ServicioAmazon(provider);
		}
		return servicioAmazon;
	}

	
	
	
}
