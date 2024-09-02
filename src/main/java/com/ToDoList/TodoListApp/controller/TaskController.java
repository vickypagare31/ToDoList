package com.ToDoList.TodoListApp.controller;

import com.ToDoList.TodoListApp.entity.Task;
import com.ToDoList.TodoListApp.entity.User;
import com.ToDoList.TodoListApp.service.TaskService;
import com.ToDoList.TodoListApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable Long TaskId)
    {
        taskService.deleteTask(TaskId);
    }
}
