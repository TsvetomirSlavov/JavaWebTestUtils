package co.com.calc.jbehave;

import org.jbehave.web.selenium.WebDriverProvider;

import co.com.calc.pages.PaginaCalculadora;
import co.com.calc.pages.PaginaGoogle;
import co.com.calc.pages.PaginaResultadoGoogle;
import co.com.calc.pages.formularios.PaginaFormularioExample2;
import co.com.calc.pages.formularios.PaginaFormularioExample3;
import co.com.calc.pages.formularios.PaginaFormularioExample7;
import co.com.calc.pages.formularios.PaginaFormularioExample9;
import co.com.calc.pages.formularios.PaginaFormulariosPpal;
import co.com.calc.pages.formularios.PaginaFormularioExample4;


public class Pages {
	
	private WebDriverProvider provider;
	
	private PaginaCalculadora paginaCalculadora;
	private PaginaGoogle paginaGoogle;
	private PaginaResultadoGoogle paginaResultadoGoogle;
	private PaginaFormulariosPpal paginaPpalFormularios;
	private PaginaFormularioExample2 paginaFormularioExample2;
	private PaginaFormularioExample3 paginaFormularioExample3;
	private PaginaFormularioExample4 paginaFormularioExample4;
	private PaginaFormularioExample7 paginaFormularioExample7;
	private PaginaFormularioExample9 paginaFormularioExample9;
	
	
	public Pages(WebDriverProvider driverProvider) {
		this.provider = driverProvider;
	}
	
	

	public PaginaCalculadora getPaginaCalculadora() {
		if(paginaCalculadora == null){
			paginaCalculadora = new PaginaCalculadora(provider);
		}
		return paginaCalculadora;
	}



	public PaginaGoogle getPaginaGoogle() {
		if(paginaGoogle == null){
			paginaGoogle = new PaginaGoogle(provider);
		}
		return paginaGoogle;
	}



	public PaginaResultadoGoogle getPaginaResultadoGoogle() {
		if(paginaResultadoGoogle == null){
			paginaResultadoGoogle = new PaginaResultadoGoogle(provider);
		}
		return paginaResultadoGoogle;
	}
	
	
	public PaginaFormulariosPpal getPaginaPpalFormularios(){
		if(paginaPpalFormularios == null){
			paginaPpalFormularios = new PaginaFormulariosPpal(provider);
		}
		return paginaPpalFormularios;
	}

	public PaginaFormularioExample2 getPaginaFormularioExample2(){
		if(paginaFormularioExample2==null){
			paginaFormularioExample2 = new PaginaFormularioExample2(provider);
		}
		return paginaFormularioExample2;
	}



	public PaginaFormularioExample3 getPaginaFormularioExample3() {
		if(paginaFormularioExample3==null){
			paginaFormularioExample3 = new PaginaFormularioExample3(provider);
		}
		return paginaFormularioExample3;
	}

	
	public PaginaFormularioExample4 getPaginaFormularioExample4() {
		if(paginaFormularioExample4==null){
			paginaFormularioExample4 = new PaginaFormularioExample4(provider);
		}
		return paginaFormularioExample4;
	}



	public PaginaFormularioExample7 getPaginaFormularioExample7() {
		if(paginaFormularioExample7 == null){
			paginaFormularioExample7 = new PaginaFormularioExample7(provider);
		}
		return paginaFormularioExample7;
	}



	public PaginaFormularioExample9 getPaginaFormularioExample9() {
		if(paginaFormularioExample9 == null){
			paginaFormularioExample9 = new PaginaFormularioExample9(provider);
		}
		return paginaFormularioExample9;
	}
}
