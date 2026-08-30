package com.demo.first.app;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    private Map<Integer, User> userDb = new HashMap<>();

    @PostMapping
    public String creating (@RequestBody User user){
        System.out.println(user.getEmail());
        userDb.putIfAbsent(user.getId(), user);
        return "User Created";
    }

    @PutMapping
    public String updateUser(@RequestBody User user){
        if(userDb.containsKey(user.getId()))
            userDb.put(user.getId(), user);
        return "Update successful";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id){
        userDb.remove(id);
        return "User deleted";
    }

    @GetMapping
    public List<User> getUsers(){
        return new ArrayList<>(userDb.values());
    }
}
