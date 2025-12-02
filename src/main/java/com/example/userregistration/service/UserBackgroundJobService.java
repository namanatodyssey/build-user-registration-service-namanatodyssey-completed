package com.example.userregistration.service;

import com.example.userregistration.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class UserBackgroundJobService {

    private static final Logger logger = LoggerFactory.getLogger(UserBackgroundJobService.class);

    @Async
    public void runPostRegistrationTasks(User user) {
        logger.info("Starting background tasks for user {}", user.getId());
        // Implementation to be completed by candidate
    }
}
