package com.incubyte.user;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@MicronautTest
public class UserControllerTest {

    @Inject
    @Client("/users")
    HttpClient client;

    @Test
    public void test_get_users() {
        HttpRequest<Object> request = HttpRequest.GET("/");
        List<Map> users = client.toBlocking().retrieve(request, Argument.listOf(Map.class));
        assertThat(users).hasSize(2);
        System.out.println("users = " + users);
    }

//    @Test
//    public void testGetUser() {
//        HttpRequest request = HttpRequest.GET("/users/1");
//        Map<String, Object> user = client.toBlocking().retrieve(request, Argument.mapOf(String.class, Object.class));
//        assertThat(user.get("name")).isEqualTo("John");
//    }
//
//    @Test
//    public void testCreateUser() {
//        HttpRequest request = HttpRequest.POST("/users", "{\"name\":\"John\"}");
//        Map<String, Object> user = client.toBlocking().retrieve(request, Argument.mapOf(String.class, Object.class));
//        assertThat(user.get("name")).isEqualTo("John");
//    }
//
//    @Test
//    public void testUpdateUser() {
//        HttpRequest request = HttpRequest.PUT("/users/1", "{\"name\":\"John\"}");
//        Map<String, Object> user = client.toBlocking().retrieve(request, Argument.mapOf(String.class, Object.class));
//        assertThat(user.get("name")).isEqualTo("John");
//    }
//
//    @Test
//    public void testDeleteUser() {
//        HttpRequest request = HttpRequest.DELETE("/users/1");
//        Map<String, Object> user = client.toBlocking().retrieve(request, Argument.mapOf(String.class, Object.class));
//        assertThat(user.get("name")).isEqualTo("John");
//    }
}
