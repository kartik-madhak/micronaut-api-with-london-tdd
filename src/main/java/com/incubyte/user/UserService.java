package com.incubyte.user;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import javax.transaction.Transactional;
import java.util.List;

@Singleton
public class UserService {

    @Inject
    UserRepository userRepository;

    @Transactional
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }
}
