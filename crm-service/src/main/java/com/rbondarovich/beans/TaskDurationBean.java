package com.rbondarovich.beans;

import lombok.Data;

import java.util.Date;

@Data
@SuppressWarnings("unused")
public class TaskDurationBean {

    private int id;

    private Date startTask;

    private Date stopTask;

    private TaskBean task;

    public TaskDurationBean() {
    }
}
