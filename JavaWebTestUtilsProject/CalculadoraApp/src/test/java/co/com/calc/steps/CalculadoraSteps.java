package co.com.calc.steps;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;

import co.com.calc.jbehave.Pages;
import co.com.calc.jbehave.TestsConfig;
import co.com.calc.pages.PaginaCalculadora;

public class CalculadoraSteps {
	
	Pages pages;
	
	
	
	public CalculadoraSteps(Pages pages) {
		this.pages = pages;
	}
	
	@BeforeStories
	public void setup() throws IOException
	{
		TestsConfig.setup();
		
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
	
	
	@AfterStories
	public void tearDown() throws Exception
	{
		TestsConfig.tearDown();
		
	}
	

}
