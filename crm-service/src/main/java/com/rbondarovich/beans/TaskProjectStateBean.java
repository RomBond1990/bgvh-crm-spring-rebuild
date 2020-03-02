package com.rbondarovich.beans;

import lombok.Data;

@Data
@SuppressWarnings("unused")
public class TaskProjectStateBean {

    private int id;

    private String stateName;

    public TaskProjectStateBean() {
    }
}
