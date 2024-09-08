package com.ToDoList.TodoListApp.service;

import com.ToDoList.TodoListApp.entity.Task;
import com.ToDoList.TodoListApp.repository.TaskRepository;
import jakarta.persistence.Id;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
  private TaskRepository taskRepository;

  public List<Task> getTaskByUserId(Long userId){
      return taskRepository.findByUserId(userId);
  }

  public Task saveTask(Task task){
      return taskRepository.save(task);

  }

  public Task updateTask(Long taskId, @NotNull Task taskDetails){
      Task existingTask = taskRepository.findById(taskId)
              .orElseThrow(() -> new RuntimeException("Task not found with id " + taskId));

      existingTask.setTitle(taskDetails.getTitle());
      existingTask.setDescription(taskDetails.getDescription());
      existingTask.setStatus(taskDetails.getStatus());
      existingTask.setDueDate(taskDetails.getDueDate());

      return taskRepository.save(existingTask);
  }

  public void deleteTask(Long taskId)
  {
      taskRepository.deleteById(taskId);
  }

}
