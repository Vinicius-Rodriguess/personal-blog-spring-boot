package com.personalblog.personalblog.controller;

import com.personalblog.personalblog.model.User;
import com.personalblog.personalblog.repository.UserRepository;
import com.personalblog.personalblog.service.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    private String getUrl(String uri) {
        return "http://localhost:" + port + "/" + uri;
    }

    @BeforeAll
    void start() {
        userRepository.deleteAll();
        userService.createUser(new User(null, "Root", "root@root.com", "rootroot", "-"));
    }

    @Test
    @DisplayName("Should create a User")
    public void shouldCreateAUser() {
        HttpEntity<User> reqBody = new HttpEntity<>(new User(null, "Cristiano Ronaldo", "cr7@email.com", "12345678", "-"));

        ResponseEntity<User> resBody = testRestTemplate
                .exchange(getUrl("user/create"), HttpMethod.POST, reqBody, User.class);

        assertEquals(HttpStatus.CREATED, resBody.getStatusCode());
    }

    @Test
    @DisplayName("Should NOT duplicate User")
    public void shouldNotDuplicateUser() {
        userService.createUser(new User(null, "Messi", "messi@email.com", "12345678", "-"));

        HttpEntity<User> reqBody = new HttpEntity<>(new User(null, "Messi", "messi@email.com", "12345678", "-"));

        ResponseEntity<User> resBody = testRestTemplate
                .exchange(getUrl("user/create"), HttpMethod.POST, reqBody, User.class);

        assertEquals(HttpStatus.BAD_REQUEST, resBody.getStatusCode());
    }

    @Test
    @DisplayName("Should update a user")
    public void shouldUpdateAUser() {
        Optional<User> registeredUser = userService.createUser(new User(null, "Cristiano Ronaldo", "cr7@email.com", "12345678", "-"));

        User userUpdate = new User(registeredUser.get().getId(), "Cristiano Ronaldo JR", "cr7JR@email.com", "12345678", "-");

        HttpEntity<User> reqBody = new HttpEntity<>(userUpdate);

        ResponseEntity<User> resBody = testRestTemplate
                .withBasicAuth("root@root.com", "rootroot")
                .exchange(getUrl("user/update"), HttpMethod.PUT, reqBody, User.class);

        assertEquals(HttpStatus.OK, resBody.getStatusCode());
    }

    @Test
    @DisplayName("Should list all users")
    public void shouldListAllUsers() {
        userService.createUser(new User(null, "Messi", "messi@email.com", "12345678", "-"));
        userService.createUser(new User(null, "Cristiano Ronaldo", "cr7@email.com", "12345678", "-"));

        ResponseEntity<String> response = testRestTemplate
                .withBasicAuth("root@root.com", "rootroot")
                .exchange(getUrl("user/all"), HttpMethod.GET, null, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
