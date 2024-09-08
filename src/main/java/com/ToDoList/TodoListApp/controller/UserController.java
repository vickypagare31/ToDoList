package com.ToDoList.TodoListApp.controller;

import com.ToDoList.TodoListApp.entity.User;
import com.ToDoList.TodoListApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<User>createUser(@RequestBody User user){
    User savedUser= userService.saveUser(user);
    return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId)
    {
        try{
            User user=userService.getUserById(userId);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        catch(RuntimeException e)
        {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    public ResponseEntity<List<User>>getAllUsers()
    {
       List<User>users= userService.getAllUser();
       return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User userDetails)
    {
        return userService.updateUserById(userId, userDetails);

    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteById(@PathVariable Long userId)
    {
        userService.deleteUserById(userId);
        return ResponseEntity.ok("User with Id "+userId+" has been deleted");
    }
}
