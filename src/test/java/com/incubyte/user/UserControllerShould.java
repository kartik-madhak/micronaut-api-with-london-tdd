package com.incubyte.user;

import com.incubyte.user.UserController;
import com.incubyte.user.UserService;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserControllerShould {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Test
    public void get_all_users_should_work() {
        userController.getAllUsers();
        verify(userService).getAllUsers();
    }

}
