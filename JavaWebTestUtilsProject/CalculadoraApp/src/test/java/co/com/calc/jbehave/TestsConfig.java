package co.com.calc.jbehave;

import java.util.ArrayList;
import java.util.List;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;

import co.com.calc.steps.CalculadoraSteps;
import co.com.calc.web.test.Main;
import co.com.sura.webTest.PhantomJSConfig;

public class TestsConfig extends PhantomJSConfig {

	private Pages pages = new Pages(driverProvider);
	private HttpServer server;
	
	
	@Before
	public void setup()
	{
		server = Main.startServer();
	}
	
	
	@Override
	protected List<Object> getWebSteps() {
		List<Object> steps = new ArrayList<Object>();		
		steps.add(new CalculadoraSteps(pages));
		return steps;
	}
	
	

	@Override
	protected String getPhantomJSPath() {
		return "D:\\Utilidades\\phantomjs-1.9.2\\phantomjs.exe";
	}
	
	@After
	public void tearDown() throws Exception {
		server.stop();
	}

	

	

}
