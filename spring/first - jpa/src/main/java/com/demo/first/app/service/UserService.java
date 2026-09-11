package com.demo.first.app.service;

import com.demo.first.app.controller.UserController;
import com.demo.first.app.exceptions.UserNotFoundException;
import com.demo.first.app.model.User;
import com.demo.first.app.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UserService {
    private UserRepository userRepository;
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // CREATE USER
    public User createUser(User user) {
        logger.info("Creating user..... INFO");
        logger.debug("Creating user..... INFO");
        logger.trace("Creating user..... INFO");
        logger.warn("Creating user..... INFO");
        logger.error("Creating user..... INFO");
        System.out.println(user.getEmail());
        return userRepository.save(user);
    }


    // UPDATE USER
    public User updateUser(User user) {
        Optional<User> userOptional = userRepository.findById(user.getId());
        User existing = userOptional.orElseThrow(() ->  new UserNotFoundException("User with ID"+user.getId()+" does not exist"));
        existing.setName(user.getName());
        existing.setEmail(user.getEmail());
        return userRepository.save(existing);
    }


    // DELETE USER
    public boolean deleteUser(int id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User with ID"+id+" does not exist");
        }
        userRepository.deleteById(id);
        return true;
    }


    // GET ALL USERS
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        if(users.isEmpty())
            throw new NullPointerException("No users found in the database");
        return users;
    }


    // GET USER BY ID
    public User getUserById(int id) {
        return userRepository.findById(id)
                .orElseThrow(
                        () ->  new UserNotFoundException("User with ID"+id+" does not exist")
                );
    }


    // SEARCH USERS
    public List<User> searchUsers(String name, String email) {

        return userRepository.findByNameIgnoreCaseAndEmailIgnoreCase(name, email);
    }
}

