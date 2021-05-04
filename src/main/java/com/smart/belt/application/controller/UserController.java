package com.smart.belt.application.controller;

import com.smart.belt.application.data.user.UserRequestDTO;
import com.smart.belt.application.data.user.UserResponseDTO;
import com.smart.belt.application.service.interfaces.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/create", consumes = "application/json")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody final UserRequestDTO userRequestDTO) {
        final UserResponseDTO response = userService.createUser(userRequestDTO);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
