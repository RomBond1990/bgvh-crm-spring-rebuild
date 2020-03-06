package com.rbondarovich.dao.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode
@Entity
@Table(name = "tasks")
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_task_id")
    @Getter @Setter
    private int id;

    @Column(name = "task_name")
    @Getter @Setter
    private String taskName;

    @Column(name = "priority")
    @Getter @Setter
    private int priority;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_of_creation")
    @CreationTimestamp
    @Getter @Setter
    private Date dateOfCreation;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_of_end")
    @Getter @Setter
    private Date dateOfEnd;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_project_id")
    @Getter @Setter
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_profile_id")
    @Getter @Setter
    private Profile profile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "fk_parent_task_id")
    @Getter @Setter
    private Task taskParent;

//    @OneToMany(fetch = FetchType.LAZY,
//               mappedBy = "taskParent",
//               cascade = CascadeType.ALL)
//    @Getter @Setter
//    private List<Task> subTasks;

//    @OneToMany(fetch = FetchType.LAZY,
//               mappedBy = "task",
//               cascade = CascadeType.ALL)
//    @Getter @Setter
//    private List<TaskDuration> durations;

    public Task() {
    }

}
