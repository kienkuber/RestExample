import io.dropwizard.Configuration;

public class MyConfiguration extends Configuration {
    private String config;

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }
}
