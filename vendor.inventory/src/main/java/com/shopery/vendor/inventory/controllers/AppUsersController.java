package com.shopery.vendor.inventory.controllers;

import com.shopery.vendor.inventory.dto.AppUsersDto;
import com.shopery.vendor.inventory.services.AppUsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/users")
public class AppUsersController {

    @Autowired
    private AppUsersService appUsersService;

    // Create User
    @Operation(summary = "Create a user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input provided")
    })
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody AppUsersDto appUsersDto){
        try {
            AppUsersDto savedUsers = appUsersService.addUsers(appUsersDto);
            return new ResponseEntity<>(savedUsers, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "User login", description = "Logs in the user using email and password.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User logged in successfully"),
            @ApiResponse(responseCode = "401", description = "Unauthorized access. Invalid email or password.")
    })
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
        try {
            AppUsersDto loggedInUser = appUsersService.login(email, password);
            return new ResponseEntity<>(loggedInUser, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }


    @Operation(summary = "Update user details", description = "Updates the information of an existing user by user ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input or user not found.")
    })
    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable UUID userId, @RequestBody AppUsersDto appUsersDto) {
        try {
            AppUsersDto updatedUser = appUsersService.updateUser(userId, appUsersDto);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Soft delete user", description = "Soft deletes a user by setting the 'isDeleted' flag to true.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User soft deleted successfully"),
            @ApiResponse(responseCode = "400", description = "User not found or invalid ID.")
    })
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> softDeleteUser(@PathVariable UUID userId) {
        try {
            appUsersService.softDeleteUser(userId);
            return new ResponseEntity<>("User soft deleted successfully", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // Get User by ID
    @Operation(summary = "Retrieve user details", description = "Fetches the details of a user based on their user ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User details retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable UUID userId) {
        try {
            AppUsersDto user = appUsersService.getUserById(userId);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // Get All Users
    @Operation(summary = "Get all users")
    @GetMapping
    public ResponseEntity<List<AppUsersDto>> getAllUsers() {
        List<AppUsersDto> users = appUsersService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


}
