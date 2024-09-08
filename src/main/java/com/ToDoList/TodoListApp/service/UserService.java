package com.ToDoList.TodoListApp.service;

import com.ToDoList.TodoListApp.entity.User;
import com.ToDoList.TodoListApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User getUserById(Long userId)
    {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<User> getAllUser()
    {
        return userRepository.findAll();
    }

    public User updateUserById(Long userId, User userDetails)
    {
        User existingUser=userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("User not found with Id "+userId));
        existingUser.setEmail(userDetails.getEmail());
        existingUser.setUsername(userDetails.getUsername());
        existingUser.setPassword(userDetails.getPassword());

        return userRepository.save(existingUser);
    }

    public User saveUser(User user)
    {
        return userRepository.save(user);
    }

    public void deleteUserById(Long userId)
    {
        userRepository.deleteById(userId);
    }

}
