package com.ToDoList.TodoListApp.controller;

import com.ToDoList.TodoListApp.entity.Task;
import com.ToDoList.TodoListApp.entity.User;
import com.ToDoList.TodoListApp.service.TaskService;
import com.ToDoList.TodoListApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @GetMapping("/user/{userId}")
    public List<Task> getTaskByUser(@PathVariable Long userId)
    {
        return taskService.getTaskByUserId(userId);
    }

    @PostMapping("/user/{userId}")
    public Task createTask(@PathVariable Long userId, @RequestBody Task task)
    {
        User user=userService.getUserById(userId);
        task.setUser(user);
        return taskService.saveTask(task);
    }

    @PutMapping("/{taskId}/user/{userId}")
    public Task updateTask(@PathVariable Long taskId, @PathVariable Long userId, @RequestBody Task taskDetails)
    {
        User user=userService.getUserById(userId);
        taskDetails.setUser(user);
        return taskService.updateTask(taskId, taskDetails);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable Long taskId)
    {
        taskService.deleteTask(taskId);
        return ResponseEntity.ok("Task with Id "+ taskId +" has been deleted");
    }
}
