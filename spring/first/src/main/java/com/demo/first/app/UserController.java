package com.demo.first.app;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService = new UserService();

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> creating (@RequestBody User user){
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User updated = userService.updateUser(user);
        if(updated == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        if(!userDb.containsKey(id))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        userDb.remove(id);
//        return ResponseEntity.ok("user Deleted");
        return ResponseEntity.noContent().build();
    }

//    @GetMapping({"users", "/user/{id}"})

    @GetMapping
    public List<User> getUsers(){
        return new ArrayList<>(userDb.values());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable(value = "userId" , required = false) int id){
        if(!userDb.containsKey(id))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(userDb.get(id));
    }

    @GetMapping("/{userId}/order/{orderId}")
    public ResponseEntity<User> getUserOrser(@PathVariable("userId") int id){
        if(!userDb.containsKey(id))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(userDb.get(id));
    }

    //search?name=john
    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUser(
            @RequestParam(required = false, defaultValue ="moto") String name,
            @RequestParam(required = false, defaultValue ="email@gmail.com") String email
    ){
        System.out.println(name);
        List<User> users = userDb.values().stream()
                .filter(u -> u.getName().equalsIgnoreCase(name))
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .toList();
        return ResponseEntity.ok(new ArrayList<>(userDb.values()));
    }

    @GetMapping("/info/{id}")
    public String getInfo(
            @PathVariable int id,
            @RequestParam String name,
            @RequestHeader("User-Agent") String userAgent){
        return "user Agent: " + userAgent
                +" : " +id
                +" : " +name;
    }
}
