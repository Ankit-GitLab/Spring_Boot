package com.demo.first.app;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private final Map<Integer, User> userDb = new HashMap<>();


    // CREATE USER
    public User createUser(User user) {
        System.out.println(user.getEmail());
        userDb.put(user.getId(), user);
        return user;
    }


    // UPDATE USER
    public User updateUser(User user) {
        if (!userDb.containsKey(user.getId())) {
            throw new IllegalArgumentException("User with ID" +user.getId()+"does not exist");
        }
        userDb.put(user.getId(), user);
        return user;
    }


    // DELETE USER
    public boolean deleteUser(int id) {
        if (!userDb.containsKey(id)) {
            return false;
        }
        userDb.remove(id);
        return true;
    }


    // GET ALL USERS
    public List<User> getAllUsers() {
        return new ArrayList<>(userDb.values());
    }


    // GET USER BY ID
    public User getUserById(int id) {
        return userDb.get(id);
    }


    // SEARCH USERS
    public List<User> searchUsers(String name, String email) {

        return userDb.values()
                .stream()
                .filter(user -> user.getName().equalsIgnoreCase(name))
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .toList();
    }
}

