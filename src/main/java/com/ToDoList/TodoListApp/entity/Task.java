package com.ToDoList.TodoListApp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.regex.Pattern;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)//Used to specify how an enum type should be stored in database
    private TaskStatus status;

    private LocalDate dueDate;

    @JsonFormat(pattern="HH:mm:ss")
    private LocalDateTime createdAt;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalDateTime updatedAt;

    @ManyToOne
    //Many tasks can be associated with the one user.

    @JoinColumn(name = "user_id") //Used to define foreign key column in the database.

    private User user;

    @PrePersist //Triggers a method before the entity is inserted into the database
    protected void onCreate()
    {
        createdAt=LocalDateTime.now(); //Sets the creation time
    }

    @PreUpdate //Triggers a method before the entity is updated in the database
    protected void onUpdate()
    {
        updatedAt=LocalDateTime.now(); //Sets the last updated time
    }



}
