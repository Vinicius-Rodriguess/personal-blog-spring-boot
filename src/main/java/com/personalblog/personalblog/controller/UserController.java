package com.personalblog.personalblog.controller;

import java.util.List;
import java.util.Optional;

import com.personalblog.personalblog.dto.user.UserCreateDTO;
import com.personalblog.personalblog.dto.user.UserUpdateDTO;
import com.personalblog.personalblog.model.User;
import com.personalblog.personalblog.model.UserLogin;
import com.personalblog.personalblog.repository.UserRepository;
import com.personalblog.personalblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public ResponseEntity <List<User>> getAll(){

        return ResponseEntity.ok(userRepository.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        return userRepository.findById(id)
                .map(response -> ResponseEntity.ok(response))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/login")
    public ResponseEntity<UserLogin> authenticateUser(@RequestBody Optional<UserLogin> userLogin){

        return userService.authenticateUser(userLogin)
                .map(response -> ResponseEntity.status(HttpStatus.OK).body(response))
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }


    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody @Valid UserCreateDTO userCreateDTO) {

        return userService.createUser(userCreateDTO)
                .map(response -> ResponseEntity.status(HttpStatus.CREATED).body(response))
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());

    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@Valid @RequestBody UserUpdateDTO userUpdateDTO) {

        return userService.updateUser(userUpdateDTO)
                .map(response -> ResponseEntity.status(HttpStatus.OK).body(response))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }

}