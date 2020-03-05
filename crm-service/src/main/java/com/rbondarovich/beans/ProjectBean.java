package com.rbondarovich.beans;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@SuppressWarnings("unused")
public class ProjectBean {

    private int id;

    private String projectName;

    private Date dateOfCreation;

    private Date dateOfEnd;

    private GroupBean group;

    private ProfileBean head;

    private TaskProjectStateBean status;

//    private List<ProfileBean> developers;

    private List<TaskBean> tasks;

    public ProjectBean() {
    }

}
