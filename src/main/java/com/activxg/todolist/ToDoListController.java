package com.activxg.todolist;

import com.activxg.todolist.constant.Status;
import com.activxg.todolist.model.TaskEntity;
import com.activxg.todolist.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
//import javax.validation.Valid;

@RestController
public class ToDoListController {


    TaskService taskService;

    @Autowired
    public ToDoListController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("/get-all-tasks")
    public List<TaskEntity> getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/tasks")
    public List<TaskEntity> getTasks(){
        Optional<List<TaskEntity>> optionalTask = taskService.findByStatusNot(Status.Deleted);
        List<TaskEntity> tasks = optionalTask.get();
        return tasks;
    }

    @GetMapping("/task/{id}")
    public TaskEntity getTaskById(
            @PathVariable("id") UUID id
    ){
        Optional<TaskEntity> optionalTask = taskService.findById(id);
        TaskEntity task = optionalTask.get();
        return task;
    }

    @PostMapping("/save")
    public TaskEntity updateTasks(
            @RequestBody TaskEntity task
    ){
        return taskService.save(task);
    }

    //soft delete. change task status to deleted
    @PostMapping("/delete")
    public TaskEntity deleteTask(
            @RequestBody TaskEntity task
    ){
        return taskService.softDelete(task.getId());
    }

    @PostMapping("/hardDelete")
    public String hardDeleteTask(
            @RequestBody TaskEntity task
    ){
        taskService.deleteById(task.getId());
        return "Task succesfully deleted";
    }

}
