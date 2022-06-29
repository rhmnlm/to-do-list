package com.activxg.todolist.repository;

import com.activxg.todolist.constant.Status;
import com.activxg.todolist.model.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, UUID> {

    Optional<List<TaskEntity>> findByStatusNot(Status status);
}
