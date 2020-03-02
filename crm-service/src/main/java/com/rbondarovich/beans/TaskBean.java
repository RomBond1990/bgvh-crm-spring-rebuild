package com.rbondarovich.beans;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@SuppressWarnings("unused")
public class TaskBean {

    private int id;

    private String taskName;

    private int priority;

    private LocalDateTime dateOfCreation;

    private LocalDateTime dateOfEnd;

    private ProjectBean project;

    private ProfileBean profile;

    private TaskBean taskParent;

    private List<TaskBean> subTasks;

    private Set<TaskDurationBean> durations;


    public TaskBean() {
    }

}
