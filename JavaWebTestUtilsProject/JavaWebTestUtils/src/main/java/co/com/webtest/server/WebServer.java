package co.com.webtest.server;

import org.apache.jasper.servlet.JspServlet;
import org.glassfish.grizzly.http.server.HttpHandler;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.Request;
import org.glassfish.grizzly.http.server.Response;
import org.glassfish.grizzly.http.server.StaticHttpHandler;
import org.glassfish.grizzly.servlet.FilterRegistration;
import org.glassfish.grizzly.servlet.ServletRegistration;
import org.glassfish.grizzly.servlet.WebappContext;

import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.ClassNamesResourceConfig;
import com.sun.jersey.spi.container.servlet.ServletContainer;

import java.io.IOException;
import java.net.URI;
import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.ws.rs.core.UriBuilder;

/**
 * Main class.
 * 
 */
public class WebServer {
	// Base URI the Grizzly HTTP server will listen on

	private static HttpServer globalServer;
	private static final String JERSEY_SERVLET_CONTEXT_PATH = "";
    private static final String JSP_CLASSPATH_ATTRIBUTE =
            "org.apache.catalina.jsp_classpath";
	private static final URI BASE_URI = UriBuilder.fromUri("http://127.0.0.1/")
			.port(8080).build();

	/**
	 * Starts Grizzly HTTP server exposing JAX-RS resources defined in this
	 * application.
	 * 
	 * @return Grizzly HTTP server.
	 * @throws IOException
	 */
	public static HttpServer startServer(URI url) throws IOException {

		System.out.println("Starting grizzly...");

		// Create HttpServer and register dummy "not found" HttpHandler
		HttpServer httpServer = GrizzlyServerFactory.createHttpServer(BASE_URI, new HttpHandler() {

            @Override
            public void service(Request rqst, Response rspns) throws Exception {
                rspns.setStatus(404, "Not found");
                rspns.getWriter().write("404: not found");
            }
        });
		httpServer.getServerConfiguration().addHttpHandler(
				new StaticHttpHandler("src/main/webapp/"), "/webapp");

		WebappContext context = new WebappContext("WebappContext",
				JERSEY_SERVLET_CONTEXT_PATH);

		// Initialize and register Jersey Servlet
		FilterRegistration registration = context.addFilter("ServletContainer",
				ServletContainer.class);
		registration.setInitParameter(ServletContainer.RESOURCE_CONFIG_CLASS,
				ClassNamesResourceConfig.class.getName());
		registration.setInitParameter(
				"com.sun.jersey.config.property.JSPTemplatesBasePath",
				"/WEB-INF/jsp");
		registration.setInitParameter(
				"com.sun.jersey.config.property.WebPageContentRegex",
				"(/(image|js|css)/?.*)|(/.*\\.jsp)|(/WEB-INF/.*\\.jsp)|"
						+ "(/WEB-INF/.*\\.jspf)|(/.*\\.html)|(/favicon\\.ico)|"
						+ "(/robots\\.txt)");

		registration.addMappingForUrlPatterns(
				EnumSet.allOf(DispatcherType.class), "/*");

		// Initialize and register JSP Servlet
		ServletRegistration jspRegistration = context.addServlet(
				"JSPContainer", JspServlet.class.getName());
		jspRegistration.addMapping("/*");

		// Set classpath for Jasper compiler based on the current classpath
		context.setAttribute(JSP_CLASSPATH_ATTRIBUTE,
				System.getProperty("java.class.path"));

		context.deploy(httpServer);
		globalServer = httpServer;
		return httpServer;

	}

	public static URI getUrl() {
		return BASE_URI;
	}

	public static void stopServer() {
		globalServer.stop();
	}

	/**
	 * Main method.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("Corriendo en " + System.getProperty("user.dir"));
		final HttpServer httpServer = startServer(BASE_URI);
		try {
			System.out
					.println(String
							.format("Jersey app started with WADL available at "
									+ "%sapplication.wadl\nTry out %stest\nHit enter to stop it...",
									BASE_URI, BASE_URI));
			System.in.read();
		} finally {
			httpServer.stop();
		}

	}
}
