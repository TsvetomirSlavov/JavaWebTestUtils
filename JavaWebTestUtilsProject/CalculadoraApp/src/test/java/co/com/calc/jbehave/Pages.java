package co.com.calc.jbehave;

import org.jbehave.web.selenium.WebDriverProvider;

import co.com.calc.pages.PaginaCalculadora;
import co.com.calc.pages.PaginaGoogle;
import co.com.calc.pages.PaginaResultadoGoogle;


public class Pages {
	

	private WebDriverProvider provider;
	
	private PaginaCalculadora paginaCalculadora;
	private PaginaGoogle paginaGoogle;
	private PaginaResultadoGoogle paginaResultadoGoogle;

	

	public Pages(WebDriverProvider driverProvider) {
		this.provider = driverProvider;
	}
	
	

	public PaginaCalculadora getPaginaCalculadora() {
		if(paginaCalculadora == null){
			paginaCalculadora = new PaginaCalculadora(provider);
		}
		return paginaCalculadora;
	}



	public PaginaGoogle getPaginaGoogle() {
		if(paginaGoogle == null){
			paginaGoogle = new PaginaGoogle(provider);
		}
		return paginaGoogle;
	}



	public PaginaResultadoGoogle getPaginaResultadoGoogle() {
		if(paginaResultadoGoogle == null){
			paginaResultadoGoogle = new PaginaResultadoGoogle(provider);
		}
		return paginaResultadoGoogle;
	}
	


	
	
	
}
