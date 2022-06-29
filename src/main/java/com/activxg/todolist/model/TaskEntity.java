package com.activxg.todolist.model;

import com.activxg.todolist.constant.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name="task")
public class TaskEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    UUID id;
    String task;
    @Enumerated(EnumType.STRING)
    Status status;
}
