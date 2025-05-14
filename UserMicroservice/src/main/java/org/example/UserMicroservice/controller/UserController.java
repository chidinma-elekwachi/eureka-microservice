package org.example.UserMicroservice.controller;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<?> findUserById(@PathVariable("userId") String userId) {
        User user = userService.findByUserId(userId);

        // Get product from product-service
        String url = "http://ProductMicroservice/api/v1/products/" + userId;
        ParameterizedTypeReference<List<Product>> responseType = new ParameterizedTypeReference<>() {};
        ResponseEntity<List<Product>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                responseType);
        List<Product> products = response.getBody();

        Map<String, Object> returnType = new LinkedHashMap<>();
        returnType.put("user", user);
        returnType.put("user-products", products);

        return ResponseEntity.ok(returnType);
}

}