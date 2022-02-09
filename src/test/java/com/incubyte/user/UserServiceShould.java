package com.incubyte.user;

import com.incubyte.user.UserController;
import com.incubyte.user.UserService;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceShould {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void get_all_users_should_work() {
        when(userRepository.findAll()).thenReturn(List.of(new User[]{new User(), new User()}));
        List<User> users = userService.getAllUsers();
        verify(userRepository).findAll();
        assertThat(users.size()).isEqualTo(2);
    }

}
