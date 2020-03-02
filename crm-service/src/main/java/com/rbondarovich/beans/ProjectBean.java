package com.rbondarovich.beans;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@SuppressWarnings("unused")
public class ProjectBean {

    private int id;

    private String projectName;

    private LocalDateTime dateOfCreation;

    private LocalDateTime dateOfEnd;

    private GroupBean group;

    private ProfileBean head;

    private TaskProjectStateBean status;

    private List<ProfileBean> developers;

    private List<TaskBean> tasks;

    public ProjectBean() {
    }

}
