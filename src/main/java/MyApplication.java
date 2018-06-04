import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;
import resource.UserResource;

public class MyApplication extends io.dropwizard.Application<MyConfiguration> {

    public static void main(String[] args) throws Exception {
        new MyApplication().run(args);
    }

    public void run(MyConfiguration myConfiguration, Environment environment) throws Exception {
        environment.jersey().register(UserResource.class);
    }
}
