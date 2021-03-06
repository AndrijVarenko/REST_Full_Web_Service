package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!",
            defaultValue_str = "Hi, Guest!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting (@RequestParam(value = "name", defaultValue = defaultValue_str) String name) {
        if (name.equals(defaultValue_str)) {
            return new Greeting (counter.incrementAndGet(), name);
        } else {
            return new Greeting (counter.incrementAndGet(), String.format(template, name));
        }
    }
}
