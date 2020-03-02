package com.rbondarovich.dao.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "projects")
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_project_id")
    private int id;

    @Column(name = "project_name")
    private String projectName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_of_creation")
    @CreationTimestamp
    private Date dateOfCreation;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_of_end")
    private Date dateOfEnd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_group_id")
    private Group group;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_project_id")
    private Profile head;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_status_id")
    private TaskProjectState status;

    @ManyToMany
    @JoinTable(name = "projects_to_profiles",
            joinColumns = @JoinColumn(name = "fk_project_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_profile_id"))
    private Set<Profile> developers;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "project")
    private List<Task> tasks;

}
