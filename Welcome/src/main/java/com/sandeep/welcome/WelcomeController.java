package com.sandeep.welcome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @Autowired
    private Environment environment;

    @GetMapping("/welcome")
    public String getWelcomeMessage() {
        String port = environment.getProperty("server.port");
        String welcomeMessage = "Welcome! " + " : " + port;
        return welcomeMessage;
    }
}
