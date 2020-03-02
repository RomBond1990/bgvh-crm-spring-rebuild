package com.rbondarovich.dao;

import com.rbondarovich.dao.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TaskDao extends JpaRepository<Task, Integer> {
}
