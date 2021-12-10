package com.kingsmantech.crudrestapi.controller;

import com.kingsmantech.crudrestapi.entity.User;
import com.kingsmantech.crudrestapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/")
    public ResponseEntity<User> createNewUser(@RequestBody User user){
        User newUser = userService.createNewUser(user);
        return ResponseEntity.ok(newUser);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> fetchUserById(@PathVariable("id") Long userId){
        User userfound = userService.fetchUserById(userId);
        return ResponseEntity.ok(userfound);
    }

    @GetMapping("/allusers")
    public ResponseEntity<List<User>> fetchAllUsers(){
        List<User> allUsers = userService.fetchAllUsers();
        return ResponseEntity.ok(allUsers);
    }

    @PutMapping("/{id}/")
    public ResponseEntity<User> updateUserEmail(@PathVariable("id") Long userId, @RequestBody User user){
        User updatedUser = userService.updateUserEmail(userId,user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable("id") Long userId){
        User deletedUser = userService.deleteByUserId(userId);
        return ResponseEntity.ok(deletedUser);
    }
}
