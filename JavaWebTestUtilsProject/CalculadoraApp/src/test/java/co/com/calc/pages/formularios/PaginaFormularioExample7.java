package co.com.calc.pages.formularios;

import org.jbehave.web.selenium.WebDriverProvider;

import co.com.webtest.config.AbstractPage;

public class PaginaFormularioExample7 extends AbstractPage {

	public PaginaFormularioExample7(WebDriverProvider driverProvider) {
		super(driverProvider);
	}
	
	public PaginaFormularioExample7 open(){
		get("http://localhost:8080/webapp/forms/example07.html");
		return this;
	}

	public void seleccionarModoPagoVisa() {
		clickRadioButtonByNameValue("paymethod", "visa");
	}

	public boolean modoPagoEsVisa() {
		return isRadioButtonValueSelected("paymethod", "visa");
	}


}
