package com.rbondarovich.dao;

import com.rbondarovich.dao.entities.Profile;
import com.rbondarovich.dao.entities.Project;
import com.rbondarovich.dao.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Repository
@Transactional
public interface TaskDao extends JpaRepository<Task, Integer> {

    List<Task> findAllByProject (Project project);

    List<Task> findAllByProfile (Profile profile);

    List<Task> findAllByTaskParent (Task taskParent);

}
