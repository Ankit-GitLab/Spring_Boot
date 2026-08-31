
package com.demo.first.app;

import com.demo.first.app.User;
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

    // EXCEPTION HANDLING METHOD
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalArgumentException(IllegalArgumentException exception){
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status",HttpStatus.BAD_REQUEST.value());
        errorResponse.put("error","Bad request");
        errorResponse.put("message",exception.getMessage());
        return new  ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
/*
* {
    "timestamp": "2026-08-31T05:32:40.687Z",
    "status": 500,
    "error": "Internal Server Error",
    "path": "/user"
}
* */

