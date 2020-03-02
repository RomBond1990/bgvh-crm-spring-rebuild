package com.rbondarovich.dao.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="task_project_states")
public class TaskProjectState implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pk_status_id")
    private int id;

    @Column(name = "status_name")
    private String stateName;

}
