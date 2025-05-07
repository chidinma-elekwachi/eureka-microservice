package org.example.UserMicroservice.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

    private UserService userService;
    private RestTemplate restTemplate;

    public UserController(UserService userService, RestTemplate restTemplate) {
        this.userService = userService;
        this.restTemplate = restTemplate;
    }

    @PostMapping
    public String createUser(@RequestBody UserCreateRequest request){
        return userService.createUser(request);
    }
    @GetMapping(value = "/{userId}")
    public User findUserById(@PathVariable("userId") String userId){
        User user = userService.findByUserId(userId);

        //Get produc from product-service
        return null;
    }
}