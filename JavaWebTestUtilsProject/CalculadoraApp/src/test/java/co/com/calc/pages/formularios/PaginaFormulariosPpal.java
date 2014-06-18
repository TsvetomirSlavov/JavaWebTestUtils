package co.com.calc.pages.formularios;

import org.jbehave.web.selenium.WebDriverProvider;

import co.com.webtest.config.AbstractPage;

public class PaginaFormulariosPpal extends AbstractPage{

	public PaginaFormulariosPpal(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public PaginaFormulariosPpal open(){
		get("http://www.websitedatabases.com/php_form_maker/html_forms/html_form_examples.html");
		return this;
	}
	
	public String buscarTituloH4(){
		return this.getTextoElementoByCssSelector("h4");
	}
}
