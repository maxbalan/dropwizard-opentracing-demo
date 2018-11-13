package github.maxbalan.demo.resources;

import io.jaegertracing.Configuration;
import io.opentracing.Span;
import io.opentracing.Tracer;
import io.opentracing.contrib.dropwizard.Trace;
import io.opentracing.contrib.tracerresolver.TracerResolver;

import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.common.collect.ImmutableMap;


@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    
    @GET
    @Path("/auto")
    @Trace(operationName = "greeting")
    public Greeting helloWorld(@QueryParam("name") Optional<String> name) {
        return new Greeting(name.orElse("Wrold"));
    }

    @GET
    @Path("/manual")
    @Trace(operationName = "extraTracing")
    public Greeting manualTracing(@QueryParam("name") Optional<String> name) {

        Tracer tracer = TracerResolver.resolveTracer();
        Span span = tracer.buildSpan("hello-world").start();
        span.setTag("hello-to", name.orElse("Wrold"));
        span.finish();

        return new Greeting(name.orElse("Wrold"));
    }
    
}
