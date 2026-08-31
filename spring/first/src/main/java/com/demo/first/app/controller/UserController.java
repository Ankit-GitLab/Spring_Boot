
package com.demo.first.app.controller;

import com.demo.first.app.model.User;
import com.demo.first.app.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // CREATE USER
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {

        User createdUser = userService.createUser(user);

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }


    // UPDATE USER
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {

        User updatedUser = userService.updateUser(user);

        if (updatedUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(updatedUser);
    }


    // DELETE USER
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {

        boolean isDeleted = userService.deleteUser(id);

        if (!isDeleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.noContent().build();
    }


    // GET ALL USERS
    @GetMapping
    public ResponseEntity<List<User>> getUsers() {

        return ResponseEntity.ok(userService.getAllUsers());
    }


    // SEARCH USER
    // Example: /user/search?name=john&email=john@gmail.com
    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUser(
            @RequestParam String name,
            @RequestParam String email
    ) {

        return ResponseEntity.ok(
                userService.searchUsers(name, email)
        );
    }


    // GET USER INFO
    // Example: /user/info/1?name=Ankit
    @GetMapping("/info/{id}")
    public String getInfo(
            @PathVariable int id,
            @RequestParam String name,
            @RequestHeader("User-Agent") String userAgent
    ) {

        return "User Agent: " + userAgent
                + " | ID: " + id
                + " | Name: " + name;
    }


    // GET USER BY ID
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(
            @PathVariable int userId) {
        User user = userService.getUserById(userId);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(user);
    }


    // GET USER WITH ORDER
    // Example: /user/1/order/101
    @GetMapping("/{userId}/order/{orderId}")
    public ResponseEntity<User> getUserOrder(
            @PathVariable int userId,
            @PathVariable int orderId) {
        User user = userService.getUserById(userId);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(user);
    }
}


