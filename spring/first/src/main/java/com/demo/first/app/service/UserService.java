package com.demo.first.app.service;

import com.demo.first.app.controller.UserController;
import com.demo.first.app.exceptions.UserNotFoundException;
import com.demo.first.app.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class UserService {
    private final Map<Integer, User> userDb = new HashMap<>();
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    // CREATE USER
    public User createUser(User user) {
        logger.info("Creating user..... INFO");
        logger.debug("Creating user..... INFO");
        logger.trace("Creating user..... INFO");
        logger.warn("Creating user..... INFO");
        logger.error("Creating user..... INFO");
        System.out.println(user.getEmail());
        userDb.put(user.getId(), user);
        return user;
    }


    // UPDATE USER
    public User updateUser(User user) {
        if (!userDb.containsKey(user.getId())) {
            throw new UserNotFoundException("User with ID" +user.getId() + " does not exist");
        }
        userDb.put(user.getId(), user);
        return user;
    }


    // DELETE USER
    public boolean deleteUser(int id) {
        if (!userDb.containsKey(id)) {
            throw new UserNotFoundException("User with ID"+id+" does not exist");
        }
        userDb.remove(id);
        return true;
    }


    // GET ALL USERS
    public List<User> getAllUsers() {
        if(userDb.isEmpty())
            throw new NullPointerException("No users found in the database");
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

