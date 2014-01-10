package co.com.calc.steps;

import static org.junit.Assert.assertTrue;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;

import co.com.calc.jbehave.Pages;
import co.com.calc.pages.PaginaCalculadora;

public class CalculadoraSteps {
	
	Pages pages;
	
	public CalculadoraSteps(Pages pages) {
		this.pages = pages;
	}
	
	@Given("ingreso a la pagina principal de la calculadora")
	public void abrirPaginaPrincipalCalculadora(){
		PaginaCalculadora calculadora = pages.getPaginaCalculadora();
		calculadora = calculadora.open();
	}
	@Then("deberia ver un banner de bienvenida a calculadora")
	public void thenDeberiaVerUnBannerDeBienvenidaACalculadora() {
		PaginaCalculadora calculadora = pages.getPaginaCalculadora();
		assertTrue(calculadora.contieneBienvenida());
		
	  
	}
	

}
