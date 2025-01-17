package com.example.swagger.api;

import org.springframework.context.annotation.DependsOn;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@DependsOn("dbService")
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Welcome to the home page!";
    }

    @GetMapping("/secured")
    public String secured() {
        return "This is a secured page. You are authorized!";
    }
}
