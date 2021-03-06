package github.maxbalan.demo;

import github.maxbalan.demo.config.TestConfig;
import io.dropwizard.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;


public class AppConfig extends Configuration {
    
    @Valid
    @NotNull
    @JsonProperty("configTest")
    private TestConfig testConfig;
    
    public TestConfig getTestConfig() {
        return this.testConfig;
    }
    
}
