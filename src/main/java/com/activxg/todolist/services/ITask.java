package com.activxg.todolist.services;

import com.activxg.todolist.constant.Status;
import com.activxg.todolist.model.TaskEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ITask {
    List<TaskEntity> getAllTasks();

    Optional<List<TaskEntity>> findByStatusNot(Status status);

    TaskEntity save(TaskEntity task);

    Optional<TaskEntity> findById(UUID id);

    void deleteById(UUID id);
}
