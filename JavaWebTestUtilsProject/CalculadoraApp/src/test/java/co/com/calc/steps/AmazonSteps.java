package co.com.calc.steps;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import co.com.calc.jbehave.Pages;
import co.com.calc.jbehave.TestsConfig;
import co.com.calc.pages.ServicioAmazon;

public class AmazonSteps {

	Pages pages;
	
	public AmazonSteps(Pages pages) {
		this.pages = pages;
	}

	@BeforeStories
	public void setup() throws IOException
	{
		TestsConfig.setup();
	}

	@Given("Estando en la pagina de amazon")
	public void abrirAmazon(){
		ServicioAmazon servicioAmazon = pages.getServicioAmazon();
		servicioAmazon.abrirAmazon();
	}
	
	@When("Ingreso la palabra $palabraClave en el campo de busqueda")
	public void buscarPalabraClave(String palabraClave){
		ServicioAmazon servicioAmazon = pages.getServicioAmazon();
		servicioAmazon.ingresarPalabra(palabraClave);	
	}
	
	@Then("Puedo buscar su significado")
	public void verSignificado(){
		ServicioAmazon resultado = pages.getServicioAmazon();
		resultado = resultado.devolverSignificado();
		assertTrue(resultado.contieneArqueologia());
	}

	@AfterStories
	public void tearDown() throws Exception
	{
		TestsConfig.tearDown();
		
	}

}
