package com.sandeep.greet.controleller;

import com.sandeep.greet.client.WelcomeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {
    @Autowired
    private WelcomeClient welcomeClient;

    @GetMapping("/greet")
    public String getGreetMessage() {
        String greetMessage = " Got a good things on sale Stranger!";
        String welcomeMessage = welcomeClient.invokeWelcome();
        return welcomeMessage + greetMessage;
    }
}
