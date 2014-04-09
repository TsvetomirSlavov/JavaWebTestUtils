package co.com.calc.pages;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import co.com.webtest.config.AbstractPage;

public class PaginaGoogle extends AbstractPage {

	public PaginaGoogle(WebDriverProvider driverProvider) {
		super(driverProvider);		
	}
	
	public PaginaGoogle open(){
		get("http://www.google.com/");		
		return this;
	}

	public PaginaResultadoGoogle buscarPersona(String nombre) {
		WebElement textoBusqueda = this.findElement(By.name("q"));
		textoBusqueda.sendKeys(nombre);
		System.out.println(getPageSource());
		return new PaginaResultadoGoogle(this.getDriverProvider());
	}

}
