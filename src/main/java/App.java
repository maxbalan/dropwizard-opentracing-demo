

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import resources.HelloWorldResource;


public class App extends Application<AppConfig> {

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public void run(AppConfig configuration, Environment environment) throws Exception {
        environment.jersey().register(new HelloWorldResource());
    }

}
