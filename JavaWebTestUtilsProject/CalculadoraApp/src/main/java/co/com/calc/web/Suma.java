package co.com.calc.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path("Suma")
public class Suma {
	
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String suma(@QueryParam("sumando1") int sumando1, @QueryParam("sumando2") int sumando2) {	
        return "3";
    }

}
