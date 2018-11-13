package config;

import com.fasterxml.jackson.annotation.JsonProperty;


public class TestConfig {
    
    @JsonProperty("testParam")
    private String testParam;
    
    public String getTestParam() {
        return this.testParam;
    }
    
}
