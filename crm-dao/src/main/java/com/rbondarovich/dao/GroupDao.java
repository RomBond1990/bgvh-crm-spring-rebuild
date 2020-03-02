package com.rbondarovich.dao;

import com.rbondarovich.dao.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupDao extends JpaRepository<Group, Integer> {
}
