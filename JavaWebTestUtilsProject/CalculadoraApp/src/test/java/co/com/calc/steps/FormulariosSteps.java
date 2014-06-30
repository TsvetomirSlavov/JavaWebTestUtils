package co.com.calc.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import co.com.calc.jbehave.Pages;
import co.com.calc.pages.formularios.PaginaFormularioExample10;
import co.com.calc.pages.formularios.PaginaFormularioExample2;
import co.com.calc.pages.formularios.PaginaFormularioExample3;
import co.com.calc.pages.formularios.PaginaFormularioExample4;
import co.com.calc.pages.formularios.PaginaFormularioExample7;
import co.com.calc.pages.formularios.PaginaFormularioExample9;

public class FormulariosSteps {
	Pages pages;
	

	public FormulariosSteps(Pages pages) {
		this.pages = pages;
	}
	
	/* Scenario: Ingresar a la pagina del ejemplo2 y llenar cajas de texto */
	
	@Given("ingreso a la pagina de ejemplo2")
	public void abrirPaginaEjemplo2(){
		PaginaFormularioExample2 example2 = pages.getPaginaFormularioExample2();
		example2.open();
	}
	
	@When("se llenan los campos de texto entry1, entry2 y entry3 con los textos prueba1, prueba2 y prueba3")
	public void whenLlenarCamposDeTextoEntry1Entry2Entry3(){
		PaginaFormularioExample2 example2 = pages.getPaginaFormularioExample2();
		example2.asignarTextoEntry1("prueba1");
		example2.asignarTextoEntry2("prueba2");
		example2.asignarTextoEntry3("prueba3");
	}
	
	@Then("los campos de texto entry1, entry2 y entry3 deben tener los textos ingresados")
	public void thenCamposEntry1Entry2Entry3conTextosIngresados(){
		PaginaFormularioExample2 example2 = pages.getPaginaFormularioExample2();
		assertEquals("prueba1",example2.obtenerValorEntry1());
		assertEquals("prueba2",example2.obtenerValorEntry2());
		assertEquals("prueba3",example2.obtenerValorEntry3());
	}
	
	/* Scenario: Ingresar a la pagina del ejemplo 3 y seleccionar ingredientes para la pizza */
	
	@Given("ingreso a la pagina de ejemplo3")
	public void abrirPaginaEjemplo3(){
		PaginaFormularioExample3 example3= pages.getPaginaFormularioExample3();
		example3.open();
	}
	
	@When("se seleccionan los checkboxes Pepperoni y Anchovies")
	public void whenSeleccionaPeperoniYAnchoas(){
		PaginaFormularioExample3 example3= pages.getPaginaFormularioExample3();
		example3.seleccionarPeperoni();
		example3.seleccionarAnchoas();
	}  
	
	@Then("las cajas de chequeo de Peperoni y Anchovies estan seleccionadas")
	public void thenPeperoniYAnchoasSeleccionadas(){
		PaginaFormularioExample3 example3= pages.getPaginaFormularioExample3();
		assertTrue(example3.estaSeleccionadoPeperoni());
		assertTrue(example3.estaSeleccionadoAnchoas());
	}
	
	/* Scenario: Ingresar a la pagina del ejemplo 3 y seleccionar todos los ingredientes para la pizza */
	
	@When ("se seleccionan los checkboxes Pepperoni, Saussage y Anchovies")
	public void whenSeleccionaTodosLosIngredientes(){
		PaginaFormularioExample3 example3 = pages.getPaginaFormularioExample3();
		example3.seleccionarTodosLosIngredientes();
	}
	
	@Then ("las cajas de chequeo de Peperoni, Saussage y Anchovies estan seleccionadas")
	public void thenTodosLosIngredientesSeleccionados(){
		PaginaFormularioExample3 example3 = pages.getPaginaFormularioExample3();
		assertTrue(example3.estaSeleccionadoPeperoni());
		assertTrue(example3.estaSeleccionadoSalsa());
		assertTrue(example3.estaSeleccionadoAnchoas());
	}
	
	/* Scenario: Cambiar valores por defecto de un texto y checkbox */

	@Given ("ingreso a la pagina de ejemplo4")
	public void abrirPaginaEjemplo4(){
		PaginaFormularioExample4 example4 = pages.getPaginaFormularioExample4();
		example4.open();
	}
	
	@When ("se llena el campo de texto entry1 con el valor prueba")
	public void whenLlenarCampoTextoEntry1conPrueba(){
		PaginaFormularioExample4 example4 = pages.getPaginaFormularioExample4();
		example4.asignarTextoEntry1("prueba");
	}
	
	@Then ("el campo de texto entry1 debe mostrar el valor prueba")
	public void thenCampoTextoEntry1ConValorPrueba(){
		PaginaFormularioExample4 example4 = pages.getPaginaFormularioExample4();
		assertEquals("prueba", example4.obtenerValorInputEntry1());
	}
	
	@When ("se deselecciona el primer checkbox")
	public void whenPrimerCheckboxdeseleccionado(){
		PaginaFormularioExample4 example4 = pages.getPaginaFormularioExample4();
		example4.desactivarPrimerCheckBox();
	}
	
	@Then ("el primer checkbox debe estar deseleccionado")
	public void thenPrimerCheckboxEstaDeseleccionado(){
		PaginaFormularioExample4 example4 = pages.getPaginaFormularioExample4();
		assertTrue(example4.estaDeseleccionadoCheckbox1());
	}
	
