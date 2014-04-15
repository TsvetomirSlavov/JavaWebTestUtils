package co.com.calc.pages;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import co.com.webtest.config.AbstractPage;

public class ServicioAmazon extends AbstractPage {

	public ServicioAmazon(WebDriverProvider driverProvider) {
		super(driverProvider);
	}
	
	public ServicioAmazon abrirAmazon(){
		get("http://www.amazon.com/");
		return this;
	}
	
	public ServicioAmazon ingresarPalabra(String palabra){
		WebElement campoBusqueda = this.findElement(By.id("twotabsearchtextbox"));
		campoBusqueda.sendKeys(palabra);
		return this;
	}
	
	public ServicioAmazon devolverSignificado(){
		WebElement formulario = this.findElement(By.id("nav-searchbar"));
		formulario.submit();
		return this;
	}
	
	public boolean contieneArqueologia(){
		return getPageSource().contains("Arqueologia");
	}

}
