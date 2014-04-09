package co.com.calc.steps;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;

import co.com.calc.jbehave.Pages;
import co.com.calc.jbehave.TestsConfig;
import co.com.calc.pages.PaginaGoogle;
import co.com.calc.pages.PaginaResultadoGoogle;

public class BusquedaGoogleSteps {

	Pages pages;
	
	
	public BusquedaGoogleSteps(Pages pages) {
		this.pages = pages;
	}
	
	@BeforeStories
	public void setup() throws IOException
	{
		TestsConfig.setup();
		
	}
	
	@Given("Estoy en google")
	public void abrirGoogle(){
		PaginaGoogle google = pages.getPaginaGoogle();
		google = google.open();
	}
	
	@When("Busco el nombre $nombre")
	public void whenBuscarPersona(String nombre) {
		PaginaGoogle google = pages.getPaginaGoogle();
		PaginaResultadoGoogle resultadoGoogle = google.buscarPersona(nombre);
		resultadoGoogle = resultadoGoogle.open();
	}
	
	@Then("Debo ver al menos un enlace en los resultados de busqueda")
	public void thenDeberiaVerUnResultado() {
		PaginaResultadoGoogle resultadoGoogle = pages.getPaginaResultadoGoogle();
		assertTrue(resultadoGoogle.contieneResultado());
	}
	
	
	@AfterStories
	public void tearDown() throws Exception
	{
		TestsConfig.tearDown();
		
	}
	

}
