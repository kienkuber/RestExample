import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import model.User;
import model.UserDAO;
import resource.UserResource;

public class MyApplication extends io.dropwizard.Application<MyConfiguration> {

    public static void main(String[] args) throws Exception {
        new MyApplication().run(args);
    }

    private HibernateBundle<MyConfiguration> hibernateBundle = new HibernateBundle<MyConfiguration>(User.class) {
        public PooledDataSourceFactory getDataSourceFactory(MyConfiguration myConfiguration) {
            return myConfiguration.getDatabase();
        }
    };

    @Override
    public void initialize(Bootstrap<MyConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
    }

    public void run(MyConfiguration myConfiguration, Environment environment) throws Exception {
        final UserDAO userDAO = new UserDAO(hibernateBundle.getSessionFactory());
        environment.jersey().register(new UserResource(userDAO));
    }
}
