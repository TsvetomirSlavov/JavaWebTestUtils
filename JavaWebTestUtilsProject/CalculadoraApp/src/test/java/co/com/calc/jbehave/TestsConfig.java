package co.com.calc.jbehave;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.UriBuilder;

import org.junit.runner.RunWith;

import co.com.calc.steps.BusquedaGoogleSteps;
import co.com.calc.steps.CalculadoraSteps;
import co.com.calc.steps.AmazonSteps;
import co.com.webtest.config.PhantomJSConfig;
import co.com.webtest.server.WebServer;
import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;

@RunWith(JUnitReportingRunner.class)
public class TestsConfig extends PhantomJSConfig {

	private Pages pages = new Pages(driverProvider);
	
	public static void setup() throws IOException
	{		
		WebServer.startServer(UriBuilder.fromPath("http://localhost:8080/").build());
	}
	
	
	@Override
	protected List<Object> getWebSteps() {
		List<Object> steps = new ArrayList<Object>();		
//		steps.add(new CalculadoraSteps(pages));
//		steps.add(new BusquedaGoogleSteps(pages));
		steps.add(new AmazonSteps(pages));
		return steps;
	}
	
	
	

	public static void tearDown() throws Exception {
		WebServer.stopServer();
	}

	

	

}
