package com.example.demo.Models;

import java.util.Date;

public class Task {

    private int id;
    private String task;

    private Date createDate;

    public int getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Task(int id, String task, Date createDate) {
        this.id = id;
        this.task = task;
        this.createDate = createDate;
    }
}
