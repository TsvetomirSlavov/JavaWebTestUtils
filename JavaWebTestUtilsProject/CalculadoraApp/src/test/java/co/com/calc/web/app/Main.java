package co.com.calc.web.app;

import java.io.IOException;

import co.com.webtest.server.WebServer;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		System.out.println("Corriendo en " + System.getProperty("user.dir"));
		String url = "http://localhost:8080/";
		WebServer.startServerWithJaxWsResources(url,"co.com.calc.web");
		System.out.println(String.format(
				"Jersey app started with WADL available at "
						+ "%sapplication.wadl\nHit enter to stop it...",
				url));
		System.in.read();
		WebServer.stopServer();

	}

}
