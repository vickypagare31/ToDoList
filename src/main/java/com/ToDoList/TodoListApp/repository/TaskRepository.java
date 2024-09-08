package com.ToDoList.TodoListApp.repository;

import com.ToDoList.TodoListApp.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task>findByUserId(Long userId);

}
