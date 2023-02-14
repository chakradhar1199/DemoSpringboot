package com.example.demo.Controller;

import com.example.demo.Models.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
}
