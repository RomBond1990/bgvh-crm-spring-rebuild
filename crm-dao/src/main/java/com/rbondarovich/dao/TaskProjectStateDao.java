package com.rbondarovich.dao;

import com.rbondarovich.dao.entities.TaskProjectState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskProjectStateDao extends JpaRepository <TaskProjectState, Integer> {
}
