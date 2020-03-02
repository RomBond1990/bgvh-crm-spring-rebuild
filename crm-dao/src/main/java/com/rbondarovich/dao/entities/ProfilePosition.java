package com.rbondarovich.dao.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name = "profile_positions")
public class ProfilePosition implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_position_id")
    private int id;

    @Column(name = "position_name")
    private String positionName;

}
