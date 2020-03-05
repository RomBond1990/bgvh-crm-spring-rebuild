package com.rbondarovich.dao.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@EqualsAndHashCode
@Entity
@Table(name = "profiles")
public class Profile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_profile_id")
    @Getter @Setter
    private int id;

    @Column(name = "first_name")
    @Getter @Setter
    private String firstName;

    @Column(name = "last_name")
    @Getter @Setter
    private String lastName;

    @Column(name = "middle_name")
    @Getter @Setter
    private String middleName;

    @Column(name = "login")
    @Getter @Setter
    private String login;

    @Column(name = "password")
    @Getter @Setter
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_group_id")
    @Getter @Setter
    private Group group;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_position_id")
    @Getter @Setter
    private ProfilePosition position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_status_id")
    @Getter @Setter
    private ProfileStatus status;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//    @JoinTable(name = "projects_to_profiles",
//            joinColumns = @JoinColumn(name = "fk_profile_id"),
//            inverseJoinColumns = @JoinColumn(name = "fk_project_id"))
//    @Getter @Setter
//    private List<Project> projects;

}
