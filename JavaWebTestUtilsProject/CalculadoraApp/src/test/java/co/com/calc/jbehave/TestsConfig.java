package co.com.calc.jbehave;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;

import co.com.calc.steps.CalculadoraSteps;
import co.com.calc.web.test.Main;
import co.com.sura.webTest.PhantomJSConfig;
import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;

@RunWith(JUnitReportingRunner.class)
public class TestsConfig extends PhantomJSConfig {

	private Pages pages = new Pages(driverProvider);
	
	
	
	
	public static void setup() throws IOException
	{
		System.out.println("Before class");
		Main.startServer();
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
	
	
	public static void tearDown() throws Exception {
		Main.stopServer();
	}

	

	

}
