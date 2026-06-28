package com.github.andre10dias.controller;

import com.github.andre10dias.config.GreetingConfiguration;
import com.github.andre10dias.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "%s, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingConfiguration configuration;

    @RequestMapping("/greeting")
    public Greeting greeting(
            @RequestParam(value = "name", defaultValue = "")
            String name
    ) {
        if(name.isEmpty()) name = configuration.getDefaultValue();
        return new Greeting(
                counter.incrementAndGet(),
                String.format(template, configuration.getGreeting(), name)
        );
    }
}
