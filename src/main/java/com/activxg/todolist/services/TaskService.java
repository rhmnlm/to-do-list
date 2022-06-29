package com.activxg.todolist.services;

import com.activxg.todolist.constant.Status;
import com.activxg.todolist.model.TaskEntity;
import com.activxg.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService implements ITask{
    TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<TaskEntity> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<List<TaskEntity>> findByStatusNot(Status status) {
        return taskRepository.findByStatusNot(Status.Deleted);
    }

    public TaskEntity save(TaskEntity task){
        TaskEntity requestTask = new TaskEntity();
        if(null==task.getId()){
            requestTask.setTask(task.getTask());
            requestTask.setStatus(task.getStatus());
        }
        else{
            Optional<TaskEntity> optionalTask = taskRepository.findById(task.getId());
            requestTask = optionalTask.get();
            requestTask.setTask(task.getTask() == null ? requestTask.getTask() : task.getTask());
            requestTask.setStatus(task.getStatus() == null ? requestTask.getStatus() : task.getStatus());
        }

        return taskRepository.save(requestTask);
    }

    public TaskEntity softDelete(UUID id){
        Optional<TaskEntity> optionalTask = taskRepository.findById(id);
        TaskEntity requestTask = optionalTask.get();
        requestTask.setStatus(Status.Deleted);
        return taskRepository.save(requestTask);
    }

    @Override
    public Optional<TaskEntity> findById(UUID id) {
        return taskRepository.findById(id);
    }

    public void deleteById(UUID id){
        TaskEntity requestTask = new TaskEntity();
        requestTask.setId(id);
        taskRepository.deleteById(id);
    }

}
