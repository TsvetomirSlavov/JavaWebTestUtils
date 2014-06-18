package co.com.calc.pages.formularios;

import org.jbehave.web.selenium.WebDriverProvider;

import co.com.webtest.config.AbstractPage;

public class PaginaFormularioExample2 extends AbstractPage{

	public PaginaFormularioExample2(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public PaginaFormularioExample2 open(){
		get("http://localhost:8080/webapp/forms/example02.html");
		return this;
	}

	public void asignarTextoEntry1(String valor) {
		asignarValorInputByName("entry1",valor);
	}

	public void asignarTextoEntry2(String valor) {
		asignarValorInputByName("entry2", valor);
	}

	public void asignarTextoEntry3(String valor) {
		asignarValorInputByName("entry3", valor);
	}

	public String obtenerValorEntry1() {
		return getValorInputByName("entry1");
	}

	public Object obtenerValorEntry2() {
		return getValorInputByName("entry2");
	}

	public Object obtenerValorEntry3() {
		return getValorInputByName("entry3");
	}
	
}
