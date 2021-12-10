package com.kingsmantech.crudrestapi.service;

import com.kingsmantech.crudrestapi.entity.User;
import com.kingsmantech.crudrestapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createNewUser(User user) {
        User newUser = userRepository.save(user);
        return newUser;
    }

    public User fetchUserById(Long userId) {
        User userFound = userRepository.findByUserId(userId);
        return userFound;
    }

    public List<User> fetchAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }


    public User updateUserEmail(Long userId, User user) {
        User userToUpdate = userRepository.findByUserId(userId);
        if (userToUpdate == null){
            return null;
        }
            userToUpdate.setEmail(user.getEmail());
            return userRepository.saveAndFlush(userToUpdate);
    }


    public User deleteByUserId(Long userId) {
        return userRepository.deleteByUserId(userId);
    }
}
