package co.com.calc.pages.formularios;

import org.jbehave.web.selenium.WebDriverProvider;

import co.com.webtest.config.AbstractPage;

public class PaginaFormularioExample4 extends AbstractPage{

	public PaginaFormularioExample4(WebDriverProvider driverProvider) {
		super(driverProvider);
	}
	
	public PaginaFormularioExample4 open(){
		get("http://localhost:8080/webapp/forms/example04.html");
		return this;
	}

	public void asignarTextoEntry1(String value) {
		asignarValorInputByName("entry1", value);
	}

	public String obtenerValorInputEntry1() {
		return getValorInputByName("entry1");
	}
	
	public void desactivarPrimerCheckBox() {
		clickCheckBoxByNameValue("box1", "activated");
	}

	public boolean estaDeseleccionadoCheckbox1() {
		return !isCheckboxValueSelected("box1", "activated");
	}

	public void adicionarValorTextoEntry1(String value) {
		adicionarValorInputByName("entry1",value);
	}

}
