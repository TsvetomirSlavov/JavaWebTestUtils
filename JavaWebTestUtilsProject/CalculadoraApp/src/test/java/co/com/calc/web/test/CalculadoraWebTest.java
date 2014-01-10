package co.com.calc.web.test;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CalculadoraWebTest {

	private HttpServer server;
	private WebTarget target;

	@Before
	public void setUp() throws Exception {
		server = Main.startServer();

		Client c = ClientBuilder.newClient();
		target = c.target(Main.BASE_URI);
	}

	@After
	public void tearDown() throws Exception {
		server.stop();
	}

	
	
	@Test
	public void sumar_1y2_debe_dar_3() {
		WebTarget targetSuma = target.path("Suma").queryParam("sumando1", 1).queryParam("sumando2", 2);
		String responseMsg = targetSuma.request().get(String.class);
		assertEquals("3", responseMsg);
	}
	

	

	
	
	

}
