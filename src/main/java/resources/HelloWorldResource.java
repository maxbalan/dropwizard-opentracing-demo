package resources;

import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    
    @GET
    public Greeting helloWorld(@QueryParam("name") Optional<String> name) {
        return new Greeting(name.orElse("Wrold"));
    }
    
}
