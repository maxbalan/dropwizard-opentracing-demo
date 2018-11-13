package github.maxbalan.demo;

import github.maxbalan.demo.lib.Tracing;
import github.maxbalan.demo.resources.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import io.opentracing.contrib.dropwizard.DropWizardTracer;
import io.opentracing.contrib.dropwizard.ServerTracingFeature;


public class App extends Application<AppConfig> {

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public void run(AppConfig configuration, Environment environment) throws Exception {
        final DropWizardTracer dwTracer = new DropWizardTracer(Tracing.init("TestDropwizard"));

        environment.jersey().register(new ServerTracingFeature
            .Builder(dwTracer)
            .build());

        environment.jersey().register(new HelloWorldResource());
    }

}
