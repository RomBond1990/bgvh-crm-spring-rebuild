package com.rbondarovich.beans;

import lombok.Data;

import java.util.List;

@Data
@SuppressWarnings("unused")
public class ProfileBean {

    private int id;

    private String firstName;

    private String lastName;

    private String middleName;

    private String login;

    private String password;

    private GroupBean group;

    private ProfilePositionBean position;

    private ProfileStatusBean status;

    private List<ProjectBean> projects;

    public ProfileBean() {
    }
}
