package com.rbondarovich.dao;

import com.rbondarovich.dao.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectDao extends JpaRepository<Project, Integer> {
}
