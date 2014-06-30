package co.com.calc.pages.formularios;

import org.jbehave.web.selenium.WebDriverProvider;

import co.com.webtest.config.AbstractPage;

public class PaginaFormularioExample9 extends AbstractPage{
	public PaginaFormularioExample9(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public PaginaFormularioExample9 open(){
		get("http://localhost:8080/webapp/forms/example09.html");
		return this;
	}

	public void seleccionarVerTV() {
		selectOptionByNameAndVisibleText("what-to-do","Watch TV");
	}

	public String obtenerValorCampoWhatToDoPorNombre() {
		return getSelectedOptionValueByName("what-to-do");
	}

	public void seleccionarPorId3() {
		selectOptionByNameAndValue("who-to-do-it-with","3");
	}

	public String obtenerValorCampoConQuienPorId() {
		return getSelectedOptionValueById("id_who");
	}

	public void clicBotonResetPorId() {
		clicButtonById("reset_id");
	}

	public void clicBotonResetPorNombre() {
		clicButtonByName("reset_name");
	}

	
}