	/* Scenario: Concatenar un texto a un campo de texto con un valor */
	
	@When ("el campo de texto entry1 tiene el valor por defecto 'foo'")
	public void andCampoTextoEntry1TieneValorFoo(){
		PaginaFormularioExample4 example4 = pages.getPaginaFormularioExample4();
		assertEquals("foo", example4.obtenerValorInputEntry1());
	} 
	
	@When ("se llena el campo de texto entry1 con el valor ' fighters'")
	public void whenLlenarCampoTextoEntryConFighters(){
		PaginaFormularioExample4 example4 = pages.getPaginaFormularioExample4();
		example4.adicionarValorTextoEntry1(" fighters");
	}
	
	@Then ("el campo de texto entry1 debe mostrar el valor foo fighters")
	public void thenCampoEntry1TieneValorFooFighters(){
		PaginaFormularioExample4 example4 = pages.getPaginaFormularioExample4();
		assertEquals("foo fighters", example4.obtenerValorInputEntry1());
	}
	
	/* Scenario: Ingresar a la pagina del ejemplo7 y seleccionar modo de pago tarjeta de credito visa */
	
	@Given ("ingreso a la pagina de ejemplo7")
	public void abrirPaginaEjemplo7(){
		PaginaFormularioExample7 example7 = pages.getPaginaFormularioExample7();
		example7.open();
	}
	
	@When ("se selecciona la opcion 'visa'")
	public void whenOpcionVisaSeleccionada(){
		PaginaFormularioExample7 example7 = pages.getPaginaFormularioExample7();
		example7.seleccionarModoPagoVisa();
	}
	
	@Then ("el valor del modo de pago es 'visa'")
	public void thenValorModoPagoEsVisa(){
		PaginaFormularioExample7 example7 = pages.getPaginaFormularioExample7();
		assertTrue(example7.modoPagoEsVisa());
	}
	
	/* Scenario: Ingresar a la pagina del ejemplo9 y seleccionar la actividad 'Watch TV' con 'George', luego resetear las opciones */
	@Given ("ingreso a la pagina de ejemplo9")
	public void abrirPaginaEjemplo9(){
		PaginaFormularioExample9 example9 = pages.getPaginaFormularioExample9();
		example9.open();
	}
	
	@When ("selecciona que actividad por texto visible 'Watch TV'")
	public void whenSeleccionaVerTV(){
		PaginaFormularioExample9 example9 = pages.getPaginaFormularioExample9();
		example9.seleccionarVerTV();
	}
	
	@Then ("el campo what-to-do debe tener el valor 'Watch TV'")
	public void thenCampoQueHacerConValorWatchTV(){
		PaginaFormularioExample9 example9 = pages.getPaginaFormularioExample9();
		assertEquals("Watch TV", example9.obtenerValorCampoWhatToDoPorNombre());
	}
	
	@When ("clic en el boton 'Reset' por id=reset_id")
	public void whenClicBotonResetPorId(){
		PaginaFormularioExample9 example9 = pages.getPaginaFormularioExample9();
		example9.clicBotonResetPorId();
	}

	@Then ("el campo what-to-do debe tener el valor 'Read A Book'")
	public void thenCampoQueHacerConValorReadABook(){
		PaginaFormularioExample9 example9 = pages.getPaginaFormularioExample9();
		assertEquals("Read A Book", example9.obtenerValorCampoWhatToDoPorNombre());
	}

	@When ("selecciona con quien hacer la actividad por id=3 que es 'Anna'")
	public void whenSeleccionaRealizarActividadConAnna(){
		PaginaFormularioExample9 example9 = pages.getPaginaFormularioExample9();
		example9.seleccionarPorId3();
	}
	@Then ("el campo who-to-do-it-with debe tener el valor 'Anna'")
	public void thenCampoConQuienConValorAnna(){
		PaginaFormularioExample9 example9 = pages.getPaginaFormularioExample9();
		assertEquals("Anna", example9.obtenerValorCampoConQuienPorId());
	}

	@When ("clic en el boton 'Reset' por name=reset_name")
	public void whenClicBotonResetPorNombre(){
		PaginaFormularioExample9 example9 = pages.getPaginaFormularioExample9();
		example9.clicBotonResetPorNombre();
	}
	@Then ("el campo who-to-do-it-with debe tener el valor 'Alex'")
	public void thenCampoConQuienConValorAlex(){
		PaginaFormularioExample9 example9 = pages.getPaginaFormularioExample9();
		assertEquals("Alex", example9.obtenerValorCampoConQuienPorId());
	}
	
	/* Scenario: Ingresar a la pagina del ejemplo10 y seleccionar varios items de ropa para ponerse */
	@Given ("ingreso a la pagina de ejemplo10")
	public void abrirPaginaEjemplo10(){
		PaginaFormularioExample10 example10 = pages.getPaginaFormularioExample10();
		example10.open();
	}
	
	@When ("se selecciona las opciones 'T-Shirt','Socks','Jeans' y 'Boots'")
	public void whenSeleccionaOpcionesRopa(){
		PaginaFormularioExample10 example10 = pages.getPaginaFormularioExample10();
		example10.seleccionarOpcionesRopa();
	}
	
	@Then ("los campos 'T-Shirt','Socks','Jeans' y 'Boots' deben estar seleccionados")
	public void thenOpcionesRopaSeleccionadas(){
		PaginaFormularioExample10 example10 = pages.getPaginaFormularioExample10();
		assertTrue(example10.opcionesRopaSeleccionadas());
	}
}
