package com.ToDoList.TodoListApp.service;

import com.ToDoList.TodoListApp.entity.User;
import com.ToDoList.TodoListApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }

    public User saveUser(User user)
    {
        return userRepository.save(user);
    }

}
