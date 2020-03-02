package com.rbondarovich.beans;

import lombok.Data;

@Data
@SuppressWarnings("unused")
public class ProfileStatusBean {

    private int id;

    private String statusName;

    public ProfileStatusBean() {
    }
}
