package co.com.calc.pages.formularios;

import java.util.Arrays;
import java.util.List;

import org.jbehave.web.selenium.WebDriverProvider;

import co.com.webtest.config.AbstractPage;

public class PaginaFormularioExample10 extends AbstractPage{

	public PaginaFormularioExample10(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public PaginaFormularioExample10 open() {
		get("http://localhost:8080/webapp/forms/example10.html");
		return this;
	}

	public void seleccionarOpcionesRopa() {
		List<String> opts = Arrays.asList("T-Shirt","Socks","Jeans","Boots");
		selectMultipleOptionsByNameAndVisibleText("what-to-wear",opts);
	}

	public boolean opcionesRopaSeleccionadas() {
		List<String> opts = Arrays.asList("T-Shirt","Socks","Jeans","Boots");
		return validarOpcionesSeleccionadas("what-to-wear",opts);
	}

}
