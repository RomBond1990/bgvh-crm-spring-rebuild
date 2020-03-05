package com.rbondarovich.dao;

import com.rbondarovich.dao.entities.Profile;
import com.rbondarovich.dao.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectDao extends JpaRepository<Project, Integer> {

    List<Project> findAllByHead (Profile profile);
}
