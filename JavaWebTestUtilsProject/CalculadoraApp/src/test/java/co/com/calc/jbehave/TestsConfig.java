package co.com.calc.jbehave;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;

import co.com.calc.steps.CalculadoraSteps;
import co.com.calc.web.test.Main;
import co.com.webtest.config.PhantomJSConfig;
import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;

@RunWith(JUnitReportingRunner.class)
public class TestsConfig extends PhantomJSConfig {

	private Pages pages = new Pages(driverProvider);
	
	public static void setup() throws IOException
	{		
		Main.startServer();
	}
	
	
	@Override
	protected List<Object> getWebSteps() {
		List<Object> steps = new ArrayList<Object>();		
		steps.add(new CalculadoraSteps(pages));
		return steps;
	}
	
	
	

	public static void tearDown() throws Exception {
		Main.stopServer();
	}

	

	

}
