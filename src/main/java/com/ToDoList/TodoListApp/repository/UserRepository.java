package com.ToDoList.TodoListApp.repository;

import com.ToDoList.TodoListApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
