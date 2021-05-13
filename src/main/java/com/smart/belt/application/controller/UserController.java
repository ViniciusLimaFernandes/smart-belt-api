package com.smart.belt.application.controller;

import com.smart.belt.application.data.user.UserRequestDTO;
import com.smart.belt.application.data.user.UserResponseDTO;
import com.smart.belt.application.service.interfaces.UserService;
import com.smart.belt.domain.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "User", description = "User requests")
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin
    @Operation(summary = "Create a new user")
    @PostMapping(value = "/create", consumes = "application/json")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody final UserRequestDTO userRequestDTO) {
        final UserResponseDTO response = userService.createUser(userRequestDTO);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @CrossOrigin
    @Operation(summary = "List all users")
    @GetMapping(value = "/list", produces = "application/json")
    public ResponseEntity<Page<UserResponseDTO>> findAll(final Pageable pageable) {
        //params: page, size e sort
        final Page<User> userPage = userService.listAll(pageable);

        final Page<UserResponseDTO> response = userPage.map(UserResponseDTO::convertToResponse);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
