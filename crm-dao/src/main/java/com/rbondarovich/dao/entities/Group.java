package com.rbondarovich.dao.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="departments")
public class Group implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_group_id")
    private int id;


    @Column(name = "group_name")
    private String groupName;

}
