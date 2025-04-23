package org.example.UserMicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    Environment environment;

    @GetMapping(value = "/test")
    public String test(){
        return "It is working on port " + environment.getProperty("local.server.port");
    }

    @GetMapping(value = "/test2")
    public String test2(){
        return "It is working on port " + environment.getProperty("local.server.port");
    }
    @GetMapping(value = "/get-configs")
    public Map<String, String> configs(){
        Map<String, String> configs = new HashMap<>();
        configs.put("number", environment.getProperty("niit.student.number"));
        configs.put("course", environment.getProperty("niit.student.course"));

        return configs;
    }

}
