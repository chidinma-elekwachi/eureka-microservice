package org.example.UserMicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    Environment environment;

    @GetMapping(value = "/test")
    public String test(){
        return "It is working on port " + environment.getProperty("local.server.port");
    }
}
