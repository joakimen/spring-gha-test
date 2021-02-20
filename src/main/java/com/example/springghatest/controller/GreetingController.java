package com.example.springghatest.controller;

import com.example.springghatest.model.Greeting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/greet")
    public Greeting greet(@RequestParam(value = "name", defaultValue = "World") final String name) {
        return new Greeting(String.format("Hello %s", name));
    }

}
