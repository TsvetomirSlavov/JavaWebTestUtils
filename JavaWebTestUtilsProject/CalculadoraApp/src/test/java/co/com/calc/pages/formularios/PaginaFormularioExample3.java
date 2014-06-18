package co.com.calc.pages.formularios;

import org.jbehave.web.selenium.WebDriverProvider;

import co.com.webtest.config.AbstractPage;

public class PaginaFormularioExample3 extends AbstractPage{

	public PaginaFormularioExample3(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public PaginaFormularioExample3 open() {
		get("http://localhost:8080/webapp/forms/example03.html");
		return this;
	}
	
	public void seleccionarPeperoni() {
		clickCheckBoxByNameValue("topping","pepperoni");
	}

	public void seleccionarAnchoas() {
		clickCheckBoxByNameValue("topping","anchovies");
	}
	
	public void seleccionarTodosLosIngredientes(){
		String[] values = {"pepperoni","anchovies","sausage"};
		clickMultipleCheckBoxesByNameValues("topping",values);
	}

	public boolean estaSeleccionadoPeperoni() {
		return isCheckboxValueSelected("topping","pepperoni");
	}

	public boolean estaSeleccionadoAnchoas() {
		return isCheckboxValueSelected("topping","anchovies");
	}

	public boolean estaSeleccionadoSalsa() {
		return isCheckboxValueSelected("topping","sausage");
	}
}
