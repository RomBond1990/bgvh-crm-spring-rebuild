package com.rbondarovich.dao.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode
@Entity
@Table(name = "projects")
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_project_id")
    @Getter @Setter
    private int id;

    @Column(name = "project_name")
    @Getter @Setter
    private String projectName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_of_creation")
    @CreationTimestamp
    @Getter @Setter
    private Date dateOfCreation;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_of_end")
    @Getter @Setter
    private Date dateOfEnd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_group_id")
    @Getter @Setter
    private Group group;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_profile_id")
    @Getter @Setter
    private Profile head;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_status_id")
    @Getter @Setter
    private TaskProjectState status;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "projects_to_profiles",
            joinColumns = @JoinColumn(name = "fk_project_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_profile_id"))
    @Getter @Setter
    private List<Profile> developers;

//    @OneToMany(fetch = FetchType.LAZY,
//            mappedBy = "project")
//    @Getter @Setter
//    private List<Task> tasks;

}
