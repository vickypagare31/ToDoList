package com.ToDoList.TodoListApp.repository;

import com.ToDoList.TodoListApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    Optional<User>findById(Long Id);
}
