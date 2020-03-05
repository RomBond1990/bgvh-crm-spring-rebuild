package com.rbondarovich.dao.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "tasktime")
public class TaskDuration implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "pk_tasktime_id")
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_task")
    @CreationTimestamp
    private Date startTask;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "finish_task")
    private Date stopTask;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_task_id")
    private Task task;

}
