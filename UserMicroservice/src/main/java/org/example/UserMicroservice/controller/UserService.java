package org.example.UserMicroservice.controller;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String createUser(UserCreateRequest request) {
        User user = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());

        return  userRepository.save(user).getId();
    }


    public User findByUserId(String userId) {
        return userRepository
                .findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
