package com.rbondarovich.dao;

import com.rbondarovich.dao.entities.TaskDuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDurationDao extends JpaRepository<TaskDuration, Integer> {
}
