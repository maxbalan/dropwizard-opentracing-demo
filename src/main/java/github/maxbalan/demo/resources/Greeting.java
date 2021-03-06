package github.maxbalan.demo.resources;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Greeting {
    
    private final String name;
    
    public Greeting(String name) {
        this.name = name;
    }
    
    @JsonProperty("greeting")
    public String greetingMessage() {
        return String.format("Hello %s", this.name);
    }
    
}
