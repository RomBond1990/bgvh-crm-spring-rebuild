package com.rbondarovich.beans;

import lombok.Data;

import java.time.LocalDateTime;

@Data
@SuppressWarnings("unused")
public class TaskDurationBean {

    private int id;

    private LocalDateTime startTask;

    private LocalDateTime stopTask;

    private TaskBean task;

    public TaskDurationBean() {
    }
}
