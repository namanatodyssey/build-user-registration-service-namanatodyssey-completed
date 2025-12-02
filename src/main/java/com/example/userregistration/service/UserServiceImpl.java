package com.example.userregistration.service;

import com.example.userregistration.dto.UserRegistrationRequest;
import com.example.userregistration.dto.UserRegistrationResponse;
import com.example.userregistration.model.User;
import com.example.userregistration.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserBackgroundJobService backgroundJobService;

    public UserServiceImpl(UserRepository userRepository, UserBackgroundJobService backgroundJobService) {
        this.userRepository = userRepository;
        this.backgroundJobService = backgroundJobService;
    }

    @Override
    public UserRegistrationResponse registerUser(UserRegistrationRequest request) {
        // Implementation to be completed by candidate
        return null;
    }

    private UserRegistrationResponse mapToResponse(User user) {
        UserRegistrationResponse response = new UserRegistrationResponse();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        response.setAge(user.getAge());
        return response;
    }
}
