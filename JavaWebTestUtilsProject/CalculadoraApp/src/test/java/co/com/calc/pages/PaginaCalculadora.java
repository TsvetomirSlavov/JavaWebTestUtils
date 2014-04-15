package co.com.calc.pages;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import co.com.webtest.config.AbstractPage;

public class PaginaCalculadora extends AbstractPage {
	
	public PaginaCalculadora(WebDriverProvider driverProvider) {
		super(driverProvider);		
	}
	
	public PaginaCalculadora open(){
		
	
		get("http://localhost:8080/webapp/");		
		return this;
	}
	


	public boolean contieneBienvenida() {
		return getPageSource().contains("Bienvenido");
	}

	public void ingresarNombreUsuario(String nombre) {
		WebElement txtNombre = findElement(By.id("txtNombre"));
		txtNombre.sendKeys(nombre);
		
		WebElement frmSaludo = findElement(By.id("frmSaludo"));
		frmSaludo.submit();
		
		
		
	}

}
