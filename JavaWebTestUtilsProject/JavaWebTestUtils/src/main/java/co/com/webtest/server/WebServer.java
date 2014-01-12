package co.com.webtest.server;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.StaticHttpHandler;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

/**
 * Main class.
 * 
 */
public class WebServer {
	// Base URI the Grizzly HTTP server will listen on
	

	private static HttpServer gobalServer;
	private static String base_url;

	/**
	 * Starts Grizzly HTTP server exposing JAX-RS resources defined in this
	 * application.
	 * 
	 * @return Grizzly HTTP server.
	 * @throws IOException
	 */
	public static HttpServer startServer(String url) throws IOException {
		
		final ResourceConfig rc = new ResourceConfig().packages();	
		return startServerInt(url, rc);
	}

	public static HttpServer startServerWithJaxWsResources(String url, String... jaxWsPackages) throws IOException {
		final ResourceConfig rc = new ResourceConfig().packages(jaxWsPackages);
		return startServerInt(url, rc);

	}

	public static HttpServer startServerInt(String url, ResourceConfig rc)
			throws IOException {	
		base_url = url;
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(
				URI.create(base_url), rc);
		server.getServerConfiguration().addHttpHandler(
				new StaticHttpHandler("src/main/webapp/"), "/webapp");

		server.start();
		gobalServer = server;
		return server;
	}
	
	public static String getUrl() {
		return base_url;
	}

	public static void stopServer() {
		gobalServer.stop();
	}

	/**
	 * Main method.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("Corriendo en " + System.getProperty("user.dir"));
		String url = "http://localhost:8080/";
		final HttpServer server = startServer(url);
		System.out.println(String.format(
				"Jersey app started with WADL available at "
						+ "%sapplication.wadl\nHit enter to stop it...",
				url));
		System.in.read();
		server.stop();
	}
}
