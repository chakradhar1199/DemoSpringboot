package com.example.demo.Controller;

import com.example.demo.Models.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@RestController
public class TaskController {
    private final List<Task> taskList;
    private AtomicInteger taskId = new AtomicInteger(0);
    public TaskController() {
        taskList = new ArrayList<>();
        taskList.add(new Task(taskId.incrementAndGet(),"Task1", new Date()));
        taskList.add(new Task(taskId.incrementAndGet(),"Task2",new Date()));
        taskList.add(new Task(taskId.incrementAndGet(), "Task3", new Date()));
    }

    @GetMapping("/tasks")
    public List<Task> getTaskList(){
        return taskList;
    }

    @PostMapping("/newTask")
    public Task createNew(@RequestBody Task task){
        Task newTask = new Task(taskId.incrementAndGet(), task.getTask(), task.getCreateDate());
        taskList.add(newTask);
        return newTask;
    }

    @GetMapping("/getById/{id}")
    Task getTaskById(@PathVariable Integer id){
        return taskList.stream().filter(c-> c.getId() == id).collect(Collectors.toList()).get(0);
    }


    @PatchMapping("/taskupdate/{id}")
    Task updateTask(@PathVariable Integer id, @RequestBody Task task){
//        var UpdatedTask = new Task()
        return null;
    }
}
