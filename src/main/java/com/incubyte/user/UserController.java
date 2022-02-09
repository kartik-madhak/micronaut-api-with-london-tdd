package com.incubyte.user;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.List;

@Controller("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Get
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
